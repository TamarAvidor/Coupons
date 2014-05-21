package il.ac.hit;

import java.util.*;

public class CouponsCart {

//	List <CouponsCartLine> couponsCartInfo = new ArrayList<CouponsCartLine> ();
	Map<Coupon,CouponsCartLine> couponsCartInfo = new Hashtable<Coupon,CouponsCartLine>();
	
	public Map<Coupon,CouponsCartLine> getCouponsCartInfo() {
	return couponsCartInfo;
}

	public void addCoupon(Coupon coupon)
	{
			if(couponsCartInfo.get(coupon)== null)
			{
				couponsCartInfo.put(coupon, new CouponsCartLine(coupon));
			}
			else
			{
				@SuppressWarnings("unused")
				CouponsCartLine line = (couponsCartInfo.get(coupon));
			}
	}
		/*else
		{
			CouponsCartLine line = (CouponsCartLine)(lines.get(coupon));
			//line.setQuantity(line.getQuantity()+5);
		}*/
		
		
		
		/*
		Iterator <CouponsCartLine> iterator = couponsCartInfo.iterator();
		if(couponsCartInfo.size() != 0)
		{
			while(iterator.hasNext())
			{
				CouponsCartLine couponsCartLine = (CouponsCartLine)iterator.next();
				Coupon couponToCheck = couponsCartLine.getCoupon(); 
			
				if(!(couponToCheck.getCouponID() == couponToAdd.getCouponID()))
				{
					couponsCartInfo.add(new CouponsCartLine(couponToAdd));
				}
			}
		}
		else
		{
			couponsCartInfo.add(new CouponsCartLine(couponToAdd));
		}

	}
	*/
	/*public double getTotal()
	{
		
		double total = 0;
		Iterator iterator = lines.values().iterator();
		while(iterator.hasNext())
		{
			CouponsCartLine line = (CouponsCartLine)iterator.next();
			//total += line.getQuantity() * line.getCoupon().getPrice();
		}
		return total;
		
	}*/
	
	public String getXMLTable()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<ul>"// +
				/*"<tr><th align=left>Name</th><th align=left>Price</th><th align=left>Expersion Date</th></tr>"*/);
		Iterator <CouponsCartLine> iterator = couponsCartInfo.values().iterator();
		while(iterator.hasNext())
		{
			CouponsCartLine couponsCartLine = (CouponsCartLine)iterator.next();
			int couponsID = couponsCartLine.getCoupon().getCouponID();
			String couponsName = couponsCartLine.getCoupon().getCouponName();
			Date expirationDate= couponsCartLine.getCoupon().getCouponExpersionDate();
			
			sb.append("<li><a href=\"/webstore/controller/coupon?couponID="+couponsID+"\">"+couponsName+" "+expirationDate + "</a></li>");
		}
		sb.append("</ul>");
		return sb.toString();
	}
}
