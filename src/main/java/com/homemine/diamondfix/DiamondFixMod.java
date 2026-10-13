package com.homemine.diamondfix;

import com.homemine.diamondfix.registry.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

/**
 * Diamond's Fix —— 专门为本整合包修复其它模组遗留问题的轻量补丁模组。
 *
 * <p>它不新增玩法，只做「上游出错、下游兜底」：把上游引用了却从未注册、或做错的东西补上。
 * 每一项修复都在代码/数据里标注清楚它修的是谁、根因是什么，方便日后上游修复后整体下线。
 */
@Mod(DiamondFixMod.MODID)
public class DiamondFixMod {
    public static final String MODID = "diamondfix";

    public DiamondFixMod(IEventBus modBus) {
        ModItems.ITEMS.register(modBus);
        modBus.addListener(ModItems::onBuildCreativeTabContents);
    }
}
