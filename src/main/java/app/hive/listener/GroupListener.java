package app.hive.listener;

import app.hive.config.Config;
import app.hive.utils.Constant;
import app.hive.utils.SearchUtil;
import kotlin.coroutines.CoroutineContext;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.contact.Member;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.At;
import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2022. Jason Wang (wxw126mail@126.com)
 * Title: GroupListener
 * Description: 群聊Event监听器
 *
 * @author: 王晓文
 * @date: 2022/7/26 22:53
 */
public class GroupListener extends SimpleListenerHost implements Constant {

    private Config config = Config.INSTANCE;
    public static final GroupListener INSTANCE = new GroupListener();

    @Override
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        System.out.println("出现未捕获错误");
    }

    @EventHandler
    private void onHelp(@NotNull GroupMessageEvent event){
        if (HELP_KEY.equals(event.getMessage().contentToString())) {
            event.getGroup().sendMessage(HELP);
        }
    }

    @EventHandler
    private void onQuestion(@NotNull GroupMessageEvent messageEvent) {
        Member sender = messageEvent.getSender();
        Group group = messageEvent.getGroup();
        String message = messageEvent.getMessage().contentToString();

        if (message.charAt(0) == PREFIX) {
            String reason = SearchUtil.searchReason(message.substring(1), config.getToken());
            messageEvent.getGroup().sendMessage(new At(sender.getId()).plus(reason));
        }
    }
}
