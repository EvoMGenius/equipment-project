package org.apatrios.service.services.photo;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.services.Photo;
import org.apatrios.model.services.QPhoto;
import org.apatrios.repository.services.PhotoRepository;
import org.apatrios.service.services.photo.argument.CreatePhotoArgument;
import org.apatrios.service.services.photo.argument.SearchPhotoArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository repository;
    private final QPhoto qPhoto = QPhoto.photo;

    @Transactional
    public Photo create(@NonNull CreatePhotoArgument argument) {
        return repository.save(Photo.builder()
                                    .fileName(argument.getFileName())
                                    .fileUrl(argument.getFileUrl())
                                    .build());
    }

    @Transactional(readOnly = true)
    public Photo getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Photo.notFound"));
    }

    @Transactional(readOnly = true)
    public List<Photo> getAllByIds(@NonNull List<UUID> id) {
        return repository.findAllById(id);
    }

    @Transactional(readOnly = true)
    public List<Photo> list(@NonNull SearchPhotoArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    private Predicate buildPredicate(SearchPhotoArgument argument) {
        return QPredicates.builder()
                          .add(argument.getFileName(), qPhoto.fileName::containsIgnoreCase)
                          .add(argument.getFileUrl(), qPhoto.fileUrl::containsIgnoreCase)
                          .buildAnd();
    }
}
