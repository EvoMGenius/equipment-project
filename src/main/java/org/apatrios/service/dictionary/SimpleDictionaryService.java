package org.apatrios.service.dictionary;

import org.apatrios.model.dictoinary.BaseDictionary;
import org.apatrios.model.dictoinary.QBaseDictionary;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;

public abstract class SimpleDictionaryService<T extends BaseDictionary>
        extends BaseDictionaryService<T, BaseDictionarySearchArgument, QBaseDictionary> {
}
