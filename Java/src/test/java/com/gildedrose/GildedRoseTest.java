package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void qualityShouldDecreaseWithTime() {
        // Given
        String name = "test";
        int sellIn = 5;
        int quality = 10;
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(quality-1, app.items[0].quality);
        assertEquals( sellIn-1, app.items[0].sellIn);
    }

    @Test
    void qualityShouldDecreaseFasterAfterExpirationDate() {
        // Given
        String name = "test";
        int sellIn = 0;
        int quality = 10;
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(quality-2, app.items[0].quality);
        assertEquals( sellIn-1, app.items[0].sellIn);
    }

    @Test
    void template() {
        // Given
        String name = "test";
        int sellIn = 0;
        int quality = 10;
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(sellIn, app.items[0].quality);
        assertEquals(quality, app.items[0].sellIn);
    }
}
