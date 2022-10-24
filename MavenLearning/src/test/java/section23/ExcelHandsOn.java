package section23;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandsOn {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<String> al=new ArrayList<String>();
		FileInputStream fis=new FileInputStream("D:\\Mohit Arora\\SeleniumLearning\\MavenLearning\\testdata\\ExcelDemo.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheetCount=workbook.getNumberOfSheets();
		for(int i=0;i<sheetCount;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata1"))
			{
				XSSFSheet worksheet=workbook.getSheetAt(i);
				Iterator<Row> row=worksheet.iterator();
				Row firstRow=row.next();
				Iterator<Cell>	cell=firstRow.cellIterator();
				int columnIndex=0;
				while(cell.hasNext())
				{
					Cell column=cell.next();
					if(column.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						columnIndex=column.getColumnIndex();
					}
				}
				System.out.println("Column Index is: "+columnIndex);
				while(row.hasNext())
				{
					Row row1=row.next();
					if(row1.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("Add Profile"))
					{
						Iterator<Cell> cells=row1.cellIterator();
						while(cells.hasNext())
						{
							Cell cv=cells.next();
							if(cv.getCellType()==CellType.STRING)
							{
								System.out.println(cv.getStringCellValue());
							}
							else
								System.out.println(NumberToTextConverter.toText(cv.getNumericCellValue()));
						}
					}
				}
			}		
		}
	}
}
