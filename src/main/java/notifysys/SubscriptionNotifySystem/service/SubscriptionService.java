package notifysys.SubscriptionNotifySystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import notifysys.SubscriptionNotifySystem.dto.SubscriptionRequest;
import notifysys.SubscriptionNotifySystem.entities.AppUser;
import notifysys.SubscriptionNotifySystem.entities.Subscription;
import notifysys.SubscriptionNotifySystem.repository.SubscriptionRepository;
import notifysys.SubscriptionNotifySystem.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subRepo;
    private final UserRepository userRepo;
    private final EmailService emailService;

    
    public void updateExpiryAndNotify(Long subId,
            String expiryDate,
            String username) {

        Subscription sub = subRepo.findById(subId)
         .orElseThrow(() -> new RuntimeException("Subscription not found"));

         // ✅ Ownership check
           if (!sub.getUser().getUsername().equals(username)) {
            throw new RuntimeException("❌ You cannot modify another user's subscription");
            }

         // ✅ Convert String → LocalDate
       //  LocalDate date = LocalDate.parse(expiryDate);
        sub.setExpiryDate(expiryDate);

         subRepo.save(sub);

        // ✅ Send mail instantly
       emailService.send(
           sub.getUser().getEmail(),
           "Subscription Update",
           "Your subscription '" + sub.getName() +
           "' will now expire on: " + sub.getExpiryDate()
        );
      }

    public Subscription create(SubscriptionRequest dto, String username) {

        AppUser user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Subscription sub = new Subscription();
        sub.setName(dto.getName());
        sub.setAmount(dto.getAmount());
        sub.setExpiryDate(dto.getExpiryDate());
        sub.setUser(user);

        return subRepo.save(sub);
    }

    public List<Subscription> findUserSubscriptions(String username) {
        return subRepo.findByUserUsername(username);
    }

    public Subscription updateOwnSubscription(Long id,
                                              SubscriptionRequest dto,
                                              String username) {

        Subscription sub = subRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));

        // ✅ Verify ownership
        if (!sub.getUser().getUsername().equals(username)) {
            throw new RuntimeException("Access Denied");
        }

        sub.setName(dto.getName());
        sub.setAmount(dto.getAmount());
        sub.setExpiryDate(dto.getExpiryDate());

        return subRepo.save(sub);
    }

    public void deleteOwnSubscription(Long id, String username) {

        Subscription sub = subRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));

        // ✅ Verify ownership
        if (!sub.getUser().getUsername().equals(username)) {
            throw new RuntimeException("Access Denied");
        }

        subRepo.delete(sub);
    }
    
    public Subscription findById(Long id) {
        return subRepo.findById(id).orElseThrow(() -> new RuntimeException("Subscription not found"));
    }

    public Subscription getOwnedSubscription(Long id, String username) {
        Subscription sub = subRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));

        if (!sub.getUser().getUsername().equals(username)) {
            throw new RuntimeException("❌ Access Denied: Not your subscription");
        }

        return sub;
    }


    
    
}

