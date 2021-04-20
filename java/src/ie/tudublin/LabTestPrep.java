package ie.tudublin;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import java.util.ArrayList;
public class LabTestPrep extends PApplet
{	
	
    ArrayList<Task> tasks = new ArrayList<Task>();
    private float leftBorder;
    private float rightBorder;

    int whichTask = -1;
    boolean isEnd = false;

	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table t = loadTable("tasks.csv", "header");
        for(TableRow r:t.rows())
        {
            Task task = new Task(r);
            tasks.add(task);
        }
	}

	public void printTasks()
	{
		for(Task t:tasks)
        {
            println(t);
        }
	}
	
	public void mousePressed()
	{
		for(int i=0;i<tasks.size() ; i++)
        {
            float y = map(i,0,tasks.size(),rightBorder + 100,height - rightBorder -50);
            float y1 = y-20;
            float y2 = y+20;
            float x1 = map(tasks.get(i).getStart(),1,30,leftBorder,width - rightBorder);
            float x2 = map(tasks.get(i).getEnd(),1,30,leftBorder,width-rightBorder);

            if(mouseX >= x1 && mouseX <= x1 + 20 && mouseY >= y1 && mouseY <=y2)
            {
                whichTask = i;
                isEnd = true;
                return;
            }

            if (mouseX <= x2 && mouseX >= x2 - 20 && mouseY >= y1 && mouseY <= y2)
            {
                whichTask = i;
                isEnd = true;
                return;
            }
        }
        whichTask = -1;
	}

	public void mouseDragged()
	{
		if (whichTask != -1)
		{
			int month = (int)map(mouseX, leftBorder, width - rightBorder, 1, 30);
			
			if (month >= 1 && month <= 30)
			{
				Task task = tasks.get(whichTask); 
				if (isEnd)
				{
					if (month - task.getStart() > 0)
					{
						task.setEnd(month);
					}
	    		}
				else
				{
					if (task.getEnd() - month > 0 )
					{
						task.setStart(month);
					}
				}
			}
		}
	}
	

	
	
	public void setup() 
	{
        loadTasks();
        printTasks();
        leftBorder = width * 0.2f;
        rightBorder = width * 0.05f;
        colorMode(HSB);
	}
	
	public void draw()
	{			
		background(0);
        displayTasks();
	}

    public void displayTasks()
    {
        stroke(255);
        fill(255);
        textAlign(CENTER,CENTER);

        for(int i = 1; i<=30;i++)
        {
            float x = map(i,1,30,leftBorder,width - rightBorder);
            line(x,30,x,height-40);
            text(i,x,20,x);
        }

        for(int i=0;i<tasks.size(); i++)
        {
            float y = map(i,0,tasks.size(),rightBorder + 100,height - rightBorder -50);
            Task t = tasks.get(i);
            float x1 = map(t.getStart(),1,30,leftBorder,width-rightBorder);
            float x2 = map(t.getEnd(),1,30,leftBorder,width-rightBorder);
            int c =  (int) map(i,0,tasks.size(),0,255);
            noStroke();
            fill(c,255,255);
            rect(x1 ,y-20,x2-x1,40);
            fill(255);
            textAlign(LEFT,CENTER);
            text(t.getTask(), 20, y);
        }
    }
}