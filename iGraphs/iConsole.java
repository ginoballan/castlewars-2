package iGraphs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import game.Player;

public 
class iConsole 
implements iGraphs, Serializable
{//#####################################//
private String outString ="";
private static final long serialVersionUID = 1L;
private Player p;
public iConsole ( Player p ) 
	{
	this.p = p;
	}
@Override
public void render ( ) 
	{
	//definir
	}
public void showTurnPlayed() {}
//#############################//
//##########################//
@Override
public void showIntro ( ) 
	{for(int i = 0; i < 7; ++i)
	System.out.println("\n");
	System.out.println("\r" + 
		"    ______     ___           _______.___________. __       _______ \r\n" + 
		"   /      |   /   \\         /       |           ||  |     |   ____|\r\n" + 
		"  |  ,----'  /  ^  \\       |   (----`---|  |----`|  |     |  |__   \r\n" + 
		"  |  |      /  /_\\  \\       \\   \\       |  |     |  |     |   __|  \r\n" + 
		"  |  `----./  _____  \\  .----)   |      |  |     |  `----.|  |____ \r\n" + 
		"   \\______/__/     \\__\\ |_______/       |__|     |_______||_______|\r\n" + 
		"                                                                   \r\n" + 
		"        ____    __    ____  ___      .______          _______.     \r\n" + 
		"        \\   \\  /  \\  /   / /   \\     |   _  \\        /       |     \r\n" + 
		"         \\   \\/    \\/   / /  ^  \\    |  |_)  |      |   (----`     \r\n" + 
		"          \\            / /  /_\\  \\   |      /        \\   \\         \r\n" + 
		"           \\    /\\    / /  _____  \\  |  |\\  \\----.----)   |        \r\n" + 
		"            \\__/  \\__/ /__/     \\__\\ | _| `._____|_______/         \r\n" + 
		"                                                                   \r\n" + 
		"                                 o\r\n" + 
		"                                  _---|         _ _ _ _ _\r\n" + 
		"                               o   ---|     o   ]-I-I-I-[\r\n" + 
		"              _ _ _ _ _ _  _---|      | _---|    \\ ` ' /\r\n" + 
		"              ]-I-I-I-I-[   ---|      |  ---|    |.   |\r\n" + 
		"               \\ `   '_/       |     / \\    |    | /^\\|\r\n" + 
		"                [*]  __|       ^    / ^ \\   ^    | |*||\r\n" + 
		"                |__   ,|      / \\  /    `\\ / \\   | ===|\r\n" + 
		"             ___| ___ ,|__   /    /=_=_=_=\\   \\  |,  _|\r\n" + 
		"             I_I__I_I__I_I  (====(_________)___|_|____|____\r\n" + 
		"             \\-\\--|-|--/-/  |     I  [ ]__I I_I__|____I_I_|\r\n" + 
		"              |[]      '|   | []  |`__  . [  \\-\\--|-|--/-/\r\n" + 
		"              |.   | |' |___|_____I___|___I___|---------|\r\n" + 
		"             / \\| []   .|_|-|_|-|-|_|-|_|-|_|-| []   [] |\r\n" + 
		"            <===>  |   .|-=-=-=-=-=-=-=-=-=-=-|   |    / \\\r\n" + 
		"            ] []|`   [] ||.|.|.|.|.|.|.|.|.|.||-      <===>\r\n" + 
		"            ] []| ` |   |/////////\\\\\\\\\\\\\\\\\\\\.||__.  | |[] [\r\n" + 
		"            <===>     ' ||||| |   |   | ||||.||  []   <===>\r\n" + 
		"             \\T/  | |-- ||||| | O | O | ||||.|| . |'   \\T/\r\n" + 
		"              |      . _||||| |   |   | ||||.|| |     | |\r\n" + 
		"            ./|' v . | .|||||/____|____\\|||| /|. . | . ./\r\n" + 
		"............|//\\............/...........\\........../../\\\\\\..........");
	int aux = inputInt("Ingrese # opcion:\n1. Crear juego\n2. Unirse a juego\n3. Cargar juego\n",1,3);
	switch(aux) 
		{
		case 1:	
			gameSettings();
			break;
		case 2:
			joinGame();
			break;
		case 3:
			loadGame();
			break;
		}
	}
	@Override
public void gameSettings() 
	{
	
	}
@Override
public void loadGame ( ) 
	{
	System.out.println("loadGame");

	}
@Override
public void saveGame  ( ArrayList<String> settingsList ) 
	{
		
	
	}
/*	public void saveMenu(ArrayList<String> settingsList) 
	{

		String folderPathString;
		String filePathString;
		folderPathString = inputString("\nIngrese la dirección de la ruta del archivo:");	
		filePathString = inputString("\nIngrese el nombre del archivo (sin \".txt\")");
		folderPathString = currentTextProcessor.duplicateBackSlash(folderPathString);
		File exportPath = new File(folderPathString, "\\" + filePathString + ".txt");
		currentGame.exportConfiguration(settingsList, exportPath);
	}
	*/
/*  public void loadMenu(ArrayList<Integer> settingsList) 
	{
	String folderPathString;
	String filePathString;
	folderPathString = inputString("\nIngrese la dirección de la ruta del archivo:");	
	filePathString = inputString("\nIngrese el nombre del archivo (sin \".txt\")");
	folderPathString = currentTextProcessor.duplicateBackSlash(folderPathString);
	File importPath = new File(folderPathString, filePathString + ".txt");
	currentGame.importConfiguration(settingsList, importPath);
	}
	*/	
@Override
public void joinGame ( ) 
{		
	System.out.println("joinGame");

}
@Override
public void waitLobby ( ) 
{
	
	
}
@Override
public void playGame ( ) 
{
	
	
}
//########################\\
@Override
public void showDialog ( String infoString ) 
	{
		
		
	}
public void showInfo(String infoString) 
{
System.out.println(infoString);
System.out.println("\n\n\t  Presione ENTER para continuar\n\n");
Scanner inputScanner = new Scanner(System.in);	
//	try{
	inputScanner.nextLine();
//	}catch(Exception e) {
//		System.out.println("Ocurrió un error al leer los datos ingresados");
//		e.printStackTrace();
//	}finally {		
//		inputScanner.close();
//	}
}
//######################################//
public static int 	inputInt(String inputString, int min, int max)
{ //  			pasando un minimo y un maximo, devuelve int ingresado en ese rango
boolean isParseable = false;
boolean inRange = false;
boolean firstTry = true;
int outputInt = 0;
String choiceString;
Scanner inputScanner = new Scanner(System.in);	
while (isParseable == false || inRange == false) {
	if (firstTry == false) {
		System.out.println("El valor ingresado es inválido.");
	}
	System.out.println(inputString);
	choiceString = inputScanner.nextLine();
	try{
		outputInt = Integer.parseInt(choiceString);	
		isParseable = true;	
		if(outputInt <= max && outputInt >= min) {
			inRange = true;
		}else {
			inRange = false;
		}		
	} catch(Exception excPars){
		isParseable = false;
		//System.out.println("El elemento ingresado no es un número.");
	}
	firstTry = false;
}
//	inputScanner.close();
return outputInt;
}
public static String inputString(String inputString)
	{//  escanea un string, no puede ser vacío
	boolean firstTry = true;
	String outString = "";
	Scanner inScanner = new Scanner(System.in);
	while (outString.equals("")) 
		{
		if(firstTry == false)
			System.out.println("No se admiten valores vacíos. Intente nuevamente");
		firstTry = false;		
		System.out.println(inputString + "\n");
		outString = inScanner.nextLine();				
		}
//	inScanner.close();
	return outString;
	}
public static String  inputString(String inputString, ArrayList<String> admittedValues)
		{ // escanea un string y lo compara con los elementos 
		//de una lista de opciones, no puede ser vacío
		boolean firstTry = true;
		boolean admitted = false;
		String outString = "";
		Scanner inScanner = new Scanner(System.in);
		while (outString.equals("") || admitted == false) 
			{
			if(firstTry == false) 
				if(admitted == false)
					System.out.println("El valor ingresado no es admitido. Intente nuevamente");
				firstTry = false;	
				outString = inScanner.next();	
				if(admittedValues.contains(outString.toLowerCase()))
					admitted = true;
			}
	//	inScanner.close();
		return outString;
		}
//##################################//
@Override
public void showOptions() {
	// TODO Auto-generated method stub
	
}
}