package Test_Casses;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Method.API_Methods;
import RequestRepository.Get_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Get_TC1 {
	@Test
	public static void extractor () {
		int statusCode = API_Methods.ResponseStatusCode(Get_Req_Repository.BaseURI(), Get_Req_Repository.Get_Resource(), Get_Req_Repository.Get_Req_TC1());
	System.out.println(statusCode);
	
	String ResponseBody = API_Methods.ResponseBody(Get_Req_Repository.BaseURI(), Get_Req_Repository.Get_Resource(), Get_Req_Repository.Get_Req_TC1());
	System.out.println(ResponseBody);
	
	JsonPath JspResponse = new JsonPath(ResponseBody);
	String Res_name = JspResponse.getString("name");
	String Res_job = JspResponse.getString("job");
	
	
	//System.out.println(Res_name,);
	Assert.assertEquals(Res_name,"morpheus");
	Assert.assertEquals(Res_job,"leader");
	}

}