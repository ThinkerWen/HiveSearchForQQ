package app.hive.service;

import app.hive.config.Config;
import app.hive.listener.FriendListener;
import app.hive.listener.GroupListener;
import app.hive.listener.SettingEventHolder;
import app.hive.utils.PermissionUtil;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.EventChannel;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.apache.commons.lang3.StringUtils;

/**
 * Copyright (c) 2022. Jason Wang (wxw126mail@126.com)
 * Title: MiraiGlobal
 * Description: 全局Event监听加载器
 *
 * @author: 王晓文
 * @date: 2022/7/26 22:53
 */
public class MiraiGlobal {

    private final GroupListener groupListener = GroupListener.INSTANCE;
    private final SettingEventHolder settingEventHolder = SettingEventHolder.INSTANCE;
    private final FriendListener friendListener = FriendListener.INSTANCE;
    private Config config = Config.INSTANCE;
    public static final MiraiGlobal INSTANCE = new MiraiGlobal();

    public void listen(EventChannel<Event> eventChannel) {
        if (!config.getEnable()) return;

        eventChannel.filter(event ->
                        StringUtils.isNotBlank(((FriendMessageEvent) event).getMessage().contentToString()))
                        .registerListenerHost(friendListener);

        eventChannel.filter(event ->
                        PermissionUtil.isGroupEnable(((GroupMessageEvent) event).getGroup().getId()) &&
                        StringUtils.isNotBlank(((GroupMessageEvent) event).getMessage().contentToString()))
                        .registerListenerHost(groupListener);

        eventChannel.filter(event ->
                        (config.getAllHost() ||
                        PermissionUtil.isHost(((GroupMessageEvent) event).getSender().getId())) &&
                        StringUtils.isNotBlank(((GroupMessageEvent) event).getMessage().contentToString()))
                        .registerListenerHost(settingEventHolder);
    }
}