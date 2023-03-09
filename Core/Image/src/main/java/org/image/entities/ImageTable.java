package org.image.entities;


import org.core.entities.BaseTable;

public class ImageTable extends BaseTable {
    public ImageTable(){
        super();
    }

    public static ImageTable factory(){
        return new ImageTable();
    }
}
