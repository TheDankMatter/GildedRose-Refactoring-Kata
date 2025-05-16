package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link AgedBrieStrategy}.
 * <p>
 * Ensures "Aged Brie" items increase in quality over time and never exceed the maximum allowed quality.
 */
class AgedBrieStrategyTest {

    @Test
    void increasesQualityByOneBeforeSellIn() {
        Item item = new Item("Aged Brie", 5, 10);
        UpdateStrategy strategy = new AgedBrieStrategy();

        strategy.update(item);

        assertEquals(4, item.sellIn);
        assertEquals(11, item.quality);
    }

    @Test
    void increasesQualityByTwoAfterSellIn() {
        Item item = new Item("Aged Brie", 0, 10);
        UpdateStrategy strategy = new AgedBrieStrategy();

        strategy.update(item);

        assertEquals(-1, item.sellIn);
        assertEquals(12, item.quality);
    }

    @Test
    void qualityNeverExceedsFifty() {
        Item item = new Item("Aged Brie", 5, 50);
        UpdateStrategy strategy = new AgedBrieStrategy();

        strategy.update(item);

        assertEquals(4, item.sellIn);
        assertEquals(50, item.quality);
    }
}