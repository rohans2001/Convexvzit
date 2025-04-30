package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtil {

	// This method reads all names from a given Excel sheet
	public static List<String> readNamesFromExcel(String filePath, String sheetName) throws IOException {
		List<String> names = new ArrayList<>();

		FileInputStream file = new FileInputStream(filePath);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);

		// Loop through each row
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			String name = sheet.getRow(i).getCell(0).getStringCellValue().trim();
			if (!name.isEmpty()) {
				names.add(name);
			}
		}

		workbook.close();
		file.close();

		return names;
	}
}
