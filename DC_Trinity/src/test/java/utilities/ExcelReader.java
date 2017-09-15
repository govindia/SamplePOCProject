package utilities;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFCell Cell;

	public static Object[][] getTableArray(String FilePath, String SheetName){   

		   String[][] tabArray = null;

		   try {

			   InputStream file = new FileInputStream(FilePath);

			   // Access the required test data sheet

			   workbook = new XSSFWorkbook(file);

			   sheet = workbook.getSheet(SheetName);

			   int startRow = 1;

			   int startCol = 1;

			   int ci,cj;

			   int totalRows = sheet.getLastRowNum();

			   // you can write a function as well to get Column count

			   int totalCols = 3;

			   tabArray=new String[totalRows][totalCols];

			   ci=0;

			   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

				  cj=0;

				   for (int j=startCol;j<=totalCols;j++, cj++){

					   tabArray[ci][cj]=getCellData(i,j);

					   System.out.println(tabArray[ci][cj]);  

						}

					}

				}

			catch (FileNotFoundException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			catch (IOException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return(tabArray);

			}

		public static String getCellData(int RowNum, int ColNum) throws Exception {

			try{
				Cell = sheet.getRow(RowNum).getCell(ColNum);
				String CellData = Cell.getStringCellValue();
				return CellData;	
			}
			catch (Exception e){

				System.out.println(e.getMessage());

				throw (e);

				}

			}


}
