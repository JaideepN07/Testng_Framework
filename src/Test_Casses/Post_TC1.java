package Test_Casses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Method.API_Methods;
import RequestRepository.Post_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Post_TC1 {
	@Test
	
	public static void extractor () throws IOException {
		int statusCode = API_Methods.ResponseStatusCode(Post_Req_Repository.BaseURI(), Post_Req_Repository.Post_Resource(), Post_Req_Repository.Post_TC2_Retry());
	System.out.println(statusCode);
	
	String ResponseBody = API_Methods.ResponseBody(Post_Req_Repository.BaseURI(), Post_Req_Repository.Post_Resource(), Post_Req_Repository.Post_TC2_Retry());
	System.out.println(ResponseBody);
	
	JsonPath JspResponse = new JsonPath(ResponseBody);
	String Res_name = JspResponse.getString("name");
	String Res_job = JspResponse.getString("job");
	
	
	//System.out.println(Res_name,);
	Assert.assertEquals(Res_name,"morpheus");
	Assert.assertEquals(Res_job,"leader");
	}

}