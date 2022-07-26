package app.hive.utils;

import app.hive.config.Config;

/**
 * Copyright (c) 2022. Jason Wang (wxw126mail@126.com)
 * Title: PermissionUtil
 * Description:
 *
 * @author: 王晓文
 * @date: 2022/7/27 0:30
 */
public class PermissionUtil {

    public static boolean isHost(Long id) {
        for (Long host: Config.INSTANCE.getHosts()) {
            if (host.equals(id)) return true;
        }
        return false;
    }

    public static boolean isGroupEnable(Long id) {
        for (Long group:Config.INSTANCE.getGroups()) {
            if (group.equals(id)) return true;
        }
        return false;
    }
}