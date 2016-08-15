package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import controllers.CountNumber;
import dao.ProductDemoDAO;
import models.ProductDemo;
import services.impl.HibernateUtil;

public class ProductDemoDAOImpl implements ProductDemoDAO
{
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private CountNumber countNumber;

    
    public Integer addProductDemo(ProductDemo p)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        Integer productDemoId = null;
        String name = p.getName();
        String type = p.getType();
        String brand = p.getBrand();
        String model = p.getModel();
        String gender = p.getGender();
        String movement = p.getMovement();
        String watchlabel = p.getWatchLabel();
        double caseSize = p.getCaseSize();
        double caseThickness = p.getCaseThickness();
        String caseMaterial = p.getCaseMaterial();
        String caseShape = p.getCaseShape();
        String dialType = p.getDialType();
        String dialColor = p.getDialColor();
        String crystal = p.getCrystal();
        String waterResistance = p.getWaterResistance();
        
        String metal = p.getMetal();
        String clasp = p.getClasp();
        double chainLength = p.getChainLength();
        String chainType = p.getChainType();
        double width = p.getWidth();
        double length = p.getLength();
        String rhodiumPlated = p.getRhodiumPlated();
        int numberOfCenterRoundDiamonds = p.getNumberOfCenterRoundDiamonds();
        double minimumCaratTotalWeight = p.getMinimumCaratTotalWeight();
        String minimumColor = p.getMinimumColor();
        String minimumClarity = p.getMinimumClarity();
        String minimumCut = p.getMinimumCut();
        String settingType = p.getSettingType();
        
        double price = p.getPrice();
        String path = p.getPath();
        
        if (type.equals("watch") && !name.equals(null) && price != 0)
        {
            try
            {
                tr = session.beginTransaction();
                
                ProductDemo productDemo = new ProductDemo(name, type, brand, model, gender, movement, watchlabel, caseSize, caseThickness, caseMaterial, caseShape, dialType, dialColor, crystal, waterResistance, price, path);
                productDemoId = (Integer) session.save(productDemo);
                tr.commit();
            }
            catch (HibernateException he)
            {
                if (tr != null)
                    tr.rollback();
                he.printStackTrace();
            }
            finally
            {
                session.close();
            }
        }
        else if (type.equals("jewelry") && !name.equals(null) && price != 0)
        {
            try
            {
                tr = session.beginTransaction();
                
                ProductDemo productDemo = new ProductDemo(name, type,  metal, clasp, chainLength, chainType, width, length, rhodiumPlated, numberOfCenterRoundDiamonds, minimumCaratTotalWeight, minimumColor, minimumClarity, minimumCut, settingType, price, path);
                productDemoId = (Integer) session.save(productDemo);
                tr.commit();
            }
            catch (HibernateException he)
            {
                if (tr != null)
                    tr.rollback();
                he.printStackTrace();
            }
            finally
            {
                session.close();
                Session s = session.getSession();
                System.out.println(countNumber.printCount() + ": " + s);
            }
            
        }

