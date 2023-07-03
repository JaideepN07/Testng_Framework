package Test_Casses;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Method.API_Methods;
import RequestRepository.Post_Req_Repository;
import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.time.LocalDateTime;

public class Post_TC2_Retry {
	@Test
public static void extractor() throws IOException
{
for(int i=0; i<5; i++) 
{
int statusCode=API_Methods.ResponseStatusCode(Post_Req_Repository.BaseURI(),
Post_Req_Repository.Post_Resource(), 
Post_Req_Repository.Post_TC2_Retry());
System.out.println(statusCode);

if(statusCode==201) {
String ResponseBody=API_Methods.ResponseBody(Post_Req_Repository.BaseURI(),
Post_Req_Repository.Post_Resource(),Post_Req_Repository.Post_TC2_Retry());
System.out.println(ResponseBody);

String RequestBody = Post_Req_Repository.Post_TC2_Retry();
Validator(RequestBody, ResponseBody); 

 

break;
}

else{
	System.out.println("Statuscode is failed");
}}}
public static void Validator(String RequestBody,String ResponseBody)
{
JsonPath JspRequest = new JsonPath(RequestBody);
String Req_name = JspRequest.getString("name");
String Req_job = JspRequest.getString("job");
LocalDateTime currentdate = LocalDateTime.now();
String expecteddate=currentdate.toString().substring(0, 11);

	//System.out.println(ResponseBody);
	JsonPath JspResponse = new JsonPath(ResponseBody);
	String Res_name = JspResponse.getString("name");
	String Res_job = JspResponse.getString("job");
	String Res_createdAt = JspResponse.getString("createdAt");
	Res_createdAt = Res_createdAt.substring(0,11);	
	Assert.assertEquals(Res_name, Req_name);
	Assert.assertEquals(Res_job, Req_job);
	Assert.assertEquals(Res_createdAt, expecteddate);
}
}


