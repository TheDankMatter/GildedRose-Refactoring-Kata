package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for {@link GildedRose}.
 * <p>
 * Validates correct system behavior for all item types and edge cases.
 */
class GildedRoseTest {

    @Test
    void normalItem_degradesByOneBeforeSellIn() {
        Item[] items = { new Item("Normal Item", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(19, items[0].quality);
    }

    @Test
    void normalItem_degradesByTwoAfterSellIn() {
        Item[] items = { new Item("Normal Item", 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(18, items[0].quality);
    }

    @Test
    void normalItem_qualityNeverNegative() {
        Item[] items = { new Item("Normal Item", 0, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void agedBrie_increasesInQuality() {
        Item[] items = { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(1, items[0].sellIn);
        assertEquals(1, items[0].quality);
    }

    @Test
    void agedBrie_qualityNeverExceedsFifty() {
        Item[] items = { new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(1, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void sulfuras_neverChanges() {
        Item[] items = { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    void backstagePass_increasesByOneWhenMoreThanTenDays() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(14, items[0].sellIn);
        assertEquals(21, items[0].quality);
    }

    @Test
    void backstagePass_increasesByTwoWhenTenOrLessDays() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(22, items[0].quality);
    }

    @Test
    void backstagePass_increasesByThreeWhenFiveOrLessDays() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, items[0].sellIn);
        assertEquals(23, items[0].quality);
    }

    @Test
    void backstagePass_qualityDropsToZeroAfterConcert() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void conjuredItem_degradesTwiceAsFastBeforeSellIn() {
        Item[] items = { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(2, items[0].sellIn);
        assertEquals(4, items[0].quality);
    }

    @Test
    void conjuredItem_degradesFourTimesAsFastAfterSellIn() {
        Item[] items = { new Item("Conjured Mana Cake", 0, 6) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(2, items[0].quality);
    }

    @Test
    void conjuredItem_qualityNeverNegative() {
        Item[] items = { new Item("Conjured Mana Cake", 0, 3) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }
}
