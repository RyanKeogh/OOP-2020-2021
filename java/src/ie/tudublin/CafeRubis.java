package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class CafeRubis extends PApplet  {

    ArrayList<Product> products = new ArrayList<Product>();
    ArrayList<Product> bill = new ArrayList<Product>();

    private float border;

    public void settings()
    {
        size(800,600);
    }

    public void setup()
    {
        loadData();
        printProducts();
       //displayProducts();
        border = height*0.1f;
        printBill();
    }

    void loadData()
    {
        Table t = loadTable("cafe.csv", "header");
        for(TableRow row:t.rows() )
        {
            Product p = new Product(row);
            products.add(p);
            

            //println(products);
        }
        
    }

    void printProducts()
    {
        for(Product p : products)
        {
            println(p);
        }
    }

    void displayProducts()
    {
        textAlign(CENTER,CENTER);
        fill(0);
        textSize(30);
        text("Cafe Rubis Till System", width/2,border+20);


        for(int i=0;i<products.size(); i++)
        {
            //Product p = products.get(i);
            float y =map(i,0,products.size(), border+70,height-border-20);
            Product p = products.get(i);
          //  float y1 = map(p.getName(),0,6,border+85,height-border-30);
            
            rectMode(CENTER);
            fill(255);
            rect(100, y, 150, 50);
            textAlign(LEFT,CENTER);
            textSize(10);
            fill(0);
            text(p.getName(),30,y);
            text(p.getPrice(), 130,y);

        }
        
    }

    public void mousePressed()
    {
        for(int i=0;i<products.size(); i++)
        {
            Product p = products.get(i);
            
            Product b = new Product();
            float y =map(i,0,products.size(), border+70,height-border-20);
            //float x = map(i,0,products.size(), border + 70,width-border-20);

            if(dist(mouseX,mouseY,50,y)< 50)
            {
               println(p.getName());
               
               bill.add(b);
               println(b);
               break;
               
            }

        }
    }

    void displayBill()
    {
        for(int i=0;i<0; i++)
        {
            //Product p = products.get(i);
            float y =map(i,0,products.size(),width-border-70,height-border-20);
            Product b = bill.get(i);

            textSize(10);
            fill(0);
            text(b.getName(),200,y);


        }
    }

    void printBill()
    {
        for (Product b: bill)
        {
            println(b);
        }
    }



    public void draw()
    {
        //background(190);
        //displayProducts();
        displayProducts();
        displayBill();

    }

    
}
