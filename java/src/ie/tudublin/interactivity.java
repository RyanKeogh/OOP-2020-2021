package ie.tudublin;
import processing.core.PApplet;

public class interactivity extends PApplet {
    
    public void settings()
    {
        size(400,400);
    }

    public void draw()
    {
        frameRate(12);
        println(mouseX + " : " + mouseY);
    }
}
