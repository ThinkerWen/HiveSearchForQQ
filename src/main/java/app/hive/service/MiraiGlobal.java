package app.hive.service;


import app.hive.listener.FriendListener;
import app.hive.listener.GroupListener;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.EventChannel;


public class MiraiGlobal {

    private GroupListener groupListener = GroupListener.INSTANCE;
    private FriendListener friendListener = FriendListener.INSTANCE;
    public static final MiraiGlobal INSTANCE = new MiraiGlobal();

    private MiraiGlobal() {}

    public void loadListener(EventChannel<Event> eventChannel) {

        groupListener.listenGroup(eventChannel);

        friendListener.listenFriend(eventChannel);
    }
}