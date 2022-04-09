package md.akdev.javasshbot.jstb.controller;

import md.akdev.javasshbot.jstb.repo.AssetRepo;
import md.akdev.javasshbot.jstb.repo.TelegramUserRepo;
import md.akdev.javasshbot.jstb.repo.entity.Asset;
import md.akdev.javasshbot.jstb.repo.entity.TelegramUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {

    private final AssetRepo assetRepo;
    private final TelegramUserRepo telegramUserRepo;


    public MainController(AssetRepo assetRepo, TelegramUserRepo telegramUserRepo) {
        this.assetRepo = assetRepo;
        this.telegramUserRepo = telegramUserRepo;
    }

    @GetMapping("/assets")
    public List<Asset> getAssets(){
        return assetRepo.findAll();
    }

    @PostMapping("/assets")
    void addAsset(@RequestBody Asset asset){
        assetRepo.save(asset);
    }

    @GetMapping("/users")
    public List<TelegramUser> getUsers() {return telegramUserRepo.findAll();}

    @PutMapping("/users")
    void updateUser(@RequestBody TelegramUser telegramUser) {telegramUserRepo.save(telegramUser);}
}
