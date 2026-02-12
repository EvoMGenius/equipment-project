package org.apatrios.api.management.doc;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.api.management.doc.dto.DocumentDto;
import org.apatrios.api.management.doc.dto.SearchDocumentDto;
import org.apatrios.service.management.document.DocumentService;
import org.apatrios.service.management.document.argument.SearchDocumentArgument;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.management.doc.mapper.DocumentMapper.DOCUMENT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/management/doc")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DocumentController {

    DocumentService service;
    Action<UUID, InputStream> downloadDocumentAction;

    @PostMapping("search")
    public List<DocumentDto> list(@RequestBody SearchDocumentDto dto, Sort sort) {
        SearchDocumentArgument argument = DOCUMENT_MAPPER.toSearchArgument(dto);
        return service.list(argument, sort)
                      .stream()
                      .map(DOCUMENT_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("{id}")
    public DocumentDto get(@PathVariable UUID id) {
        return DOCUMENT_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("{id}/download")
    public ResponseEntity<Resource> download(@PathVariable UUID id) {
        InputStream stream = downloadDocumentAction.execute(id);
        InputStreamResource resource = new InputStreamResource(stream);
        return ResponseEntity.ok()
                             .header(HttpHeaders.CONTENT_DISPOSITION)
                             .contentType(MediaType.APPLICATION_OCTET_STREAM)
                             .body(resource);
    }
}