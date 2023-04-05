package by.shulga.diplomaproject.service;


import by.shulga.diplomaproject.entity.User;
import by.shulga.diplomaproject.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByLogin(username).orElseThrow(
                () -> new UsernameNotFoundException(username));

        return CustomUserDetails.getUserDetailsFromUser(user);
    }
}
