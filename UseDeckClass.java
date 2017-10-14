// The "UseDeckClass" class.
import java.awt.*;
import hsa.Console;

public class UseDeckClass
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();
	CardClass C = new CardClass ();

	DeckClass d1 = new DeckClass ();
	DeckClass d2 = new DeckClass ();
	DeckClass main = new DeckClass (1);

	d1.setCentre (100, 400);
	d1.flipDeckDown ();
	d2.setCentre (550, 400);
	main.setCentre (300, 200);

	main.shuffle ();

	//d1.draw (c);
	//d2.draw (c);
	main.draw (c);
	System.out.println (main.count ());
	//for (int i = 0 ; i < main.count() ; i++)
	//for (int i = 0 ; i < 52 ; i++)
	int y = main.count ();
	for (int i = 0 ; i < y ; i++)
	{
	    // Draw
	    d1.draw (c);
	    C = main.removeTop ();
	    //Move card to the new deck
	    C.slideTo (c, d1.getX (), d1.getY ());
	    d1.erase (c);
	    d1.addTop (C);
	    d1.draw (c);
	    main.draw (c);
	}



    }
} // UseDeckClass class
