package com.metricv.yubiauth.command

import com.metricv.yubiauth.listener.PlayerFreezer
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

/**
 * Executor for the yubiauth base command.
 */
class RootCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty() || args[0] == "info") {
            sendInfo(sender, command, label, args)
            return true
        }

        when (args[0]) {
            "debug" -> {
                debugCommand(sender, command, label, args.slice(1 until args.size))
                return true
            }

            else -> {
                unRecognized(sender, command, label, args)
                return false
            }
        }
    }

    private fun sendInfo(sender: CommandSender, command: Command, label: String, args: Array<out String>) {

    }

    private fun debugCommand(sender: CommandSender, command: Command, label: String, args: List<String>) {
        if (args.isEmpty() || args[0] == "help") {
            /* Print some help message */
            return
        }

        when (args[0]) {
            "freeze" -> sender.server.getPlayer(args[1])?.let {
                PlayerFreezer.freezePlayer(it)
                sender.sendMessage("${args[1]} frozen.")
            }
            "unfreeze" -> sender.server.getPlayer(args[1])?.let {
                PlayerFreezer.unfreezaPlayer(it)
                sender.sendMessage("${args[1]} unfrozen.")
            }
        }
    }

    private fun unRecognized(sender: CommandSender, command: Command, label: String, args: Array<out String>) {

    }
}