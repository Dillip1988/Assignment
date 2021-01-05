package com.interactions.automation.interactions;

  
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.Test;
import java.util.HashMap;


public class ParsingJsonComplexData {


    public  String pressurevalue;

    
    HashMap<Object,String> map= new HashMap<Object, String>();
    RestAPIHelper rhelp= new RestAPIHelper();

    @Test
    public void parsingJsonCode(){


    	String response= rhelp.getRestAPI("?q=London,UK&appid=b1b15e 88fa797225412429c1c50c122a1");
		System.out.println("The Response of the API : " + response);

        		JsonObject obj = new JsonParser().parse(response).getAsJsonObject();


        JsonArray arr = obj.getAsJsonArray("list");
        for (int i = 0; i < arr.size(); i++) {


            String tempvalue =   arr.get(i).getAsJsonObject().getAsJsonObject("main").get("temp").getAsString();
            String tempminvalue =   arr.get(i).getAsJsonObject().getAsJsonObject("main").get("temp_min").getAsString();
            String tempMaxvalue =   arr.get(i).getAsJsonObject().getAsJsonObject("main").get("temp_max").getAsString();
           


            map.put("temp",tempvalue);
            map.put("temp_min",tempminvalue);
            map.put("temp_max",tempMaxvalue);
           


        }

        System.out.println("Printing the map values " +map.entrySet());

    }

}


