package md.akdev.javasshbot.jstb.service;

import md.akdev.javasshbot.jstb.repo.AssetTypeRepository;
import md.akdev.javasshbot.jstb.repo.entity.AssetType;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssetTypeServiceImpl implements AssetTypeService{
    private final AssetTypeRepository assetTypeRepository;

    public AssetTypeServiceImpl(AssetTypeRepository assetTypeRepository) {
        this.assetTypeRepository = assetTypeRepository;
    }

    @Override
    public Optional<AssetType> findById(int id) {
        return assetTypeRepository.findById(id);
    }
}
