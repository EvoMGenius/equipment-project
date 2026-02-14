package org.apatrios.action.management.doc.download.response;

import lombok.Builder;
import lombok.Value;

import java.io.InputStream;

@Value
@Builder
public class FileResponse {
    InputStream inputStream;
    String fileName;
}
