package dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import controllers.CountNumber;
import dao.ProductDemoDAO;
import models.ProductDemo;
import services.HibernateUtil;

public class ProductDemoDAOImpl implements ProductDemoDAO
{
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private CountNumber countNumber;
    private static List<ProductDemo> initializedListProductDemo;
    
    private static int isActiveInitializeList = 0;
    private static int isActiveCountData = 0;
    private static int isActiveCountWatch = 0;
    private static int isActiveCountJewelry = 0;
    
    private static int maxDataSize;
    private static int maxWatchSize;
    private static int maxJewelrySize;

    //if = 1: queried to get max maxDataSize
    public int getIsActiveCountData()
    {
        return isActiveCountData;
    }
    
    public int getIsActiveCountWatch()
    {
        return isActiveCountWatch;
    }
    
    public int getIsActiveCountJewelry()
    {
        return isActiveCountJewelry;
    }
    
    
    public void setIsActiveCountData(int number)
    {
        this.isActiveCountData = number;
    }
    
    public void setIsActiveCountWatch(int number)
    {
        this.isActiveCountWatch = number;
    }
    
    public void setIsActiveCountJewelry(int number)
    {
        this.isActiveCountJewelry = number;
    }
    
    
    public void setMaxDataSize(int maxDataSize)
    {
        this.maxDataSize = maxDataSize;
    }
    
    public void setMaxWatchSize(int maxWatchSize)
    {
        this.maxWatchSize = maxWatchSize;
    }
    
    public void setMaxJewelrySize(int maxJewelrySize)
    {
        this.maxJewelrySize = maxJewelrySize;
    }
    
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
                maxDataSize = maxDataSize + 1;
                maxWatchSize = maxWatchSize + 1;
                tr = session.beginTransaction();
                
