package ie.tudublin;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import java.util.ArrayList;
public class LabTestStar extends PApplet {

    ArrayList<Star1> stars = new ArrayList<Star1>();

   private float border;
    int startStar = -1;
    int endStar = -1;


    public void settings()
    {
        size(600,600);
    }
    public void setup()
    {
       
        colorMode(RGB);
        loadStars();
        printStars();
       
       // background(0);
       border = width * 0.1f;
       
    }
     void drawGrid()
    {
        textAlign(CENTER,CENTER);
       
        for(int i = -5; i <= 5; i++)
        {
            float x = map(i,-5,5,border,width-border);
            float y = map(i,-5,5,border,height-border);
            stroke(0,0,255);
            line(x,border,x,height-border);
            line(border,y,width-border,y);
            fill(255);
            text(i,x,border/2);
            text(i,border/2,y);
        }
    }


    void drawStars()
    {
        for(Star1 s: stars)
        {
            s.render(this);
        }
    }

     void loadStars()
    {
        Table table = loadTable("HabHYG15ly.csv", "header");
        for(TableRow row:table.rows())
        {
            Star1 s = new Star1(row);
            stars.add(s);
        }
    }

    void printStars()
    {
        for(Star1 s: stars)
        {
            println(s);
        }
    }

    public void draw()
    {
        background(0);
        drawGrid();
        drawStars();
        if(startStar != -1 && endStar ==-1)
        {
            Star1 s = stars.get(startStar);
            stroke(255,255,0);
            float x = map(s.getX(),-5,5,border,width -border);
            float y = map(s.getY(), -5,5,border,height-border);
            line(x,y,mouseX,mouseY);
            
        }
        else if (startStar !=-1 && endStar !=-1)
        {
            Star1 s = stars.get(startStar);
            stroke(255,255,0);
            float x = map(s.getX(),-5,5,border,width -border);
            float y = map(s.getY(), -5,5,border,height-border);

            Star1 s1 = stars.get(endStar);
            float x2 = map(s1.getX(),-5,5,border,width -border);
            float y2 = map(s1.getY(), -5,5,border,height-border);


            line(x,y,x2,y2);
            float dist = dist(s.getX(),s.getY(),s.getZ(),s1.getX(),s1.getY(),s1.getZ());
            stroke(255);
            text("Distance between " + s.getDisplayName() + " and " +  s1.getDisplayName() + " is " + dist + " parsecs", width/4,height -( border/2));

        }
    }

    public void mouseDragged()
    {
      
    }

    public void mouseClicked()
    {
        for(int i=0; i<stars.size(); i++)
        {
            Star1 s = stars.get(i);
            float x = map(s.getX(),-5,5,border,width -border);
            float y = map(s.getY(), -5,5,border,height-border);

            if(dist(mouseX,mouseY,x,y)< s.getAbsMag() /2)
            {

                
                if (startStar == -1)
                {
                    startStar = i;
                    break;
                    
                }
                else if (endStar == -1)
                {
                    endStar =i;
                    break;
                    
                }
                else
                {
                    startStar = i;
                    endStar = -1;
                    
                }
            }

        }

    }



}
