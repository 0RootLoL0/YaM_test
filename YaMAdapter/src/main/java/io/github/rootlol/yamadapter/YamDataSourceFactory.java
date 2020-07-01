/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yamadapter;

import androidx.paging.DataSource;

public abstract class YamDataSourceFactory extends DataSource.Factory {
    public abstract YamVHFactory getVHFactory();
    public abstract Object getOnClick();
}
