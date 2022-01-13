package app.hive.listener;

import app.hive.entity.Config;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.EventChannel;
import net.mamoe.mirai.event.events.FriendMessageEvent;

public class FriendListener {

    private Config config = Config.INSTANCE;
    public static final FriendListener INSTANCE = new FriendListener();

    private FriendListener() {}

    public void listenFriend(EventChannel<Event> eventChannel) {
        eventChannel.subscribeAlways(FriendMessageEvent.class, g -> {
            //监听群消息
            handlerFriendMessage(g);
        });
    }

    private void handlerFriendMessage(FriendMessageEvent messageEvent) {
    }
}
