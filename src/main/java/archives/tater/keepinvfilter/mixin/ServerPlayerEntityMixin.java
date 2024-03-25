package archives.tater.keepinvfilter.mixin;

import archives.tater.keepinvfilter.KeepInvFilterTags;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity {
    @Shadow public abstract void onLanding();

    @Shadow public abstract void onTeleportationDone();

    public ServerPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile gameProfile) {
        super(world, pos, yaw, gameProfile);
    }

    @Inject(
            at = @At("TAIL"),
            method = "copyFrom"
    )
    private void copySome(ServerPlayerEntity oldPlayer, boolean alive, CallbackInfo ci) {
        if (!alive && !this.getWorld().getGameRules().getBoolean(GameRules.KEEP_INVENTORY) && !oldPlayer.isSpectator()) {
            PlayerInventory inventory = getInventory();
            PlayerInventory otherInventory = oldPlayer.getInventory();

            for (int i = 0; i < inventory.size(); ++i) {
                ItemStack otherStack = otherInventory.getStack(i);
                if (!otherStack.isIn(KeepInvFilterTags.KEEP_ITEMS)) continue;
                inventory.setStack(i, otherStack);
            }
            inventory.selectedSlot = otherInventory.selectedSlot;
        }
    }

}
