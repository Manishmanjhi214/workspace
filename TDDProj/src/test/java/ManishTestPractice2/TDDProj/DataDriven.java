package ManishTestPractice2.TDDProj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	public static XSSFWorkbook wb;

	public static XSSFSheet sheet;

	public static XSSFRow row;

	public static XSSFCell cell;

	public static FileInputStream fis;

	public static void main(String[] args) throws IOException {
		// FileInput stream argument for file loc
		FileInputStream fis = new FileInputStream("F:\\ECLIPSE\\workspace\\TDDProj\\AccountDetails.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		getAllRowsValueInAColumn(workbook);

		String value = getCelldata(2, 2);

		System.out.println(value);

		String value1 = getCelldata(1, 2);

		System.out.println(value1);

		value = setCelldata("automation", 2, 2);

		System.out.println(value);
		

	}

	public static ArrayList<String> getAllRowsValueInAColumn(XSSFWorkbook workbook) {
		ArrayList<String> accountNames= new ArrayList<String>();
		int sheet = workbook.getNumberOfSheets();
		for (int i = 0; i < sheet; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Accounts")) {
				XSSFSheet selectedSheet = workbook.getSheetAt(i);
				Iterator<Row> rows = selectedSheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.iterator();
				int columnNo = 0;
				int col = 0;
				if (cells.hasNext()) {
					Cell value = cells.next();
					if (!value.getStringCellValue().equals(null)) {
						// got desired column
						col = columnNo;
						//System.out.println(col);
						// Verify all values in single column
						while (rows.hasNext()) {
							Row rValue = rows.next();
							//System.out.println(rValue.getRowNum());
							Iterator<Cell> rCells = rValue.iterator();
							Cell cNo = rCells.next();
							String cValue = cNo.getStringCellValue();
							accountNames.add(cValue);
						}
					}
					columnNo++;
				}
			}
		}
		return accountNames;

	}

	public static String getCelldata(int rownum, int col) throws IOException

	{

		fis = new FileInputStream("F:\\ECLIPSE\\workspace\\TDDProj\\AccountDetails.xlsx");

		wb = new XSSFWorkbook(fis);

		sheet = wb.getSheet("Accounts");

		row = sheet.getRow(2);

		cell = row.getCell(2);

		return cell.getStringCellValue();

	}

	public static String setCelldata(String text, int rownum, int col) throws IOException

	{

		fis = new FileInputStream("F:\\ECLIPSE\\workspace\\TDDProj\\AccountDetails.xlsx");

		wb = new XSSFWorkbook(fis);

		sheet = wb.getSheet("Accounts");

		row = sheet.getRow(2);

		cell = row.getCell(2);

		cell.setCellValue(text);

		String celldata1 = cell.getStringCellValue();

		return celldata1;

	}
}
