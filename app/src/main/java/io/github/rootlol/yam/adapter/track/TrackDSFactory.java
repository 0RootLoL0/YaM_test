/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.adapter.track;

import androidx.paging.DataSource;

import io.github.rootlol.yamadapter.YamDataSourceFactory;
import io.github.rootlol.yamadapter.YamVHFactory;

public class TrackDSFactory extends YamDataSourceFactory {

    TrackVHFactory trackVHFactory;

    @Override
    public YamVHFactory getVHFactory() {
        if (trackVHFactory == null) {
            trackVHFactory = new TrackVHFactory();
        }
        return trackVHFactory;
    }

    @Override
    public DataSource create() {
        return null;
    }
}
