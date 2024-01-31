package iegcode.validation.extractor;

import iegcode.validation.container.DataInteger;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.UnwrapByDefault;
import jakarta.validation.valueextraction.ValueExtractor;

@UnwrapByDefault
public class DataIntegerValueExecutor
        implements ValueExtractor<@ExtractedValue(type = Integer.class) DataInteger> {
    @Override
    public void extractValues(DataInteger originValue, ValueReceiver receiver) {
        receiver.value(null, originValue.getData());
    }
}
