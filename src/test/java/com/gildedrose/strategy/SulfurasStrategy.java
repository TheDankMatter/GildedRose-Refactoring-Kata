package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link SulfurasStrategy}.
 * <p>
 * Confirms that "Sulfuras" items never change in quality or sell-in value.
 */
class SulfurasStrategyTest {

    @Test
    void sulfurasQualityAndSellInRemainUnchanged_PositiveSellIn() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 5, 80);
        UpdateStrategy strategy = new SulfurasStrategy();

        strategy.update(item);

        assertEquals(5, item.sellIn, "SellIn should remain unchanged for Sulfuras");
        assertEquals(80, item.quality, "Quality should remain unchanged for Sulfuras");
    }

    @Test
    void sulfurasQualityAndSellInRemainUnchanged_ZeroSellIn() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        UpdateStrategy strategy = new SulfurasStrategy();

        strategy.update(item);

        assertEquals(0, item.sellIn, "SellIn should remain unchanged for Sulfuras");
        assertEquals(80, item.quality, "Quality should remain unchanged for Sulfuras");
    }

    @Test
    void sulfurasQualityAndSellInRemainUnchanged_NegativeSellIn() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", -10, 80);
        UpdateStrategy strategy = new SulfurasStrategy();

        strategy.update(item);

        assertEquals(-10, item.sellIn, "SellIn should remain unchanged for Sulfuras");
        assertEquals(80, item.quality, "Quality should remain unchanged for Sulfuras");
    }

    @Test
    void sulfurasQualityRemainsUnchanged_IfNot80() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 2, 70);
        UpdateStrategy strategy = new SulfurasStrategy();

        strategy.update(item);

        assertEquals(2, item.sellIn, "SellIn should remain unchanged for Sulfuras");
        assertEquals(70, item.quality, "Quality should remain unchanged even if not 80");
    }
}
