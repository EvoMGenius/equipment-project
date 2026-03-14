package org.apatrios.service.details;

import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
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
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        User user = repository.findByPhoneNumber(phoneNumber)
                              .orElseThrow(() -> new EntityNotFoundException("User.Bad.Credentials"));

        return getUserDetails(user);
    }

    private ElBikesUserDetails getUserDetails(User user) {
        return ElBikesUserDetails.builder()
                                 .id(user.getId())
                                 .username(user.getPhoneNumber())
                                 .authorities(user.getAuthorities().stream()
                                                  .map(SimpleGrantedAuthority::new)
                                                  .collect(Collectors.toSet()))
                                 .build();
    }
}
