package notifysys.SubscriptionNotifySystem.controller;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import notifysys.SubscriptionNotifySystem.service.SubscriptionService;

@Controller
public class PageController {

    private final SubscriptionService Service;

    public PageController(SubscriptionService Service) {
        this.Service = Service;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication auth) {

        String username = auth.getName();  // get logged in username

        model.addAttribute("subscriptions",
                Service.findUserSubscriptions(username));  // correct method

        return "subscription-list";  // your Thymeleaf file
    }
}
