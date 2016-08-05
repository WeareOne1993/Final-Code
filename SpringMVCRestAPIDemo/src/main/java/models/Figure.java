package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FIGURE")
public class Figure
{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;
    @Column(name="path")
    private String path;
    
    public Figure()
    {
        
    }
    
    public Figure( String name, double price, String path)
    {
        this.name = name;
        this.price = price;
        this.path = path;
    }
    
    public Figure(int id, String name, double price, String path)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public void setPath(String path)
    {
        this.path = path;
    }
    
    public String getPath()
    {
        return path;
    }
}
