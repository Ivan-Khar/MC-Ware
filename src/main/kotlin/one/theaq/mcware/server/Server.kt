package one.theaq.mcware.server

import net.minestom.server.Auth
import net.minestom.server.MinecraftServer
import net.minestom.server.event.GlobalEventHandler

class Server {
	val server: MinecraftServer = MinecraftServer.init(Auth.Online())
	val globalEventHandler: GlobalEventHandler = MinecraftServer.getGlobalEventHandler()
	
	fun run() {
		ServerEvents(globalEventHandler).registerEvents()
		server.start("0.0.0.0", 25565)
	}
}