package one.theaq.mcware.instance.generator

import net.minestom.server.coordinate.Pos
import net.minestom.server.instance.block.Block
import net.minestom.server.instance.generator.GenerationUnit
import net.minestom.server.instance.generator.Generator

class LobbyGenerator: Generator {
    override fun generate(unit: GenerationUnit) {
        val start = unit.absoluteStart()
        val size = unit.size()

        val pos = Pos(0.0, 0.0, 0.0)
        if (pos.x >= start.x() && pos.x < start.x() + size.x()) {
            if (pos.y >= start.y() && pos.y < start.y() + size.y()) {
                if (pos.z >= start.z() && pos.z < start.z() + size.z()) {
                    unit.modifier().fill(pos, pos.add(size.withY(1.0)), Block.STONE)
                }
            }
        }

    }
}