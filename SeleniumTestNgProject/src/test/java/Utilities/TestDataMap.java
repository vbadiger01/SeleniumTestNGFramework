package Utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestDataMap {
	
	public Map<String,String> testDataMap = new HashedMap<String,String>();
	LoadConfigProperties getConfigProp = new LoadConfigProperties();
	
	public Map<String,String> createTestDataMap() {
		
		try {
			System.out.println("Reading Excel");
			InputStream input = new FileInputStream(getConfigProp.getTestData());
			Workbook wbook = WorkbookFactory.create(input);
			Sheet sheet = wbook.getSheet("TestData");
			
			int rowNum = sheet.getLastRowNum();
			for (int i = 1;i<= rowNum;i++) {
				Row row = sheet.getRow(i);
				String key = row.getCell(0).getStringCellValue();
				String value = row.getCell(1).toString();
				testDataMap.put(key, value);
			}		
			
		} catch (Exception exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}		
		return testDataMap;
		
	}	
	
}
