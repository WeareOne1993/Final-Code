package dao;

import java.util.List;

import models.ProductDemo;

public interface ProductDemoDAO 
{
    public Integer addProductDemo(ProductDemo p);
    public void updateProductDemo(ProductDemo p);
    public List<ProductDemo> listProductDemo();
    public void removeProductDemo(Integer id);
    public List<ProductDemo> returnProductForOnePage(int pageNumber, int pageSize);
}
