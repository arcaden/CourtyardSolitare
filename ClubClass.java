import hsa.Console;
import java.awt.*;

public class ClubClass extends SuitClass
{
    public ClubClass ()
    {
    }


    public ClubClass (int iNewHeight, int iNewCentreX, int iNewCentreY, Color cNewColor)
    {
	super.setHeight (iNewHeight);
	x = iNewCentreX;
	y = iNewCentreY;
	iColor = cNewColor;
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
	triPointsY [0] = y - height / 4;
	triPointsX [1] = x - width / 8;
	triPointsY [1] = y + height / 2;
	triPointsX [2] = x + width / 8;
	triPointsY [2] = y + height / 2;

	c.setColor (iColor);

	c.fillOval (iPointsX [3], iPointsY [3], width / 2, height / 2);
	c.fillOval (iPointsX [4], iPointsY [4], width / 2, height / 2);
	c.fillOval (x - width / 4, y - 4 * (height / 7), width / 2, height / 2);
	c.fillPolygon (triPointsX, triPointsY, 3);

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
	triPointsY [0] = y - height / 4;
	triPointsX [1] = x - width / 8;
	triPointsY [1] = y + height / 2;
	triPointsX [2] = x + width / 8;
	triPointsY [2] = y + height / 2;

	c.setColor (iColor);

	c.fillOval (iPointsX [3], iPointsY [3], width / 2, height / 2);
	c.fillOval (iPointsX [4], iPointsY [4], width / 2, height / 2);
	c.fillOval (x - width / 4, y - 4 * (height / 7), width / 2, height / 2);
	c.fillPolygon (triPointsX, triPointsY, 3);

    }
}
