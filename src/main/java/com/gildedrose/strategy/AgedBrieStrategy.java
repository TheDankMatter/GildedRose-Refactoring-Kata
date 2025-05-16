package com.gildedrose.strategy;

import com.gildedrose.Item;

/**
 * Update strategy for "Aged Brie" items.
 * <p>
 * "Aged Brie" increases in quality as it ages, up to a maximum of 50.
 */
public class AgedBrieStrategy implements UpdateStrategy {
    public void update(Item item) {
        item.sellIn--;
        if (item.quality < 50) {
            item.quality += (item.sellIn < 0) ? 2 : 1;
        }
        item.quality = Math.min(50, item.quality);
    }
}