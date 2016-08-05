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

}
