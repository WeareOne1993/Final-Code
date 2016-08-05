package dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.ProductDemoDAO;
import models.ProductDemo;

public class ProductDemoDAOImpl implements ProductDemoDAO
{
    private static SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf)
    {
        this.sessionFactory = sf;
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
                
                ProductDemo productDemo = new ProductDemo(name, dialType, metal, clasp, chainLength, chainType, width, length, rhodiumPlated, numberOfCenterRoundDiamonds, minimumCaratTotalWeight, minimumColor, minimumClarity, minimumCut, settingType, price, path);
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
        else 
            System.out.println("ok!");

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
            System.out.println("updateded");
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
            Criteria crit = session.createCriteria(ProductDemo.class);
            List<ProductDemo> products = crit.list();
            
            return products;            
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

    @SuppressWarnings("deprecation")
	public List<ProductDemo> returnProductForOnePage(int pageNumber, int pageSize)
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        int newId;
        pageSize = 8;
        
        try
        {
            tr = session.beginTransaction();
            
            // count data size
            String hql = "SELECT count(*) FROM ProductDemo";
            @SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
            newId = ((Long) query.uniqueResult()).intValue();
            
            if (newId%pageSize == 0)
            {
            	newId = newId/pageSize;            	
            }
            else
            {
            	newId = newId/pageSize + 1;
            }
            
            //page number nay vuot wa' so luong data
            if (pageNumber > newId)
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
                ProductDemo productDemoForCount = new ProductDemo(newId);
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
        }
        
        return null;
    }
    
}
