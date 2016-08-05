package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import models.Figure;
import models.ProductDemo;
import services.FigureService;
import services.ProductDemoService;

@RestController
public class ManageController
{
    private FigureService figureService;
    private ProductDemoService productDemoService;
    
    @Autowired(required=true)
    @Qualifier(value="figureService")
    public void setFigureService(FigureService fs)
    {
        this.figureService = fs;
    }
    
    @Autowired(required=true)
    @Qualifier(value="productDemoService")
    public void setProductDemoService(ProductDemoService pds)
    {
        this.productDemoService = pds;
    }
    
    
    /*
     * return list product: watch and jewelry
     * URL    : localhost:8080/SpringMVCRestAPIDemo/products
     * Method : GET
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/products", method=RequestMethod.GET)
    public List<ProductDemo> listProductDemo()
    {
        return this.productDemoService.listProductDemo();
    }
    
    
    /*
     * add a new product: watch or jewelry
     * URL    : localhost:8080/SptirngMVCRestAPIDemo/product/add
     * Method : POST
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/add", method=RequestMethod.POST, headers="Accept=application/json")
    public String addProductDemo(@RequestBody ProductDemo pd)
    {
        Integer productDemoNewId = productDemoService.addProductDemo(pd);
        return "Added";
    }
    
    
    /*
     *update a current product: watch or jewelry
     * URL    : localhost:8080/SptirngMVCRestAPIDemo/product/update
     * Method : PUT
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/update", method=RequestMethod.PUT, headers="Accept=application/json")
    public void updateProductDemo(@RequestBody ProductDemo pd)
    {
        this.productDemoService.updateProductDemo(pd);
    } 
    
    
    
    /*
     * remove a product
     * URL    : localhost:8080/SpringMVCRestAPIDemo/product/remove/{id}
     * */
    @CrossOrigin(origins="http://localhost:9000")
    @RequestMapping(value="/product/remove/{id}", method=RequestMethod.DELETE)
    public void removeProductDemo(@PathVariable int id)
    {
        this.productDemoService.removeProductDemo(id);
    }
    
    
    
    /*
     * call addFigure
     * URL   : localhost:8080/SpringMVCRestAPIDemo/figure/add/
     * Method: POST
     * */
    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value="/figure/add", method=RequestMethod.POST, headers="Accept=application/json")
    public List<Figure> addFigure(@RequestBody Figure f)
    {
        Integer figureNewID = figureService.addFigure(f);
        return this.figureService.listFigure();
   //     System.out.println(f);
     //   return null;
    }
    
    
    /*
     * call listFigure
     * URL   : localhost:8080/SpringMVCRestAPIDemo/figures
     * Method: GET
     * */
    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/figures", method = RequestMethod.GET)
    public List<Figure> listFigure()
    {
        List<Figure> figureList = this.figureService.listFigure();
        return figureList;
    }
    
    
    /*
     * call updateFigure
     * URL   : localhost:8080/SpringMVCRestAPIDemo/figure/update
     * METHOD: PUT
     * */
    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value="/figure/update", method=RequestMethod.PUT)//, consumes="application/json")
    public List<Figure> updateFigure(@RequestBody Figure f)
    {
        figureService.updateFigure(f);
        return this.figureService.listFigure();
    }
  


    /*
     * call removeFigure
     * URL   : locahost:8080/SpringMVCRestAPIDemo/figure/remove/{id}
     * @param: id- Integer
     * */
    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value="/figure/remove/{id}", method=RequestMethod.DELETE)
    public List<Figure> removeFigure(@PathVariable Integer id)
    {
        figureService.removeFigure(id);
        return this.figureService.listFigure();
    }


    /*
     * call getFigureById
     * URL   : localhost:8080/SpringMVCRestAPIDemo/figure/
     * */
    @RequestMapping(value="figure/{id}", method=RequestMethod.GET)
    public Figure getFigureById(@PathVariable Integer id)
    {
        return figureService.getFigureById(id);
    }


}
