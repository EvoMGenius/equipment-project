package org.apatrios.service.details;

import com.github.dockerjava.api.exception.ConflictException;
import lombok.RequiredArgsConstructor;
import org.apatrios.model.management.User;
import org.apatrios.repository.managment.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ElBikesUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        User user = repository.findByPhoneNumber(phoneNumber)
                              .orElseThrow(() -> new ConflictException("User.Bad.Credentials"));

        return getUserDetails(user);
    }

    private ElBikesUserDetails getUserDetails(User user) {
        return ElBikesUserDetails.builder()
                                 .id(user.getId())
                                 .username(user.getPhoneNumber())
                                 .password(user.getPassword())
                                 .build();
    }
}
