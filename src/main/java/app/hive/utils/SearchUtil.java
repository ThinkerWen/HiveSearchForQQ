package app.hive.utils;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import java.io.IOException;


public class SearchUtil {

    public static String searchReason(String question, String token) {
        String url = String.format("https://wangke.hive-net.cn/wechat/searchHtml/?token=%s&question=%s", token, question);
        String body = null;
        try {
            body = Jsoup.connect(url).ignoreContentType(true).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(body);
        String reason = jsonObject.getString("reason");
        return reason;
    }
}
