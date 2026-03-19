package org.apatrios.api.management.doc;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.doc.download.response.FileResponse;
import org.apatrios.action.management.doc.upload.UploadDocumentAction;
import org.apatrios.api.management.doc.dto.DocumentDto;
import org.apatrios.api.management.doc.dto.UploadDocumentDto;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import static org.apatrios.api.management.doc.mapper.DocumentMapper.DOCUMENT_MAPPER;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/management/doc")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DocumentController {

    Action<UUID, FileResponse> downloadDocumentAction;
    UploadDocumentAction uploadDocumentAction;

    @GetMapping("{id}/download")
    public ResponseEntity<InputStreamResource> download(@PathVariable UUID id) {
        FileResponse fileResponse = downloadDocumentAction.execute(id);
        return ResponseEntity.ok()
                             .contentType(MediaType.APPLICATION_OCTET_STREAM)
                             .header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment()
                                                                                        .filename(fileResponse.fileName(), StandardCharsets.UTF_8)
                                                                                        .build().toString())
                             .body(new InputStreamResource(fileResponse.inputStream()));
    }

    @PostMapping("upload")
    public DocumentDto upload(@Valid @RequestBody UploadDocumentDto dto, @RequestParam("file") MultipartFile file) {
       return DOCUMENT_MAPPER.toDto(uploadDocumentAction.execute(DOCUMENT_MAPPER.toUploadArgument(dto), file));
    }
}