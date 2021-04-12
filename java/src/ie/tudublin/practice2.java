package ie.tudublin;
import processing.core.PApplet;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;

public class practice2 extends PApplet {

    Minim minim; //connecting to the minim libraries
    AudioInput ai; //connectig to AI libraries
    AudioPlayer ap; //connecting to the ap libraries
    AudioBuffer ab; //the samples
  
    float[] lerpedBuffer;

    float halfHeight = height/2;




    public void settings()
    {
        size(512,512);
    }

    public void setup()
    {
        minim = new Minim(this);
        ap = minim.loadFile("heroplanet.mp3", width);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);
       // lerpedBuffer = new float[width];
       // noFill();
    }

    public void draw()
    {
        background(0);
        stroke(255);
        for(int i =0; i< ab.size(); i++)
        {
            float c = map(i,0, ab.size(),0,255);
            stroke(c,255,255);
            line(i,height/2 - ab.get(i) * halfHeight * 2,i,height/2 + ab.get(i) * halfHeight * 2);
        }
    
    }
}



