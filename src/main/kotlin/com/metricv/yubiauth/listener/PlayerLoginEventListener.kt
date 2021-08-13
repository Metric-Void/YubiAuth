package com.metricv.yubiauth.listener

import com.metricv.yubiauth.PluginGlobal
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

public class PlayerLoginEventListener : Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    fun onPlayerJoin(event: PlayerJoinEvent) {
        PluginGlobal.getSensitivePermissions().forEach {
            if (event.player.hasPermission(it)) {
                PlayerFreezer.freezePlayer(event.player)
                event.player.sendMessage(PluginGlobal.getMessage("frozen"))
                return;
            }
        }
    }
}