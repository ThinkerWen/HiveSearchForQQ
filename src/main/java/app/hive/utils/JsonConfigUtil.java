package app.hive.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Copyright (c) 2022. Jason Wang (wxw126mail@126.com)
 * Title: JsonConfigUtil
 * Description:
 *
 * @author: 王晓文
 * @date: 2022/7/26 23:54
 */

public class JsonConfigUtil {

    public static <T> T getConfigFromFile(String fileName, Class<T> object) throws IOException {
        String filePath = String.format("/config/%s/%s.json", fileName, fileName);
//        String filePath = "D:\\IntelliJ Project\\MiraiSearch\\config\\HiveSearch\\HiveSearch.json";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
        StringBuilder jsonString = new StringBuilder();
        String buffer;
        while ((buffer = reader.readLine()) != null) {
            jsonString.append(buffer);
        }

        ObjectMapper mapper = new ObjectMapper();
        return (T) mapper.readValue(jsonString.toString(), object);
    }

    public static void setConfigFile(String fileName, Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        String filePath = String.format("config/%s/%s.json", fileName, fileName);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath,false), StandardCharsets.UTF_8));
        bw.write(jsonString);
        bw.close();
    }

    public static boolean createConfigFile(String fileName) throws IOException {
        String filePath = String.format("config/%s/%s.json", fileName, fileName);
        File file = new File(filePath);
        File dir = new File("config/" + fileName);
        if (!file.exists()) {
            return dir.mkdirs() && file.createNewFile();
        }
        return false;
    }
}
