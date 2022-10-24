package ManishTestPractice2.TDDProj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("F:\\ECLIPSE\\workspace\\TDDProj\\AccountDetails.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		ArrayList<String> names= DataDriven.getAllRowsValueInAColumn(workbook);
		
		for(int i=0;i<names.size();i++) {
			System.out.println(names.get(i));
		}
	}

}
