package org.externaldata.app.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUtils {

    private static final String JSON_REGEX_FORMAT = "\\{.*}";

    public String parseJsonStr(String context) {
        Pattern p = Pattern.compile(JSON_REGEX_FORMAT);
        Matcher matcher = p.matcher(context);

        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
