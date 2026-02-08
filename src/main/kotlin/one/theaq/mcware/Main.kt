package one.theaq.mcware

import net.minestom.server.MinecraftServer
import net.minestom.server.coordinate.Pos
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent
import net.minestom.server.instance.block.Block

fun main() {
    val minecraftServer = MinecraftServer.init()
    val instanceManager = MinecraftServer.getInstanceManager()
    val globalEventHandler = MinecraftServer.getGlobalEventHandler()

    minecraftServer.start("0.0.0.0", 25565)
    val instanceContainer = instanceManager.createInstanceContainer()
    instanceContainer.setGenerator { genUnit -> genUnit.modifier().fillHeight(0, 24, Block.fromKey("stone")) }
    globalEventHandler.addListener(AsyncPlayerConfigurationEvent::class.java) { event ->
        val player = event.player

        event.spawningInstance = instanceContainer
        player.respawnPoint = Pos(0.0, 25.0, 0.0)
    }
}
