package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;


import processing.core.PApplet;


public class Line extends PApplet{

    
Minim minim; //connecting to the minim libraries
AudioInput ai; //connectig to AI libraries
AudioPlayer ap; //connecting to the ap libraries
AudioBuffer ab; //the samples

    public void settings()//runs once
    {
        size(400,400);
        
    } 
    public void setup()//runs once
    {
        stroke(255);
        minim = new Minim(this);
        ap = minim.loadFile("heroplanet.mp3", width);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);
        
    }

    float lerpedAverage = 0;
    int border = 20;
    public void draw()//draw method runs constantly
    {
        float average = 0;
        float sum = 0;

        for (int i = 0; i < ab.size(); i ++)
        {
            sum += abs(ab.get(i));
        }
        average = sum / ab.size();
        // Move lerpedAverage 10% closer to average every frame
        lerpedAverage = lerp(lerpedAverage, average, 0.1f);


        background(0);
       // stroke(255);
        noFill();

        float c = map(average, 0, 1, 0, 255);
        stroke(c,255,255);






        ellipse(width/2,height/2,100 + (lerpedAverage * 500), 100 + (lerpedAverage * 500));
        ellipse(width/2 - 50,height/2,100 + (lerpedAverage * 500), 100 + (lerpedAverage * 500));
        ellipse(width/2 + 50,height/2,100 + (lerpedAverage * 500), 100 + (lerpedAverage * 500));
        ellipse(width/2,height/2 + 50,100 + (lerpedAverage * 500), 100 + (lerpedAverage * 500));
        ellipse(width/2,height/2 - 50,100 + (lerpedAverage * 500), 100 + (lerpedAverage * 500));


        ellipse(width/4,height/4,50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
        ellipse(width/4 -25,height/4,50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
        ellipse(width/4 + 25,height/4,50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
        ellipse(width/4,height/4 + 25,50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
        ellipse(width/4,height/4 - 25,50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));

        ellipse(width-width/4,height/4,50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
        ellipse(width- width/4 -25,height/4,50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
        ellipse(width - width/4 + 25,height/4,50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
        ellipse(width- width/4,height/4 + 25,50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
        ellipse(width - width/4,height/4 - 25,50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));

        ellipse(width-width/4, height -height/4,50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
        ellipse(width- width/4 -25,height - height/4,50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
        ellipse(width - width/4 + 25, height - height/4,50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
        ellipse(width- width/4, height - height/4 + 25,50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
        ellipse(width - width/4, height - height/4 - 25,50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));

        
        ellipse(width/4, height -height/4,50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
        ellipse( width/4 -25,height - height/4,50 + (lerpedAverage * 1000), 50 + (lerpedAverage * 1000));
        ellipse( width/4 + 25, height - height/4,50 + (lerpedAverage * 1000), 50 + (lerpedAverage * 1000));
        ellipse( width/4, height - height/4 + 25,50 + (lerpedAverage * 1000), 50 + (lerpedAverage * 1000));
        ellipse( width/4, height - height/4 - 25,50 + (lerpedAverage * 1000), 50 + (lerpedAverage * 1000));

    }


    public void mousePressed()
    {
        background(192,64,0);
    }
}
