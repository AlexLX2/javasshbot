package md.akdev.javasshbot.jstb.controller;

import md.akdev.javasshbot.jstb.repo.AssetRepo;
import md.akdev.javasshbot.jstb.repo.AssetTypeRepository;
import md.akdev.javasshbot.jstb.repo.PlaybookRepository;
import md.akdev.javasshbot.jstb.repo.TelegramUserRepo;
import md.akdev.javasshbot.jstb.repo.entity.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {

    private final AssetRepo assetRepo;
    private final TelegramUserRepo telegramUserRepo;
    private final PlaybookRepository playbookRepository;
    private final AssetTypeRepository assetTypeRepository;


    public MainController(AssetRepo assetRepo, TelegramUserRepo telegramUserRepo, PlaybookRepository playbookRepository, AssetTypeRepository assetTypeRepository) {
        this.assetRepo = assetRepo;
        this.telegramUserRepo = telegramUserRepo;
        this.playbookRepository = playbookRepository;
        this.assetTypeRepository = assetTypeRepository;
    }

    @GetMapping("/assets")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
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

    @GetMapping("/assettypes")
    public List<AssetType> getAssetTypes() {return assetTypeRepository.findAll();}

    @PostMapping("/assettypes")
    void addAssetType(@RequestBody AssetType assetType) {assetTypeRepository.save(assetType);}

    @GetMapping("/playbooks")
    public List<Playbook> getPlaybooks() {return playbookRepository.findAll();}

    @PostMapping("/playbooks")
    void addPlaybook(@RequestBody Playbook playbook) {playbookRepository.save(playbook);}

}
