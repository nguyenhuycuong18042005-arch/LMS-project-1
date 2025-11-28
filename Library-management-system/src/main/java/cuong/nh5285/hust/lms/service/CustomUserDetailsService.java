package cuong.nh5285.hust.lms.service;

import cuong.nh5285.hust.lms.model.User;
import cuong.nh5285.hust.lms.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository repo) {
        this.userRepository = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Trả về UserDetails chuẩn Spring Security
        return org.springframework.security.core.userdetails.User
                .withUsername(u.getUserName())
                .password(u.getPassword())   // password đã mã hóa BCrypt
                .roles(u.getRole())          // ADMIN / LIBRARIAN
                .build();
    }
}
