package com.metricv.yubiauth

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
    }

}