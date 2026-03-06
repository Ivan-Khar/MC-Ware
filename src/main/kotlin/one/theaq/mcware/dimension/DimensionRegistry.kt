package one.theaq.mcware.dimension

import net.minestom.server.MinecraftServer
import net.minestom.server.registry.RegistryKey
import net.minestom.server.utils.IntProvider
import net.minestom.server.world.DimensionType
import net.minestom.server.world.DimensionType.Skybox
import one.theaq.mcware.Constants

object DimensionRegistry {
	val LOBBY = registerDimension(
		"lobby", DimensionType.builder()
			.fixedTime(true)
			.skylight(true)
			.ceiling(false)
			.coordinateScale(1.0)
			.minY(-32)
			.height(256 + 32)
			.logicalHeight(256 + 32)
			.infiniburn("#minecraft:infiniburn_overworld")
			.ambientLight(1.0f)
			.monsterSpawnLightLevel(IntProvider.Uniform(0, 6))
			.monsterSpawnBlockLightLimit(0)
			.skybox(Skybox.OVERWORLD)
			.cardinalLight(DimensionType.CardinalLight.DEFAULT)
			.build()
	)
	
	fun registerDimension(dimensionId: String, dimensionType: DimensionType): RegistryKey<DimensionType> {
		return MinecraftServer.getDimensionTypeRegistry().register(Constants.resourceLocation(dimensionId), dimensionType)
	}
}
