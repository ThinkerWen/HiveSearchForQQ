package org.example.mirai.plugin

import app.hive.JavaPluginMain
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.console.MiraiConsole
import net.mamoe.mirai.console.plugin.PluginManager.INSTANCE.enable
import net.mamoe.mirai.console.plugin.PluginManager.INSTANCE.load
import net.mamoe.mirai.console.terminal.MiraiConsoleTerminalLoader
import net.mamoe.mirai.utils.BotConfiguration

suspend fun main() {
    MiraiConsoleTerminalLoader.startAsDaemon()

    //如果是Java
    JavaPluginMain.INSTANCE.load()
    JavaPluginMain.INSTANCE.enable()

    val bot = BotFactory.newBot(123456, "") {
        // 配置，例如：
        fileBasedDeviceInfo()
        protocol = BotConfiguration.MiraiProtocol.ANDROID_PAD
    }.alsoLogin()

    MiraiConsole.job.join()
}
