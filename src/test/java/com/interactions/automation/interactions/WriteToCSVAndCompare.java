package com.interactions.automation.interactions;

import java.io.File;

import org.testng.annotations.Test;

public class WriteToCSVAndCompare {
	 String tempvalue=null;
     String tempminvalue =null;
     String tempMaxvalue= null; 
     String sheetName="convertcsv";
     String csvFileToWrite= "writecsv.csv";
     CSVHandler csvH=new CSVHandler();
     CSVWriteHandler csvW= new CSVWriteHandler();
     
     String tempvalue_afterwrite=null;
     String tempminvalue_afterwrite =null;
     String tempMaxvalue_afterwrite= null; 
	
	@Test
    public void testReadThenWriteToCSVFile() throws Exception{
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File readFilePath = new File(classLoader.getResource("convertcsv.csv").getFile());
		System.out.println("Filepath to Read "+ readFilePath);
        
		
		tempvalue= csvH.ReadCSVCell(readFilePath,sheetName,0,3);
		System.out.println("tempvalue readed "+ tempvalue);
		
		tempminvalue= csvH.ReadCSVCell(readFilePath,sheetName,1,3);
		System.out.println("tempminvalue readed "+ tempminvalue);
		
		tempMaxvalue= csvH.ReadCSVCell(readFilePath,sheetName,2,3);
		System.out.println("tempMaxvalue readed "+ tempMaxvalue);
		
		//Writing into the CSV File
		
		csvW.writeCSV(csvFileToWrite,tempvalue,tempminvalue,tempMaxvalue);
		File writeFilePath = new File(classLoader.getResource("writecsv.csv").getFile());
		System.out.println("Filepath to Read "+ writeFilePath);
		
		tempvalue_afterwrite= csvH.ReadCSVCell(readFilePath,sheetName,0,3);
		System.out.println("tempvatempvalue_afterWritelue readed "+ tempvalue_afterwrite);
		
		tempminvalue_afterwrite= csvH.ReadCSVCell(readFilePath,sheetName,1,3);
		System.out.println("tempminvalue_afterwrite readed "+ tempminvalue_afterwrite);
		
		tempMaxvalue_afterwrite= csvH.ReadCSVCell(readFilePath,sheetName,2,3);
		System.out.println("tempMaxvalue_afterwrite readed "+ tempMaxvalue_afterwrite);
		

    }

}
