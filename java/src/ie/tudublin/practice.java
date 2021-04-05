package ie.tudublin;
import processing.core.PApplet;

public class practice extends PApplet {

    public void settings()
    {
        size(500,500);
    }

    public void draw()
    {
        if (mousePressed)
        {
            fill(0);

        }
        else
        {
            fill(255);
        }
        ellipse(mouseX,mouseY, 180, 80);

    }
    
}
