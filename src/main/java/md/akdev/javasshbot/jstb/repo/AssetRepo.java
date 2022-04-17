package md.akdev.javasshbot.jstb.repo;

import md.akdev.javasshbot.jstb.repo.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepo extends JpaRepository<Asset, Long> {
    List<Asset> findAll();
}
