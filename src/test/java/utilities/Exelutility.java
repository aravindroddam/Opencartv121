package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exelutility {

public static FileInputStream fi;
public static FileOutputStream fo;
public static XSSFWorkbook wb;
public static XSSFSheet ws;
public static XSSFRow row;
public static XSSFCell cell;
public static XSSFCellStyle style;
String path; //new step to add filepath
public Exelutility(String path)
{
	this.path=path;
}

public int getrowcount(String xlsheet) throws IOException
{
fi=new FileInputStream(path);
wb=new XSSFWorkbook(fi);
ws=wb.getSheet(xlsheet);
int rowcount=ws.getLastRowNum();
wb.close();
fi.close();
return rowcount;
}

public int getcellcount(String xlsheet,int rownum) throws IOException
{
	fi=new FileInputStream(path);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
int cellcount=row.getLastCellNum();
wb.close();
fi.close();
return cellcount;
}

public  String getcelldata(String xlsheet,int rownum,int colnum) throws IOException
{
	fi=new FileInputStream(path);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	cell=row.getCell(colnum);
	String data;
	try
	{
	DataFormatter formatter=new DataFormatter();
	data=formatter.formatCellValue(cell);
	}
	catch(Exception e)
	{
data=" ";
	}
wb.close();
fi.close();
return data;
}
public void setcelldata(String xlsheet,int rownum,int colnum,String data) throws IOException
{
	File xlfile=new File(path);
	if(!xlfile.exists())   //if filenot exists then create new file
	{
		wb=new XSSFWorkbook();
		fo=new FileOutputStream(path);
	wb.write(fo);
	}
	
	fi=new FileInputStream(path);
	wb=new XSSFWorkbook(fi);
	
	if(wb.getSheetIndex(xlsheet)==-1)   //if sheet not exists then create new sheet
	wb.createSheet(xlsheet);
	ws=wb.getSheet(xlsheet);
	
	if(ws.getRow(rownum)==null)			//if  row not exists then create new row
		ws.createRow(rownum);
	row=ws.getRow(rownum);
	
	cell=row.createCell(colnum);
	cell.setCellValue(data);
	fo=new FileOutputStream(path);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
}
public  void fillgreencolour(String xlsheet,int rownum,int colnum) throws IOException
{
	fi=new FileInputStream(path);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	cell=row.getCell(colnum);
style=wb.createCellStyle();
style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
cell.setCellStyle(style);
fo=new FileOutputStream(path);
wb.write(fo);
wb.close();
fi.close();
fo.close();

}
public  void fillredcolour(String xlsheet,int rownum,int colnum) throws IOException
{
	fi=new FileInputStream(path);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rownum);
	cell=row.getCell(colnum);
style=wb.createCellStyle();
style.setFillForegroundColor(IndexedColors.RED.getIndex());
style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
cell.setCellStyle(style);
fo=new FileOutputStream(path);
wb.write(fo);
wb.close();
fi.close();
fo.close();
}}
