package org.apatrios.api.management.doc;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.doc.create.argument.CreateDocumentActionArgument;
import org.apatrios.action.management.doc.download.response.FileResponse;
import org.apatrios.action.management.doc.upload.UploadDocumentAction;
import org.apatrios.api.management.doc.dto.CreateDocumentDto;
import org.apatrios.api.management.doc.dto.DocumentDto;
import org.apatrios.api.management.doc.dto.SearchDocumentDto;
import org.apatrios.model.management.Document;
import org.apatrios.service.management.document.DocumentService;
import org.apatrios.util.CollectionDto;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import static org.apatrios.api.management.doc.mapper.DocumentMapper.DOCUMENT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/management/doc")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DocumentController {

    DocumentService service;
    Action<UUID, FileResponse> downloadDocumentAction;
    Action<CreateDocumentActionArgument, Document> createDocumentAction;
    UploadDocumentAction uploadDocumentAction;

    @GetMapping("search")
    public CollectionDto<DocumentDto> page(SearchDocumentDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(DOCUMENT_MAPPER.toSearchArgument(dto), pageable)
                                       .map(DOCUMENT_MAPPER::toDto));
    }

    @GetMapping("{id}")
    public DocumentDto get(@PathVariable UUID id) {
        return DOCUMENT_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("{id}/download")
    public ResponseEntity<InputStreamResource> download(@PathVariable UUID id) {
        FileResponse fileResponse = downloadDocumentAction.execute(id);
        return ResponseEntity.ok()
                             .contentType(MediaType.APPLICATION_OCTET_STREAM)
                             .header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment()
                                                                                        .filename(fileResponse.getFileName(), StandardCharsets.UTF_8)
                                                                                        .build().toString())
                             .body(new InputStreamResource(fileResponse.getInputStream()));
    }

    @PostMapping("{id}/upload")
    public void upload(@PathVariable UUID id, @RequestParam("file") MultipartFile file) {
        uploadDocumentAction.execute(id, file);
    }

    @PostMapping
    public DocumentDto create(@RequestBody CreateDocumentDto dto) {
        return DOCUMENT_MAPPER.toDto(createDocumentAction.execute(DOCUMENT_MAPPER.toCreateArgument(dto)));
    }
}