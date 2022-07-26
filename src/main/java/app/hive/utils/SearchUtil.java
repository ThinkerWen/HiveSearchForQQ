package app.hive.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import java.io.IOException;

/**
 * Copyright (c) 2022. Jason Wang (wxw126mail@126.com)
 * Title: SearchUtil
 * Description: 插件工具类
 *
 * @author: 王晓文
 * @date: 2022/7/26 22:53
 */
public class SearchUtil implements Constant{

    public static String searchReason(String askQuestion, String token) {
        String url = String.format("https://www.hive-net.cn/wangke/?token=%s&question=%s", token, askQuestion);
        String body = null;
        StringBuilder result = new StringBuilder();
        try {
            body = Jsoup.connect(url).ignoreContentType(true).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(body);
        } catch (JsonProcessingException e) {
            return "请求出错，请联系作者！";
        }
        if (jsonNode.get("code").asInt() != 0) return "";
        JsonNode resultList = jsonNode.get("result");
        for (JsonNode node : resultList) {
            String course = node.get("course").asText();
            String options = "无";
            if (node.get("type").asInt() == 1) {
                options = node.get("options").asText();
            }
            String question = node.get("question").asText();
            String reason = node.get("reason").asText();
            String resultSingle = String.format(SINGLE_RESULT, question, options, reason, course);
            result.append(resultSingle);
        }
        return result.toString();
    }
}
