package org.apatrios.service.details;

import com.github.dockerjava.api.exception.ConflictException;
import lombok.RequiredArgsConstructor;
import org.apatrios.model.management.User;
import org.apatrios.repository.managment.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ElBikesUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username)
                              .orElseThrow(() -> new ConflictException("User.Bad.Credentials"));

        if (!user.isEnabled()) throw new ConflictException("User.Access.Denied");

        return getUserDetails(user);
    }

    private ElBikesUserDetails getUserDetails(User user) {
        return ElBikesUserDetails.builder()
                                 .id(user.getId())
                                 .authorities(user.getAuthorities().stream()
                                                  .map(SimpleGrantedAuthority::new)
                                                  .collect(Collectors.toSet()))
                                 .username(user.getUsername())
                                 .password(user.getPassword())
                                 .firstName(user.getUserProfile().getFirstName())
                                 .middleName(user.getUserProfile().getMiddleName())
                                 .lastName(user.getUserProfile().getLastName())
                                 .enabled(user.isEnabled())
                                 .build();
    }
}
