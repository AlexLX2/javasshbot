package md.akdev.javasshbot.jstb.repo;

import md.akdev.javasshbot.jstb.repo.entity.Playbook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaybookRepository extends JpaRepository<Playbook, Integer> {
    List<Playbook> findAllByAssetTypeId(int id);
    Optional<Playbook> findById(int id);
}