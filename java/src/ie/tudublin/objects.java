package ie.tudublin;
import processing.core.PApplet;

public class objects extends PApplet {
 

    public void settings() {
        size(400,400);
   

      }

      public void draw() {
        background(255);

        for(int i = 0; i<11;i++)
        {
          float x = map(i, 0, 11, 20, 380);
          float y = map(i,0,11,20,380);

          line(x,20,x,380);
          line(20,y,380,y);

        }
    
      }
    
 
      

      

    }

