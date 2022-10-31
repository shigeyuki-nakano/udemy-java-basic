package ComEx2.attendance_calculation.utility;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadFileUtil {
    public static List<String[]> csv(Path csvFilePath) throws IOException {
        List<String[]> content = new ArrayList<>();
        List<String> fileLines = Files.readAllLines(csvFilePath.toAbsolutePath(), Charset.defaultCharset());

        for(String line : fileLines) {
            String[] data = line.split(",");
            content.add(data);
        }

        return content;
    }
}
