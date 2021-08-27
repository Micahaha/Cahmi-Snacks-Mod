package net.fabricmc.firstmod.blocks;
import net.fabricmc.firstmod.blocks.entity.PantryBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class PantryBlock extends Block implements BlockEntityProvider {
    public PantryBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView){
        return new PantryBlockEntity();
    }

    @Override
    public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult blockHitResult){
    if(world.isClient) return ActionResult.SUCCESS;
        Inventory blockEntity = (Inventory) world.getBlockEntity(blockPos);

    if(!player.getStackInHand(hand).isEmpty())
    {
        if(blockEntity.getStack(0).isEmpty())
        {
            blockEntity.setStack(0, player.getStackInHand(hand).copy());
            player.getStackInHand(hand).setCount(0);
        }
        else if(blockEntity.getStack(1).isEmpty()) {
            blockEntity.setStack(1, player.getStackInHand(hand).copy());
        }
        else
        {
            System.out.println("The first slot holds" + blockEntity.getStack(0) + "and the second slot holds " + blockEntity.getStack(1));
        }
    }

    if(!player.getStackInHand(hand).isEmpty())
    {

    }
    else {
    if(!blockEntity.getStack(1).isEmpty()){
        player.inventory.offerOrDrop(world, blockEntity.getStack(1));
        blockEntity.removeStack(1);
        } else if(!blockEntity.getStack(0).isEmpty()){
        player.inventory.offerOrDrop(world,blockEntity.getStack(0));
        blockEntity.removeStack(0);
       }
    }
        return ActionResult.SUCCESS;
    }
}



