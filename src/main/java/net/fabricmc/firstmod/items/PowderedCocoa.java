package net.fabricmc.firstmod.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public class PowderedCocoa extends Item {


   public PowderedCocoa(Settings settings){
        super(settings);
    }


    //I give up, No idea how to add ToolTips ):

   /* @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( new TranslatableText("item.firstmod.powdered_cocoa").formatted(Formatting.RED));
    */

    }


