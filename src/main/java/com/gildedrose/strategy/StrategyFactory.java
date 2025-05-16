package com.gildedrose.strategy;

import java.util.Map;
import java.util.HashMap;
import com.gildedrose.Item;

/**
 * Factory for selecting the appropriate {@link UpdateStrategy} based on item name.
 * <p>
 * Ensures each item is updated according to its unique rules.
 */
public class StrategyFactory {
    private static final Map<String, UpdateStrategy> STRATEGIES = Map.of(
        "Aged Brie", new AgedBrieStrategy(),
        "Backstage passes to a TAFKAL80ETC concert", new BackstagePassStrategy(),
        "Sulfuras, Hand of Ragnaros", new SulfurasStrategy(),
        "Conjured Mana Cake", new ConjuredStrategy()
    );

    public static UpdateStrategy getStrategy(Item item) {
        return STRATEGIES.getOrDefault(item.name, new DefaultStrategy());
    }
}