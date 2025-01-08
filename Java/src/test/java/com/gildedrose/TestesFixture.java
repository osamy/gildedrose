package com.gildedrose;

import com.gildedrose.constants.ItemNames;
import com.gildedrose.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestesFixture {
    private static final Logger log = LoggerFactory.getLogger(TestesFixture.class);

    public static void main(String[] args) {
        Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20),
            new Item(ItemNames.AGED_BRIE, 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item(ItemNames.SULFURAS, 0, 80),
            new Item(ItemNames.SULFURAS, -1, 80),
            new Item(ItemNames.BACKSTAGE_PASSES, 15, 20),
            new Item(ItemNames.BACKSTAGE_PASSES, 10, 49),
            new Item(ItemNames.BACKSTAGE_PASSES, 5, 49),
            new Item(ItemNames.CONJURED, 3, 6)};

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            log.info("-------- day {} --------", i);
            log.info("name, sellIn, quality");
            for (Item item : items) {
                log.info(item.toString());
            }

            app.updateQuality();
        }
    }

}
