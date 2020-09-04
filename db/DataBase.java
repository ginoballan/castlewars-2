package db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import castlewars.CW_SoldierDeck;

public class DataBase implements Serializable
{//####################//
private File 	rootPath;
private File 	logFile;
private File 	mainDeckFile;
private File 	playerFolderPath;
private File 	playerDeckFile;
private String  gameLog;	
private static final long serialVersionUID = 1L;
public DataBase ( ) 
	{
	
	}
public boolean  createFile (File f) 
	{// utility que crea archivo
	boolean output = true;
	BufferedWriter bw = null;
	try	
		{
		bw = new BufferedWriter(new FileWriter(f));
		bw.close();
		}
	catch (IOException e) { output = false; } 
	return output;
	}
public boolean  writeFile (File archivo, String texto) 
	{// utility que escribe string a archivo
	boolean output = true;
	try 
		{	
		BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
		bw.write(texto);
		bw.newLine();			
		bw.close();
		}
	catch (IOException e) 
		{
		output = false;
		System.out.println("io exception " + e);
		}
	catch (Exception ex) { output = false;}
	return output;
	}
public boolean  addListToFile (File archivo, ArrayList<String> lista) 
	{//agrega a un archivo pasandole las lineas en un arraylist
	boolean output = false;
	String auxS;
	BufferedWriter bw = null;
	try 
		{		
		bw = new BufferedWriter(new FileWriter(archivo));
		for(int i=0; i<lista.size();i++)
			{
			auxS = lista.get(i);
			bw.write(auxS);
			bw.newLine();
			output = true;
			}		
		bw.close();
		}
	catch (IOException e) {output = false;}
	return output;
	}	
public String 	duplicateBackSlash (String text)
	{ 
	//utility que duplica "\" para archivos
	text.replace("\\", "\\\\");
	return text;
	}
public int 		checkImportedSettingsFile (ArrayList<Integer> auxSettingsList, File importedFile)
	{//##################################################################################		
	// utility que importa configuracion
	int checkResult = 1;
	String splitWords[]= new String[5];
	ArrayList<String> fileLines = new ArrayList<String>();
	fileLines = openFile(importedFile);
	if (fileLines.get(0).equals("2")) 
		checkResult = 2;	
	if (fileLines.get(0).equals("3")) 
		checkResult = 3;
	if(checkResult == 1){
		ArrayList<String> textSettingsArrayList = new ArrayList<String>();
		textSettingsArrayList.add("Cantidad de jugadores");
		textSettingsArrayList.add("Cartas por jugador");	
		textSettingsArrayList.add("Atacar con soldados");
		textSettingsArrayList.add("Restaurar salud de castillo");
		textSettingsArrayList.add("Descartar cartas de oponente");
		textSettingsArrayList.add("Robar carta a oponente");
		textSettingsArrayList.add("Intercambiar carta con oponente");
		textSettingsArrayList.add("Levantar otra carta");
		textSettingsArrayList.add("Soldado");
		textSettingsArrayList.add("Matar soldado");
		textSettingsArrayList.add("Construir muro");
		textSettingsArrayList.add("Destruir muro");	
		Scanner fileScanner = null;
		try 
			{
		    int lineNum = 0;
			fileScanner = new Scanner(importedFile);
		    while (fileScanner.hasNextLine() && lineNum <12 && checkResult == 0) 
		    	{
		        String line = fileScanner.nextLine();
		        if(line.startsWith(textSettingsArrayList.get(lineNum)) == false) 
		  			checkResult = 4;
				splitWords = fileLines.get(lineNum).split(":");
				splitWords[1]=splitWords[1].replaceAll("\\s", "");				
		        try
		        	{
		        	Integer.parseInt(splitWords[1]);
		        	}
		        catch(Exception excPars)
		        	{
					checkResult = 6;
		        	}
		        lineNum++;
		    	}
			} 
		catch (FileNotFoundException e) 
			{
			e.printStackTrace();
			}			
		}		
		return checkResult; 
	}
public boolean 	exportCW_SoldierDeck (CW_SoldierDeck exportingCW_SoldierDeck) 
	{
	boolean result = false;
	return result;
	}
public boolean 	createLog (String chosenPath, ArrayList<Integer> settings, String playerName)
	{	
	boolean result;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
	String rootPathString = chosenPath + "\\Castle Wars " + format.format(new Date());
	File rootPathFile = new File(rootPathString);	
	if (rootPathFile.isDirectory()) 
		rootPathString = rootPathString +"(1)";
	rootPathFile = new File(rootPathString);
	result = new File(rootPathString + "\\" + playerName).mkdirs();
	int aux = 0;
	if (result == true) 
		{
		for(int i = 1; i<settings.get(0);i++) 
			{
			aux = i+1;
			new File(rootPathString + "\\Player " + aux).mkdirs();
			}
		}
	if (result) 
		{ 
		File logFile = new File(rootPathString + "\\log.txt");
		result = createFile(logFile);
		if(result) {
			result = writeFile(logFile, "New Castle Wars Game");
			result = writeFile(logFile, "Jugadores : " + settings.get(0));
			result = writeFile(logFile, "Jugador unido : " + playerName);
			if(result) 
				{
				this.rootPath = rootPathFile;
				this.logFile = logFile;
				}
			}
		}		
		return result;
	}
/*public boolean 	logStartupCheck (File auxLogFile) 
	{
	boolean checkResult = true;
	if(logFile.exists()==true) {    	
		logFile = auxLogFile;
		ArrayList<String> logString = openFile(logFile);
		int amountOfPlayers = 0; 
		if (logString.isEmpty()) 
			{
			checkResult = false;
			} 
		if (logString.get(0).equals("1")) 
			{
			currentMode.showInfo("Error al acceder al archivo (FileNotFoundException). El archivo no pudo ser encontado.");
			checkResult = false;
			}
		if (logString.get(0).equals("2")) 
			{
			currentMode.showInfo("Error al acceder al archivo (IOException). El archivo no existe o no pudo ser abierto.");
			checkResult = false;
			}
		if (logString.get(0).equals("3")) 
			{			
			currentMode.showInfo("Error al acceder al archivo (Exception)");
			checkResult = false;
			}	
		
		if(checkResult == true){	
			if (!logString.get(0).equals("New Castle Wars Game")) 
				{	
				checkResult = false;
				}	
			if(!logString.get(1).startsWith("Jugadores : ")) 
				{
				checkResult = false;
				}
			try{
				String auxPlayers[] = logString.get(1).split(" : ");
				try{
					amountOfPlayers = Integer.parseInt(auxPlayers[1]); 
					} catch(Exception excPars)
					{
					checkResult = false;		
					}
				}catch(ArrayIndexOutOfBoundsException  e){
				checkResult = false;
			}			
			if (amountOfPlayers < 1 && amountOfPlayers > 4) {
				checkResult = false;
			}			
		}
	} 
	else 
		{
		checkResult = false;
		currentMode.showInfo("Error al acceder al archivo (FileNotFoundException). El archivo no pudo ser encontado.");
		}
	return checkResult;
	}
*/public ArrayList<String> logPlayersCheck (File logFile) 
	{
		
	//	ArrayList<String> playersList = null;
	
	ArrayList<String> fileLines = new ArrayList<String>();
	ArrayList<String> playersList = new ArrayList<String>();
	fileLines = openFile(logFile);
	String auxPlayers[] = new String[10];
	int amountOfPlayers = 0;
	
	if (fileLines.get(0).equals("1")) {
		return playersList;
	}		
	if (fileLines.get(0).equals("2")) {
		return playersList;
	}
	if (fileLines.get(0).equals("3")) { 
		return playersList;
	}
			
	auxPlayers = fileLines.get(1).split(" : ");
	
	try{			
    	amountOfPlayers = Integer.parseInt(auxPlayers[1]); 
	}catch(Exception excPars){
		return playersList;		
	}
	
	for (int i = 0; i<amountOfPlayers; i++)
    	playersList.add("");
	
    int lineNum = 2;
    int joinedPlayers = 0;
    
	while(fileLines.size() > lineNum && lineNum < amountOfPlayers + 2) {
	//	System.out.println(fileLines.size()+ "fileLines.size() > lineNum" + lineNum +" && " + lineNum +"lineNum < (amountOfPlayers + 2)"  + (amountOfPlayers + 2));
		
        if(fileLines.get(lineNum).startsWith("Jugador unido : ") == true) { 

        	auxPlayers = fileLines.get(lineNum).split(" : ");
        	boolean playerExists = false;
     	    for (int i = 0; i<playersList.size(); i++) {
	        	String duplicateChecker = playersList.get(i);
	        	if (auxPlayers[1].equalsIgnoreCase(duplicateChecker)) 
        			playerExists = true;
        	}
        	if(playerExists == false) {
        		playersList.set(joinedPlayers, auxPlayers[1]);		
				joinedPlayers++;
        	}
        }
        lineNum++;
	} 
//		System.out.println(playersList);
	return playersList;
	}
//revisar
public ArrayList<String> openFile (File file)
	{ 
	//utility que abre archivo si existe
	//si no existe, pone 2. si tiene otro error, 3.
	String line = "";	
	BufferedReader buffRead  = null;
	ArrayList<String> fileContent = new ArrayList<String>();
	try
		{
		buffRead = new BufferedReader(new FileReader(file));	
		while ((line = buffRead.readLine()) != null) 
			fileContent.add(line);
		buffRead.close();
		}
	catch (FileNotFoundException e) 
		{
		fileContent.clear();
		System.out.println(e);
		fileContent.add("1");
		}
	catch (IOException e) {
		fileContent.clear();
		System.out.println(e);
		fileContent.add("2");
		}
	catch (Exception ex) 
		{
		fileContent.clear();
		System.out.println(ex);
		fileContent.add("3");
		}
	return fileContent;
	}
//########################################//
public File 	getLogFile () 
	{
	return logFile;
	}
public void 	setLogFile (File log) 
	{
	this.logFile = log;
	}
public File 	getRootPath () 
{
return rootPath;
}
public void 	setRootPath (File rootPath) 
{
this.rootPath = rootPath;
}
public File		getPlayerFolderPath () 
{
return playerFolderPath;
}
public void 	setPlayerFolderPath (File playerFolderPath) 
{
this.playerFolderPath = playerFolderPath;
}
public File 	getPlayerDeckFile () 
{
return playerDeckFile;
}
public void 	setPlayerDeckFile (File playerDeckFile) 
{
this.playerDeckFile = playerDeckFile;
}
public File 	getMainDeckFile	()
	{
	return mainDeckFile;
	}
public void 	setMainDeckFile	(File mainDeckFile) 
{
this.mainDeckFile = mainDeckFile;
}
@Override
public String 	toString () 
	{
	return "TextProcessor [rootPath=" + rootPath + "\nlogFile=" + logFile + "\nplayerFolderPath=" + playerFolderPath
			+ "\nplayerDeckFile=" + playerDeckFile + "\nmainDeckFile=" + mainDeckFile + "\ncurrentMode=]";
	}
}//#####################################//


