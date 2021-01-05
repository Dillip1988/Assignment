package com.interactions.automation.interactions;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;





public class AssignmentTaskAPITest {
	
	RestAPIHelper rhelp= new RestAPIHelper();
    
	

	@BeforeGroups(groups = { "Assignment" })
	@Parameters("environment")
	public void preSetUp(@Optional String environment) throws Exception {

	}

	@Test(priority = 1, description = "AssignmentTest", groups = { "Assignment"})
	public void testGetAPICallWithMavenProject() throws Exception {
		String response= rhelp.getRestAPI("?q=London,UK&appid=b1b15e 88fa797225412429c1c50c122a1");
		System.out.println("The Response of the API : " + response);
		
	}
	
	@Test(priority = 2, description = "AssignmentTest", groups = { "Assignment"})
	public void testSimpleParsingJsonResponse() throws Exception {

		
		String response= rhelp.getRestAPI("?q=London,UK&appid=b1b15e 88fa797225412429c1c50c122a1");
		System.out.println("The Response of the API : " + response);
		
		JsonPath js= new JsonPath(response);
		String value=js.getString("message");
		int cod=js.getInt("cod");
		double city_id=js.getDouble("city_id");
		double calctime=js.getDouble("calctime");
		int cnt=js.getInt("cnt");
		System.out.println("Data after parsing the Json " + value  );
		System.out.println("Data after parsing the Json " + cod  );
		System.out.println("Data after parsing the Json " + city_id  );
		System.out.println("Data after parsing the Json " + calctime  );
		System.out.println("Data after parsing the Json " + cnt  );
		
		
	}

}
