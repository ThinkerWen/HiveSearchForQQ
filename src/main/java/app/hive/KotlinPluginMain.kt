package app.hive

import app.hive.config.Config
import app.hive.service.MiraiGlobal
import net.mamoe.mirai.console.plugin.jvm.*
import net.mamoe.mirai.event.GlobalEventChannel


/**
 * Copyright (c) 2022. Jason Wang (wxw126mail@126.com)
 * Title: KotlinPluginMain
 * Description: 插件入口类
 *
 * @author: 王晓文
 * @date: 2022/7/30 19:00
 */
object KotlinPluginMain : KotlinPlugin(

    JvmPluginDescriptionBuilder("cn.hive.plugin.HiveSearch", "1.3.0")
        .name("HiveSearch网课搜题")
        .info("网课答案搜索")
        .author("微信公众号：夜寒信息")
        .build()
) {

    override fun onEnable() {
        Config.reload()
        logger.info("网课搜题 for Mirai已启用")
        val miraiGlobal = MiraiGlobal.INSTANCE
        val eventChannel = GlobalEventChannel.parentScope(this)
        miraiGlobal.listen(eventChannel)
    }
}
