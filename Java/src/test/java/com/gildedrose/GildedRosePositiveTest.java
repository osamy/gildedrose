package com.gildedrose;

import com.gildedrose.constants.ItemNames;
import com.gildedrose.model.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

class GildedRosePositiveTest {

    @ParameterizedTest
    @MethodSource("provideItemsForUpdateQuality")
    void testUpdateQuality(String name, int sellIn, int quality, int expectedQuality, int expectedSellIn) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedQuality, items[0].quality, "Quality mismatch for " + name);
        assertEquals(expectedSellIn, items[0].sellIn, "SellIn mismatch for " + name);
    }

    private static Stream<Arguments> provideItemsForUpdateQuality() {
        return Stream.of(
            Arguments.of(ItemNames.AGED_BRIE, 10, 20, 21, 9),        //quality increases by 1
            Arguments.of(ItemNames.BACKSTAGE_PASSES, 15, 20, 21, 14), //quality increases by 1
            Arguments.of(ItemNames.SULFURAS, 10, 80, 80, 10),        //quality and sellIn remain unchanged
            Arguments.of(ItemNames.CONJURED, 10, 20, 18, 9)          //quality degrades by 2
        );
    }
}
