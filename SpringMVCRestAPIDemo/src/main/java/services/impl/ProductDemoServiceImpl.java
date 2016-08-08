package services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.ProductDemoDAO;
import models.ProductDemo;
import services.ProductDemoService;

public class ProductDemoServiceImpl implements ProductDemoService {

    private ProductDemoDAO productDemoDAO;
    
    public void setProductDemoDAO(ProductDemoDAO productDemoDAO)
    {
        this.productDemoDAO = productDemoDAO;
    }
    
    @Transactional
    public Integer addProductDemo(ProductDemo p) {
        return this.productDemoDAO.addProductDemo(p);
    }

    
    @Transactional
    public List<ProductDemo> listProductDemo() {
        return this.productDemoDAO.listProductDemo();
    }

    
    @Transactional
    public void updateProductDemo(ProductDemo p) {
        this.productDemoDAO.updateProductDemo(p);

    }

    
    @Transactional
    public void removeProductDemo(Integer id) {
        this.productDemoDAO.removeProductDemo(id);

    }
    
    @Transactional
    public List<ProductDemo> returnProductsForOnePage(int pageNumber, int pageSize)
    {
        return this.productDemoDAO.returnProductsForOnePage(pageNumber, pageSize);
    }
    
    @Transactional
    public List<ProductDemo> returnProductsWatchForOnePage(int pageNumber, int pageSize)
    {
        return this.productDemoDAO.returnProductsWatchForOnePage(pageNumber, pageSize);
    }    
    
    @Transactional
    public List<ProductDemo> returnProductsJewelryForOnePage(int pageNumber, int pageSize)
    {
        return this.productDemoDAO.returnProductsJewelryForOnePage(pageNumber, pageSize);
    }
    
    @Transactional
    public List<ProductDemo> returnProductsForSearchNameForOnePage(int pageNumber, int pageSize, String name)
    {
        return this.productDemoDAO.returnProductsForSearchNameForOnePage(pageNumber, pageSize, name);
    }
    
    

}
