package com.metricv.yubiauth

import com.metricv.yubiauth.command.RootCommand
import com.metricv.yubiauth.listener.PlayerFreezer
import com.metricv.yubiauth.listener.PlayerLoginEventListener
import org.bukkit.plugin.java.JavaPlugin

class PluginMain : JavaPlugin() {
    override fun onLoad() {
        super.onLoad()
        saveDefaultConfig()
        PluginGlobal.plugin = this;
        PluginGlobal.config = this.config;
    }

    override fun onEnable() {
        super.onEnable()
        this.getCommand("yubiauth")?.setExecutor(RootCommand())
        this.server.pluginManager.registerEvents(PlayerFreezer, this)
        this.server.pluginManager.registerEvents(PlayerLoginEventListener, this)
    }
}