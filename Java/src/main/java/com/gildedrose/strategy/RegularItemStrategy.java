package com.gildedrose.strategy;

import com.gildedrose.constants.ItemNames;
import com.gildedrose.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegularItemStrategy implements QualityUpdateStrategy {
    private static final Logger log = LoggerFactory.getLogger(RegularItemStrategy.class);

    @Override
    public void updateQuality(Item item) {
        log.info("Updating quality for " + ItemNames.REGULAR_ITEM);
        if (item.quality > 0)
            item.quality--;
        item.sellIn--;
        if (item.sellIn < 0 && item.quality > 0)
            item.quality--;
    }
}
