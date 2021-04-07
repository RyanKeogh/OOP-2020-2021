package ie.tudublin;
import javax.lang.model.util.ElementScanner14;

import processing.core.PApplet;

public class interactivity extends PApplet {
    int frame = 0;
    public void settings()
    {
        size(400,400);
    }
    public void setup()
    {

        strokeWeight(4);
    }
    public void draw()
    {
       // frameRate(12);
        //println(mouseX + " : " + mouseY);
       
       /* background(130);
        ellipse(mouseX,mouseY , 33,33);
        ellipse(mouseX + 20,mouseY + 40, 33,33);
        ellipse(mouseX - 20,mouseY - 40, 33,33);
        */

        /*float x = mouseX;
        float y = mouseY;
        float ix = width - mouseX; // Inverse X
        float iy = height - mouseY; // Inverse Y
        background(126);
        fill(255, 150);
        ellipse(x, height/2, y, y);
        fill(0, 159);
        ellipse(ix, height/2, iy, iy);
    */
        /*background(204);
        line(mouseX,mouseY,pmouseX,pmouseY);
    */
      /*  background(204);
        if(mouseX < width/3)
        {
            rect(0,0,width/3,height);
        }
        else 
        {
            rect(width/3,0,width,height);
        }
        */
      /*background(204);
      if((keyPressed==true) && (key=='A'))
        {
            line(width/2,height/4,width/2,height-height/4);
        }
        else
        {
            ellipse(width/2,height/2,100,100);
        }
    */
    if (frame > 120) { // If 120 frames since the mouse
        noLoop(); // was pressed, stop the program
        background(0); // and turn the background black.
      } else { // Otherwise, set the background
        background(204); // to light gray and draw lines
        line(mouseX, 0, mouseX, 100); // at the mouse position
        line(0, mouseY, 100, mouseY);
        frame++;
      }

    }
    public void mousePressed()
    {
        loop();
        frame=0;
    }
}
