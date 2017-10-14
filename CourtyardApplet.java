// The "CourtyardApplet" class.
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CourtyardApplet extends Applet implements ActionListener, MouseListener, MouseMotionListener
{
    Graphics g;
    Button buttonRestart = new Button ("Restart");
    Button buttonQuit = new Button ("Quit");
    DeckClass fD[] = new DeckClass [8]; // Array to hold foundation decks
    DeckClass tD[] = new DeckClass [12]; //Array of tableau decks
    DeckClass stock = new DeckClass (2); //stock deck
    DeckClass waste = new DeckClass (); // waste deck
    int origin = 0; // A varible to hold where to return deck to
    DeckClass D = new DeckClass (); //Temporary deck for movement
    CardClass C = new CardClass (); //Temporary card for movement
    boolean okToMove = false; //Ok to move flag
    boolean fOk = false; // flag for foundation movement
    boolean deckMove = false; //flag for deck movement
    boolean winFlag = false;
    boolean loseFlag = false;
    Rectangle r = new Rectangle (0, 0, 1100, 700); //Bounding Box for text
    Font currentFont = super.getFont ();
    int style = Font.BOLD | Font.ITALIC; // text styles
    Font font = new Font ("Garamond", style, 250); // font class

    // The object we will use to write with instead of the standard screen graphics
    Graphics bufferGraphics;
    // The image that will contain everything that has been drawn on
    // bufferGraphics.
    Image offscreen;
    // To get the width and height of the applet.
    Dimension dim;
    int curX, curY;

    private void initFoundation ()  //Init foundation
    {

	int X = 305;
	int Y = 120;
	int i;
	for (i = 0 ; i < fD.length ; i++) // inits ever foundation deck setting location and fan state
	{
	    fD [i] = new DeckClass ();
	    (fD [i]).setFanState (0);
	    (fD [i]).draw (g);
	    (fD [i]).setCentre (X, Y);
	    X += 80;
	}

    }


    private void initTableau ()  // init tableau deck, setting location and fanstate
    {
	int X = 85;
	int Y = 240;
	int i;
	for (i = 0 ; i < tD.length ; i++)
	{
	    tD [i] = new DeckClass ();
	    (tD [i]).setFanState (2);
	    (tD [i]).draw (g);
	    (tD [i]).setCentre (X, Y);
	    X += 80;
	}
    }


    private void drawFoundation (Graphics g)  //draws every foundation
    {
	for (int i = 0 ; i < fD.length ; i++)
	{
	    fD [i].draw (g);
	}
    }


    private void drawTableau (Graphics g)  //draws every tableau
    {
	for (int i = 0 ; i < tD.length ; i++)
	{
	    tD [i].draw (g);
	}
    }


    private void initStock ()  //inits a 104 card deck, shuffles it, sets location
    {
	int Y = 600;
	int X = 85;
	stock.shuffle ();
	stock.setCentre (X, Y);
	stock.shuffle ();
    }


    private void initWaste ()  // inits a waste deck sets location
    {
	int Y = 600;
	int X = 200;
	waste.setFanState (1);
	waste.setCentre (X, Y);
    }


    private boolean checkWin ()  // checks for a win, if every deck has 8 cards, win, else return false
    {
	for (int i = 0 ; i < fD.length ; i++)
	{
	    if (tD [i].count () != 13)
	    {
		return false;
	    }
	}

	return true;
    }


    private boolean checkLose ()  //if stock empties, you lose
    {
	if (stock.empty ())
	{
	    return true;
	}
	else
	{
	    return false;
	}
    }


    private boolean checkFoundation (CardClass C, DeckClass D)  //Check for if card can be added to foundation
    {
	if (D.empty ())
	{
	    if (C.getValue () == 1) // if foundation is empty and card value is 1 pass
	    {
		return true;
	    }
	    else
	    {
		return false;
	    }
	}

	if (C.getSuit () == (D.botCard ()).getSuit () && (C.getValue () - (D.topCard ()).getValue () == 1))
	    //If card suit is the same as the deck, and the value of the card being entered is one higher, then add, else reject
	    {

		return true;
	    }
	else
	{
	}

	return false;
    }


    private boolean checkTableau (CardClass C, DeckClass D)  //Check for if card can be added to a Tableau pile
    {
	if (D.empty ()) //if Tableau is empty, accept any card
	{
	    return true;
	}

	else if (C.getSuit () == (D.botCard ()).getSuit () && (D.botCard ()).getValue () - C.getValue () == 1) //The current card has the same suit and the value is 1 lower than the bottom of the deck
	    //else if the suit is the same and the card value is 1 lower than the deck, add
	    {
		return true;
	    }
	else
	{
	    return false;
	}
    }


    private void fillTab ()
    {
	for (int i = 0 ; i < tD.length ; i++) //If any one of the tableau decks are eemprty
	{
	    if (tD [i].empty ())
	    {
		if (stock.empty ()) //if the stock is empty, gameOver
		{
		    //gameOver();
		}
		else //Autofill from the top of the stock deck
		{
		    C = stock.removeTop ();
		    stock.erase (g);
		    stock.draw (g);

		    tD [i].erase (g);
		    tD [i].addTop (C);
		    tD [i].draw (g);
		}
	    }

	}
    }


    private void fillWaste ()  //If the waste is empty, fill from the stock
    {
	if (waste.empty ())
	{
	    addWaste ();
	}
    }


    private void merge (DeckClass a, DeckClass b)  // Merges two decks togeather
    {
	for (int i = 0 ; b.count () > 0 ; i++)
	{
	    a.addBot (b.removeTop ()); //Removes the from the top of the second deck and adds to the top of the first deck
	}
    }



    private void mergef (DeckClass a, DeckClass b)  //Specific merge for the foundation
    {
	for (int i = 0 ; b.count () > 0 ; i++)
	{
	    a.addTop (b.removeTop ());
	}
    }


    private void mergeWaste ()
    {
	int i = 0;
	while (waste.count () > 0)
	{
	    i += 1;
	    C = waste.removeTop ();
	    stock.addTop (C);
	    repaint ();
	}

    }


    private void addWaste ()  //Adds a card to waste from the top of the stock
    {
	if (waste.count () <= 52) //Maximum hand size of 52 cards, or 1 deck
	{
	    C = stock.removeTop ();
	    waste.addBot (C);
	}
	repaint ();
    }


    private void addTableau (DeckClass D)  //Adds the card in movement to the tableau
    {
	C = waste.removeTop ();

	waste.draw (g);


	D.addTop (C);

	repaint ();

    }


    public void init ()  //Applet init
    {
	//First runs all the double buffering inits that need to be run
	dim = getSize ();
	g = getGraphics ();
	offscreen = createImage (dim.width, dim.height);
	bufferGraphics = offscreen.getGraphics ();
	//Sets  background color and and adds two buttosn
	setBackground (Color.gray);
	add (buttonRestart);
	add (buttonQuit);
	//Set the fanstate of the deck in movement
	D.setFanState (2);
	//Runs the init for all the decks and starts the game
	initTableau ();
	initFoundation ();
	initWaste ();
	initStock ();
	fillTab ();
	fillWaste ();
	//Listeners inits
	buttonRestart.addActionListener (this);  // this is the button
	buttonQuit.addActionListener (this);
	addMouseListener (this);
	addMouseMotionListener (this);
	repaint ();
    }


    public void mouseClicked (MouseEvent e)
    {
	if (stock.isPointInside (e.getX (), e.getY ()) == true)
	{
	    //if click registered is inside the stock, add a card to waste, if stock empty, gameover
	    if (stock.empty ())
	    {
		//gameOver();
	    }
	    else
	    {
		addWaste ();
	    }
	}

    }


    public void mouseEntered (MouseEvent e)
    {
    }


    public void mouseExited (MouseEvent e)
    {
    }


    public void mousePressed (MouseEvent e)
    {
	//If point pressed is inside the waste deck, then pick up the card
	if ((waste.botCard ()).isPointInside (e.getX (), e.getY ()) == true)
	{
	    C = waste.removeBot ();

	    if (C.getValue () == 1) //If its an ace, enable foundation movement
	    {
		fOk = true; //sets movement flag
		C.setCentre (e.getX (), e.getY ()); //sets center
		repaint ();


	    }
	    else if (C.getValue () != 1) //If its not an ace
	    {
		okToMove = true; //set regular movement to trye
		C.setCentre (e.getX (), e.getY ()); //sets center
		repaint ();

	    }
	}

	{ //Goes through ever deck and card and looks for the click
	    for (int j = 0 ; j < tD.length ; j++)
	    {
		for (int i = tD [j].count () - 1 ; i >= 0 ; i--)
		{
		    if ((tD [j].getCard (i)).isPointInside (e.getX (), e.getY ()))
		    {
			//If a press is found, move all the cards from the bottom the of the deck to the click to temp move deck
			for (int o = tD [j].count () - 1 ; o >= i ; o--)
			{
			    D.addTop (tD [j].removeBot ());
			    deckMove = true; //set deck movement flag
			    origin = j; //sets where the deck came from in case return
			    D.setCentre (e.getX (), e.getY ()); //sets center
			}
		    }

		}

	    }
	}


	repaint ();


    }


    public void mouseReleased (MouseEvent e)
    {


	//---------------------------------------------------------------------------------------------------------------------
	if (okToMove)
	{ //Booleans to check if either the tableau movement is true or foundation movement is true
	    boolean tabIn = false;
	    boolean foundIn = false;
	    int deck = 0;

	    for (int i = 0 ; i < tD.length ; i++)
	    {
		if (tD [i].isPointInside (e.getX (), e.getY ()) == true)
		{
		    if (checkTableau (C, tD [i]) == true)
		    {
			tabIn = true;
			deck = i;
			break;
		    }
		    else
		    {
			tabIn = false;
			break;
		    }
		}

		else if ((i == 11 && tD [i].isPointInside (e.getX (), e.getY ()) == false))
		{
		    tabIn = false;
		    break;
		}

		else if (i == 11 && checkTableau (C, tD [i]) == false)
		{
		    tabIn = false;
		    break;
		}
	    }

	    for (int i = 0 ; i < fD.length ; i++)
	    {
		if (fD [i].isPointInside (e.getX (), e.getY ()) == true)
		    if (checkFoundation (C, fD [i]) == true)
		    {

			foundIn = true;
			deck = i;
			break;
		    }
		    else
		    {
			foundIn = false;
			break;
		    }

		else if ((i == 7 && fD [i].isPointInside (e.getX (), e.getY ()) == false))
		{
		    foundIn = false;
		    break;
		}

		else if (i == 7 && checkFoundation (C, tD [i]) == false)
		{
		    foundIn = false;
		    break;
		}
	    }

	    if (tabIn)
	    {
		tD [deck].addBot (C);
	    }
	    else if (foundIn)
	    {
		fD [deck].addTop (C);
	    }
	    else
	    {
		waste.addBot (C);
	    }
	}

	//---------------------------------------------------------------------------------------------------------------------
	if (fOk)
	{
	    for (int i = 0 ; i < fD.length ; i++)
	    {
		if (fD [i].isPointInside (e.getX (), e.getY ()) == true)
		    if (checkFoundation (C, fD [i]) == true)
		    {
			fD [i].addBot (C);
			break;
		    }
		    else
		    {
			waste.addBot (C);
			break;
		    }

		else if ((i == 7 && fD [i].isPointInside (e.getX (), e.getY ()) == false))
		{
		    waste.addBot (C);
		    break;
		}

		else if (i == 7 && checkFoundation (C, tD [i]) == false)
		{
		    waste.addBot (C);
		    break;
		}
	    }

	}
	//---------------------------------------------------------------------------------------------------------------------
	if (deckMove)
	{
	    boolean tIn = false;
	    boolean fIn = false;
	    int deck = 0;

	    for (int i = 0 ; i < tD.length ; i++)
	    {
		if (tD [i].isPointInside (e.getX (), e.getY ()) == true)
		{
		    if (checkTableau (D.topCard (), tD [i]) == true)
		    {
			tIn = true;
			deck = i;
			break;
		    }
		    else
		    {
			tIn = false;
			break;
		    }
		}

		else if ((i == 11 && tD [i].isPointInside (e.getX (), e.getY ()) == false))
		{
		    tIn = false;
		    break;
		}

		else if (i == 11 && checkTableau (D.topCard (), tD [i]) == false)
		{
		    tIn = false;
		    break;
		}
	    }

	    for (int i = 0 ; i < fD.length ; i++)
	    {
		if (fD [i].isPointInside (e.getX (), e.getY ()) == true)
		    if (checkFoundation (D.topCard (), fD [i]) == true)
		    {
			fIn = true;
			deck = i;
			break;
		    }
		    else
		    {

			fIn = false;
			break;
		    }

		else if ((i == 7 && fD [i].isPointInside (e.getX (), e.getY ()) == false))
		{
		    fIn = false;
		    break;
		}

		else if (i == 7 && checkFoundation (D.topCard (), tD [i]) == false)
		{
		    fIn = false;
		    break;
		}
	    }

	    if (tIn)
	    {
		merge (tD [deck], D);
	    }
	    else if (fIn)
	    {
		mergef (fD [deck], D);
	    }
	    else
	    {
		merge (tD [origin], D);
	    }
	}
	//---------------------------------------------------------------------------------------------------------------------
	if (checkWin ())
	{

	    winFlag = true;
	    //drawCenteredString (bufferGraphics, "You Win", r, font);

	}
	if (checkLose ())
	{

	    loseFlag = true;


	}

	fillTab ();
	fillWaste ();
	okToMove = false;
	fOk = false;
	deckMove = false;
	repaint ();
    }


    public void actionPerformed (ActionEvent e)
    {
	Object objSource = e.getSource ();

	if (objSource == buttonRestart)
	{


	    mergeWaste ();

	    for (int i = 0 ; i < fD.length ; i++)
	    {
		mergef (stock, fD [i]);
	    }

	    for (int i = 0 ; i < tD.length ; i++)
	    {
		mergef (stock, tD [i]);
	    }

	    stock.shuffle ();
	    fillWaste ();
	    fillTab ();

	}
	else if (objSource == buttonQuit)
	{
	    System.exit (0);
	}

	winFlag = false;
	loseFlag = false;
	repaint ();
    }


    public void action (ActionEvent e)
    {

    }


    public void mouseDragged (MouseEvent e)
    {
	if (C.isPointInside (e.getX (), e.getY ()) == true && (okToMove || fOk))
	{
	    C.setCentre (e.getX (), e.getY ());
	}

	if (D.isPointInside (e.getX (), e.getY ()) == true && deckMove)
	{
	    D.setCentre (e.getX (), e.getY ());
	}


	repaint ();
    }


    public void mouseMoved (MouseEvent e)
    {
    }


    public void update (Graphics g)
    {
	paint (g);
    }


    public void paint (Graphics g)
    {
	bufferGraphics.setFont (currentFont);
	bufferGraphics.clearRect (0, 0, dim.width, dim.width);
	bufferGraphics.setColor (Color.gray);
	bufferGraphics.fillRect (0, 0, 2000, 2000);
	drawTableau (bufferGraphics);
	drawFoundation (bufferGraphics);
	waste.draw (bufferGraphics);
	stock.draw (bufferGraphics);


	if (okToMove || fOk)
	{
	    C.draw (bufferGraphics);
	}

	if (deckMove)
	{
	    D.draw (bufferGraphics);
	}

	g.drawImage (offscreen, 0, 0, this);

	if (winFlag)
	{
	    g.setFont (font);
	    g.drawString ("You Win!", 100, 500);
	}

	if (loseFlag)
	{
	    g.setFont (font);
	    g.drawString ("You Lose!", 100, 500);
	}

    }



    // Place the body of the drawing method here
    // paint method
} // CourtyardApplet class


