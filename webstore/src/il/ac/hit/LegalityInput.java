package il.ac.hit;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LegalityInput {

				//private int businessId;
			//private String businessName;
	//private String businessCatgory;
	//private String businessAddress;
				//private String businessPhoneNumber;	 
				//private int couponID;
				//private String couponName;
	//private String couponCategory;
	//private Date couponExpersionDate; //Date && Time
		//private double couponPrice;
	
	public static boolean checkID(String IDToCheck)
	{
		boolean isIDLegit = true;
		
		//if(!(IDToCheck.contains(" ")))
		//{
			if (IDToCheck == null || IDToCheck.length() == 0)
				isIDLegit = false;
	        
	        for (int i = 0; i < IDToCheck.length(); i++) {
	 
	            //If we find a non-digit character we return false.
	            if (!Character.isDigit(IDToCheck.charAt(i)))
	            	isIDLegit =  false;
	        }
		//}
		//else
		//{
		//	isIDLegit =  false;
		//}
        return isIDLegit;
	}
	
	public static boolean checkName(String nameToCheck)
	{
		boolean isNameLegit = true;
		
		if (nameToCheck == null || nameToCheck.length() == 0)
			isNameLegit = false;
		
		return isNameLegit;
	}
	
	/*public static boolean checkPrice(String priceToCheck)
	{
		boolean isPriceLegit = true;
		
		if (priceToCheck == null || priceToCheck.length() == 0)
			isPriceLegit = false;
        
        for (int i = 0; i < priceToCheck.length(); i++) {
 
            //If we find a non-digit character we return false.
            if (!Character.isDigit(priceToCheck.charAt(i)))
            	isPriceLegit =  false;
        }

        return isPriceLegit;
	}*/
	public static boolean checkPhoneNumber(String phoneNumberToCheck)
	{
		boolean isPhoneNumberLegit = false;
		/*String pattern = "^0\d([\d]{0,1})([-]{0,1})\d{7}$";
	    String s= "1233323322";
	    assertFalse(s.matches(pattern));*/
		
		 Pattern pattern = Pattern
         .compile(("0\\d[\\d]?-\\d{7}"));//"0\\d([\\d]{0,1})([-]{0,1})\\d{7}");//("^0/d{5}$");//("0\\d([\\d]{0,1})([-]{0,1})\\d{7}");
		 Matcher matcher = pattern.matcher(phoneNumberToCheck);
		 
		 if ((matcher.matches()))
		 {
			 isPhoneNumberLegit = true;
		 }
		 
		 return isPhoneNumberLegit;
	}
	
	public static boolean checkDate(String DateToCheck)
	{
		boolean isDateLegit = false;
		/*String pattern = "^0\d([\d]{0,1})([-]{0,1})\d{7}$";
	    String s= "1233323322";
	    assertFalse(s.matches(pattern));*/
		
		 Pattern pattern = Pattern
         .compile("(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-](19|20)\\d{2}");//[-](0[1-9]|1[012])[-](19|20)//d//d");
		// (19|20)\d\d   [- /.]       (0[1-9]|1[012])      [- /.]       (0[1-9]|[12][0-9]|3[01])
		 //"0\\d([\\d]{0,1})([-]{0,1})\\d{7}");//("^0/d{5}$");//("0\\d([\\d]{0,1})([-]{0,1})\\d{7}");
		 Matcher matcher = pattern.matcher(DateToCheck);
		 
		 if ((matcher.matches()))
		 {
			 isDateLegit = true;
		 }
		 
		 return isDateLegit;
	}
}




