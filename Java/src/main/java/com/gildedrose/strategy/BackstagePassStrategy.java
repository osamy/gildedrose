package com.gildedrose.strategy;

import com.gildedrose.constants.ItemNames;
import com.gildedrose.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BackstagePassStrategy implements QualityUpdateStrategy {

    private static final Logger log = LoggerFactory.getLogger(BackstagePassStrategy.class);

    @Override
    public void updateQuality(Item item) {
        log.info("Updating item quality for " + ItemNames.BACKSTAGE_PASSES);
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn < 11 && item.quality < 50)
                item.quality++;
            if (item.sellIn < 6 && item.quality < 50)
                item.quality++;
        }
        item.sellIn--;
        if (item.sellIn < 0)
            item.quality = 0;
    }
}
