package app.hive.listener;

import app.hive.config.Config;
import app.hive.utils.Constant;
import app.hive.utils.JsonConfigUtil;
import net.mamoe.mirai.contact.Group;
import kotlin.coroutines.CoroutineContext;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Copyright (c) 2022. Jason Wang (wxw126mail@126.com)
 * Title: SettingEventHolder
 * Description: 搜题插件设置监听器
 *
 * @author: 王晓文
 * @date: 2022/7/27 1:02
 */
public class SettingEventHolder extends SimpleListenerHost implements Constant {

    public static final SettingEventHolder INSTANCE = new SettingEventHolder();
    Config config = Config.INSTANCE;

    @Override
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        System.out.println("出现未捕获错误");
    }

    @EventHandler
    private void onSettings(@NotNull GroupMessageEvent event) throws IOException {
        Group group = event.getGroup();
        if (SEARCH_ON_KEY.equals(event.getMessage().contentToString())) {
            config.addGroup(group.getId());
            JsonConfigUtil.setConfigFile("HiveSearch", config);
            group.sendMessage(SEARCH_ON);
        }
        else if (SEARCH_OFF_KEY.equals(event.getMessage().contentToString())) {
            config.removeGroup(group.getId());
            JsonConfigUtil.setConfigFile("HiveSearch", config);
            group.sendMessage(SEARCH_OFF);
        }
        else if (ALL_HOST_ON_KEY.equals(event.getMessage().contentToString())) {
            config.setAllHost(true);
            JsonConfigUtil.setConfigFile("HiveSearch", config);
            group.sendMessage(ALL_HOST_ON);
        }
        else if (ALL_HOST_OFF_KEY.equals(event.getMessage().contentToString())) {
            config.setAllHost(false);
            JsonConfigUtil.setConfigFile("HiveSearch", config);
            group.sendMessage(ALL_HOST_OFF);
        }
    }
}
