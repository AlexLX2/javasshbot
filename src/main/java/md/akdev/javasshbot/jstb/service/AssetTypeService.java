package md.akdev.javasshbot.jstb.service;

import md.akdev.javasshbot.jstb.repo.entity.AssetType;

import java.util.Optional;

public interface AssetTypeService {
    Optional<AssetType> findById(int id);
}
