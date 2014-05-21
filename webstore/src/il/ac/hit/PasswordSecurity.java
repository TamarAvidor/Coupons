package il.ac.hit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordSecurity {

//replace the throwing exception to our exception
public String encryptStringToHex(String userInputToEncrypt) throws NoSuchAlgorithmException 
{
	MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(userInputToEncrypt.getBytes());

    byte byteData[] = md.digest();

    //convert the byte to hex format
    StringBuffer encryptedPassword = new StringBuffer();
    for (int i = 0; i < byteData.length; i++) {
    	encryptedPassword.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
    }

    System.out.println("Digest(in hex format):: " + encryptedPassword.toString());

    
	return encryptedPassword.toString();
}

public Boolean passwordAuthentication(int adminID ,String adminInputToEncrypt)
{
	Boolean succeededPasswordAuthentication = false;
	IDAO daoUser = HibernateDAO.getInstance();
	
	
		Administrator adminToAuthenticat;
		try {
			adminToAuthenticat = (Administrator) daoUser.getObject("Administrator", adminID);
	
		System.out.println("entered method");
		String encryptedInput = encryptStringToHex(adminInputToEncrypt);
		

		
		System.out.println("encrypted Input" + encryptedInput);
		System.out.println("adminToAuthenticat.getAdminPassword()" +      adminToAuthenticat.getAdminPassword());
		
		if (encryptedInput.equals(adminToAuthenticat.getAdminPassword()))
		{
			System.out.println("enter if");
			 succeededPasswordAuthentication = true;
		}
		} catch (ObjectPlatformException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	System.out.println("return statment");
	return succeededPasswordAuthentication;
}

//public addNewUserTotable
 

}
