package one.theaq.mcware

import one.theaq.mcware.Main.Companion.LOGGER
import one.theaq.mcware.dimension.DimensionRegistry
import one.theaq.mcware.instance.InstanceRegistry
import one.theaq.mcware.server.ServerInstance
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class Main {
    companion object {
        val LOGGER: Logger = LogManager.getLogger()
    }
}

fun main() {
    LOGGER.info("test")
    val serverInstance = ServerInstance()

    DimensionRegistry
    InstanceRegistry

    serverInstance.run()
}