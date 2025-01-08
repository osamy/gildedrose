package com.gildedrose;

import com.gildedrose.constants.ItemNames;
import com.gildedrose.model.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

class GildedRoseNegativeTest {

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
            Arguments.of(ItemNames.REGULAR_ITEM, 10, 0, 0, 9),       // quality never goes below 0
            Arguments.of(ItemNames.AGED_BRIE, 10, 50, 50, 9),        //quality never exceeds 50
            Arguments.of(ItemNames.BACKSTAGE_PASSES, 0, 20, 0, -1),  // quality drops to 0 after concert
            Arguments.of(ItemNames.BACKSTAGE_PASSES, 5, 49, 50, 4)   //quality caps at 50
        );
    }
}
