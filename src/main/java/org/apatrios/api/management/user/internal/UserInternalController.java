package org.apatrios.api.management.user.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/user")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserInternalController {
}
