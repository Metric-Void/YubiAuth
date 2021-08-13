package com.metricv.yubiauth

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.Plugin

object PluginGlobal {
    lateinit var plugin: Plugin
    lateinit var config: FileConfiguration

    fun getSensitivePermissions() : List<String> {
        return config.getStringList("SensitivePermissions")
    }

    fun getMessage(msgName: String) : String {
        return config.getString("Messages.${msgName}") ?: "Error: Messages.${msgName} not found.";
    }
}