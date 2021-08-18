package com.metricv.yubiauth.listener

import org.bukkit.Server
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.SignChangeEvent
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryOpenEvent
import org.bukkit.event.player.*
import java.util.*


/**
 * Freezes a player, prohibit all movements, chats or commands.
 * Chats will be redirected.
 */
object PlayerFreezer : Listener {
    val frozenPlayers = HashSet<UUID>();

    fun freezePlayer(p: Player) {
        frozenPlayers.add(p.uniqueId)
    }

    fun unfreezaPlayer(p: Player) {
        frozenPlayers.remove(p.uniqueId)
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerChat(e: AsyncPlayerChatEvent) {
        if (frozenPlayers.contains(e.player.uniqueId)
            && !e.player.hasPermission("yubiauth.unauthed.chat")
        ) e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerMove(e: PlayerMoveEvent) {
        if (frozenPlayers.contains(e.player.uniqueId)
            && !e.player.hasPermission("yubiauth.unauthed.move")
        ) e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerSwapHandItemEvent(e: PlayerSwapHandItemsEvent) {
        if (frozenPlayers.contains(e.player.uniqueId)
            && !e.player.hasPermission("yubiauth.unauthed.swapitem")
        ) e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerArmorStandManipulate(e: PlayerArmorStandManipulateEvent) {
        if (frozenPlayers.contains(e.player.uniqueId)
            && !e.player.hasPermission("yubiauth.unauthed.armorstand")
        ) e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerInventoryClick(e: InventoryClickEvent) {
        if (frozenPlayers.contains(e.whoClicked.uniqueId)
            && !e.whoClicked.hasPermission("yubiauth.unauthed.invclick")
        ) e.isCancelled = false
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerOpenInv(e: InventoryOpenEvent) {
        if (frozenPlayers.contains(e.player.uniqueId)
            && !e.player.hasPermission("yubiaht.unauthed.openinv")
        ) e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerConsumeItem(e: PlayerItemConsumeEvent) {
        if (frozenPlayers.contains(e.player.uniqueId)
            && !e.player.hasPermission("yubiauth.unauthed.consume")
        ) e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerPickupItem(e: EntityPickupItemEvent) {
        if (e.entity is Player
            && frozenPlayers.contains(e.entity.uniqueId)
            && !(e.entity as Player).hasPermission("yubiauth.unauthed.pickupitem")
        ) e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerDropItem(e: PlayerDropItemEvent) {
        if (frozenPlayers.contains(e.player.uniqueId)
            && !e.player.hasPermission("yubiauth.unauthed.dropitem")
        ) e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerHeldItem(e: PlayerItemHeldEvent) {
        if (frozenPlayers.contains(e.player.uniqueId)
            && !e.player.hasPermission("yubiauth.unauthed.holditem")
        ) e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerInteract(e: PlayerInteractEvent) {
        if (frozenPlayers.contains(e.player.uniqueId)
            && !e.player.hasPermission("yubiauth.unauthed.interact")
        )
            e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerInteractEntity(e: PlayerInteractEntityEvent) {
        if (frozenPlayers.contains(e.player.uniqueId)
            && !e.player.hasPermission("yubiauth.unauthed.interactentity")
        )
            e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerInteractEntity(e: PlayerInteractAtEntityEvent) {
        if (frozenPlayers.contains(e.player.uniqueId)
            && !e.player.hasPermission("yubiauth.unauthed.interactatentity")
        ) e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerHit(e: EntityDamageByEntityEvent) {
        if (e.entity is Player
            && frozenPlayers.contains(e.entity.uniqueId)
            && !e.entity.hasPermission("yubiauth.unauthed.hit")
        ) e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerShear(e: PlayerShearEntityEvent) {
        if (frozenPlayers.contains(e.entity.uniqueId)
            && !e.entity.hasPermission("yubiauth.unauthed.shear")
        ) e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerFish(e: PlayerFishEvent) {
        if (frozenPlayers.contains(e.player.uniqueId)
            && !e.player.hasPermission("yubiauth.unauthed.fish")
        ) e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerOnBed(e: PlayerBedEnterEvent) {
        if (frozenPlayers.contains(e.player.uniqueId)
            && !e.player.hasPermission("yubiauth.unauthed.sleep")
        ) e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerEditBook(e: PlayerEditBookEvent) {
        if (frozenPlayers.contains(e.player.uniqueId)
            && !e.player.hasPermission("yubiauth.unauthed.editbook")
        ) e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerHit(e: SignChangeEvent) {
        if (frozenPlayers.contains(e.player.uniqueId)
            && !e.player.hasPermission("yubiauth.unauthed.changesign")
        ) e.isCancelled = true
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerLeave(e: PlayerQuitEvent) {
        frozenPlayers.remove(e.player.uniqueId)
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun onPlayerExecCommand(e: PlayerCommandPreprocessEvent) {
        if (frozenPlayers.contains(e.player.uniqueId)
            && !e.player.hasPermission("yubiauth.unauthed.command")
        ) e.isCancelled = true
    }
}