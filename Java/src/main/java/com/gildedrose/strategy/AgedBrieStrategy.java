package com.gildedrose.strategy;

import com.gildedrose.constants.ItemNames;
import com.gildedrose.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgedBrieStrategy implements QualityUpdateStrategy {
    private static final Logger log = LoggerFactory.getLogger(AgedBrieStrategy.class);

    @Override
    public void updateQuality(Item item) {
        log.info("Updating quality for "+ ItemNames.AGED_BRIE);
        if (item.quality < 50)
            item.quality++;
        item.sellIn--;
        if (item.sellIn < 0 && item.quality < 50)
            item.quality++;
    }
}
