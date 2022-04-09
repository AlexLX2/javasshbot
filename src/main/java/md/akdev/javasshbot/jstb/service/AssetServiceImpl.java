package md.akdev.javasshbot.jstb.service;

import md.akdev.javasshbot.jstb.repo.AssetRepo;
import md.akdev.javasshbot.jstb.repo.entity.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetServiceImpl implements AssetService{

    @Autowired
    private AssetRepo assetRepo;

    public AssetServiceImpl(AssetRepo assetRepo){
        this.assetRepo = assetRepo;
    }

    @Override
    public void save(Asset asset) {
        assetRepo.save(asset);
    }

    @Override
    public List<Asset> findAll() {
        return assetRepo.findAll();
    }

    @Override
    public Optional<Asset> findById(Long id) {
        return assetRepo.findById(id);
    }
}
