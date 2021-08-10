package com.metricv.yubiauth.listener

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

public class PlayerLoginEventListener : Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public fun onPlayerJoin(event: PlayerJoinEvent) {
        
    }
}