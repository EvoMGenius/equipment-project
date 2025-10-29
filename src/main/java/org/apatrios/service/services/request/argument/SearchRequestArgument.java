package org.apatrios.service.services.request.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.services.RequestStatus;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class SearchRequestArgument {
    String phone;
    String surname;
    String searchString;
    String name;
    UUID serviceTypeId;
    UUID modelBikeId;
    String note;
    UUID clientId;
    RequestStatus status;
    LocalDateTime createDateFrom;
    LocalDateTime createDateTo;
    LocalDateTime updateDateFrom;
    LocalDateTime updateDateTo;
    boolean isDeleted;
    UUID rejectionReasonId;
    String rejectNote;
    Set<UUID> franchiseeIds;
}
