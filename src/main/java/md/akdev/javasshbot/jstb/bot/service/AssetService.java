package md.akdev.javasshbot.jstb.bot.service;


import md.akdev.javasshbot.jstb.repo.entity.Asset;

import java.util.List;
import java.util.Optional;

public interface AssetService {
    void save(Asset asset);
    List<Asset> findAll();
    Optional<Asset> findById(Long id);
}
