package ie.tudublin;
import processing.core.PApplet;


public class shapes extends PApplet {
    

     public void settings()//runs once
    {
        size(200,200);
        
    } 
    public void setup()
    {
       
        background(150);    // Setting the background to white
        stroke(0);          // Setting the outline (stroke) to black
        line(0,0,100,100);
        stroke(255);
        noFill();         // Setting the interior of a shape (fill) to grey 
        rect(25,25,50,50);
    }
 

  

   
}

    

