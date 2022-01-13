package app.hive;

import app.hive.service.MiraiGlobal;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.EventChannel;
import net.mamoe.mirai.event.GlobalEventChannel;


public final class JavaPluginMain extends JavaPlugin {

    private MiraiGlobal miraiGlobal = MiraiGlobal.INSTANCE;

    public static final JavaPluginMain INSTANCE = new JavaPluginMain();
    private JavaPluginMain() {
        super(new JvmPluginDescriptionBuilder("cn.hive.plugin.mirai", "1.0.0")
                .name("HiveSearch网课搜题")
                .info("网课答案搜索")
                .author("微信公众号：夜寒信息")
                .build());
    }

    @Override
    public void onEnable() {
        getLogger().info("网课搜题 for Mirai已启用");
        EventChannel<Event> eventChannel = GlobalEventChannel.INSTANCE.parentScope(this);
        miraiGlobal.loadListener(eventChannel);
    }
}
