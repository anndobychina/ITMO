package homework;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.ArrayList;
import com.opencsv.CSVWriter;

public class Lab5 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream in = new FileInputStream("./reestr.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(in);
		ArrayList<String[]> rows = new ArrayList<String[]>();
		ArrayList<String> temp1 = new ArrayList<String>();
		Sheet sheet = wb.getSheetAt(0);
		for (Row row : sheet) {
			temp1.clear();
			for (Cell cell : row) {
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					temp1.add(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					temp1.add(Double.toString(cell.getNumericCellValue()));
					break;

				case Cell.CELL_TYPE_FORMULA:
					temp1.add(Double.toString(cell.getNumericCellValue()));
					break;
				default:
					break;
				}
			}
			rows.add(temp1.toArray(new String[0]));
		}

		CSVWriter writer;
		writer = new CSVWriter(
				new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./result.csv"), "UTF-8")));
		for (String[] row : rows) {
			writer.writeNext(row);
		}
		writer.close();
		wb.close();
	}

}