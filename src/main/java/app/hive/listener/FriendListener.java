package app.hive.listener;

import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.EventChannel;
import net.mamoe.mirai.event.events.FriendMessageEvent;
/**
 * Copyright (c) 2022. Jason Wang (wxw126mail@126.com)
 * Title: Config
 * Description: 插件配置类
 *
 * @author: 王晓文
 * @date: 2022/7/26 22:53
 */
public class FriendListener {

    public static final FriendListener INSTANCE = new FriendListener();

    private FriendListener() {}

    public void listenFriend(EventChannel<Event> eventChannel) {
        //监听群消息
        eventChannel.subscribeAlways(FriendMessageEvent.class, this::handlerFriendMessage);
    }

    private void handlerFriendMessage(FriendMessageEvent messageEvent) {
    }
}
