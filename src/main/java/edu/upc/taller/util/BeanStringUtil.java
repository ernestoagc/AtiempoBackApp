package edu.upc.taller.util;

public class BeanStringUtil {
	public static boolean isBlank(String str) {
		if (str == null || str.trim().length() == 0){
			return true;
		}
		return false;
	}
	
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
}
