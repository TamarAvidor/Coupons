package il.ac.hit;

public class CouponsCartLine {
	
	private Coupon coupon;
	//private int quantity;
	
	public CouponsCartLine(Coupon coupon)
	{
		super();
		this.coupon = coupon;
		//this.quantity = quantity;
	}
	public boolean equals(Object ob)
	{
		return this.coupon.equals(((CouponsCartLine)ob).getCoupon());
	}
	public Coupon getCoupon()
	{
		return coupon;
	}
	public void setProduct(Coupon coupon)
	{
		this.coupon = coupon;
	}
	/*public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}*/
}
