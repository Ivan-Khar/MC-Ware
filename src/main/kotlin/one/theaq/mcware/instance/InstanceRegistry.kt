package one.theaq.mcware.instance

import net.minestom.server.MinecraftServer
import net.minestom.server.instance.Instance
import net.minestom.server.instance.generator.Generator
import net.minestom.server.registry.RegistryKey
import net.minestom.server.world.DimensionType
import one.theaq.mcware.dimension.DimensionRegistry
import one.theaq.mcware.instance.generator.LobbyGenerator

object InstanceRegistry {
    val LOBBY = registerInstance(DimensionRegistry.LOBBY, LobbyGenerator())

    fun registerInstance(dimensionType: RegistryKey<DimensionType>, generator: Generator): Instance {
        val instanceManager = MinecraftServer.getInstanceManager()
        val instance = instanceManager.createInstanceContainer(dimensionType)
        instance.setGenerator(generator)

        return instance
    }
}