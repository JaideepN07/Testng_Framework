package Test_Casses;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Method.API_Methods;
import RequestRepository.Patch_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Patch_TC1 {
	@Test
	
	public static void extractor () {
		int statusCode = API_Methods.ResponseStatusCode(Patch_Req_Repository.BaseURI(), Patch_Req_Repository.Patch_Resource(), Patch_Req_Repository.Patch_Req_TC1());
	System.out.println(statusCode);
	
	String ResponseBody = API_Methods.ResponseBody(Patch_Req_Repository.BaseURI(), Patch_Req_Repository.Patch_Resource(), Patch_Req_Repository.Patch_Req_TC1());
	System.out.println(ResponseBody);
	
	JsonPath JspResponse = new JsonPath(ResponseBody);
	String Res_name = JspResponse.getString("name");
	String Res_job = JspResponse.getString("job");
	
	
	//System.out.println(Res_name,);
	Assert.assertEquals(Res_name,"morpheus");
	Assert.assertEquals(Res_job,"leader");
	}

}