package md.akdev.javasshbot.jstb.command;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import md.akdev.javasshbot.jstb.repo.entity.Asset;
import md.akdev.javasshbot.jstb.repo.entity.Playbook;
import md.akdev.javasshbot.jstb.service.AssetService;
import md.akdev.javasshbot.jstb.service.PlaybookService;
import md.akdev.javasshbot.jstb.service.SendBotMessageService;
import md.akdev.javasshbot.jstb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PlaybookCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final AssetService assetService;
    private final PlaybookService playbookService;

    public PlaybookCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService, AssetService assetService, PlaybookService playbookService) {
        this.sendBotMessageService = sendBotMessageService;
        this.assetService = assetService;
        this.playbookService = playbookService;
    }


    @Override
    public void execute(Update update) {
        String call_data = update.getCallbackQuery().getData();

        Long asset_id = Long.valueOf(call_data.split(" ")[1]);

        int playbook_id = Integer.parseInt(call_data.split(" ")[2]);

        long chat_id = update.getCallbackQuery().getMessage().getChatId();

        Asset asset = assetService.findById(asset_id).orElse(new Asset());
        Playbook playbook = playbookService.findById(playbook_id).orElse(new Playbook());

        String answer = execSSHPlaybook(asset,playbook);
        sendBotMessageService.sendMessage(String.valueOf(chat_id), answer);

    }

    private String execSSHPlaybook(Asset asset, Playbook playbook){
        String answer = "Something wrong";

        Session session = null;
        ChannelExec channel = null;
        try {
            session = new JSch().getSession(asset.getLogin(),asset.getIp(),22);
            session.setPassword(asset.getPassword());
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(playbook.getCommand());

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

            }

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
