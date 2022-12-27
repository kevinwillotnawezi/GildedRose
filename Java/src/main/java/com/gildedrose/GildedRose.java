package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            SpecialItem.get(item.name).ifPresentOrElse(it -> {
                switch (it) {
                    case AGED_BRIE:
                        if (item.quality < 50) {
                            item.quality++;
                        }
                        break;
                    case BACKSTAGE:
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
                    case SULFURAS:
                        item.quality = 80;
                        break;
                    case CONJURED:
                        item.quality -= 2;
                        break;
                    default:
                        break;
                }

                if (it != SpecialItem.SULFURAS) {
                    item.sellIn--;

                    if (item.sellIn < 0
                        && it != SpecialItem.AGED_BRIE
                        && item.quality != 0) {
                        item.quality--;
                    }
                }

                if (it != SpecialItem.AGED_BRIE && item.sellIn < 0) {
                    item.quality--;
                }

                if (it == SpecialItem.BACKSTAGE && item.sellIn < 0) {
                    item.quality = 0;
                }
            }, () -> {
                item.sellIn--;
                if (item.quality != 0) {
                    item.quality--;

                    if (item.sellIn < 0 && item.quality != 1) {
                        item.quality--;
                    }
                }
            });
        }
    }
}
