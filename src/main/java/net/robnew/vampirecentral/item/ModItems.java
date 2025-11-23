package net.robnew.vampirecentral.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Identifier;
import net.robnew.vampirecentral.VampireCentral;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(VampireCentral.MOD_ID, name), item);
    }

    public static final Item SILVER_INGOT = registerItem("silver_ingot", new Item(new Item.Settings()));
    public static final Item RAW_SILVER = registerItem("raw_silver", new Item(new Item.Settings()));

    public static void registerModItems() {
        VampireCentral.LOGGER.info("Registered items for " + VampireCentral.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SILVER_INGOT);
            entries.add(RAW_SILVER);
        });
    }
}
