<<<<<<< HEAD
package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Star {
    private boolean hab;
    private string displayName;
    private float distance;
    private float xG,yG,zG;
    private float absMag;

    @Override
    public String toString() {
        return "Star [absMag=" + absMag + ", displayName=" + displayName + ", distance=" + distance + ", hab=" + hab
                + ", xG=" + xG + ", yG=" + yG + ", zG=" + zG + "]";
    }

    public Star()
    {

    }

    public void render(PApplet pa)
    {
        float border = pa.width *0.1f;
        float x = PApplet.map(xG, -5, 5, border, pa.width-border);
        float y = PApplet.map(yG, -5, 5, border, pa.width-border);
        pa.stroke(255,255,0);
        pa.line(x - 5,y,x+5,y);
        pa.line(x,y-5,x,y+5);
        pa.circle(x,y,absMag);
        pa.stroke(255,0,0);
        pa.noFill();
        pa.fill(255);
        pa.textAlign(PApplet.LEF, PApplet.CENTER);
        pa.text(displayName, x + 20, y);

    }

    public Star(TableRow row)
    {
        // constructor chaining
        this(
            row.getInt("Hab?") == 1 ? true : false,
            row.getString("Display Name"),
            row.getFloat("Distance"),
            row.getFloat("Xg"),
            row.getFloat("Yg"),
            row.getFloat("Zg"),
            row.getFloat("AbsMag")
        
            
            
            );
    }

    public Star(boolean hab, String displayName, float distance, float xG, float yG, float zG, float f)
    {
        this.hab = hab;
        this.displayName = displayName;
        this.distance = distance;
        this.xG = xG;
        this.yG = yG;
        this.zG = zG;
        this.absMag = absMag;
        }


    public boolean isHab() {
        return hab;
    }

    public void setHab(boolean hab) {
        this.hab = hab;
    }

    public string getDisplayName() {
        return displayName;
    }

    public void setDisplayName(string displayName) {
        this.displayName = displayName;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getxG() {
        return xG;
    }

    public void setxG(float xG) {
        this.xG = xG;
    }

    public float getyG() {
        return yG;
    }

    public void setyG(float yG) {
        this.yG = yG;
    }

    public float getzG() {
        return zG;
    }

    public void setzG(float zG) {
        this.zG = zG;
    }

    public float getAbsMag() {
        return absMag;
    }

    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }

	public Star() {
	}
    
}
