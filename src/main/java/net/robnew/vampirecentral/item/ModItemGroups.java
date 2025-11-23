package net.robnew.vampirecentral.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.robnew.vampirecentral.VampireCentral;
import net.robnew.vampirecentral.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup VAMPIRE_CENTRAL_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(VampireCentral.MOD_ID, "vampire_central_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.SILVER_INGOT))
                    .displayName(Text.translatable("itemgroup.vampirecentral.items_group"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModBlocks.SILVER_BLOCK);
                        entries.add(ModBlocks.RAW_SILVER_BLOCK);
                        entries.add(ModBlocks.SILVER_ORE);
                        entries.add(ModItems.RAW_SILVER);
                        entries.add(ModItems.SILVER_INGOT);
                    })).build());

    public static void registerItemGroups() {
        VampireCentral.LOGGER.info("Registering Item Group for" + VampireCentral.MOD_ID);

    }
}
