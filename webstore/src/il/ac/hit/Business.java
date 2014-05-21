package il.ac.hit;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.Query;

@javax.persistence.Entity
public class Business
{
	@Id
	@Column(name="BUSINESS_ID")
	private int businessId;
	private String businessName;
	private String businessCatgory;
	private String businessAddress;
	private String businessPhoneNumber;
	
	//@OneToMany(cascade={CascadeType.ALL}, mappedBy="business")
	 @OneToMany(mappedBy="business")
	private List<Coupon> businessCouponsDataStructure; 
	
	public Business() {}


	public Business(int businessId, String businessName,
			String businessCatgory, String businessAddress,
			String businessPhoneNumber) {
		super();
		this.businessId = businessId;
		this.businessName = businessName;
		this.businessCatgory = businessCatgory;
		this.businessAddress = businessAddress;
		this.businessPhoneNumber = businessPhoneNumber;
	}

	public int getBusinessId() {
		return businessId;
	}


	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}


	public String getBusinessName() {
		return businessName;
	}


	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}


	public String getBusinessCatgory() {
		return businessCatgory;
	}


	public void setBusinessCatgory(String businessCatgory) {
		this.businessCatgory = businessCatgory;
	}


	public String getBusinessAddress() {
		return businessAddress;
	}


	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}


	public String getBusinessPhoneNumber() {
		return businessPhoneNumber;
	}


	public void setBusinessPhoneNumber(String businessPhoneNumber) {
		this.businessPhoneNumber = businessPhoneNumber;
	}
	
		/*@JoinTable(name = "BusinessCouponsStock", joinColumns={@JoinColumn(name="businessId")},
			inverseJoinColumns=@JoinColumn(name="couponId"))
	//@OrderBy("businessId ASC")*/
	//@JoinColumn(name="businessId")
	public List<Coupon> getBusinessCouponsDataStructure() {
		return businessCouponsDataStructure;
	}

	public void setBusinessCouponsDataStructure(
			List<Coupon> businessCouponsDataStructure) {
		this.businessCouponsDataStructure = businessCouponsDataStructure;
	}
	
	@Override
	public String toString()
	{
		
		String stringToReturn = this.businessId + this.businessName + this.businessCatgory + this.businessAddress + this.businessPhoneNumber;
		return stringToReturn;
	}
	
	public String printBusinessFields()
	{
		return ("ID:" + this.businessId + "	Name:" + this.businessName + "	Category:" 
							+ this.businessCatgory + "	Address:" + this.businessAddress + "	Phone number:" + this.businessPhoneNumber);
	}
	
	public String getXMLTable()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<table width=500><tr><th align=left>Name</th><th align=left>Price</th><th align=left>quantity</th><th align=left>total</th></tr>");
		
		HibernateDAO hibernateDaoInstance =  HibernateDAO.getInstance();
		List<Object> listOfBusinesses = hibernateDaoInstance.getRequestedObjectsFromDAO("bussinss");
		Iterator<Object> iterator = listOfBusinesses.iterator();
		while(iterator.hasNext())
		{
			CouponsCartLine line = (CouponsCartLine)iterator.next();
			sb.append("<tr><td>"+line.getCoupon().getCouponName()+"</td>");
			sb.append("<td>"+line.getCoupon().getCouponPrice()+"</td>");
			//sb.append("<td>"+line.getQuantity()+"</td>");
		}
		sb.append("</table>");
		return sb.toString();
	}
}

