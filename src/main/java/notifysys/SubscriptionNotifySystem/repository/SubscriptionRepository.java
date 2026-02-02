package notifysys.SubscriptionNotifySystem.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import notifysys.SubscriptionNotifySystem.entities.Subscription;



public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUserUsername(String username);
    List<Subscription> findByExpiryDateBetween(LocalDate start, LocalDate end); 
    Optional<Subscription> findById(Long id);   // ✅ CORRECT

}




