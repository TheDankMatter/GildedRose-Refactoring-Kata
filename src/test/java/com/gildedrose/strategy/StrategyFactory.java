package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link StrategyFactory}.
 * <p>
 * Verifies correct mapping of item names to their respective update strategies.
 */
class StrategyFactoryTest {

    @Test
    void returnsAgedBrieStrategyForAgedBrie() {
        Item item = new Item("Aged Brie", 10, 20);
        UpdateStrategy strategy = StrategyFactory.getStrategy(item);
        assertTrue(strategy instanceof AgedBrieStrategy, "Should return AgedBrieStrategy");
    }

    @Test
    void returnsBackstagePassStrategyForBackstagePass() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        UpdateStrategy strategy = StrategyFactory.getStrategy(item);
        assertTrue(strategy instanceof BackstagePassStrategy, "Should return BackstagePassStrategy");
    }

    @Test
    void returnsSulfurasStrategyForSulfuras() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        UpdateStrategy strategy = StrategyFactory.getStrategy(item);
        assertTrue(strategy instanceof SulfurasStrategy, "Should return SulfurasStrategy");
    }

    @Test
    void returnsConjuredStrategyForConjuredItem() {
        Item item = new Item("Conjured Mana Cake", 3, 6);
        UpdateStrategy strategy = StrategyFactory.getStrategy(item);
        assertTrue(strategy instanceof ConjuredStrategy, "Should return ConjuredStrategy");
    }

    @Test
    void returnsDefaultStrategyForNormalItem() {
        Item item = new Item("Elixir of the Mongoose", 5, 7);
        UpdateStrategy strategy = StrategyFactory.getStrategy(item);
        assertTrue(strategy instanceof DefaultStrategy, "Should return DefaultStrategy for normal items");
    }

    @Test
    void returnsDefaultStrategyForUnknownItem() {
        Item item = new Item("Mystery Item", 5, 7);
        UpdateStrategy strategy = StrategyFactory.getStrategy(item);
        assertTrue(strategy instanceof DefaultStrategy, "Should return DefaultStrategy for unknown items");
    }
}
