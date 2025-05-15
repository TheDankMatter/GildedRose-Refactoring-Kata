package com.gildedrose.strategy;

import com.gildedrose.Item;

/**
 * Default update strategy for standard items.
 * <p>
 * Quality degrades by 1 before sell-in date, and by 2 after.
 * Quality never drops below 0.
 */
public class DefaultStrategy implements UpdateStrategy {
    public void update(Item item) {
        item.sellIn--;
        int degradation = (item.sellIn < 0) ? 2 : 1;
        item.quality = Math.max(0, item.quality - degradation);
    }
}