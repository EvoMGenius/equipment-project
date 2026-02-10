package org.apatrios.service.management.user.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.UserRole;
import org.apatrios.model.management.Franchisee;
import org.apatrios.model.management.Staff;
import org.apatrios.model.management.UserProfile;

import java.util.Set;

@Value
@Builder
public class CreateUserArgument {
    String username;
    String login;
    String password;
    Set<UserRole> userRoles;
    UserProfile userProfile;
    Franchisee company;
    Staff staff;
}
