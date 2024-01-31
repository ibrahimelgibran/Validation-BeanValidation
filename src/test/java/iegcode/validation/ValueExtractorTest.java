package iegcode.validation;

import iegcode.validation.container.Data;
import iegcode.validation.container.DataInteger;
import iegcode.validation.container.Entry;
import org.junit.jupiter.api.Test;

public class ValueExtractorTest extends  AbstractValidatorTest{

    @Test
    void testSampleData() {

        SampleData data = new SampleData();
        data.setData(new Data<>());
        data.getData().setData(" ");

        validate(data);
    }

    @Test
    void testSampleEntry() {

        SampleEntry sampleEntry = new SampleEntry();
        sampleEntry.setEntry(new Entry<>());
        sampleEntry.getEntry().setKey("");
        sampleEntry.getEntry().setValue("");

        validate(sampleEntry);
    }

    @Test
    void testSampleDataInteger() {

        SampleDataInteger sampleDataInteger = new SampleDataInteger();
        sampleDataInteger.setData(new DataInteger());
        sampleDataInteger.getData().setData(0);

        validate(sampleDataInteger);
    }
}
