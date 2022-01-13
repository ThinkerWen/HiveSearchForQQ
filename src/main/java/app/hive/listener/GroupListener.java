package app.hive.listener;

import app.hive.entity.Config;
import app.hive.utils.Constant;
import app.hive.utils.ScriptUtil;
import app.hive.utils.SearchUtil;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.contact.Member;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.EventChannel;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.At;
import org.apache.commons.lang3.StringUtils;

public class GroupListener implements Constant {

    private Config config = Config.INSTANCE;
    public static final GroupListener INSTANCE = new GroupListener();

    private GroupListener() {}

    public void listenGroup(EventChannel<Event> eventChannel) {
        eventChannel.subscribeAlways(GroupMessageEvent.class, g -> {
            //监听群消息
            handlerGroupMessage(g);
        });
    }

    private void handlerGroupMessage(GroupMessageEvent messageEvent) {
        Member sender = messageEvent.getSender();
        Group group = messageEvent.getGroup();
        String message = messageEvent.getMessage().contentToString();
        System.out.println(message);

        if (isHost(sender.getId())) {
            if (!config.isEnable() && SEARCH_ON_SCRIPT.equals(message)) {
                config.setEnable(true);
                messageEvent.getGroup().sendMessage(String.format(SERACH_ON, group.getName()));
                return;
            }
            else if (config.isEnable() && SEARCH_OFF_SCRIPT.equals(message)) {
                config.setEnable(false);
                messageEvent.getGroup().sendMessage(String.format(SERACH_OFF, group.getName()));
                return;
            }

            String scriptSendBack = ScriptUtil.identifyScript(config, message);
            if (!StringUtils.isBlank(scriptSendBack)) {
                messageEvent.getGroup().sendMessage(scriptSendBack);
            }
        }

        if (config.isEnable() && isGroup(group.getId())) {
            if (!StringUtils.isBlank(message)) {
                if (message.charAt(0) == PREFIX) {
                    String reason = SearchUtil.searchReason(message.substring(1), config.getToken());
                    messageEvent.getGroup().sendMessage(new At(sender.getId()).plus(reason));
                }
            }
        }
    }

    private boolean isGroup(long id) {
        for (long group : config.getGroup()) {
            if (config.isAllGroup() || group == id) return true;
        }
        return false;
    }

    private boolean isHost(long id) {
        for (long host : config.getHost()) {
            if (config.isAllHost() || host == id) return true;
        }
        return false;
    }
}
