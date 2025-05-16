package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link BackstagePassStrategy}.
 * <p>
 * Verifies correct quality increases for backstage passes and quality drop after the concert.
 */
class BackstagePassStrategyTest {

    @Test
    void qualityIncreasesByOne_WhenMoreThanTenDaysLeft() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        UpdateStrategy strategy = new BackstagePassStrategy();

        strategy.update(item);

        assertEquals(14, item.sellIn, "SellIn should decrease by 1");
        assertEquals(21, item.quality, "Quality should increase by 1 when >10 days left");
    }

    @Test
    void qualityIncreasesByTwo_WhenBetweenSixAndTenDays() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        UpdateStrategy strategy = new BackstagePassStrategy();

        strategy.update(item);

        assertEquals(9, item.sellIn);
        assertEquals(22, item.quality);
    }

    @Test
    void qualityIncreasesByThree_WhenFiveDaysOrLess() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        UpdateStrategy strategy = new BackstagePassStrategy();

        strategy.update(item);

        assertEquals(4, item.sellIn);
        assertEquals(23, item.quality);
    }

    @Test
    void qualityDropsToZero_AfterConcert() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        UpdateStrategy strategy = new BackstagePassStrategy();

        strategy.update(item);

        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void qualityNeverExceedsFifty() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        UpdateStrategy strategy = new BackstagePassStrategy();

        strategy.update(item);

        assertEquals(4, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void qualityCapsAtFifty_WhenNearLimit() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 49);
        UpdateStrategy strategy = new BackstagePassStrategy();

        strategy.update(item);

        assertEquals(2, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void qualityHandlesEdgeCase_OneDayBeforeConcert() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20);
        UpdateStrategy strategy = new BackstagePassStrategy();

        strategy.update(item);

        assertEquals(0, item.sellIn);
        assertEquals(23, item.quality);
    }
}