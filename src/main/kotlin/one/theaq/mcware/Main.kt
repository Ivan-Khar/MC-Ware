package one.theaq.mcware

import one.theaq.mcware.dimension.DimensionRegistry
import one.theaq.mcware.instance.InstanceRegistry
import one.theaq.mcware.server.Server

fun main() {
	val server = Server()

	DimensionRegistry
	InstanceRegistry
	
	server.run()
}