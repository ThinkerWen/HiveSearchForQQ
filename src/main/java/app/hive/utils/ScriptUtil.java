package app.hive.utils;

import app.hive.entity.Config;
import net.mamoe.mirai.BotFactory;

public class ScriptUtil implements Constant{

    public static String identifyScript(Config config, String message) {

        if (!config.isAllHost() && ALL_HOST_ON_SCRIPT.equals(message)) {
            config.setAllHost(true);
            return ALL_HOST_ON;
        }
        else if (config.isAllHost() && ALL_HOST_OFF_SCRIPT.equals(message)) {
            config.setAllHost(false);
            return ALL_HOST_OFF;
        }

        if (!config.isAllGroup() && ALL_GROUP_ON_SCRIPT.equals(message)) {
            config.setAllGroup(true);
            return ALL_GROUP_ON;
        }
        else if (config.isAllGroup() &&  ALL_GROUP_OFF_SCRIPT.equals(message)) {
            config.setAllGroup(false);
            return ALL_GROUP_OFF;
        }

        return null;
    }
}
