package net.fabricmc.firstmod.items;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ReesesCup extends Item {

    public ReesesCup(Settings settings){
        super(settings);
    }



    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context)
    {
        tooltip.add(new TranslatableText("item.firstmod.reeses_cup.tooltip_1").formatted(Formatting.DARK_RED));
        tooltip.add(new TranslatableText("item.firstmod.reeses_cup.tooltip_2").formatted(Formatting.DARK_RED));

    }
}
