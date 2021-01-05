package com.interactions.automation.interactions;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import au.com.bytecode.opencsv.CSVReader;
import com.csvreader.CsvReader;


public class CSVHandler {
	
	public static List<String[]> csvReader (String filePath) throws IOException{
		CSVReader reader = new CSVReader(new FileReader(filePath));
		List<String[]> file = reader.readAll();
		reader.close();
		return file;
	}
	
	public static List<String[]> csvReader (String filePath,char separator) throws IOException{
		CSVReader reader = new CSVReader(new FileReader(filePath),separator);
		List<String[]> file = reader.readAll();
		reader.close();
		return file;
	}
	
	public static List<String> getHeaders(String filePath) throws IOException{
		List<String[]> data = csvReader(filePath);
		String [] header = data.get(0);
		return Arrays.asList(header);
	}
	
	public static List<String[]> csvReaderWithoutHeader(String filePath) throws IOException{
		CSVReader reader = new CSVReader(new FileReader(filePath));
		
		List<String[]> file = reader.readAll();
		file.remove(0);
		
		reader.close();
		
		return file;
	}
	
	public static List<String> getHeaders(String filePath, char separator) throws IOException{
		List<String[]> data = csvReader(filePath, separator);
		String [] header = data.get(0);
		return Arrays.asList(header);
	}
	
	public static List<String[]> csvReaderWithoutHeader(String filePath, char separator) throws IOException{
		CSVReader reader = new CSVReader(new FileReader(filePath), separator);
		
		List<String[]> file = reader.readAll();
		file.remove(0);
		
		reader.close();
		
		return file;
	}
	
	
	public List<Map<String, Object>> convertCSVRowToMap(String filePath) throws Exception {
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		List<String> headersList = getHeaders(filePath);
		String[] header = headersList.toArray(new String[0]);
		try {
					CsvReader data = new CsvReader(filePath);
					data.readHeaders();
					while (data.readRecord())
					{
						Map<String, Object> hmap = new HashMap<String, Object>();
						for(int i=0;i<header.length;i++){
							Object currentValue = data.get(header[i]);
							if(currentValue!="")
							 hmap.put(header[i], currentValue);
						}
						mapList.add(hmap);
					}
					data.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		return mapList;
	}	
	
	public static  String ReadCSVCell(String filePath, String sheetName,int c,int r) throws Exception {
		
		BufferedReader fileReader = null;
		String[] token = null;
		try{
			String line ="";
			
			fileReader = new BufferedReader(new FileReader(filePath));
			for(int i =0 ; i < r; i ++){
				fileReader.readLine();
						} 
			
			line = fileReader.readLine();
			token = line.split(",");
		}
		catch(IOException e){
			System.out.println("Unable to read the file"+filePath);
		}
		
		return token[c];
	
	}
public static  String ReadCSVCell(File filePath, String sheetName,int c,int r) throws Exception {
		
		BufferedReader fileReader = null;
		String[] token = null;
		try{
			String line ="";
			
			fileReader = new BufferedReader(new FileReader(filePath));
			for(int i =0 ; i < r; i ++){
				fileReader.readLine();
						} 
			
			line = fileReader.readLine();
			token = line.split(",");
		}
		catch(IOException e){
			System.out.println("Unable to read the file"+filePath);
		}
		
		return token[c];
	
	}
}

