package com.gildedrose;

import com.gildedrose.constants.ItemNames;
import com.gildedrose.model.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

class GildedRoseBoundaryTest {

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
            Arguments.of(ItemNames.AGED_BRIE, 0, 20, 22, -1),        // quality increases by 2 at sellIn 0
            Arguments.of(ItemNames.BACKSTAGE_PASSES, 10, 20, 22, 9), //quality increases by 2 at sellIn 10
            Arguments.of(ItemNames.BACKSTAGE_PASSES, 5, 20, 23, 4),  // quality increases by 3 at sellIn 5
            Arguments.of(ItemNames.REGULAR_ITEM, 0, 20, 18, -1),     //quality degrades by 2 at sellIn 0
            Arguments.of(ItemNames.REGULAR_ITEM, -1, 20, 18, -2),    //quality degrades by 2 after sellIn
            Arguments.of(ItemNames.SULFURAS, 0, 80, 80, 0)           // sell-in and quality remain unchanged
        );
    }
}