/*
 * public boolean 	renamePlayerFolder (String playerName, int playerIndex)
{
File sourceFile = new File(rootPath+ "\\Player "+ playerIndex);
File destFile = new File(rootPath + "\\"+ playerName);
boolean result;
if (sourceFile.renameTo(destFile)) {
	result = true;
	playerFolderPath = destFile;
} else 
	result = false;
return result;
}
public boolean removePlayerFromLog (String playerName) 
{		
boolean logcheck = logStartupCheck(this.logFile);
boolean result = false;
ArrayList<String> logString = new ArrayList<String>();
if (logcheck == true){		
	logString = openFile(this.logFile);
	for(int i = 0; i<logString.size();i++) {
		if(logString.get(i).equalsIgnoreCase("Jugador unido : " + playerName)) {
			logString.remove(i);
			result = true;
}	}	}
if (result == true) {
	try {	
		BufferedWriter bw = new BufferedWriter(new FileWriter(this.logFile));
		bw.write("");
		addListToFile(this.logFile, logString);
	} catch (IOException e) {
		e.printStackTrace();
		currentMode.showInfo("Error al remover el jugador del juego");
		result = false;
	}
}
return result;
}	
*/
/*public void 	delFolderAndContents (File deletingFolder, String playerName) 
{		
File deletingFile = new File(deletingFolder +"\\" +playerName);
delFolderAndContents_Rec(deletingFile);
}
*/
/*private void 	delFolderAndContents_Rec (File deletingFolder) 
{   
File[] contents = deletingFolder.listFiles();
if (contents != null) {
for (File f : contents) {
    	delFolderAndContents_Rec(f);
    }
}
deletingFolder.delete();
}
*/
