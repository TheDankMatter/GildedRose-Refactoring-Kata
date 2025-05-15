package com.gildedrose;

import com.gildedrose.strategy.UpdateStrategy;
import com.gildedrose.strategy.StrategyFactory;

/**
 * Main class for updating the inventory of the Gilded Rose inn.
 * <p>
 * Delegates item update logic to specific strategies based on item type.
 */
class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * Updates the quality and sellIn values for all items in inventory.
     */
    public void updateQuality() {
        for (Item item : items) {
            UpdateStrategy strategy = StrategyFactory.getStrategy(item);
            strategy.update(item);
        }
    }
}