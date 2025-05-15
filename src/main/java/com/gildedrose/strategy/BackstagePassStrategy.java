package com.gildedrose.strategy;

import com.gildedrose.Item;

/**
 * Update strategy for "Backstage passes to a TAFKAL80ETC concert".
 * <p>
 * Quality increases as the concert approaches, with special rules:
 * <ul>
 *   <li>+1 when more than 10 days left</li>
 *   <li>+2 when 6-10 days left</li>
 *   <li>+3 when 0-5 days left</li>
 *   <li>Quality drops to 0 after the concert</li>
 * </ul>
 */
public class BackstagePassStrategy implements UpdateStrategy {
    public void update(Item item) {
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            item.quality += (item.sellIn < 5) ? 3 :     
                            (item.sellIn < 10) ? 2 : 1;
        }
        item.quality = Math.min(50, item.quality);
    }
}