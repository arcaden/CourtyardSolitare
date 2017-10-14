// The "MshapesClass" class.
import java.awt.*;
import hsa.Console;

public abstract class MshapesClass extends ShapeClass
{
    private int step = 25;
    private int delay = 50;


    public void setStep (int sIn)
    {
	if (sIn > 0)
	{
	    step = sIn;
	}
    }


    public void setDelay (int dIn)
    {
	if (dIn > 0)
	{
	    delay = dIn;
	}
    }


    public void slideTo (Graphics c, int dx, int dy)
    {
	int X = getX ();
	int Y = getY ();
	erase (c);
	while (X != dx || Y != dy)
	{
	    if (Math.abs (dx - X) < step)
	    {
		//X = dx;
		setX (dx);
	    }
	    else if (dx - X > 0)
	    {
		X += step;
		setX (X);
	    }
	    else if (dx - X < 0)
	    {
		X -= step;
		setX (X);
	    }

	    if (Math.abs (dy - Y) < step)
	    {
		setY (dy);
	    }
	    else if (dy - Y > 0)
	    {
		Y += step;
		setY (Y);
	    }
	    else if (dy - Y < 0)
	    {
		Y -= step;
		setY (Y);
	    }
	    draw (c);
	    super.delay (delay);
	    erase (c);
	}
	draw (c);
    }


    public void slideTo (Console c, int dx, int dy)
    {
	int X = getX ();
	int Y = getY ();
	erase (c);
	while (X != dx || Y != dy)
	{
	    if (Math.abs (dx - X) < step)
	    {
		//X = dx;
		setX (dx);
	    }
	    else if (dx - X > 0)
	    {
		X += step;
		setX (X);
	    }
	    else if (dx - X < 0)
	    {
		X -= step;
		setX (X);
	    }

	    if (Math.abs (dy - Y) < step)
	    {
		setY (dy);
	    }
	    else if (dy - Y > 0)
	    {
		Y += step;
		setY (Y);
	    }
	    else if (dy - Y < 0)
	    {
		Y -= step;
		setY (Y);
	    }
	    draw (c);
	    super.delay (delay);
	    erase (c);
	}
	draw (c);
    }
}
// MshapesClass class


