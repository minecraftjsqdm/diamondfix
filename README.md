# Diamond's Fix

NeoForge 1.21.1 · MIT · mod id `diamondfix` · v1.0.0

## English

A compatibility-patch mod: it fixes problems caused by other mods in the THEDIMS modpack. It adds no new gameplay of its own.

- **Fix #1 — the missing Steel Bow.** The upstream `oritech_steel_tools` mod references `oritech_steel_tools:steel_bow` from the vanilla `minecraft:enchantable/durability` item tag but never registers that item. The broken reference makes the tag fail to load, which cascades into `enchantable/vanishing`, `c:enchantables` and `ars_elemental:soulbound_extra`.
- **How it is fixed** — this mod registers the missing `steel_bow` item under the `oritech_steel_tools` namespace (a `BowItem`, durability 832 taken from the upstream `SteelTier.getUses()`), and adds it to the Combat creative tab.

## 中文

一个兼容性补丁模组：修复 THEDIMS 整合包中其他模组引发的问题，本身不新增玩法。

- 修复一 —— 缺失的钢弓。上游 `oritech_steel_tools` 在原版 `minecraft:enchantable/durability` 物品标签里引用了 `oritech_steel_tools:steel_bow`，却从未注册该物品。这个坏引用导致标签加载失败，并级联拖垮 `enchantable/vanishing`、`c:enchantables` 与 `ars_elemental:soulbound_extra`。
- 修复方式：本模组以 `oritech_steel_tools` 命名空间注册缺失的 `steel_bow` 物品（一个 `BowItem`，耐久 832，取自上游 `SteelTier.getUses()`），并加入「战斗」创造标签页。

## Dependencies / 依赖

- Required / 必需：NeoForge 21.1.x on Minecraft 1.21.1
- Optional / 可选：`oritech_steel_tools`、`oritech`（`AFTER` 加载顺序）

## Build / 构建

```sh
# Windows
$env:JAVA_HOME='<path-to-jdk21>'; .\gradlew.bat build --console=plain -q

# Linux / macOS
JAVA_HOME=<path-to-jdk21> ./gradlew build
```

Output jar: `build/libs/diamondfix-1.0.0.jar`. 产物：`build/libs/diamondfix-1.0.0.jar`。

## License / 许可

MIT. See `LICENSE`.
