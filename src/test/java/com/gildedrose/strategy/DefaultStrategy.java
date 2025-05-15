package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link DefaultStrategy}.
 * <p>
 * Ensures standard items degrade in quality appropriately and never go below zero.
 */
class DefaultStrategyTest {

    @Test
    void qualityDecreasesByOneBeforeSellIn() {
        Item item = new Item("Normal Item", 10, 20);
        UpdateStrategy strategy = new DefaultStrategy();

        strategy.update(item);

        assertEquals(9, item.sellIn, "SellIn should decrease by 1");
        assertEquals(19, item.quality, "Quality should decrease by 1 before sell-in");
    }

    @Test
    void qualityDecreasesByTwoAfterSellIn() {
        Item item = new Item("Normal Item", 0, 20);
        UpdateStrategy strategy = new DefaultStrategy();

        strategy.update(item);

        assertEquals(-1, item.sellIn, "SellIn should decrease by 1");
        assertEquals(18, item.quality, "Quality should decrease by 2 after sell-in");
    }

    @Test
    void qualityNeverGoesNegative() {
        Item item = new Item("Normal Item", 0, 1);
        UpdateStrategy strategy = new DefaultStrategy();

        strategy.update(item);

        assertEquals(-1, item.sellIn, "SellIn should decrease by 1");
        assertEquals(0, item.quality, "Quality should not go below 0");
    }

    @Test
    void qualityStaysAtZeroIfAlreadyZero() {
        Item item = new Item("Normal Item", 5, 0);
        UpdateStrategy strategy = new DefaultStrategy();

        strategy.update(item);

        assertEquals(4, item.sellIn, "SellIn should decrease by 1");
        assertEquals(0, item.quality, "Quality should remain at 0");
    }
}