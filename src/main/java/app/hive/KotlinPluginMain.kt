package app.hive

import app.hive.config.Config
import app.hive.service.MiraiGlobal
import net.mamoe.mirai.console.plugin.jvm.*
import net.mamoe.mirai.event.GlobalEventChannel


object KotlinPluginMain : KotlinPlugin(

    JvmPluginDescriptionBuilder("cn.hive.plugin.mirai", "1.2.1")
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
