package archives.tater.keepinvfilter

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.item.Items
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.ItemTags
import java.util.concurrent.CompletableFuture

object KeepInvFilterDataGenerator : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
		fabricDataGenerator.createPack().apply {
			addProvider(::ItemTagGenerator)
		}
	}

	class ItemTagGenerator(
		output: FabricDataOutput?,
		completableFuture: CompletableFuture<RegistryWrapper.WrapperLookup>?
	) : FabricTagProvider.ItemTagProvider(output, completableFuture) {
		override fun configure(arg: RegistryWrapper.WrapperLookup?) {
			getOrCreateTagBuilder(KeepInvFilterTags.KEEP_ITEMS).apply {
				forceAddTag(ItemTags.TOOLS)
				add(
					Items.BOW,
					Items.CROSSBOW,
					Items.WATER_BUCKET,
					Items.ELYTRA,
					Items.LEATHER_HELMET,
					Items.LEATHER_CHESTPLATE,
					Items.LEATHER_LEGGINGS,
					Items.LEATHER_BOOTS,
					Items.CHAINMAIL_HELMET,
					Items.CHAINMAIL_CHESTPLATE,
					Items.CHAINMAIL_LEGGINGS,
					Items.CHAINMAIL_BOOTS,
					Items.IRON_HELMET,
					Items.IRON_CHESTPLATE,
					Items.IRON_LEGGINGS,
					Items.IRON_BOOTS,
					Items.DIAMOND_HELMET,
					Items.DIAMOND_CHESTPLATE,
					Items.DIAMOND_LEGGINGS,
					Items.DIAMOND_BOOTS,
					Items.NETHERITE_HELMET,
					Items.NETHERITE_CHESTPLATE,
					Items.NETHERITE_LEGGINGS,
					Items.NETHERITE_BOOTS,
					Items.DIAMOND_HELMET,
					Items.DIAMOND_CHESTPLATE,
					Items.DIAMOND_LEGGINGS,
					Items.DIAMOND_BOOTS,
					Items.TURTLE_HELMET,
					Items.FIREWORK_ROCKET,
					Items.FLINT_AND_STEEL,
				)
			}
		}
	}
}
