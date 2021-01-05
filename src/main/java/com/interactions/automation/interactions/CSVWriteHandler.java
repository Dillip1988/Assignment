package com.interactions.automation.interactions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSVWriteHandler {
  public static void writeCSV(String fileName,String value1, String value2, String value3) {
	  
	  ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File writeFilePath = new File(classLoader.getResource(fileName).getFile());

    try (PrintWriter writer = new PrintWriter(new File(writeFilePath.toString()))) {

      StringBuilder sb = new StringBuilder();
      sb.append("temp,");
      sb.append(',');
      sb.append("temp_min");
      sb.append(',');
      sb.append("temp_max");
      sb.append('\n');

      sb.append(value1);
      sb.append(',');
      sb.append(value2);
      sb.append(',');
      sb.append(value3);
      sb.append('\n');

      writer.write(sb.toString());

      System.out.println("done!");

    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }

  }
}
