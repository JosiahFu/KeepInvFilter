package archives.tater.keepinvfilter.mixin;

import archives.tater.keepinvfilter.KeepInvFilterTags;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlayerInventory.class)
public abstract class PlayerInventoryMixin {

	@WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isEmpty()Z"), method = "dropAll")
	private boolean dropSome(ItemStack instance, Operation<Boolean> original) {
		return original.call(instance) || instance.isIn(KeepInvFilterTags.KEEP_ITEMS);
	}
}
