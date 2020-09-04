package iGraphs;

import java.io.Serializable;
import java.util.ArrayList;

import game.Match;
import game.Player;

public 
class iGUI 
implements iGraphs, Serializable
{//#####################################//
/* this.setPreferredSize(new Dimension(750, 75)); */
private static final long serialVersionUID = 1L;
private Player 	p;
private Match 	m;	
ArrayList<GUI_Frame> fL = new ArrayList<GUI_Frame>();
private GUI_Frame introW;
private GUI_Frame gameW;
private GUI_Frame joinW;
private GUI_Frame lobbyW;
private GUI_Frame loadW;
private GUI_Frame saveW;
private GUI_Frame optionsW;
private GUI_Frame gameSettingsW;

public iGUI(Player p) 
	{
	this.p = p;
	this.m = p.getcM();
	}@Override
public void render ( ) 
	{
	for(GUI_Frame wC : fL) 
		wC.render();
	}

//crear atributos de TextArea EN GAME Y LOBBY

@Override
public void showIntro ( ) 
	{
	introW = new GUI_IntroWin(this);
	}	
@Override
public void joinGame ( ) 
	{
	joinW = new GUI_JoinWin(this);
	}
@Override
public void gameSettings ( ) 
	{
	gameSettingsW = new GUI_SetupWin(this);
	}
@Override
public void showOptions ( ) 
	{
	optionsW = new GUI_OptionsWin(this);
	}
@Override
public void waitLobby ( ) 
	{
	lobbyW = new GUI_LobbyWin(this);

	/*	getFrame();
	//frame.getContentPane().removeAll();
	//frame.add(waitLobby(), BorderLayout.CENTER);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setVisible(true);
	frame.pack();
	frame.setLocationRelativeTo(null);
	*/
	
	}
@Override
public void playGame ( )
	{
	gameW = new GUI_CW_Win(this);
	}

@Override
public void showDialog ( String infoString ) 
	{
		
	}
@Override
public void saveGame ( ArrayList<String> settingsList ) 
	{
	saveW = new GUI_SaveWin(this);
	}
@Override
public void loadGame  ( )
	{
	loadW = new GUI_LoadWin(this);
	}
public void showTurnPlayed() {}

//#############################\\
public Player getP() {
	return p;
}
public Match getM() {
	return m;
}

public GUI_Frame getIntroW() {
	return introW;
}
public GUI_Frame getGameW() {
	return gameW;
}
public GUI_Frame getJoinW() {
	return joinW;
}
public GUI_Frame getLobbyW() {
	return lobbyW;
}
public GUI_Frame getLoadW() {
	return loadW;
}
public GUI_Frame getSaveW() {
	return saveW;
}
public GUI_Frame getOptionsW() {
	return optionsW;
}
public GUI_Frame getGameSettingsW() {
	return gameSettingsW;
}
public ArrayList<GUI_Frame> getfL() {
	return fL;
}
public void setP(Player p) {
	this.p = p;
}
public void setM(Match m) {
	this.m = m;
}
public void setfL(ArrayList<GUI_Frame> fL) {
	this.fL = fL;
}
public void setIntroW(GUI_Frame introW) {
	this.introW = introW;
}
public void setGameW(GUI_Frame gameW) {
	this.gameW = gameW;
}
public void setJoinW(GUI_Frame joinW) {
	this.joinW = joinW;
}
public void setLobbyW(GUI_Frame lobbyW) {
	this.lobbyW = lobbyW;
}
public void setLoadW(GUI_Frame loadW) {
	this.loadW = loadW;
}
public void setSaveW(GUI_Frame saveW) {
	this.saveW = saveW;
}
public void setOptionsW(GUI_Frame optionsW) {
	this.optionsW = optionsW;
}
public void setGameSettingsW(GUI_Frame gameSettingsW) {
	this.gameSettingsW = gameSettingsW;
}
}//##################################//
	
	/*	jdialog input

 * does not return an integer is showInputDialog,
 * which returns an Object instead.This Object is
 * generally a String reflecting the user's choice.
 * Here is an example of using showInputDialog to
 * create a dialog that lets the user choose
 * one of three strings:

An input dialog with a combo box
Object[] possibilities = {"ham", "spam", "yam"};
String s = (String)JOptionPane.showInputDialog(
                    frame,
                    "Complete the sentence:\n"
                    + "\"Green eggs and...\"",
                    "Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE,
                    icon,
                    possibilities,
                    "ham");

//If a string was returned, say so.
if ((s != null) && (s.length() > 0)) {
    setLabel("Green eggs and... " + s + "!");
    return;
} 

//If you're here, the return value was null/empty.
setLabel("Come on, finish the sentence!");
If you do not care to limit the user's choices,
you can either use a form of the showInputDialog
method that takes fewer arguments or specify null
for the array of objects. In the Java look and feel,
substituting null for possibilities results in a
dialog that has a text field and looks like this:

An input dialog with a text field
Because the user can type anything into the text field,
you might want to check the returned value and ask the
user to try again if it is invalid. Another approach is
to create a custom dialog that validates the user-entered
data before it returns. See CustomDialog.java
for an example of validating data.

If you're designing a custom dialog, you need to design
your dialog's API so that you can query the dialog about
what the user chose. For example, CustomDialog has a
get
ValidatedText method that returns the text the user entered.


*///	jdialog cierre
/*
final JOptionPane optionPane = new JOptionPane( 
                "The only way to close this dialog is by\n"
                + "pressing one of the following buttons.\n"
                + "Do you understand?",
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION);
/*///dialog
/*
final JDialog dialog = new JDialog(frame, 
                             "Click a button",
                             true);
dialog.setContentPane(optionPane);
dialog.setDefaultCloseOperation(
    JDialog.DO_NOTHING_ON_CLOSE);
dialog.addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent we) {
        setLabel("Thwarted user attempt to close window.");
    }
});

/*///frame
/*
optionPane.addPropertyChangeListener(
    new PropertyChangeListener() {
        public void propertyChange(PropertyChangeEvent e) {
            String prop = e.getPropertyName();

            if (dialog.isVisible() 
             && (e.getSource() == optionPane)
             && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
                //If you were going to check something
                //before closing the window, you'd do
                //it here.
                dialog.setVisible(false);
            }
        }
    });
dialog.pack();
dialog.setVisible(true);

/*///que hacer con el resultado
/*

int value = ((Integer)optionPane.getValue()).intValue();
if (value == JOptionPane.YES_OPTION) {
    setLabel("Good.");
} else if (value == JOptionPane.NO_OPTION) {
    setLabel("Try using the window decorations "
             + "to close the non-auto-closing dialog. "
             + "You can't!");
} 

/*///frame look n feel
/*

//Ask for window decorations provided by the look and feel.
JFrame.setDefaultLookAndFeelDecorated(true);

//Create the frame.
JFrame frame = new JFrame("A window");

//Set the frame icon to an image loaded from a file.
frame.setIconImage(new ImageIcon(imgURL).getImage());
*/
	