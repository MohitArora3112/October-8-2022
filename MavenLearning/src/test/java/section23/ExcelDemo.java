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
import org.testng.annotations.Test;

public class ExcelDemo {
	
	public static ArrayList<String> getData() throws IOException
	{
		ArrayList<String> al=new ArrayList<String>();
		FileInputStream fis=new FileInputStream("D:\\Mohit Arora\\SeleniumLearning\\MavenLearning\\testdata\\ExcelDemo.xlsx");
		// XSSFWorkbook Accept FIleInputStream as an argument
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheetCount=workbook.getNumberOfSheets();		
		for(int i=0;i<sheetCount;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata1"))
			{
				XSSFSheet worksheet=workbook.getSheetAt(i);
				Iterator<Row> rows=worksheet.iterator();
				Row firstRow=rows.next();
				Iterator<Cell> cells=firstRow.cellIterator();
				int column=0;
				while(cells.hasNext())
				{
					Cell firstColumn=cells.next();
					if(firstColumn.getStringCellValue().equalsIgnoreCase("testcases"))
					{
							column=firstColumn.getColumnIndex();						
					}
				}
				System.out.println("Column Index is: "+column);
				int rowIndex=0;
				while(rows.hasNext())
				{
					Row row=rows.next();
					if(row.getCell(column).getStringCellValue().equalsIgnoreCase("Add profile"))
					{
						Iterator<Cell> cell=row.cellIterator();
						while(cell.hasNext())
						{
							Cell cv=cell.next();
							
							if(cv.getCellType()==CellType.STRING)
							{
								al.add(cv.getStringCellValue());
							}
							else
								al.add(NumberToTextConverter.toText(cv.getNumericCellValue()));
						}	
					}
				}
			}
		}
		return al;
	}
	@Test
	public void getDataFromExcel() throws IOException
	{
		ArrayList<String> al1;
		al1=ExcelDemo.getData();
		for(int i=0;i<al1.size();i++)
		{
			System.out.println(al1.get(i));
		}
	}
}
