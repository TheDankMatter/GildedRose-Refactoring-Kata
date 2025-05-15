package com.gildedrose.strategy;

import com.gildedrose.Item;

/**
 * Update strategy for "Sulfuras, Hand of Ragnaros".
 * <p>
 * "Sulfuras" is a legendary item; its quality and sellIn never change.
 */
public class SulfurasStrategy implements UpdateStrategy {
    public void update(Item item) {
        // Legendary item - no changes
    }
}