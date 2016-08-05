package services;

import java.util.List;

import models.ProductDemo;

public interface ProductDemoService
{
    public Integer addProductDemo(ProductDemo p);
    public List<ProductDemo> listProductDemo();
    public void updateProductDemo(ProductDemo p);
    public void removeProductDemo(Integer id);
}
