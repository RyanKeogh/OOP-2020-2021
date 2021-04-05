package ie.tudublin;
import processing.core.PApplet;

public class objects extends PApplet {
   
    Car myCar1;
    Car myCar2;

    public void settings() {
        size(400,400);
        myCar1 = new Car(0,100,2);
        myCar2 = new Car(0,200,5);

      }

      public void draw() {
        background(255);
        myCar1.drive();
        myCar1.display();
        myCar2.drive();
        myCar2.display();
      }
    
    class Car{
        float xp;
        float yp;
        float speed;

        Car(float tx, float ty, float ts)
        {
            xp=tx;
            yp=ty;
            speed = ts;
        }
    
      
      public void drive() {
        xp = xp + speed;
        if (xp > width) {
          xp = 0;
        }
        if(mousePressed)
        {
            speed = 0;
        }
      }
      
      public void display() {
        stroke(0);
        rectMode(CENTER);
        rect(xp,yp,30,10);
      }

    }
}
