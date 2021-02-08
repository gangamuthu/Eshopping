package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	public static String getdata(String filepath, String sheetName, int rowNum, int cellNum) {
		try {
			FileInputStream fin = new FileInputStream(filepath);

			// System.out.println("fin : "+fin);

			Workbook workbook = WorkbookFactory.create(fin);

			// System.out.println("workbook : "+workbook);

			Sheet sheet = workbook.getSheet(sheetName);

			// System.out.println("sheet : "+sheet);

			return sheet.getRow(rowNum).getCell(cellNum).toString();

		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("error    : " + e.getMessage());
			// System.out.println("error : "+e.;
		}
		return null;
	}

	public static Double getNumericData(String filepath, String sheetName, int rowNum, int cellNum) {

		try {
			FileInputStream fin = new FileInputStream(filepath);

			Workbook workbook = WorkbookFactory.create(fin);

			Sheet sheet = workbook.getSheet(sheetName);
			return sheet.getRow(rowNum).getCell(cellNum).getNumericCellValue();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Boolean getBooleandata(String filepath, String sheetName, int rowNum, int cellNum) {

		try {
			FileInputStream fin = new FileInputStream(filepath);

			Workbook workbook = WorkbookFactory.create(fin);

			Sheet sheet = workbook.getSheet(sheetName);
			return sheet.getRow(rowNum).getCell(cellNum).getBooleanCellValue();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void getMultiplendata(String filepath, String sheetName) {

		try {
			FileInputStream fin = new FileInputStream(filepath);

			Workbook workbook = WorkbookFactory.create(fin);

			Sheet sheet = workbook.getSheet(sheetName);

			int rowcount = sheet.getPhysicalNumberOfRows();
			int cellcount = 2;

			for (int i = 0; i <= rowcount; i++) {
				for (int j = 0; j <= cellcount - 1; j++) {
					System.out.print(sheet.getRow(i).getCell(j).toString() + "  ");
				}
				System.out.println();

			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static String[][] getMultiplendata1(String filepath, String sheetName) {

		try {
			FileInputStream fin = new FileInputStream(filepath);

			Workbook workbook = WorkbookFactory.create(fin);

			Sheet sheet = workbook.getSheet(sheetName);

			int rowcount = sheet.getPhysicalNumberOfRows();
			int cellcount = 2;
            
			String[][] sarr= new String[rowcount][cellcount];
			
			
			for (int i = 0; i <= rowcount-1; i++) {
				for (int j = 0; j <= cellcount - 1; j++) {
					sarr[i][j]=sheet.getRow(i).getCell(j).toString();
				}
				}
              return sarr;
              		}

		catch (Exception e) {
			e.printStackTrace();
		}
          return null;
	}
}
