package com.gildedrose.strategy;

import com.gildedrose.constants.ItemNames;
import com.gildedrose.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConjuredItemStrategy implements QualityUpdateStrategy {
    private static final Logger log = LoggerFactory.getLogger(ConjuredItemStrategy.class);

    @Override
    public void updateQuality(Item item) {
        log.info(ItemNames.CONJURED + ": {}", item);
        if (item.quality > 0)
            item.quality -= 2;
        item.sellIn--;
        if (item.sellIn < 0 && item.quality > 0)
            item.quality -= 2;
    }
}
