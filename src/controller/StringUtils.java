package controller;

public class StringUtils {
	
	public static String formatQueryString(String message) {
		String result = "";
		
		if(message != null) {
			result = message.replace(" ", "+");
		}
		return result;
	}
	
}
