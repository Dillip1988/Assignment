package com.interactions.automation.interactions;

import java.io.File;

import org.testng.annotations.Test;



public class ReadingCSVFile {
	
	CSVHandler csvH=new CSVHandler();
	 String tempvalue=null;
     String tempminvalue =null;
     String tempMaxvalue= null; 
     String sheetName="convertcsv";
	
	
	
	@Test
    public void testReadingCSVFile() throws Exception{
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File readFilePath = new File(classLoader.getResource("convertcsv.csv").getFile());
		System.out.println("Filepath to Read "+ readFilePath);
        
		
		tempvalue= csvH.ReadCSVCell(readFilePath,sheetName,0,3);
		System.out.println("tempvalue readed "+ tempvalue);
		
		tempminvalue= csvH.ReadCSVCell(readFilePath,sheetName,1,3);
		System.out.println("tempminvalue readed "+ tempminvalue);
		
		tempMaxvalue= csvH.ReadCSVCell(readFilePath,sheetName,2,3);
		System.out.println("tempMaxvalue readed "+ tempMaxvalue);
    	

    }

}
