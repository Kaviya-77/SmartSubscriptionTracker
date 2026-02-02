package notifysys.SubscriptionNotifySystem.security;

import lombok.RequiredArgsConstructor;
import notifysys.SubscriptionNotifySystem.entities.AppUser;
import notifysys.SubscriptionNotifySystem.repository.UserRepository;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
