package md.akdev.javasshbot.jstb.service;


import md.akdev.javasshbot.jstb.repo.entity.Asset;

import java.util.List;

public interface AssetService {
    void save(Asset asset);
    List<Asset> findAll();
}
