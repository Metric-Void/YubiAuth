package com.metricv.yubiauth.db

import org.bukkit.entity.Player
import java.time.Instant

/**
 * This is an abstract interface that represents a database connection.
 * The implementation should provide all these functions for data persistency.
 */
interface AbstractDataSource {
    /** Check if a player has elected (or elected out of) YubiAuth. */
    fun getPlayerBound(p: Player)

    /** Get the Yubikey OTP username of a player. */
    fun getPlayerYubiUsername(p: Player)

    /** Check if a player is under breakglass. */
    fun getPlayerBreakglass(p: Player)

    /** Register that a breakglass event has occured. */
    fun registerBreakGlassOccurence(p: Player)

    /** Set the Yubikey OTP username for a player. */
    fun setPlayerYubiUsername(p: Player, keyName: String)

    /** Allow a player to bypass 2FA for ${count} times. */
    fun setBreakGlassByCount(p: Player, count: Int)

    /** Allow a player to bypass 2FA until a certain time. */
    fun setBreakGlassUntil(p: Player, timeUntil: Instant)

    /** Remoke all breakglass sessions for a player. */
    fun revokeAllBreakglass(p: Player)
}