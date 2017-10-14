// The "SuitClass" class.
import java.awt.*;
import hsa.Console;

public abstract class SuitClass extends MshapesClass
{
    protected boolean filled = true;

    public void setWidth (int W)
    {
	int H = (int) Math.round (0.8 / W);
	super.setWidth (W);
	super.setHeight (H);
    }


    public void setHeight (int H)
    {
	int W = (int) Math.round (0.8 * H);
	super.setWidth (W);
	super.setHeight (H);
    }


    public void setIsFilled (boolean newfilled)
    {
	filled = newfilled;
    }


    public boolean getIsFilled ()
    {
	return filled;
    }
} // SuitClass class