                ProductDemo productDemo = new ProductDemo(name, type, brand, model, gender, movement, watchlabel, caseSize, caseThickness, caseMaterial, caseShape, dialType, dialColor, crystal, waterResistance, price, path);
                productDemoId = (Integer) session.save(productDemo);
                tr.commit();
            }
            catch (HibernateException he)
            {
                maxDataSize = maxDataSize - 1;
                maxWatchSize = maxWatchSize - 1;
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
                maxDataSize = maxDataSize + 1;
                maxJewelrySize = maxJewelrySize + 1;
                tr = session.beginTransaction();
                
                ProductDemo productDemo = new ProductDemo(name, type,  metal, clasp, chainLength, chainType, width, length, rhodiumPlated, numberOfCenterRoundDiamonds, minimumCaratTotalWeight, minimumColor, minimumClarity, minimumCut, settingType, price, path);
                productDemoId = (Integer) session.save(productDemo);
                tr.commit();
            }
            catch (HibernateException he)
            {
                maxDataSize = maxDataSize - 1;
                maxJewelrySize = maxJewelrySize - 1;
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
            maxDataSize = maxDataSize - 1;
            tr = session.beginTransaction();
            ProductDemo productDemo = session.get(ProductDemo.class, id);
            session.delete(productDemo);
            tr.commit();
        }
        catch (HibernateException he)
        {
            maxDataSize = maxDataSize + 1;
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }
    
    @SuppressWarnings("deprecation")
	public List<ProductDemo> returnProductsForOnePage(int pageNumber, int pageSize)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        int maxPageSize;
        
        try
        {
            tr = session.beginTransaction();
            
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
                Criteria crit = session.createCriteria(ProductDemo.class)
                                        .setFirstResult(((pageNumber-1)*pageSize))
                                        .setMaxResults(pageSize);
                List<ProductDemo> productDemos = crit.list();
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
    
    //**************
    public List<ProductDemo> returnProductsForOnePagee(int pageNumber, int pageSize)
                             
    {
        
  //      System.out.println("in " + getCurrentTimeStamp());
        
        
        List<ProductDemo> products = new ArrayList<ProductDemo>();
        products.add(initializedListProductDemo.get(0));
        for (int i = 0; i < 8; i++)
        {
           
      //      System.out.println(i + ": " + getCurrentTimeStamp());
      //      products.add(initializedListProductDemo.get((pageNumber-1)*pageNumber+i));
            System.out.println("pagenumber = " + pageNumber);
            System.out.println("index = " + (pageNumber-1)*pageSize+i);
            products.add(initializedListProductDemo.get((pageNumber-1)*pageSize+i));
        }
        
        
    //    System.out.println("out " + getCurrentTimeStamp());
        
        return products;
    }
    //**************
    
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
            Criteria crit = session.createCriteria(ProductDemo.class);
            maxDataSize = (Long) crit.add(Restrictions.ilike("name", "%" + name + "%"))
                .setProjection(Projections.rowCount())
                .uniqueResult();
            
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
                List<ProductDemo> productDemos = crit.add(Restrictions.ilike("name", "%" + name + "%"))
                                                     .setFirstResult((pageNumber-1)*pageSize)
                                                     .setMaxResults(pageSize)
                                                     .list();
                
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
        
        try
        {
            tr = session.beginTransaction();
            
            if (maxWatchSize%pageSize == 0)
            {
                maxPageSize = (int) maxWatchSize/pageSize;               
            }
            else
            {
                maxPageSize = (int) maxWatchSize/pageSize + 1;
            }
            
            //page number nay vuot wa' so luong data
            if (pageNumber > maxPageSize || pageNumber == 0)
            {
                return null;
            }
            else
            {
              //get data for 1 page
                List<ProductDemo> productDemos = session.createCriteria(ProductDemo.class)
                                                        .add(Restrictions.ilike("type", "watch"))
                                                        .setFirstResult((pageNumber-1)*pageSize)
                                                        .setMaxResults(pageSize)
                                                        .list();
                
                ProductDemo productDemoForCount = new ProductDemo(maxPageSize, maxWatchSize);
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
        
        try
        {
            tr = session.beginTransaction();
            
            if (maxJewelrySize%pageSize == 0)
            {
                maxPageSize = (int) maxJewelrySize/pageSize;               
            }
            else
            {
                maxPageSize = (int) maxJewelrySize/pageSize + 1;
            }
            
            //page number nay vuot wa' so luong data
            if (pageNumber > maxPageSize || pageNumber == 0)
            {
                return null;
            }
            else
            {
              //get data for 1 page
                
                List<ProductDemo> productDemos = session.createCriteria(ProductDemo.class)
                                                        .add(Restrictions.ilike("type", "jewelry"))
                                                        .setFirstResult((pageNumber-1)*pageSize)
                                                        .setMaxResults(pageSize)
                                                        .list();
                ProductDemo productDemoForCount = new ProductDemo(maxPageSize, maxJewelrySize);
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
            tr = session.beginTransaction();
            int maxPageSize;

            List<ProductDemo> products = session.createCriteria(ProductDemo.class)
                                                .setFirstResult(0)
                                                .setMaxResults(number)
                                                .list();
            
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
    
    public int getMaxDataSize()
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        int maxSizeData;
        
        try
        {
            tr = session.beginTransaction();
            String hql = "Select count(*) from ProductDemo";
            Query query = session.createQuery(hql);
            maxSizeData = ((Long) query.uniqueResult()).intValue();
            
            return maxSizeData;
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
        
        return 0;
    }

    public int getMaxWatchSize()
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        try
        {
            String hql = "Select count(*) from ProductDemo as p where p.type = 'watch'";
            Query query = session.createQuery(hql);
            int maxWatchSize = ((Long) query.uniqueResult()).intValue();
            
            return maxWatchSize;
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
        
        return 0;
    }

    public int getMaxJewelrySize()
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        try
        {
            String hql = "Select count(*) from ProductDemo as p where p.type = 'jewelry'";
            Query query = session.createQuery(hql);
            int maxWatchSize = ((Long) query.uniqueResult()).intValue();
            
            return maxWatchSize;
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
        
        return 0;
    }

    public void initializeListProduct()
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        try 
        {
            System.out.println("start");
            
            tr = session.beginTransaction();
            
            Criteria crit = session.createCriteria(ProductDemo.class);            
            //initializedListProductDemo = crit.setFirstResult(0).setMaxResults(100000).list();
            initializedListProductDemo = crit.list();
   //         System.out.println("size = " + initializedListProductDemo.size());
            
            System.out.println("end");
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
    
    public String getCurrentTimeStamp()
    {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }

    //public List<ProductDemo> returnProductForSearchNameForOnePagee(int pageNUmber, int pageSize)
}
