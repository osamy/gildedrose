package com.gildedrose;

import com.gildedrose.constants.ItemNames;
import com.gildedrose.model.Item;
import com.gildedrose.strategy.*;

import java.util.HashMap;
import java.util.Map;


class GildedRose {
    Item[] items;
    private final Map<String, QualityUpdateStrategy> strategies;

    public GildedRose(Item[] items) {
        this.items = items;
        this.strategies = new HashMap<>();
        strategies.put(ItemNames.AGED_BRIE, new AgedBrieStrategy());
        strategies.put(ItemNames.BACKSTAGE_PASSES, new BackstagePassStrategy());
        strategies.put(ItemNames.SULFURAS, new SulfursStrategy());
        strategies.put(ItemNames.CONJURED, new ConjuredItemStrategy());
    }


    public void updateQuality() {
        for (Item item : items) {
            QualityUpdateStrategy strategy = strategies.getOrDefault(item.name, new RegularItemStrategy());
            strategy.updateQuality(item);
        }
    }
}
