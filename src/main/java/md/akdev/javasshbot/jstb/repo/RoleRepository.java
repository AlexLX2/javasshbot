package md.akdev.javasshbot.jstb.repo;

import md.akdev.javasshbot.jstb.repo.entity.ERole;
import md.akdev.javasshbot.jstb.repo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
