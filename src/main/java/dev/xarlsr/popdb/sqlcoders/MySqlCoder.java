package dev.xarlsr.popdb.sqlcoders;

import dev.xarlsr.popdb.userint.EnterData;

public class MySqlCoder {

	public MySqlCoder() {
	}

	public static String rowText() {
		String rText;
		rText = "INSERT INTO "+ EnterData.tableName()+EnterData.genRowFieldsList();
		return rText;
	}
	
	/*public String fieldString() {
		String fs;
		return fs;
	}*/

}
