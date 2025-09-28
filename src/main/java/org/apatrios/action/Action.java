package org.apatrios.action;

import lombok.NonNull;

public interface Action<ArgumentT, ReturnedT> {
    ReturnedT execute(@NonNull ArgumentT argument);
}
