package md.akdev.javasshbot.jstb.bot.service;

import md.akdev.javasshbot.jstb.repo.PlaybookRepository;
import md.akdev.javasshbot.jstb.repo.entity.Playbook;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaybookServiceImpl implements PlaybookService{

    private final PlaybookRepository playbookRepository;

    public PlaybookServiceImpl(PlaybookRepository playbookRepository) {
        this.playbookRepository = playbookRepository;
    }


    @Override
    public List<Playbook> findByAssetTypeId(int id) {
        return playbookRepository.findAllByAssetTypeId(id);
    }

    @Override
    public Optional<Playbook> findById(int id) {
        return playbookRepository.findById(id);
    }
}
