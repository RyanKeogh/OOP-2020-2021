package ie.tudublin;

import processing.core.PApplet;

public class Player {

    float x, y;
    float dx, dy;
    float w = 50;
    float halfW = w / 2;
    YASC yasc;
    float rotation;

    int health = 10;
    int ammo = 10;

    public Player(YASC yasc, float x, float y)
    {
        this.yasc = yasc;
        this.x = x;
        this.y = y;
        rotation = 0;
    }

    void render()
    {
        yasc.pushMatrix();
        yasc.translate(x, y);
        yasc.rotate(rotation);
        // Write this!!
        yasc.line(- halfW, halfW, 0, - halfW);
        yasc.line(0, - halfW, halfW, halfW);
        yasc.line(halfW, halfW, 0, 0);
        yasc.line(0, 0, - halfW, halfW);
        yasc.popMatrix();
        yasc.textSize(14);
        yasc.text("Health: " + health, x + 50, y - 10);
        yasc.text("Ammo: " + ammo, x + 50, y + 10);
    }

    void shoot()
    {
        if(yasc.checkKey(' '))
        {
            
            float dist = 30;
            Bullet b = new Bullet(yasc,x + (dx * dist),y + (dy * dist),rotation);

            
            yasc.gameObjects.add(b);
        }
        
    }

    void update()
    {
        dx = PApplet.sin(rotation);
        dy =  - PApplet.cos(rotation);
        
        if (yasc.checkKey(PApplet.UP))
        {
            x += dx;
            y += dy;
        }
        if (yasc.checkKey(PApplet.DOWN))
        {
            x -= dx;
            y -= dy;
        }
        if (yasc.checkKey(PApplet.LEFT))
        {
            rotation -= 0.1f;
        }
        if (yasc.checkKey(PApplet.RIGHT))
        {
            rotation += 0.1f;
        }        
        shoot();
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

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }
}