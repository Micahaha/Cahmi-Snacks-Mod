package net.fabricmc.firstmod.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ImposterSnack extends Item {
    public ImposterSnack(Settings settings){
            super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){


        playerEntity.addExperienceLevels(1000000);
        playerEntity.setVelocity(playerEntity.getVelocity().x,20,playerEntity.getVelocity().z);
        playerEntity.playSound(SoundEvents.BLOCK_NOTE_BLOCK_BASEDRUM, 1.0F, 1.0F);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
