package org.apatrios.service.details;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Builder
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ElBikesUserDetails implements UserDetails {

    UUID id;
    String username;
    String password;
    Set<? extends GrantedAuthority> authorities;
    String firstName;
    String lastName;
    String middleName;
    @Builder.Default
    boolean enabled = true;
    @Builder.Default
    boolean accountNonLocked = true;
    @Builder.Default
    boolean accountNonExpired = true;
    @Builder.Default
    boolean credentialsNonExpired = true;
}
