package one.theaq.mcware.server

import net.minestom.server.coordinate.Pos
import net.minestom.server.event.GlobalEventHandler
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent
import one.theaq.mcware.instance.InstanceRegistry

class ServerEvents(val globalEventHandler: GlobalEventHandler) {
    fun registerEvents() {
        globalEventHandler.addListener(AsyncPlayerConfigurationEvent::class.java) { asyncPlayerConfiguration(it) }
    }

    fun asyncPlayerConfiguration(event: AsyncPlayerConfigurationEvent) {
        val player = event.player
        event.spawningInstance = InstanceRegistry.LOBBY
        player.respawnPoint = Pos(0.0, 4.0, 0.0)
    }
}