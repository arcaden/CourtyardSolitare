import hsa.Console;
import java.awt.*;

public class SpadeClass extends SuitClass
{
    public SpadeClass ()
    {
    }


    public SpadeClass (int iNewHeight, int iNewCentreX, int iNewCentreY, Color cNewColor)
    {
	super.setHeight (iNewHeight);
	x = iNewCentreX;
	y = iNewCentreY;
	iColor = cNewColor;
    }


    public void draw (Graphics c)
    {
	int iPointsX[] = new int [5];
	int iPointsY[] = new int [5];

	iPointsX [0] = x - width / 2;
	iPointsY [0] = y;
	iPointsX [1] = x + width / 2;
	iPointsY [1] = y;
	iPointsX [2] = x;
	iPointsY [2] = y - height / 2;
	iPointsX [3] = x - width / 2;
	iPointsY [3] = y - height / 4;
	iPointsX [4] = x;
	iPointsY [4] = y - height / 4;

	int triPointsX[] = new int [3];
	int triPointsY[] = new int [3];

	triPointsX [0] = x;
	triPointsY [0] = y;
	triPointsX [1] = x - width / 8;
	triPointsY [1] = y + height / 2;
	triPointsX [2] = x + width / 8;
	triPointsY [2] = y + height / 2;

	c.setColor (iColor);
	c.fillArc (iPointsX [3], iPointsY [3], width / 2, height / 2, 180, 180);
	c.fillArc (iPointsX [4], iPointsY [4], width / 2, height / 2, 180, 180);
	c.fillPolygon (iPointsX, iPointsY, 3);
	c.fillPolygon (triPointsX, triPointsY, 3);
    }


    public void draw (Console c)
    {
	int iPointsX[] = new int [5];
	int iPointsY[] = new int [5];

	iPointsX [0] = x - width / 2;
	iPointsY [0] = y;
	iPointsX [1] = x + width / 2;
	iPointsY [1] = y;
	iPointsX [2] = x;
	iPointsY [2] = y - height / 2;
	iPointsX [3] = x - width / 2;
	iPointsY [3] = y - height / 4;
	iPointsX [4] = x;
	iPointsY [4] = y - height / 4;

	int triPointsX[] = new int [3];
	int triPointsY[] = new int [3];

	triPointsX [0] = x;
	triPointsY [0] = y;
	triPointsX [1] = x - width / 8;
	triPointsY [1] = y + height / 2;
	triPointsX [2] = x + width / 8;
	triPointsY [2] = y + height / 2;

	c.setColor (iColor);
	c.fillArc (iPointsX [3], iPointsY [3], width / 2, height / 2, 180, 180);
	c.fillArc (iPointsX [4], iPointsY [4], width / 2, height / 2, 180, 180);
	c.fillPolygon (iPointsX, iPointsY, 3);
	c.fillPolygon (triPointsX, triPointsY, 3);
    }
}
