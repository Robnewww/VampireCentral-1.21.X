package net.robnew.vampirecentral.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.sound.BlockSoundGroup;
import net.robnew.vampirecentral.VampireCentral;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block SILVER_ORE = registerBlock("silver_ore",
            new Block(AbstractBlock.Settings.create()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3f, 3f)
                    .requiresTool()
                    .mapColor(MapColor.STONE_GRAY)
            )
    );

    public static final Block SILVER_BLOCK = registerBlock("silver_block",
            new Block(AbstractBlock.Settings.create()
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .strength(5f, 6f)
                    .requiresTool()
                    .mapColor(MapColor.IRON_GRAY)
                    .sounds(BlockSoundGroup.METAL)
            )
    );

    public static final Block RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
            new Block(AbstractBlock.Settings.create()
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .strength(5f, 6f)
                    .requiresTool()
                    .mapColor(MapColor.RAW_IRON_PINK)
                    .sounds(BlockSoundGroup.METAL)
            )
    );


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(VampireCentral.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(VampireCentral.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        VampireCentral.LOGGER.info("Registering blocks for " + VampireCentral.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
                    entries.add(ModBlocks.SILVER_ORE);
                    entries.add(ModBlocks.SILVER_BLOCK);
                    entries.add(ModBlocks.RAW_SILVER_BLOCK);
        });
    }
}
