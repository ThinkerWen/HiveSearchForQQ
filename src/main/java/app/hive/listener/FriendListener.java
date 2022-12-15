package app.hive.listener;

import app.hive.config.Config;
import app.hive.utils.Constant;
import app.hive.utils.SearchUtil;
import kotlin.coroutines.CoroutineContext;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2022. Jason Wang (wxw126mail@126.com)
 * Title: Config
 * Description: 插件配置类
 *
 * @author: 王晓文
 * @date: 2022/7/26 22:53
 */
public class FriendListener extends SimpleListenerHost implements Constant {

    private Config config = Config.INSTANCE;
    public static final FriendListener INSTANCE = new FriendListener();

    @Override
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        System.out.println("出现未捕获错误");
    }

    @EventHandler
    private void onQuestion(@NotNull FriendMessageEvent messageEvent) {
        String message = messageEvent.getMessage().contentToString();
        if (message.charAt(0) == PREFIX) {
            String reason = SearchUtil.searchReason(message.substring(1), config.getToken());
            if (reason == null) reason = "暂无结果，我们已经收到您的需求，请过段时间再次前来查询。";
            messageEvent.getSender().sendMessage(reason);
        }
    }
}
