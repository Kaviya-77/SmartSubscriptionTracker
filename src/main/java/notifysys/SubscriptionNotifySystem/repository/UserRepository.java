package notifysys.SubscriptionNotifySystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import notifysys.SubscriptionNotifySystem.entities.AppUser;


public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
