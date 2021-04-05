package ie.tudublin;

import processing.core.PApplet;

public class Line extends PApplet{

    public void settings()//runs once
    {
        size(400,400);
        
    } 
    public void setup()//runs once
    {
        stroke(255);
        
    }
    int border = 20;
    public void draw()//draw method runs constantly
    {
        
        line(200, 200, mouseX-border, mouseY-border);
        ellipse(width/2, height/2, 50,50);//always use this to center 
        line(30, 20, 350, 20);
        line(30,20,30,350);
        line(350,20,350,350);
        line(30,350,350,350);
    }
    public void mousePressed()
    {
        background(192,64,0);
    }
}
