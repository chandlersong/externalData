package rg.externaldata.app.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.externaldata.app.utils.JsonUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class JsonUtilsTest {

    @Test
    public void testParseJsonStr() throws IOException {

        JsonUtils utils = new JsonUtils();

        LineIterator expected = FileUtils.lineIterator(new File("src/test/resources/jsonUitlsData/expected"));
        LineIterator source = FileUtils.lineIterator(new File("src/test/resources/jsonUitlsData/source"));

        while (expected.hasNext()) {
            Assert.assertEquals(expected.next(), utils.parseJsonStr(source.next()));
        }

    }
}
