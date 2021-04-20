package ie.tudublin;

import static processing.core.PConstants.CENTER;
import static processing.core.PConstants.LEFT;

import processing.core.PApplet;
import processing.data.TableRow;

public class Star1{

    private boolean hab;
    private String displayName;
    private float distance;
    private float x,y,z;
    private float absMag;

    public Star1()
    {

    }

    @Override
    public String toString() {
        return "Star1 [absMag=" + absMag + ", displayName=" + displayName + ", distance=" + distance + ", hab=" + hab
                + ", x=" + x + ", y=" + y + ", z=" + z + "]";
    }



    public void render(PApplet pa)
    {
        float border = pa.width *0.1f;
        float x1 = PApplet.map(x,-5,5,border,pa.width-border);
        float y1 = PApplet.map(y,-5,5,border,pa.height-border);
        pa.stroke(255,255,0);
        pa.line(x1-3,y1,x1+3,y1);
        pa.line(x1,y1-3,x1,y1+3);
        pa.stroke(255,0,0);
        pa.noFill();
        pa.circle(x1, y1, absMag);
        pa.stroke(255);
        pa.textAlign(PApplet.LEFT,CENTER);
        pa.text(displayName, x1+20,y1);
    }


    public Star1(boolean hab,String displayName,float distance,float x, float y, float z, float absMag)
    {
        this.hab = hab;
        this.displayName=displayName;
        this.distance= distance;
        this.x=x;
        this.y=y;
        this.z=z;
        this.absMag=absMag;
    }



    public Star1(TableRow row)
    {
        this(
            row.getInt("Hab?") == 1 ? true:false,
            row.getString("Display Name"),
            row.getFloat("Distance"),
            row.getFloat("Xg"),
            row.getFloat("Yg"),
            row.getFloat("Zg"),
            row.getFloat("AbsMag")
     );

    }

    public boolean isHab() {
        return hab;
    }
    public void setHab(boolean hab) {
        this.hab = hab;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public float getDistance() {
        return distance;
    }
    public void setDistance(float distance) {
        this.distance = distance;
    }
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public float getZ() {
        return z;
    }
    public void setZ(float z) {
        this.z = z;
    }
    public float getAbsMag() {
        return absMag;
    }
    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }







}
