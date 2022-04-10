package md.akdev.javasshbot.jstb.command;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import md.akdev.javasshbot.jstb.repo.entity.Asset;
import md.akdev.javasshbot.jstb.repo.entity.TelegramUser;
import md.akdev.javasshbot.jstb.service.AssetService;
import md.akdev.javasshbot.jstb.service.SendBotMessageService;
import md.akdev.javasshbot.jstb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class InlineCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;
    private final AssetService assetService;


    public InlineCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService, AssetService assetService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
        this.assetService = assetService;
    }



    @Override
    public void execute(Update update) {
        String call_data = update.getCallbackQuery().getData();
        long message_id = update.getCallbackQuery().getMessage().getMessageId();
        long chat_id = update.getCallbackQuery().getMessage().getChatId();
        Optional<TelegramUser> telegramUser = telegramUserService.findByChatId(chat_id);
        String answer = "";
        if (telegramUser.isEmpty() || !telegramUser.get().isActive()) {
             answer = "not autorized!";
        }
        else {
            Asset asset = assetService.findById(Long.valueOf(call_data)).orElse(new Asset());
            answer = testSSHFunc(asset);

        }

        sendBotMessageService.sendMessage(String.valueOf(chat_id), answer);
    }

    private String testSSHFunc(Asset asset){
        String answer = "Something wrong";

        Session session = null;
        ChannelExec channel = null;
        try {
            session = new JSch().getSession(asset.getLogin(),asset.getIp(),22);
            session.setPassword(asset.getPassword());
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand("ls");
            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();

            InputStream inputStream = channel.getInputStream();

            channel.connect();

            byte[] tmp = new byte[1024];
            while (true){
                while (inputStream.available()>0){
                    int i = inputStream.read(tmp,0,1024);
                    if(i<0) break;
                    System.out.println(new String(tmp,0,i));
                    answer = new String(tmp,0,i);
                }
                if(channel.isClosed()){
                    if(inputStream.available()>0) continue;
                    System.out.println("exit-status: " + channel.getExitStatus());
                    break;
                }
                try{Thread.sleep(100);}catch (Exception e){}

            }
          //  channel.setOutputStream(responseStream);


            //System.out.println("0" + responseStream);
//            while (session.isConnected()){
//                Thread.sleep(600);
//            }
            //System.out.println("1" + responseStream);
            //answer = responseStream.toString();

        } catch (JSchException | IOException e) {
            e.printStackTrace();
        } finally {

            if(session != null) {
                session.disconnect();
            }

            if(channel != null){
                channel.disconnect();
            }
        }

        return answer;
    }
}
