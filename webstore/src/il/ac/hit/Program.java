package il.ac.hit;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Program
{

	public static void main(String[] args)
	{
		Date date = new Date();
		date.setMonth(6);
		date.setYear(116);
		Coupon coupon1 = new Coupon(1, "Pizza", "Food", date,50);
		Coupon coupon2 = new Coupon(2, "Hamburger", "Food", date,60);
		Coupon coupon3 = new Coupon(3, "Sushi", "Food", date, 100);
		Coupon coupon4 = new Coupon(4, "Spaghetti", "Food", date, 80);
		
		Coupon coupon5 = new Coupon(5, "Hame Gaash", "Spa", new Date(), 600);
		Coupon coupon6 = new Coupon(6, "Yam HaMelah", "Spa", new Date(), 500);
		Coupon coupon7 = new Coupon(7, "Horse Riding", "Sports", new Date(), 250);
		Coupon coupon8 = new Coupon(8, "Paint Ball", "Sports", new Date(), 140);
		
		Business business1 = new Business(1, "Pizza Hot", "Food", "bkbas", "0350188888");
		Business business2 = new Business(2, "SpaghettiM", "Food", "jkkbas", "0356969638");
		Business business3 = new Business(3, "Sushi Susha", "Food", "bkbas", "0350188888");
		

		Business business4 = new Business(4, "Hame Gaash baam", "Spa", "bkbas", "0350188888");
		Business business5 = new Business(5, "Yam HaMelah baam", "Spa", "jkkbas", "0356969638");
		Business business6 = new Business(6, "Horse Riding baam", "Sports", "bkbas", "0350188888");
		Business business7 = new Business(7, "Paint Ball baam", "Sports", "bkbas", "0350188888");
		Business business8 = new Business(8, "BBB", "Food", "bkbas", "0350188888");
		
		
		Administrator admin1 = new Administrator(1, "tamar", "e02b665d7be83f3561ac4cb6970bbde4");
	//	coupon2.setBusiness(business2);
	//	coupon3.setBusiness(business3);
	//	coupon4.setBusiness(business3);
		//User user1 = new User(00001, "Jacob", "33c41405b256ab84a9cbd89d2b305a75", "JacobBer@gmail.com","client");
		//User user2 = new User(00002, "Raz", "IloveHen", "JacobBer@gmail.com","client");
		//user1.getCouponsPerUserList().add(coupon1);
		//user1.getCouponsPerUserList().add(coupon2);
		
		//Administrator admin1 = new Administrator(00001, "Raz", "IloveHen");

		if((LegalityInput.checkPhoneNumber("03-1234567")))
		{
			System.out.println("PHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDED");
		}
		if((LegalityInput.checkDate("21-01-1922")))
		{
			System.out.println("DATE CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDEDPHONE NUMBER CHECK SUCCEEDED");
		}
		System.out.println("Start of checking hibernatedao methods(add,get,delete,update))");
		IDAO daoObject = HibernateDAO.getInstance();
		try
		{
		    daoObject.dropsTables();
			//daoObject.addObject(business1);
			daoObject.addObject(admin1);
			System.out.println("coupon1.setBusiness(business1); coupon1.setBusiness(business1); coupon1.setBusiness(business1);");
			
			daoObject.addObject(coupon1);
			daoObject.addObject(coupon2);
			daoObject.addObject(coupon3);
			daoObject.addObject(coupon4);
			daoObject.addObject(coupon5);
			daoObject.addObject(coupon6);
			daoObject.addObject(coupon7);
			daoObject.addObject(coupon8);
			
			daoObject.addObject(business1);
			daoObject.addObject(business2);
			daoObject.addObject(business3);
			daoObject.addObject(business4);
			daoObject.addObject(business5);
			daoObject.addObject(business6);
			daoObject.addObject(business7);
			daoObject.addObject(business8);
			
	
			coupon1.setBusiness(business1);
			coupon2.setBusiness(business8);
			coupon3.setBusiness(business3);
			coupon4.setBusiness(business2);
			coupon5.setBusiness(business4);
			coupon6.setBusiness(business5);
			coupon7.setBusiness(business6);
			coupon8.setBusiness(business7);
			
			/*
			if (daoObject.addObject(coupon1))
			{
				System.out.println("coupon1 was added");
			}
			
			if (daoObject.addObject(coupon2))
			{
				System.out.println("coupon2 was added");
			}
			
			if (daoObject.addObject(coupon3))
			{
				System.out.println("coupon3 was added");
			}
			
			/*if (daoObject.addObject(coupon4))
			{
				System.out.println("coupon4 was added");
			}*/
			
			/*
			if (daoObject.deleteObject(coupon1))
			{
				System.out.println("coupon1 was deleted");
			}
			
			
			coupon3.setCouponPrice(50);
			if (daoObject.updateObject(coupon3))
			{
				System.out.println("coupon3 price was updated");
			}

			System.out.println("TEST TEST TEST COUPON 00003:"+daoObject.getObject("Coupon",00003).toString());
			
			if (daoObject.addObject(business3))
			{
				System.out.println("business 3 added");
				business3.setBusinessPhoneNumber("0399999999");
			}
			
			if (daoObject.updateObject(business3))
			{
				System.out.println("business 3 added");
			}
			
			if (daoObject.addObject(business2))
			{
				System.out.println("business 2 added");
			}
			
			/*
			if (daoObject.deleteObject(business2))
			{
				System.out.println("business 2 deleted");
			}
			*/
			
			//System.out.println("TEST TEST TEST BUSINESS 00001:"+daoObject.getObject("Business",00001).toString());
			
			//daoObject.dropsTables();

		}
		catch (ObjectPlatformException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println("End of checking hibernatedao methods(add,get,delete,update))");
		
		
		System.out.println("Start of checking password authenticion");
		PasswordSecurity passwordSecurity = new PasswordSecurity();

	
	}
}
