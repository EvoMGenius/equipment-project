package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.QBaseDictionary;
import org.apatrios.model.dictoinary.QRejectionReason;
import org.apatrios.model.dictoinary.RejectionReason;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.RejectionReasonRepository;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RejectionReasonService extends BaseDictionaryService<RejectionReason, BaseDictionarySearchArgument, QBaseDictionary> {

    private final RejectionReasonRepository repository;

    @Override
    protected BaseDictionaryRepository<RejectionReason> getRepository() {
        return this.repository;
    }

    @Override
    protected QBaseDictionary getQRoot() {
        return QRejectionReason.rejectionReason._super;
    }
}
