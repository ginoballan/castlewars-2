package iGraphs;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public abstract 
class GUI_Frame 
extends JFrame
{ 
	private static final long serialVersionUID = 1L;
	private GUI_Frame f;
	protected iGUI GUI; 
	public GUI_Frame(iGUI gui) 
		{
		f = this;
		this.GUI = gui;
		GUI.getfL().add(this);
		System.out.println(GUI.getfL());
		getContentPane().removeAll();
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(getPreferredSize());
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		/*
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent we) { 
		        String ObjButtons[] = {"Yes","No"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Online Examination System",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
//		            System.exit(0);	
		    		GUI.getfL().remove(f);
		    		System.out.println(GUI.getfL());
		    		f.dispose();
		    		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        }
		    }});*/
		}	
	public void render() 
		{
	  	f.repaint();	
		f.revalidate();
		}
}