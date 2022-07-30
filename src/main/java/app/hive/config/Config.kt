package app.hive.config

import net.mamoe.mirai.console.data.*

/**
 * Copyright (c) 2022. Jason Wang (wxw126mail@126.com)
 * Title: Config
 * Description:
 * @author: 王晓文
 * @date: 2022/7/30 14:30
 */
public object Config : AutoSavePluginConfig("HiveSearch") {

    @ValueName("enable")
    @ValueDescription("是否启用插件")
    var enable by value<Boolean>(true)

    @ValueName("allHost")
    @ValueDescription("是否所有人可控制插件")
    var allHost by value<Boolean>(false)

    @ValueName("token")
    @ValueDescription("插件搜题接口token")
    val token by value<String>("free")

    @ValueName("hosts")
    @ValueDescription("插件的管理员")
    var hosts: MutableSet<Long> by value()

    @ValueName("groups")
    @ValueDescription("插件允许的群")
    var groups: MutableSet<Long> by value()

    fun addHost(host: Long) {
        for (id in hosts) if (id == host) return
        hosts.add(host)
    }

    fun addGroup(group: Long) {
        for (id in groups) if (id == group) return
        groups.add(group)
    }

    fun removeGroup(group: Long) {
        groups.remove(group)
    }


    override fun toString(): String {
        return "ConfigKt(enable=$enable, allHost=$allHost, token='$token', hosts=$hosts, groups=$groups)"
    }

}