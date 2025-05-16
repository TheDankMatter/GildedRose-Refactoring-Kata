package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link ConjuredStrategy}.
 * <p>
 * Validates that "Conjured" items degrade in quality twice as fast as normal items.
 */
class ConjuredStrategyTest {

    @Test
    void degradesQualityTwiceAsFastBeforeSellIn() {
        Item item = new Item("Conjured Mana Cake", 3, 10);
        UpdateStrategy strategy = new ConjuredStrategy();

        strategy.update(item);

        assertEquals(2, item.sellIn, "SellIn should decrease by 1");
        assertEquals(8, item.quality, "Quality should decrease by 2 before sell-in");
    }

    @Test
    void degradesQualityFourTimesAsFastAfterSellIn() {
        Item item = new Item("Conjured Mana Cake", 0, 10);
        UpdateStrategy strategy = new ConjuredStrategy();

        strategy.update(item);

        assertEquals(-1, item.sellIn, "SellIn should decrease by 1");
        assertEquals(6, item.quality, "Quality should decrease by 4 after sell-in");
    }

    @Test
    void qualityNeverNegative() {
        Item item = new Item("Conjured Mana Cake", 0, 3);
        UpdateStrategy strategy = new ConjuredStrategy();

        strategy.update(item);

        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality, "Quality should not go below 0");
    }

    @Test
    void qualityDegradesToZeroIfDegradationExceedsCurrentQuality() {
        Item item = new Item("Conjured Mana Cake", 0, 2);
        UpdateStrategy strategy = new ConjuredStrategy();

        strategy.update(item);

        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality, "Quality should not go below 0");
    }
}
