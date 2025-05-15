package com.gildedrose.strategy;

import com.gildedrose.Item;

/**
 * Update strategy for "Conjured" items.
 * <p>
 * "Conjured" items degrade in quality twice as fast as normal items.
 */
public class ConjuredStrategy implements UpdateStrategy {
    public void update(Item item) {
        item.sellIn--;
        int baseDegradation = (item.sellIn < 0) ? 2 : 1;
        int degradation = baseDegradation * 2;
        item.quality = Math.max(0, item.quality - degradation);
    }
}