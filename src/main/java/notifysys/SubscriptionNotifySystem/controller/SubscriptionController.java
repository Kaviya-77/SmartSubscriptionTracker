package notifysys.SubscriptionNotifySystem.controller;

import lombok.RequiredArgsConstructor;
import notifysys.SubscriptionNotifySystem.dto.SubscriptionRequest;
import notifysys.SubscriptionNotifySystem.entities.Subscription;
import notifysys.SubscriptionNotifySystem.service.SubscriptionService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService service;

    // LIST all subscriptions of logged-in user
    @GetMapping
    public String list(Model model, Authentication auth) {
        String username = auth.getName();
        model.addAttribute("subscriptions", service.findUserSubscriptions(username));
        return "subscription-list";
    }

    
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("subscription", new Subscription());
        return "subscription-form"; // form for new subscription
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Subscription sub, Authentication auth) {
        String username = auth.getName();
        SubscriptionRequest dto = new SubscriptionRequest(
                sub.getName(),
                sub.getAmount(),
                sub.getExpiryDate()
        );
        service.create(dto, username); // always creates new
        return "redirect:/subscriptions";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Authentication auth, Model model) {
        String username = auth.getName();
        Subscription sub = service.getOwnedSubscription(id, username); // secure
        model.addAttribute("subscription", sub);
        return "subscription-edit-form"; // separate form for editing
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute Subscription sub,
                         Authentication auth) {
        String username = auth.getName();
        SubscriptionRequest dto = new SubscriptionRequest(
                sub.getName(),
                sub.getAmount(),
                sub.getExpiryDate()
        );
        service.updateOwnSubscription(id, dto, username); // updates existing
        return "redirect:/subscriptions";
    }
   

    // DELETE subscription
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Authentication auth) {
        String username = auth.getName();
        service.deleteOwnSubscription(id, username);
        return "redirect:/subscriptions";
    }

    // UPDATE expiry only
    @PostMapping("/expiry/{id}")
    public String updateExpiry(@PathVariable Long id,
                               @RequestParam String expiryDate,
                               Authentication auth) {
        String username = auth.getName();
        service.updateExpiryAndNotify(id, expiryDate, username);
        return "redirect:/subscriptions";
    }
}
