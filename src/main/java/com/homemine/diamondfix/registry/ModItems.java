package com.homemine.diamondfix.registry;

import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * 修复项容器的物品注册。
 *
 * <p><b>修复 1：oritech_steel_tools:steel_bow 缺失。</b>
 * 上游 oritech_steel_tools 1.0.0 的数据包标签
 * {@code data/minecraft/tags/item/enchantable/durability.json} 把 {@code oritech_steel_tools:steel_bow}
 * 加进了物品标签，但该模组从未注册这个物品。引用不存在的物品会让该标签加载失败，并级联拖垮
 * {@code minecraft:enchantable/vanishing}、{@code c:enchantables}、{@code ars_elemental:soulbound_extra}
 * 等依赖它的标签。
 *
 * <p>解决办法不是在别处改标签（那是上游的数据，会在更新时被覆盖），而是把这个「本应存在」的物品
 * 真正注册出来。为此这里刻意用 {@link DeferredRegister#createItems(String)} 以
 * <b>上游命名空间 {@code oritech_steel_tools}</b> 注册（NeoForge 不校验 namespace 必须等于本模组 modid），
 * 这样标签里的引用才能命中。模型/贴图随物品走同一命名空间，见 {@code assets/oritech_steel_tools/}；
 * 语言键则放在本模组自己的命名空间（{@code assets/diamondfix/lang/}），避免覆盖上游同名 lang 文件。
 */
public class ModItems {

    /** 上游钢制工具的耐久基准，取自 {@code SteelTier.getUses()} == 832，让钢弓同档。 */
    public static final int STEEL_DURABILITY = 832;

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems("oritech_steel_tools");

    public static final DeferredItem<BowItem> STEEL_BOW = ITEMS.register("steel_bow",
            () -> new BowItem(new Item.Properties().durability(STEEL_DURABILITY)));

    public static void onBuildCreativeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(STEEL_BOW);
        }
    }
}
