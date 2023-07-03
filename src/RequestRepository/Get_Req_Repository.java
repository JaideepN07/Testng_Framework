package RequestRepository;

public class Get_Req_Repository {
	
	public static String BaseURI() {
		 String baseURI = "https://reqres.in/";
		 return baseURI;	 
	}
	public static String Get_Resource() {
		String get_Resource = "api/users/2";
		return get_Resource;
	}

	
	public static String Get_Req_TC1() {
		String RequestBody = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		return RequestBody;
	}
}