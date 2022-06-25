package dev.xarlsr.popdb;

import dev.xarlsr.popdb.sqlcoders.FieldsFiller;
import dev.xarlsr.popdb.sqlcoders.TableField;
import dev.xarlsr.popdb.sqlcoders.TableRow;
import dev.xarlsr.popdb.userint.EnterData;
import dev.xarlsr.popdb.userint.FieldDescriptor;

import java.util.List;

public class App {


    public static void main( String[] args ) {

        List<FieldDescriptor> fide = EnterData.genRowFieldsList();
        for (int i = 0; i<fide.size(); i++){
            FieldDescriptor fd = fide.get(i);
            System.out.println(fd.fdName+" - "+fd.fdType+" - "+fd.fdPath);
        }

        List<TableField> tafi = FieldsFiller.filledField(fide);
        for (int i = 0; i<tafi.size(); i++){
            TableField tf = tafi.get(i);
            System.out.println(tf.getName()+" - "+tf.getType()+" - "+tf.getValue());
        }
        TableRow tr = new TableRow();
        String codeLine = tr.makeCode(tafi);
        System.out.println(codeLine);


        //System.out.println(MySqlCoder.rowText());
    }
}
