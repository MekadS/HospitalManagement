import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mekadspace.HospitalManagement.model.UserLogin;
import com.mekadspace.HospitalManagement.repository.UserLoginRepo;

@Service
public class HMUserDetailsService implements UserDetailsService {

    @Autowired
    private UserLoginRepo userRepository; // Replace with your user repository

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // Password encoder bean

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin user = userRepository.findByUsername(username); // Fetch user by username
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        // Create UserDetails object with username, encoded password, and authorities
        return new UserLogin(user.getUsername(),
                passwordEncoder.encode(user.getPassword()), // Encoded password
                user.getAuthorities());
    }
}
