package ie.tudublin;


import processing.core.PApplet;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;

public class LineVis extends PApplet{

        
Minim minim; //connecting to the minim libraries
AudioInput ai; //connectig to AI libraries
AudioPlayer ap; //connecting to the ap libraries
AudioBuffer ab; //the samples
 float lerpedBuffer[];

public void settings()//runs once
{
    size(600,600, P3D);
    
} 
public void setup()//runs once
{
   // background(0);
    stroke(255);
    minim = new Minim(this);
    ap = minim.loadFile("heroplanet.mp3", width);
    ap.play();
    ab = ap.mix;
    colorMode(HSB);
    lerpedBuffer = new float[width];

    
}
float lerpedAverage = 0;
int border = 20;

public void draw()
{
    float average = 0;
    float sum = 0;
    background(0);

    for (int i = 0; i < ab.size(); i ++)
    {
        sum += abs(ab.get(i));
    }
    average = sum / ab.size();
    // Move lerpedAverage 10% closer to average every frame
    lerpedAverage = lerp(lerpedAverage, average, 0.1f);

    for(int i=0;i< ab.size(); i++)
    {
        float c = map(i,0,ab.size(),0,255);
        stroke(c,255,255);
        lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
    }

        float r = 1f;
        int numPoints = 2;
        float thetaInc = TWO_PI / (float) numPoints;
        strokeWeight(1);                
        float lastX = width / 4, lastY = height / 4;
        for(int i = 0 ; i < 100 ; i ++)
        {
            float c = map(i, 0, 300, 0, 255) % 255.0f;
            stroke(c, 255, 255, 100);
            float theta = i * (thetaInc + lerpedAverage * 5);
            float x = width / 2 + sin(theta) * r;
            float y = height / 2 - cos(theta) * r;
            r += 0.5f + lerpedAverage;
            line(lastX, lastY, x, y);
            //lastX = x;
            //lastY = y;
        }
        for(int i = 0 ; i < 100 ; i ++)
        {
            float c = map(i, 0, 300, 0, 255) % 255.0f;
            stroke(c, 255, 255, 100);
            float theta = i * (thetaInc + lerpedAverage * 5);
            float x = width / 4 + sin(theta) * r;
            float y = height / 4 - cos(theta) * r;
            r += 0.5f + lerpedAverage;
            line(lastX, lastY, x, y);
            //lastX = x;
            //lastY = y;
        }
            noFill();
        
}




    
}