        return productDemoId;
    }
    
    public void updateProductDemo(ProductDemo p)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        Integer productDemoId = p.getId();
        String name = p.getName();
        String type = p.getType();
        String brand = p.getBrand();
        String model = p.getModel();
        String gender = p.getGender();
        String movement = p.getMovement();
        String watchLabel = p.getWatchLabel();
        double caseSize = p.getCaseSize();
        double caseThickness = p.getCaseThickness();
        String caseMaterial = p.getCaseMaterial();
        String caseShape = p.getCaseShape();
        String dialType = p.getDialType();
        String dialColor = p.getDialColor();
        String crystal = p.getCrystal();
        String waterResistance = p.getWaterResistance();
        
        String metal = p.getMetal();
        String clasp = p.getClasp();
        double chainLength = p.getChainLength();
        String chainType = p.getChainType();
        double width = p.getWidth();
        double length = p.getLength();
        String rhodiumPlated = p.getRhodiumPlated();
        int numberOfCenterRoundDiamonds = p.getNumberOfCenterRoundDiamonds();
        double minimumCaratTotalWeight = p.getMinimumCaratTotalWeight();
        String minimumColor = p.getMinimumColor();
        String minimumClarity = p.getMinimumClarity();
        String minimumCut = p.getMinimumCut();
        String settingType = p.getSettingType();
        
        double price = p.getPrice();
        String path = p.getPath();
        
        try
        {
            tx = session.beginTransaction();
            ProductDemo productDemo = session.get(ProductDemo.class, productDemoId);
            productDemo.setName(name);
            productDemo.setType(type);
            productDemo.setBrand(brand);
            productDemo.setGender(gender);
            productDemo.setMovement(movement);
            productDemo.setWatchLabel(watchLabel);
            productDemo.setCaseSize(caseSize);
            productDemo.setCaseThickness(caseThickness);
            productDemo.setCaseMaterial(caseMaterial);
            productDemo.setCaseShape(caseShape);
            productDemo.setDialType(dialType);
            productDemo.setDialColor(dialColor);
            productDemo.setCrystal(crystal);
            productDemo.setWaterResistance(waterResistance);
            
            productDemo.setMetal(metal);
            productDemo.setClasp(clasp);
            productDemo.setChainLength(chainLength);
            productDemo.setChainType(chainType);
            productDemo.setWidth(width);
            productDemo.setLength(length);
            productDemo.setRhodiumPlated(rhodiumPlated);
            productDemo.setNumberOfCenterRoundDiamonds(numberOfCenterRoundDiamonds);
            productDemo.setMinimumCaratTotalWeight(minimumCaratTotalWeight);
            productDemo.setMinimumColor(minimumColor);
            productDemo.setMinimumClarity(minimumClarity);
            productDemo.setMinimumCut(minimumCut);
            productDemo.setSettingType(settingType);

            productDemo.setPrice(price);
            productDemo.setPath(path);
            tx.commit();
        }
        catch (HibernateException he)
        {
            if (tx != null)
                tx.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
            Session s = session.getSession();
            System.out.println(countNumber.printCount() + ": " + s);
        }

    }

    public List<ProductDemo> listProductDemo()
    {
        // TODO Auto-generated method stub
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        try
        {
            tr = session.beginTransaction();
//            Criteria crit = session.createCriteria(ProductDemo.class);
 //           List<ProductDemo> products = crit.list();
            String hql = "from ProductDemo";
            Query query = session.createQuery(hql);
            
            return query.list();            
        }
        catch (HibernateException he)
        {
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
            return null;
        }
        finally
        {
            session.close();
        }
    }

    public void removeProductDemo(Integer id)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        try
        {
            tr = session.beginTransaction();
            ProductDemo productDemo = session.get(ProductDemo.class, id);
            session.delete(productDemo);
            tr.commit();
        }
        catch (HibernateException he)
        {
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    public void returnProductsNumber(int productNumber)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        
    }
    
    @SuppressWarnings("deprecation")
	public List<ProductDemo> returnProductsForOnePage(int pageNumber, int pageSize)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        int maxPageSize;
        double maxDataSize;
        
        try
        {
            tr = session.beginTransaction();
            
            // count data size
            String hql = "SELECT count(*) FROM ProductDemo";
			Query query = session.createQuery(hql);
			maxDataSize = ((Long) query.uniqueResult()).intValue();
			System.out.println(maxDataSize);
            
            if (maxDataSize == 0)
            {
                List<ProductDemo> products = new ArrayList<ProductDemo>();
                ProductDemo product = new ProductDemo(0, 0);
                products.add(product);
                
                return products;
            }
			
            if (maxDataSize%pageSize == 0)
            {
                maxPageSize = (int) maxDataSize/pageSize;            	
            }
            else
            {
                maxPageSize = (int) maxDataSize/pageSize + 1;
            }
            
            //page number nay vuot wa' so luong data
            if (pageNumber > maxPageSize || pageNumber == 0)
            {
                return null;
            }
            else
            {
              //get data for 1 page
                hql = "FROM ProductDemo";
                query = session.createQuery(hql);
                query.setFirstResult((pageNumber-1)*pageSize);
                query.setMaxResults(pageSize);
                List<ProductDemo> productDemos = query.list();
                ProductDemo productDemoForCount = new ProductDemo(maxPageSize, maxDataSize);
                productDemos.add(productDemoForCount); 
                
                return productDemos;
            }
        }
        catch(HibernateException he)
        {
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
            Session s = session.getSession();
            System.out.println(countNumber.printCount() + ": " + s);
        }
        
        return null;
    }
    
    public List<ProductDemo> returnProductsForSearchNameForOnePage(int pageNumber, int pageSize, String name)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        int maxPageSize;
        double maxDataSize;
        
        try
        {
            tr = session.beginTransaction();
            
            //count data searched name size
            String hql = "SELECT COUNT(*) FROM ProductDemo AS p WHERE p.name like :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", "%" + name + "%");
            maxDataSize = ((Long) query.uniqueResult()).intValue();
            
            if (maxDataSize == 0)
            {
                List<ProductDemo> products = new ArrayList<ProductDemo>();
                ProductDemo product = new ProductDemo(0, 0);
                products.add(product);
                
                return products;
            }
            
            if (maxDataSize%pageSize == 0)
            {
                maxPageSize = (int) maxDataSize/pageSize;             
            }
            else
            {
                maxPageSize = (int) maxDataSize/pageSize + 1;
            }
            
            //page number nay vuot wa' so page hien co
            if (pageNumber > maxPageSize || pageNumber == 0)
            {
                return null;
            }
            else
            {
              //get data for 1 page
                hql = "FROM ProductDemo AS p WHERE p.name LIKE :name";
                query = session.createQuery(hql);
                query.setParameter("name", "%" + name + "%");
                query.setFirstResult((pageNumber-1)*pageSize);
                query.setMaxResults(pageSize);
                List<ProductDemo> productDemos = query.list();
                ProductDemo productDemoForCount = new ProductDemo(maxPageSize, maxDataSize);
                productDemos.add(productDemoForCount); 
                
                return productDemos;
            }
        }
        catch (HibernateException he)
        {
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
            Session s = session.getSession();
            System.out.println(countNumber.printCount() + ": " + s);
        }
        
        return null;
    }
  
    public List<ProductDemo> returnProductsWatchForOnePage(int pageNumber, int pageSize)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        int maxPageSize;
        double maxDataSize;
        
        try
        {
            tr = session.beginTransaction();
            
            // count data size
            String hql = "SELECT count(*) FROM ProductDemo AS p WHERE p.type = 'watch'";
            Query query = session.createQuery(hql);
            maxDataSize = ((Long) query.uniqueResult()).intValue();
            
            if (maxDataSize%pageSize == 0)
            {
                maxPageSize = (int) maxDataSize/pageSize;               
            }
            else
            {
                maxPageSize = (int) maxDataSize/pageSize + 1;
            }
            
            //page number nay vuot wa' so luong data
            if (pageNumber > maxPageSize || pageNumber == 0)
            {
                return null;
            }
            else
            {
              //get data for 1 page
                hql = "FROM ProductDemo as p WHERE p.type = 'watch'";
                query = session.createQuery(hql);
                query.setFirstResult((pageNumber-1)*pageSize);
                query.setMaxResults(pageSize);
                List<ProductDemo> productDemos = query.list();
                ProductDemo productDemoForCount = new ProductDemo(maxPageSize, maxDataSize);
                productDemos.add(productDemoForCount); 
                
                return productDemos;
            }
        }
        catch(HibernateException he)
        {
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
        }
        finally
        {

            if (session.isOpen())
            {
                session.close();            
            }

            Session s = session.getSession();
            System.out.println(countNumber.printCount() + ": " + s);
        }
        
        return null;  
    }

    public List<ProductDemo> returnProductsJewelryForOnePage(int pageNumber, int pageSize)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        int maxPageSize;
        double maxDataSize;
        
        try
        {
            tr = session.beginTransaction();
            
            // count data size
            String hql = "SELECT count(*) FROM ProductDemo AS p WHERE p.type = 'jewelry'";
            Query query = session.createQuery(hql);
            maxDataSize = ((Long) query.uniqueResult()).intValue();
            
            if (maxDataSize%pageSize == 0)
            {
                maxPageSize = (int) maxDataSize/pageSize;               
            }
            else
            {
                maxPageSize = (int) maxDataSize/pageSize + 1;
            }
            
            //page number nay vuot wa' so luong data
            if (pageNumber > maxPageSize || pageNumber == 0)
            {
                return null;
            }
            else
            {
              //get data for 1 page
                hql = "FROM ProductDemo as p WHERE p.type = 'jewelry'";
                query = session.createQuery(hql);
                query.setFirstResult((pageNumber-1)*pageSize);
                query.setMaxResults(pageSize);
                List<ProductDemo> productDemos = query.list();
                ProductDemo productDemoForCount = new ProductDemo(maxPageSize, maxDataSize);
                productDemos.add(productDemoForCount); 
                
                return productDemos;
            }
        }
        catch(HibernateException he)
        {
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
            Session s = session.getSession();
            System.out.println(countNumber.printCount() + ": " + s);
        }
        
        return null;
    }

    public List<ProductDemo> returnAmountOfProduct(int number)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        try
        {
            int maxPageSize;
            String hql = "FROM ProductDemo";
            Query query = session.createQuery(hql);
            query.setFirstResult(0);
            query.setMaxResults(number);
            List<ProductDemo> products = query.list();
            
            if (number%8 == 0)
            {
                maxPageSize = number/8;
            }
            else
            {
                maxPageSize = number/8 + 1;
            }
            
            ProductDemo p = new ProductDemo(maxPageSize, number);
            
            products.add(p);
            
            return products;
        }
        catch (HibernateException he)
        {
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
        
        return null;
    }
    
}
