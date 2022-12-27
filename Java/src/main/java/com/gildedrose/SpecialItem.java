package com.gildedrose;

import java.util.Arrays;
import java.util.Optional;

public enum SpecialItem {
    AGED_BRIE("Aged Brie"),
    BACKSTAGE("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    CONJURED("Conjured");

    private String name;

    SpecialItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Optional<SpecialItem> get(String name) {
        return Arrays.stream(SpecialItem.values())
            .filter(n -> n.name.equals(name))
            .findFirst();
    }
}
