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
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ElBikesUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = repository.findByLogin(login)
                              .orElseThrow(() -> new ConflictException("User.Bad.Credentials"));

        if (!user.isEnabled()) throw new ConflictException("User.Access.Denied");

        return getUserDetails(user);
    }

    private ElBikesUserDetails getUserDetails(User user) {
        return ElBikesUserDetails.builder()
                                 .id(user.getId())
                                 .authorities(user.getRoles().stream()
                                                  .map(userRole -> new SimpleGrantedAuthority(userRole.getDictName()))
                                                  .collect(Collectors.toSet()))
                                 .username(user.getUsername())
                                 .login(user.getLogin())
                                 .password(user.getPassword())
                                 .enabled(user.isEnabled())
                                 .build();
    }
}
