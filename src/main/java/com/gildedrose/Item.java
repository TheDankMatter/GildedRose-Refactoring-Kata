package com.gildedrose;

/**
 * Represents an item in the Gilded Rose inventory.
 * <p>
 * Note: This class should not be modified as per kata constraints.
 */
public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
