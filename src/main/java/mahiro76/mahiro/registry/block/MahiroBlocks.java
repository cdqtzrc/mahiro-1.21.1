package mahiro76.mahiro.registry.block;


import mahiro76.mahiro.Mahiro;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class MahiroBlocks {
    //在下方添加物品
    public static final Block BIGGER_BOX = registerBlock("bigger_box",new Block(AbstractBlock.Settings.create().strength(3.0f,4.0f)));

    //方块物品注册方法（在注册方块的同时注册方块物品）
    public static void registerBlockItems(String id,Block block){
        Item item = Registry.register(Registries.ITEM, Identifier.of(Mahiro.MOD_ID, id), new BlockItem(block, new Item.Settings()));
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

    }

    //方块注册方法
    public static <T extends Block> T registerBlock(String id, T block) {
        registerBlockItems(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Mahiro.MOD_ID, id), block);
    }
}
