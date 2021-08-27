package net.fabricmc.firstmod.blocks.entity;
import net.fabricmc.firstmod.Main;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.collection.DefaultedList;


public class PantryBlockEntity extends BlockEntity implements ImplementedInventory {

    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(2, ItemStack.EMPTY);

    @Override
    public DefaultedList<ItemStack> getItems(){
        return items;
    }


    @Override
    public void fromTag(BlockState state, CompoundTag tag){
        super.fromTag(state,tag);
        Inventories.fromTag(tag,items);
    }


    @Override
    public CompoundTag toTag(CompoundTag tag){
        Inventories.toTag(tag,items);
        return super.toTag(tag);
    }







    public PantryBlockEntity(){
        super(Main.PANTRY_BLOCK_ENTITY);

    }


}
