package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ItOtFileUtils {

    public static String readPayloadFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        return FileUtils.readFileToString(file, "UTF-8");
    }

}
