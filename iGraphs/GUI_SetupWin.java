package iGraphs;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import game.Player;
import iGraphs.GUI_Frame;

public 
class GUI_SetupWin 
extends GUI_Frame 
{//########//
private static final long serialVersionUID = 1L;
private final ArrayList<JPanel>  	rowsJPanelArrayList 	  = new ArrayList<JPanel>();
private final ArrayList<JLabel>  	infoJLabelArrayList 	  = new ArrayList<JLabel>();
private final ArrayList<JTextField> valuesJTextFieldArrayList = new ArrayList<JTextField>();
private final ArrayList<JButton> 	moreButtonsArrayList 	  = new ArrayList<JButton>();
private final ArrayList<JButton> 	lessButtonsArrayList 	  = new ArrayList<JButton>();
private final ArrayList<String> 	settingsInfo 			  = new ArrayList<String>();
private final LinkedHashMap <String,Integer> s;
private int position;
//#################//
public GUI_SetupWin
(iGUI gui) 
{
	super(gui);	
	System.out.println(GUI.getP().getcM());
	s = GUI.getP().getcM().getS();
	//Player p = gui.getP();
	//s = p.getcM().getS();
	
	for (Map.Entry<String, Integer> mapElement : s.entrySet()) 
		{ 
		String aux = mapElement.getKey();
	    settingsInfo.add(aux);
		}					
	settingsInfo.sort(null);
	
/*
    Component[] components = panel.getComponents();

    for (Component component : components) {
        if (component instanceof JPanel) {
            setPanelEnabled((JPanel) component, isEnabled);
        }
        component.setEnabled(isEnabled);
*/	
	//////////////////////////////////
	JPanel topJPanel = new JPanel();
	add(topJPanel, BorderLayout.NORTH);
	topJPanel.setLayout(new GridLayout(2,3));
	JButton classicSettingsJButton = new JButton("Clasico");
	JButton extendedSettingsJButton = new JButton("Extendido");
	JButton randomSettingsJButton = new JButton("Aleatorio");
	JButton importJButton = new JButton("<html><div style='text-align: center;'>" + "    Importar <br> configuraciones"+ "</html>");
	JButton exportJButton = new JButton("<html><div style='text-align: center;'>"+"Exportar <br> configuraciones"+"<html>");
	JButton endSetupButton = new JButton("<html><div style='text-align: center;'>"+"Finalizar <br> configuración"+"<html>");
	topJPanel.add(importJButton);
	topJPanel.add(exportJButton);
	topJPanel.add(endSetupButton);	
	topJPanel.add(classicSettingsJButton);
	topJPanel.add(extendedSettingsJButton);
	topJPanel.add(randomSettingsJButton);	
	int value = 0;
	//-----------------------------------------------------------------------------		   
	for (position = 0; position < settingsInfo.size(); position++)
		{
		String key = settingsInfo.get(position);
		value = s.get(key);
		rowsJPanelArrayList.add(new JPanel());					
		JLabel  auxInfo = new JLabel (key);	
		infoJLabelArrayList.add(auxInfo);
		valuesJTextFieldArrayList.add(new JTextField("  " +value +"  "));
		valuesJTextFieldArrayList.get(position).setEditable(false);
		moreButtonsArrayList.add(new JButton(" + "));
		lessButtonsArrayList.add(new JButton(" - "));		
		rowsJPanelArrayList.get(position).setLayout(new FlowLayout(FlowLayout.RIGHT));
		rowsJPanelArrayList.get(position).add(infoJLabelArrayList.get(position));
		rowsJPanelArrayList.get(position).add(valuesJTextFieldArrayList.get(position));
		rowsJPanelArrayList.get(position).add(moreButtonsArrayList.get(position));
		rowsJPanelArrayList.get(position).add(lessButtonsArrayList.get(position));	
		//botones +		
		moreButtonsArrayList.get(position).addActionListener(new ActionListener() 
			{
			@Override
			public void actionPerformed(ActionEvent arg0) 
				{
				JButton sender = (JButton)arg0.getSource();			        				        
				for (int j = 0; j <settingsInfo.size(); j++) 
					{
					if (sender.equals(moreButtonsArrayList.get(j))) 
						{
						s.put(settingsInfo.get(j), s.get(settingsInfo.get(j))+1);
						valuesJTextFieldArrayList.get(j).setText("  "+s.get(settingsInfo.get(j))+"  ");	
						}
					}
				}
			}	
		);
		//botones -
		lessButtonsArrayList.get(position).addActionListener(new ActionListener() 
			{
			@Override
			public void actionPerformed(ActionEvent arg0) 
				{
				JButton sender = (JButton)arg0.getSource();			        				        
				for (int y = 0; y <rowsJPanelArrayList.size(); y++) 
					{
					if (sender.equals(lessButtonsArrayList.get(y)))
						{
						s.put(settingsInfo.get(y),s.get(settingsInfo.get(y))-1);
						valuesJTextFieldArrayList.get(y).setText("  "+s.get(settingsInfo.get(y))+"  ");						
							}
						}
					}
				}
			);
		}
		JPanel midJPanel = new JPanel();
		add(midJPanel, BorderLayout.CENTER);
		midJPanel.setLayout(new GridLayout(settingsInfo.size(),1));
		for (position = 0; position <settingsInfo.size(); position++) 
			{
			midJPanel.add(rowsJPanelArrayList.get(position));
			}	
		endSetupButton.setBackground(Color.green);
		endSetupButton.setOpaque(true);
		endSetupButton.setBorderPainted(true); 
		endSetupButton.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent arg0) {	
					GUI.getP().getiNH().startServer();
				}
			});
		pack();
		}//################//
}