// The DiamondClass Class
// Second in a series of demonstration programs for introducing Java

import hsa.Console;
import java.awt.*;

public class DiamondClass extends SuitClass
{
    public boolean drawFlag = false;
    public boolean isFilled = true;
    public DiamondClass ()
    {
	iColor = Color.red;
    }


    public DiamondClass (int iNewHeight, int iNewCentreX, int iNewCentreY, Color cNewColor)
    {
	super.setHeight (iNewHeight);
	x = iNewCentreX;
	y = iNewCentreY;
	iColor = cNewColor;
    }


    public void setIsFilled (boolean bIn)
    {
	isFilled = bIn;
    }


    public boolean getState ()
    {
	return isFilled;
    }


    public void draw (Console c)
    {
	// declare two arrays for X & Y coordinates of Diamond
	int iPointsX[] = new int [4];
	int iPointsY[] = new int [4];

	// calculate points on diamond & store in the arrays
	iPointsX [0] = x - width / 2;
	iPointsY [0] = y;
	iPointsX [1] = x;
	iPointsY [1] = y - height / 2;
	iPointsX [2] = x + width / 2;
	iPointsY [2] = y;
	iPointsX [3] = x;
	iPointsY [3] = y + height / 2;

	// draw the diamond using methods available from the Console object (c)
	c.setColor (iColor);
	if (filled)
	{
	    c.fillPolygon (iPointsX, iPointsY, 4);
	}
	else
	{
	    c.drawPolygon (iPointsX, iPointsY, 4);
	}
    }


    public void erase (Console c)
    {
	Color cOldColor = getColor ();
	setColor (Color.white);
	draw (c);
	setColor (cOldColor);
    }


    public void draw (Graphics g)
    {
	// declare two arrays for X & Y coordinates of Diamond
	int iPointsX[] = new int [4];
	int iPointsY[] = new int [4];

	// calculate points on diamond & store in the arrays
	iPointsX [0] = x - width / 2;
	iPointsY [0] = y;
	iPointsX [1] = x;
	iPointsY [1] = y - height / 2;
	iPointsX [2] = x + width / 2;
	iPointsY [2] = y;
	iPointsX [3] = x;
	iPointsY [3] = y + height / 2;

	// draw the diamond using methods available from the Console object (c)
	g.setColor (iColor);
	if (isFilled)
	{
	    g.fillPolygon (iPointsX, iPointsY, 4);
	}
	else
	{
	    g.drawPolygon (iPointsX, iPointsY, 4);
	}
	g.drawPolygon (iPointsX, iPointsY, 4);
    }


    public void erase (Graphics g)
    {
	Color cOldColor = getColor ();
	setColor (Color.white);
	draw (g);
	setColor (cOldColor);
    }


    /*
	public boolean isPointInside (int Xi, int Yi)
	{
	    if (Math.abs (x - Xi) < width / 2 && Math.abs (x - Yi) < height / 2)
	    {
		return true;
	    }
	    else
	    {
		return false;
	    }
	}
    */

}


