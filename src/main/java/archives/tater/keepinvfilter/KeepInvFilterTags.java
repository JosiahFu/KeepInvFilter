package archives.tater.keepinvfilter;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class KeepInvFilterTags {
    public static TagKey<Item> KEEP_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier(KeepInvFilter.MOD_ID, "keep"));
}
