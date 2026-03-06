package one.theaq.mcware.server

import net.minestom.server.coordinate.Pos
import net.minestom.server.entity.GameMode
import net.minestom.server.event.GlobalEventHandler
import net.minestom.server.event.instance.InstanceTickEvent
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent
import net.minestom.server.event.player.PlayerDisconnectEvent
import one.theaq.mcware.instance.InstanceRegistry

class ServerEvents(val globalEventHandler: GlobalEventHandler) {
	fun registerEvents() {
		globalEventHandler.addListener(AsyncPlayerConfigurationEvent::class.java, ::asyncPlayerConfiguration)
		globalEventHandler.addListener(PlayerDisconnectEvent::class.java, ::playerDisconnectEvent)
		globalEventHandler.addListener(InstanceTickEvent::class.java, ::serverTickEvent)
	}
	
	fun asyncPlayerConfiguration(event: AsyncPlayerConfigurationEvent) {
		val player = event.player
		event.spawningInstance = InstanceRegistry.LOBBY
		player.respawnPoint = Pos(0.0, 2.0, 0.0)
		player.gameMode = GameMode.ADVENTURE
	}
	
	fun playerDisconnectEvent(event: PlayerDisconnectEvent) {
		val instance = event.instance
		val player = event.player
		
		println(instance.players.joinToString(transform = { p -> "${p.username}" }))
		if (instance.players.count() <= 1 && instance.players.first().equals(player)) {
			println("${instance.uuid} is empty")
		}
	}
	
	fun serverTickEvent(event: InstanceTickEvent) {
	
	}
}