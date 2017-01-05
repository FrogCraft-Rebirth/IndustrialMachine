package info.tritusk.inductivemachine

import ic2.api.event.TeBlockFinalCallEvent as TeBlockReg
import ic2.core.block.TeBlockRegistry
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@Mod(
		modid = "inductivemachine",
		name = "Inductive Machine",
		version = "0.0.1",
		useMetadata = true,
		dependencies = "required-after:IC2@[2.6.134,)",
		modLanguage = "kotlin",
		modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter")
object InductiveMachine {

	init {
		try { Class.forName("net.shadowfacts.forgelin.KotlinAdapter") } catch (e: Exception) { throw IllegalStateException("Inductive Machine requires Forgelin to run.") }
		
		MinecraftForge.EVENT_BUS.register(object: Any() {
			@SubscribeEvent fun onIC2TeReg(event: TeBlockReg) = TeBlockRegistry.addAll(BlockInductional::class.java, BLOCK_ID)
		})		
	}

}