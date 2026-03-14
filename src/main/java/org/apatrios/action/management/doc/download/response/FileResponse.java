package org.apatrios.action.management.doc.download.response;

import lombok.Builder;

import java.io.InputStream;

@Builder
public record FileResponse(InputStream inputStream, String fileName) {
}
