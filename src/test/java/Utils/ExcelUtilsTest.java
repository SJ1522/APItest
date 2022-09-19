package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsTest extends ExcelUtils {
	public ExcelUtilsTest(String excelpath, String sheet) {
		super(excelpath, sheet);

	}

	public static void main(String[] args) {
		String excelpath = "./data/TestData.xlsx";
		String sheet = "Sheet1";
		ExcelUtilsTest excel = new ExcelUtilsTest(excelpath, sheet);
		int rowCount = excel.sh.getLastRowNum();
		int cellCount = excel.sh.getRow(0).getLastCellNum();

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j <= cellCount; j++) {
				excel.getCellData(i, j);
			}
		}
	}

}
