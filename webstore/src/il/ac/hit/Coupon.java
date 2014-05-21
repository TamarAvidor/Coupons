package il.ac.hit;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@javax.persistence.Entity
public class Coupon
{
	@Id
	@Column(name="COUPON_ID")
	private int couponID;
	private String couponName;
	private String couponCategory;
	private Date couponExpersionDate; //Date && Time
	private double couponPrice;
	@ManyToOne
	@JoinColumn(name="business_id")
	private Business business;
	private int businessID;
		



	public Coupon() {}


	public Coupon(int couponID, String couponName, String couponCategory,
			Date couponExpersionDate, double couponPrice) {
		this.couponID = couponID;
		this.couponName = couponName;
		this.couponCategory = couponCategory;
		this.couponExpersionDate = couponExpersionDate;
		this.couponPrice = couponPrice;
	}


	public int getCouponID() {
		return couponID;
	}

	public void setCouponID(int couponID) {
		this.couponID = couponID;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public String getCouponCategory() {
		return couponCategory;
	}

	public void setCouponCategory(String couponCategory) {
		this.couponCategory = couponCategory;
	}

	public Date getCouponExpersionDate() {
		return couponExpersionDate;
	}

	public void setCouponExpersionDate(Date couponExpersionDate) {
		this.couponExpersionDate = couponExpersionDate;
	}

	public double getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(double couponPrice) {
		this.couponPrice = couponPrice;
	}
	
	@Override
	public String toString()
	{
		String stringToReturn = this.couponID + this.couponName + this.couponCategory + this.couponExpersionDate + this.couponPrice;
		return stringToReturn;
	}


	public Business getBusiness() {
		return business;
	}


	public int getBusinessID() {
		return businessID;
	}


	public void setBusinessID() {
		this.businessID = business.getBusinessId();
	}


	public void setBusiness(Business business) {
		this.business = business;
		this.setBusinessID();
	}

	public String printCouponFields()
	{
		return ("ID:" + this.couponID + "	Name:" + this.couponName + "	Category:" 
							+ this.couponCategory + "	Price:" + this.couponPrice + "ExpersionDate:" + this.couponExpersionDate );
	}
    
   /*
	public int getBusinessId() {
		return businessId;
	}

    
	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}
	
*/

}
