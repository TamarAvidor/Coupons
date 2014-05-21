package il.ac.hit;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateDAO implements IDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SessionFactory factory;

	public static HibernateDAO instance;

	public static HibernateDAO getInstance()
	{
		if (instance == null)
		{
			instance = new HibernateDAO();
		}
		return instance;
	}

	private HibernateDAO()
	{
		factory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		

	}

	@Override
	public boolean addObject(Object ob) throws ObjectPlatformException
	{
		Session session = null;
		try
		{
			session = factory.openSession();
			session.beginTransaction();
			session.save(ob);
			session.getTransaction().commit();
			return true;
		}
		catch (HibernateException e)
		{
			if (session != null)
			{
				session.getTransaction().rollback();
			}
			throw new ObjectPlatformException("failure in openning session",
					e);
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		
	}
	
	@Override
	public boolean deleteObject(Object ob) throws ObjectPlatformException
	{
		Session session = null;
		try
		{
			session = factory.openSession();
			session.beginTransaction();
			if (ob.getClass() == Business.class) //delete all coupons that belong to specified business 
			{
				Business business = (Business) ob;
				 
				@SuppressWarnings("unchecked")
				Query query = session.createQuery("delete Coupon where businessID = :businessId");
				 query.setParameter("businessId", business.getBusinessId());
				 int result = query.executeUpdate();
				 
				 /*
				 List <Coupon> coupons = getAllBusinessCoupons(business.getBusinessId());
				 Iterator<Coupon> iterator = coupons.iterator();
				 while(iterator.hasNext()) 
				 {
					 Coupon CouponElement = iterator.next();
					 deleteObject(CouponElement);
					 coupons.remove(CouponElement);
				 }	
				 */
			}
			
			session.delete(ob);
			session.getTransaction().commit();
			return true;
		}
		catch (HibernateException e)
		{
			if (session != null)
			{
				session.getTransaction().rollback();
			}
			throw new ObjectPlatformException("failure in openning session",
					e);
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		
	}
	
	@Override
	public boolean updateObject(Object ob) throws ObjectPlatformException
	{
		Session session = null;
		try
		{
			session = factory.openSession();
			session.beginTransaction();
			session.update(ob);
			session.getTransaction().commit();
			return true;
		}
		catch (HibernateException e)
		{
			if (session != null)
			{
				session.getTransaction().rollback();
			}
			throw new ObjectPlatformException("failure in openning session",
					e);
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		
	}
	
	@Override
	public Object getObject(String objectClassName, int objectID) throws ObjectPlatformException
	{
		Session session = null;
		System.out.println("session has been created and stored with the null value");
		try
		{
			session = factory.openSession();
			System.out.println("open session operation has succeeded");
			session.beginTransaction();
			System.out.println("session begin transaction");
			Object object = session.get("il.ac.hit."+objectClassName, objectID);
			System.out.println("getting the actual object");
			session.getTransaction().commit();
			System.out.println("getTranscation() and commit() has been excuted");
			return object;
		}
		catch (HibernateException e)
		{
			if (session != null)
			{
				session.getTransaction().rollback();
			}
			throw new ObjectPlatformException("failure in openning session",
					e);
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		
	}
	
	
	
	public void dropsTables()
	{
		Session session = factory.openSession();
		session.beginTransaction();
		session.createQuery("DELETE FROM Coupon").executeUpdate();
		session.createQuery("DELETE FROM Administrator").executeUpdate();
		session.createQuery("DELETE FROM Business").executeUpdate();
		session.getTransaction().commit();
		session.close();
	
	}

	public List<Coupon> getAllBusinessCoupons(int businessId)
	{
		Session session = factory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		Query query = session.createQuery("from coupon where business_id = :businessId");
		query.setParameter("businessId", businessId);
		List<Coupon> coupons = query.list();// where businessID="+businessId).list();" 
	  //Set<Coupon> coupons = new HashSet<Coupon>();// = session.createQuery("from coupon").Set();
		session.close(); 	
		return coupons; 
	}
	
	public List<Object> getRequestedObjectsFromDAO(String tableName)
	{
		Session session = factory.openSession();
		session.beginTransaction();
		List <Object> listOfObjects = session.createCriteria("il.ac.hit." + tableName).list(); 
		 //= new HashSet<Coupon>();// = session.createQuery("from coupon").Set();
		session.close(); 	
		return listOfObjects; 
	}
	
}
