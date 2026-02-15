package one.theaq.mcware

import net.kyori.adventure.key.Key

object Constants {
    const val RESOURCE_ID = "mc_ware"

    fun resourceLocation(path: String): Key {
        return Key.key(RESOURCE_ID, path)
    }
}