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
        fill(255);
        ellipse(width/2,height/2,140,60);
        ellipse(width/2+70,height/2-30,40,20);
        rect(width/2-35,height/2+25,15,30);
        rect(width/2+30,height/2+20,15,35);

        fill(0);
        noStroke();
        ellipse(width/2-20,height/2+20,25,18);//spot one
        ellipse(width/2-25,height/2+15,30,18);//spot one
        ellipse(width/2-45,height/2,25,18);//spot one




        ellipse(width/2-35,height/2-8,30,12);//spot two
        ellipse(width/2-20,height/2+10,20,12);

        ellipse(width/2+40,height/2,20,25);//spot three
        ellipse(width/2+30,height/2+13,30,20);//spot three

        
        ellipse(width/2+5,height/2-10,20,25);//spot three
        ellipse(width/2,height/2-13,30,20);//spot three


    
    }
}



