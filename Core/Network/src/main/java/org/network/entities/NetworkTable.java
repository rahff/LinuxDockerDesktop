package org.network.entities;

import org.core.entities.BaseTable;

public class NetworkTable extends BaseTable {
    public NetworkTable() {
        super();
    }

    public static NetworkTable factory() {
        return new NetworkTable();
    }
}
