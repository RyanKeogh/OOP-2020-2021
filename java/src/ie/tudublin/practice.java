package ie.tudublin;
import processing.core.PApplet;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;

public class practice extends PApplet {

    Minim minim; //connecting to the minim libraries
    AudioInput ai; //connectig to AI libraries
    AudioPlayer ap; //connecting to the ap libraries
    AudioBuffer ab; //the samples
  
    float[] lerpedBuffer;

    float halfHeight = height/2;

    int amount = 20;


    public void settings()
    {
        size(600,600, P3D);
    }

    public void setup()
    {
        minim = new Minim(this);
        ap = minim.loadFile("heroplanet.mp3", width);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);
        lerpedBuffer = new float[width];
        noFill();
    }

    public void draw()
    {
        background(0);
       // translate(width/2, halfHeight);
        for (int i = 0; i < ab.size(); i++) {

            float c = map(i, 0, ab.size(), 0, 255);
            stroke(c, 255, 255);
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 2f);
            //noFill();
            strokeWeight(3);
            ellipse(width/2,height/2, 150 + lerpedBuffer[i] *8 , 150 + lerpedBuffer[i]  * 10);
           // strokeWeight(5);
          //  line(width/5, height/2 - lerpedBuffer[i] * halfHeight , width-width/5, height/2 + lerpedBuffer[i] * halfHeight);
    }   
       /* for(int j = 0; j < 10; j++)
        {
            //strokeWeight(5);
            float xpos = random(0,width/5);
            float ypos = random(0,height);
           // strokeWeight(10);
          //  point(xpos,ypos);
            float x1pos = random(width-width/5,width);
            float y2pos = random(0,height);
            point(x1pos,y2pos);
            point(xpos,ypos);
        }
       // noLoop();
       */

    
}
}