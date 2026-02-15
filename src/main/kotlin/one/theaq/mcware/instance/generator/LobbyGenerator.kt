package one.theaq.mcware.instance.generator

import net.minestom.server.instance.block.Block
import net.minestom.server.instance.generator.GenerationUnit
import net.minestom.server.instance.generator.Generator

class LobbyGenerator: Generator {
    override fun generate(unit: GenerationUnit) {
        val start = unit.absoluteStart()
        val size = unit.size()

        for (x in 0 ..< size.blockX()) {
            for (z in 0 ..< size.blockZ()) {
                for (y in 0 ..< (40 - start.blockY()).coerceAtMost(3)) {
                    unit.modifier().setBlock(start.add(x.toDouble(), y.toDouble(), z.toDouble()), Block.STONE)
                }
            }
        }
    }
}