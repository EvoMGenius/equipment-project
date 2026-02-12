package org.apatrios.service.services.photo.argument;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreatePhotoArgument {
    String fileName;

    String fileUrl;
}
