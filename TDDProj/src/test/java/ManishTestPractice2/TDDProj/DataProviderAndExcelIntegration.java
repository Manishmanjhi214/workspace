package ManishTestPractice2.TDDProj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAndExcelIntegration {
	DataFormatter formatter = new DataFormatter();

	@Test(dataProvider = "exceldata")
	public void testCaseData(String AccountName,String Type,String Rating,String BillingState,String AccountPhone,String website,String BillingCity,String BillingZip,String AnnualRevenue){
		System.out.println(AccountName+":"+Type+":"+Rating+":"+BillingState+":"+AccountPhone+":"+website+":"+BillingCity+":"+BillingZip+":"+AnnualRevenue);
	}

	@DataProvider(name = "exceldata")
	public Object[][] getData() throws IOException {
		FileInputStream fis = new FileInputStream("F:\\ECLIPSE\\workspace\\TDDProj\\AccountDetails.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		Object data[][] = new Object[rowCount - 1][colCount];
		for (int i = 0; i < rowCount - 1; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}

		return data;

	}
}
