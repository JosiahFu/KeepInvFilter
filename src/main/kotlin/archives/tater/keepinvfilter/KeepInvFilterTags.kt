package archives.tater.keepinvfilter

import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier

object KeepInvFilterTags {
    @JvmField
    val KEEP_ITEMS: TagKey<Item> = TagKey.of(RegistryKeys.ITEM, Identifier(KeepInvFilter.modId, "keep"))
}
