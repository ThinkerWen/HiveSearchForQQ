package app.hive;

import app.hive.config.Config;
import app.hive.service.MiraiGlobal;
import app.hive.utils.JsonConfigUtil;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.EventChannel;
import net.mamoe.mirai.event.GlobalEventChannel;

import java.io.IOException;

/**
 * Copyright (c) 2022. Jason Wang (wxw126mail@126.com)
 * Title: JavaPluginMain
 * Description: 插件主类
 *
 * @author: 王晓文
 * @date: 2022/7/26 22:53
 */
public final class JavaPluginMain extends JavaPlugin {

    private final MiraiGlobal miraiGlobal = MiraiGlobal.INSTANCE;


    public static final JavaPluginMain INSTANCE = new JavaPluginMain();
    private JavaPluginMain() {
        super(new JvmPluginDescriptionBuilder("cn.hive.plugin.mirai", "1.1.0")
                .name("HiveSearch网课搜题")
                .info("网课答案搜索")
                .author("微信公众号：夜寒信息")
                .build());
    }

    @Override
    public void onEnable() {
        Config config = Config.INSTANCE;
        // 创建本地配置文件
        try {
            if (JsonConfigUtil.createConfigFile("HiveSearch")){
                JsonConfigUtil.setConfigFile("HiveSearch", config);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 启动插件载入本地json
        try {
            config = (Config) JsonConfigUtil.getConfigFromFile("HeroPower", Config.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getLogger().info("网课搜题 for Mirai已启用");
        EventChannel<Event> eventChannel = GlobalEventChannel.INSTANCE.parentScope(this);
        miraiGlobal.listen(eventChannel);
    }
}
