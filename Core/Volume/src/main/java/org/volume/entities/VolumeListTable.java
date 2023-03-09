package org.volume.entities;


import org.core.entities.BaseTable;

public class VolumeListTable extends BaseTable {
    public VolumeListTable(){
        super();
    }

    public static VolumeListTable factory() {
        return new VolumeListTable();
    }

}
