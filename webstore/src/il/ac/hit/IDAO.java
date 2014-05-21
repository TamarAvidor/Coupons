package il.ac.hit;

import java.util.List;
import java.util.Set;

public interface IDAO {

	public boolean addObject(Object ob) throws ObjectPlatformException;
	public Object getObject(String objectClassName, int idObject) throws ObjectPlatformException;
	public boolean deleteObject(Object ob) throws ObjectPlatformException;
	public boolean updateObject(Object ob) throws ObjectPlatformException;
	public void dropsTables();
	public List<Coupon> getAllBusinessCoupons(int businessId);
	public List<Object>getRequestedObjectsFromDAO(String tableName);
	
}
