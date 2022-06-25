package dev.xarlsr.popdb.sqlcoders;

import dev.xarlsr.popdb.generators.ValuesGenerator;
import dev.xarlsr.popdb.userint.FieldDescriptor;
import java.util.ArrayList;
import java.util.List;

public class FieldsFiller {

    public static List<TableField> filledField(List<TableField> listFd){
        List<TableField> filledFieldList = new ArrayList<>();
        FieldFactory ff = new FieldFactory();
        for (int i = 0; i< listFd.size(); i++){
            FieldDescriptor fd = listFd.get(i);
            TableField tf = ff.getField(fd.fdType);
            tf.setName(fd.fdName);
            tf.setType(fd.fdType);
            tf.setFilePath(fd.fdPath);
            if (fd.fdType.equalsIgnoreCase("FILE")){
                tf.setValue(ValuesGenerator.getStringFromFile(fd.fdPath));
            }
            filledFieldList.add(tf);
        }
        return filledFieldList;
    }
}
