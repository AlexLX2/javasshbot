package md.akdev.javasshbot.jstb.bot.service;

import md.akdev.javasshbot.jstb.repo.entity.Playbook;

import java.util.List;
import java.util.Optional;

public interface PlaybookService {
    public List<Playbook> findByAssetTypeId(int id);
    public Optional<Playbook> findById(int id);
}
