// The "CardClass" class.
import java.awt.*;
import hsa.Console;

public class CardClass extends MshapesClass
{
    protected String values = "A23456789TJQK";
    protected int value = 1;
    protected int suit = 1;
    protected boolean faceUp = true;

    public CardClass ()
    {
	super.setHeight (100);
	super.setWidth (70);
	super.setX (150);
	super.setY (150);
    }


    public CardClass (int i)
    {
	super.setHeight (80);
	super.setWidth (56);
	super.setX (150);
	super.setY (150);
    }


    public void setValue (int valueIn)
    {
	if (valueIn >= 1 && valueIn <= 13)
	{
	    value = valueIn;
	}
    }


    public void setSuit (int sIn)
    {
	if (sIn >= 1 && sIn <= 4)
	{
	    suit = sIn;
	}

    }


    public void gen ()
    {
	super.setX ((int) (Math.random () * 10) * 50 + 1);
	super.setY ((int) (Math.random () * 10) * 50 + 1);
	setValue ((int) (Math.random () * 13 + 1));
	setSuit ((int) (Math.random () * 4 + 1));
	super.setHeight ((int) (Math.random () * 100 + 1));
	super.setWidth ((int) (Math.round (height * 0.7 + 1)));
    }


    public void setFace (boolean fIn)
    {
	faceUp = fIn;

    }


    public void setSize (char size)
    {
	if (size == 'S')
	{
	    super.setHeight (60);
	}
	else if (size == 'M')
	{
	    super.setHeight (80);
	}
	else if (size == 'L')
	{
	    super.setHeight (100);
	}
	else if (size == 'X')
	{
	    super.setHeight (120);
	}
	super.setWidth ((int) Math.round (height * 0.7));
    }


    public int getValue ()
    {
	return value;
    }


    public int getSuit ()
    {
	return suit;
    }


    public void draw (Console c)
    {
	c.setColor (iColor);
	if (faceUp)
	{
	    String single = (values.charAt (value - 1) + " ");
	    c.drawRect (x - (width / 2), y - (height / 2), width, height);
	    c.drawString (single, x - (width / 2) + 5, y - (height / 2) + 12);
	    if (suit == 1)
	    {
		SpadeClass spade1 = new SpadeClass ((int) Math.round (height * 0.5), x, y, Color.black);
		c.setColor (Color.black);
		spade1.draw (c);
	    }
	    else if (suit == 2)
	    {

		HeartClass heart1 = new HeartClass ((int) Math.round (height * 0.5), x, y, Color.red);
		heart1.draw (c);
	    }
	    else if (suit == 3)
	    {
		c.setColor (Color.black);
		ClubClass club1 = new ClubClass ((int) Math.round (height * 0.5), x, y, Color.black);
		club1.draw (c);
	    }
	    else if (suit == 4)
	    {
		DiamondClass diamond1 = new DiamondClass ((int) Math.round (height * 0.5), x, y, Color.red);
		diamond1.draw (c);
	    }
	}
	else
	{
	    c.fillRect (x - (width / 2), y - (height / 2), width, height);
	}
    }


    public void draw (Graphics c)
    {
	c.setColor (Color.black);
	if (faceUp)
	{
	    String single = (values.charAt (value - 1) + " ");
	    c.setColor (Color.white);
	    c.fillRect (x - (width / 2), y - (height / 2), width, height);
	    c.setColor (Color.black);
	    c.drawRect (x - (width / 2), y - (height / 2), width, height);
	    c.drawString (single, x - (width / 2) + 5, y - (height / 2) + 12);
	    if (suit == 1)
	    {
		SpadeClass spade1 = new SpadeClass ((int) Math.round (height * 0.5), x, y, Color.black);
		spade1.draw (c);
	    }
	    else if (suit == 2)
	    {
		HeartClass heart1 = new HeartClass ((int) Math.round (height * 0.5), x, y, Color.red);
		heart1.draw (c);
	    }
	    else if (suit == 3)
	    {
		ClubClass club1 = new ClubClass ((int) Math.round (height * 0.5), x, y, Color.black);
		club1.draw (c);
	    }
	    else if (suit == 4)
	    {
		DiamondClass diamond1 = new DiamondClass ((int) Math.round (height * 0.5), x, y, Color.red);
		diamond1.draw (c);
	    }
	}
	else
	{
	    c.setColor (Color.white);
	    c.fillRect (x - (width / 2), y - (height / 2), width, height);
	    c.setColor (Color.red);
	    c.fillRect (x + 5, y + 5, width - 10, height - 10);
	}
    }
} // CardClass class
