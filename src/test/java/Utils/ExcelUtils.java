package Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	 XSSFWorkbook wb;
	 XSSFSheet sh;	

	
	public ExcelUtils(String excelpath,String sheet) {
		XSSFWorkbook wb;
		try {
			wb = new XSSFWorkbook(excelpath);
		    sh = wb.getSheet(sheet); 	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public  void getCellData(int rowval,int cellval)
    {
    	DataFormatter df = new DataFormatter();
        Object cellvalue=df.formatCellValue(sh.getRow(rowval).getCell(cellval) );
        System.out.println(cellvalue);
	   }
    	
	public   void getRowCount() {
	        int rowCount= sh.getPhysicalNumberOfRows();
	        System.out.println("Number of rows "+rowCount);
	        
	}
}
 