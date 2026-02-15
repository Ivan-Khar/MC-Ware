package one.theaq.mcware.server

import net.minestom.server.MinecraftServer
import net.minestom.server.event.GlobalEventHandler

class ServerInstance {
    val server: MinecraftServer = MinecraftServer.init()
    val globalEventHandler: GlobalEventHandler = MinecraftServer.getGlobalEventHandler()

    fun run() {
        ServerEvents(globalEventHandler).registerEvents()
        server.start("0.0.0.0", 25565)
    }
}