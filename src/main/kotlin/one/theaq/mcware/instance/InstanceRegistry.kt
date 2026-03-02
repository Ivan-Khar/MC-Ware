package one.theaq.mcware.instance

import net.minestom.server.MinecraftServer
import net.minestom.server.instance.Instance
import net.minestom.server.instance.anvil.AnvilLoader
import net.minestom.server.registry.RegistryKey
import net.minestom.server.world.DimensionType
import one.theaq.mcware.dimension.DimensionRegistry

object InstanceRegistry {
    val LOBBY = registerInstance(DimensionRegistry.LOBBY, "worlds/lobby")

    fun registerInstance(dimensionType: RegistryKey<DimensionType>, worldPath: String): Instance {
        val instanceManager = MinecraftServer.getInstanceManager()
        val instance = instanceManager.createInstanceContainer(dimensionType)
        instance.chunkLoader = AnvilLoader(worldPath)
        return instance
    }
}