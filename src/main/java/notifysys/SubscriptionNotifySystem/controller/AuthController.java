package notifysys.SubscriptionNotifySystem.controller;


import lombok.RequiredArgsConstructor;
import notifysys.SubscriptionNotifySystem.dto.RegisterRequest;
import notifysys.SubscriptionNotifySystem.entities.AppUser;
import notifysys.SubscriptionNotifySystem.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;
    
    @PostMapping("/register")
    public String registerUser(@ModelAttribute RegisterRequest reg) {

        //block saving if username exists
        if (userRepository.existsByUsername(reg.getUsername())) {
            return "redirect:/register?error=username";
        }

        // block saving if email exists
        if (userRepository.existsByEmail(reg.getEmail())) {
            return "redirect:/register?error=email";
        }

        // SAVE ONLY IF NO ERRORS
        AppUser user = new AppUser();
        user.setUsername(reg.getUsername());
        user.setEmail(reg.getEmail());
        user.setPassword(passwordEncoder.encode(reg.getPassword()));

        userRepository.save(user);

        return "redirect:/login";
    }


}
