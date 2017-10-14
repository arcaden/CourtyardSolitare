// The "Shape" class.
import java.awt.*;
import hsa.Console;

public abstract class ShapeClass
{
    protected int height = 100;
    protected int x = 100;
    protected int y = 100;
    protected int width = 100;
    protected Color iColor = Color.red;

    ShapeClass ()
    {

    }


    public void setHeight (int H)
    {
	if (H > 0)
	{
	    height = H;
	}
    }


    public void setWidth (int W)
    {
	if (W > 0)
	{
	    width = W;
	}
    }


    public void setX (int xIn)
    {
	x = xIn;
    }


    public void setY (int yIn)
    {
	y = yIn;
    }


    public void setCentre (int xIn, int yIn)
    {
	if (xIn > 0 && yIn > 0)
	{
	    x = xIn;
	    y = yIn;
	}
    }


    public void setColor (Color cIn)
    {
	iColor = cIn;
    }


    public int getY ()
    {
	return y;
    }


    public int getX ()
    {
	return x;
    }


    public int getHeight ()
    {
	return height;
    }


    public int getWidth ()
    {
	return width;
    }


    public Color getColor ()
    {
	return iColor;
    }


    public abstract void draw (Console c);

    public void erase (Console c)
    {
	Color OldColor = getColor ();
	setColor (Color.white);
	draw (c);
	setColor (OldColor);
    }


    public abstract void draw (Graphics c);

    public void erase (Graphics c)
    {
	Color OldColor = getColor ();
	setColor (Color.white);
	draw (c);
	setColor (OldColor);
    }


    public void delay (int iDelayTime)
    {
	long lFinalTime = System.currentTimeMillis () + iDelayTime;
	do
	{
	}
	while (lFinalTime >= System.currentTimeMillis ());
    }


    public boolean isPointInside (int X, int Y)
    {
	return (Math.abs (x - X) < width / 2 && Math.abs (y - Y) < height / 2);
    }
} // Shape class

