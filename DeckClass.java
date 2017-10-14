// The "DeckClass" class.
import java.awt.*;
import hsa.Console;
import java.util.Vector;
public class DeckClass extends MshapesClass
{
    private Vector stdDeck; // = new Vector ();
    private int fanState = 0;

    public DeckClass ()
    {
	stdDeck = new Vector ();
    }


    public DeckClass (int select)
    {
	stdDeck = new Vector ();
	for (int o = 1 ; o < select + 1 ; o++)
	{
	    for (int j = 1 ; j < 5 ; j++)
	    {
		for (int i = 1 ; i < 14 ; i++)
		{
		    CardClass C = new CardClass ();
		    C.setValue (i);
		    C.setSuit (j);
		    stdDeck.add (0, C);
		}
	    }
	}
    }


    public boolean empty ()
    {
	if (stdDeck.isEmpty ())
	{
	    return true;
	}
	else
	{
	    return false;
	}
    }


    public void shuffle ()
    {
	if (stdDeck.isEmpty () == false)
	{
	    for (int i = 1 ; i < 102 ; i++)
	    {
		stdDeck.add (0, stdDeck.remove ((int) (Math.random () * 102 + 1)));
	    }

	}
    }


    public int count ()
    {
	stdDeck.trimToSize ();
	return stdDeck.size ();

    }


    public void flipDeckUp ()
    {
	for (int i = 0 ; i < stdDeck.size () ; i++)
	{
	    ((CardClass) stdDeck.elementAt (i)).setFace (true);
	}
    }


    public void flipDeckDown ()
    {
	for (int i = 0 ; i < stdDeck.size () ; i++)
	{
	    ((CardClass) stdDeck.elementAt (i)).setFace (false);
	}
    }


    public void match ()
    {
	for (int i = 0 ; i < stdDeck.size () ; i++)
	{
	    ((CardClass) stdDeck.elementAt (i)).setColor (iColor);
	    ((CardClass) stdDeck.elementAt (i)).setCentre (x, y);
	}
    }


    public void addTop (CardClass N)
    {
	//stdDeck.trimToSize ();
	stdDeck.add (0, N);
    }


    public void addBot (CardClass N)
    {
	//stdDeck.trimToSize ();
	stdDeck.addElement (N);
    }


    public CardClass removeTop ()
    {
	return (CardClass) stdDeck.remove (0);
    }


    public CardClass removeBot ()
    {
	return (CardClass) stdDeck.remove (stdDeck.size () - 1);
    }


    public CardClass remove (int sIn)
    {
	return (CardClass) stdDeck.remove (sIn);
    }


    public CardClass botCard ()
    {
	return (CardClass) stdDeck.elementAt ((stdDeck.size () - 1));

    }


    public CardClass topCard ()
    {
	return (CardClass) stdDeck.elementAt (0);

    }


    public CardClass getCard (int nIn)
    {
	if (nIn > stdDeck.size ())
	{
	    System.out.print ("Size of deck");
	    System.out.print (stdDeck.size ());
	    System.out.print ("Card number requested");
	    System.out.print (nIn);
	    return (CardClass) stdDeck.elementAt (stdDeck.size () - 1);

	}
	else
	{
	    return (CardClass) stdDeck.elementAt (nIn);
	}
    }


    public void add (CardClass N, int sIn)
    {
	stdDeck.add (sIn, N);
    }


    public void setFanState (int iS)
    {
	fanState = iS;
    }


    public void draw (Console c)
    {
	c.setColor (iColor);
	if (stdDeck.isEmpty ())
	{
	    c.fillRect (x - (int) Math.round (42), y - (int) Math.round (60), 84, 120);
	}
	else
	{
	    //((CardClass) stdDeck.firstElement ()).setColor (iColor);
	    match ();
	    ((CardClass) stdDeck.firstElement ()).draw (c);
	    //match ();
	}
    }


    public void draw (Graphics c)
    {
	//System.out.println("jkl");
	c.setColor (Color.white);
	if (stdDeck.isEmpty ())
	{
	    //c.fillRect (x - (width / 2), y - (height / 2), width, height);
	    c.fillRect (x - 35, y - 50, 70, 100);
	    c.setColor (Color.red);
	    c.fillRect (x - 30, y - 45, 60, 90);
	}
	else
	{
	    match ();
	    if (fanState == 0)
	    {
		((CardClass) stdDeck.firstElement ()).draw (c);
	    }
	    if (fanState == 1)
	    {
		int X = getX ();
		int Y = getY ();
		((CardClass) stdDeck.firstElement ()).draw (c);

		for (int i = 1 ; i < stdDeck.size () ; i++)
		{
		    X += 15;
		    ((CardClass) stdDeck.get (i)).setCentre (X, Y);
		    ((CardClass) stdDeck.get (i)).draw (c);
		}
	    }
	    if (fanState == 2)
	    {
		int X = getX ();
		int Y = getY ();
		((CardClass) stdDeck.firstElement ()).draw (c);

		for (int i = 1 ; i < stdDeck.size () ; i++)
		{
		    Y += 15;
		    ((CardClass) stdDeck.get (i)).setCentre (X, Y);
		    ((CardClass) stdDeck.get (i)).draw (c);
		}
	    }
	}
    }
} // DeckClass class


