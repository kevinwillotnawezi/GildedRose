package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    if (item.quality < 50) {
                        item.quality++;
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    if (item.quality < 50) {
                        item.quality++;
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality++;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality++;
                            }
                        }
                    }
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    item.quality = 80;
                    break;
                case "Conjured":
                    item.quality -= 2;
                    break;
                default:
                    if (item.quality != 0) {
                        item.quality--;
                    }
                    break;
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn--;

                if (item.sellIn < 0
                    && !item.name.equals("Aged Brie")
                    && item.quality != 0) {
                    item.quality--;
                }
            }

            if (item.name.equals("Conjured") && item.sellIn < 0) {
                item.quality--;
            }


            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert") && item.sellIn < 0) {
                item.quality = 0;
            }
        }
    }
}
