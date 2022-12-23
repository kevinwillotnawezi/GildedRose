package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void qualityShouldNotBeNegative() {
        // Given
        String name = "test";
        int sellIn = 0;
        int quality = 0;
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(sellIn-1, app.items[0].sellIn);
        assertTrue(app.items[0].quality >= 0);
    }

    @Test
    void agedBrieQualityShouldIncreaseWithTime() {
        // Given
        String name = "Aged Brie";
        int sellIn = 0;
        int quality = 0;
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(sellIn-1, app.items[0].sellIn);
        assertTrue(quality < app.items[0].quality);
    }

    @Test
    void sulfurasShouldNotLoseQuality () {
        // Given
        String name = "Sulfuras, Hand of Ragnaros";
        int sellIn = 0;
        int quality = 50;
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(sellIn, app.items[0].sellIn);
        assertEquals(quality, app.items[0].quality);
    }

    @Test
    void qualityShouldNotBeBiggerThan50() {
        // Given
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int sellIn = 11;
        int quality = 50;
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(sellIn-1, app.items[0].sellIn);
        assertEquals(quality, app.items[0].quality);
    }

    @Test
    void backStagePassesQualityShouldIncreaseWithTime() {
        // Given
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int sellIn = 11;
        int quality = 20;
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(sellIn-1, app.items[0].sellIn);
        assertEquals(quality+1, app.items[0].quality);
    }

    @Test
    void backStagePassesQualityShouldIncreaseMore10daysBeforeConcert() {
        // Given
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int sellIn = 10;
        int quality = 20;
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(sellIn-1, app.items[0].sellIn);
        assertEquals(quality+2, app.items[0].quality);
    }

    @Test
    void backStagePassesQualityShouldIncreaseMore5daysBeforeConcert() {
        // Given
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int sellIn = 5;
        int quality = 20;
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(sellIn-1, app.items[0].sellIn);
        assertEquals(quality+3, app.items[0].quality);
    }

    @Test
    void backStagePassesQualityShouldBe0afterConcert() {
        // Given
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int sellIn = 0;
        int quality = 20;
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(sellIn-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
}
