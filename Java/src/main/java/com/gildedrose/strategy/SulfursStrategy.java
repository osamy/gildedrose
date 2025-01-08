package com.gildedrose.strategy;

import com.gildedrose.constants.ItemNames;
import com.gildedrose.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SulfursStrategy implements QualityUpdateStrategy {
    private static final Logger log = LoggerFactory.getLogger(SulfursStrategy.class);

    @Override
    public void updateQuality(Item item) {
        log.info("Update quality for " + ItemNames.SULFURAS);
        // Sulfurs never changes
    }
}
