package one.theaq.mcware

import net.minestom.server.MinecraftServer

fun main() {
    val minecraftServer = MinecraftServer.init()

    minecraftServer.start("0.0.0.0", 25565)
}
