package com.gildedrose.strategy;

import com.gildedrose.Item;

/**
 * Defines the contract for updating the quality and sellIn values of an item.
 * <p>
 * Implementations encapsulate the specific update logic for different item types.
 */
public interface UpdateStrategy {
    /**
     * Updates the sellIn and quality of the given item according to specific rules.
     *
     * @param item the item to update
     */
    void update(Item item);
}