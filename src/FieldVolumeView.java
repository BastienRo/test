

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultFormatter;

import java.awt.Color;
import java.awt.TextArea; 
import java.applet.*;
import java.awt.*;
public class FieldVolumeView implements ActionListener, Observer 
{
	private VolumeController controller = null;

	private VolumeModel model = null;
	private JFrame frame = null;
	private JPanel contentPane = null;
	private JFormattedTextField field = null;
	//private TextArea texte =null;
	private JComboBox  button0 = null;
	private JComboBox  button1 = null;
	//private JComboBox button2 = null;
	private JButton button3 = null;
	private NumberFormat format = null;
	private Object[] list1;
	private Object[] list0;
	
	
	

	
	public FieldVolumeView(VolumeModel model, VolumeController controller)
	{
		this(model, controller, 0);
	}
	public FieldVolumeView(VolumeModel model, VolumeController controller, int volume)
	{
		this.model = model;
		this.model.addObserver(this);
		this.controller = controller;
		buildFrame(volume);
	}
	
	
	private void buildFrame(int volume) 
	{
		
		frame = new JFrame();
		contentPane = new JPanel();
		/*format = NumberFormat.getNumberInstance();
		format.setParseIntegerOnly(true);
		format.setGroupingUsed(false);
		format.setMaximumFractionDigits(0);
		format.setMaximumIntegerDigits(3);
		field = new JFormattedTextField(format);
		field.setValue(volume);
		((DefaultFormatter)field.getFormatter()).setAllowsInvalid(false);
		contentPane.add(field);*/
		//button1 = new JButton("A partir d'une fonction usuelle");
		
		
		
		//texte = new TextArea("Rentrer L le nombre de valeur dans l'intervalle")  ;
		
		
		field = new JFormattedTextField(format);
		field.setValue(volume);
		
		frame.setContentPane(contentPane);
		frame.setTitle("Projet Math-Java");
		 
			
		
		
		
	
		
		
		 list1 = new Object []{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100"};                                                                                                    
		button0 = new JComboBox(list1);
		frame.add(button0);
		
		
	
		
		
		
		list0 = new Object []{"2" ,"4","8","16","32","64","128","256","512","1024","2048","4096","8192","16384","32768","65536"};         ;
		button1 = new JComboBox(list0);
		frame.add(button1);
		
		
		//Object[] list = new Object []{"sinus" ,"cosinus"};
		//button2=new JComboBox(list);
		//frame.add(button2);
		
		
		button3 = new JButton("Calculer la fonction");
		
		
		
		button0.addActionListener(this);
		
		button1.addActionListener(this);
		//button2.addActionListener(this);
		button3.addActionListener(this);
		
		
		
		//contentPane.add(texte);
		JLabel text1 = new JLabel("Rentrer le nombre de valeur: "); // cela sera égale à nombre de valeur à calculer par la FFT
		frame.add(text1);
		contentPane.add(button0);
		JLabel text3 = new JLabel("Rentrer la taille des fenetre: "); // cela sera égale à notre échantillonage
		 frame.add(text3);
		contentPane.add(button1);
		
		//contentPane.add(button2);
		contentPane.add(button3);
		
		
		
		
		
		frame.pack();
		frame.setSize(300, 200);
		frame.setLocation(0, 300);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    
	    
	    
	    
		
	}
	public void close() 
	{
		frame.dispose();
	}
	public void display() 
	{			
		frame.setVisible(true);
	}
	
	
		
		
		/**
		* @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) */
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
		
			
			this.controller.notifyVolumeChanged(Integer.parseInt(this.field.getValue().toString()));
			
			
			//this.controller.notifyGraph(Integer.parseInt(this.field))
			String cmd = e.getActionCommand();
	        if(cmd.equals("Calculer la fonction")){
	       
	        	int l = 0;
				int N= 0;
		    try {
		        l = Integer.parseInt(field.getText());
		        if (button1.getSelectedItem()=="2"){
		            N = 2;
		        }else if (button1.getSelectedItem()=="4"){
		            N = 4;
		        }else if (button1.getSelectedItem()=="8"){
		            N = 8;
		        }else if (button1.getSelectedItem()=="16"){
		            N = 16;
		        }else if (button1.getSelectedItem()=="32"){
		            N = 32;
		        }else if (button1.getSelectedItem()=="64"){
		            N = 64;
		        }else if (button1.getSelectedItem()=="128"){
		            N = 128;
		        }else if (button1.getSelectedItem()=="256"){
		            N = 256;
		        }else if (button1.getSelectedItem()=="512"){
		            N = 512;
		        }else if (button1.getSelectedItem()=="1024"){
		            N = 1024;
		        }else if (button1.getSelectedItem()=="2048"){
		            N = 2048;
		        }else if (button1.getSelectedItem()=="4096"){
		            N = 4096;
		        }else if (button1.getSelectedItem()=="8192"){
		            N = 8192;
		        }else if (button1.getSelectedItem()=="16384"){
		            N = 16384;
		        }else if (button1.getSelectedItem()=="32768"){
		            N = 32768;
		        }else if (button1.getSelectedItem()=="65536"){
		            N = 65536;
		        }else {
		            System.out.println("Erreur Scroll Bar");
		        }
                
		        System.out.println("la valeur de N est de :");
		        System.out.println(N);
		        

		        if (button0.getSelectedItem()=="1"){
		            l = 1;
		        }else if (button0.getSelectedItem()=="2"){
		            l = 2;
		        }else if (button0.getSelectedItem()=="3"){
		            l = 3;
		        }else if (button0.getSelectedItem()=="4"){
		            l = 4;
		        }else if (button0.getSelectedItem()=="5"){
		            l = 5;
		        }else if (button0.getSelectedItem()=="6"){
		            l = 6;
		        }else if (button0.getSelectedItem()=="7"){
		            l = 7;
		        }else if (button0.getSelectedItem()=="8"){
		            l = 8;
		        }else if (button0.getSelectedItem()=="9"){
		            l = 9;
		        }else if (button0.getSelectedItem()=="10"){
		            l = 10;
		        }else if (button0.getSelectedItem()=="11"){
		            l = 11;
		        }else if (button0.getSelectedItem()=="12"){
		            l = 12;
		        }else if (button0.getSelectedItem()=="13"){
		            l = 13;
		        }else if (button0.getSelectedItem()=="14"){
		            l = 14;
		        }else if (button0.getSelectedItem()=="15"){
		            l = 15;
		        }else if (button0.getSelectedItem()=="16"){
		            l = 16;
		        }else if (button0.getSelectedItem()=="17"){
		            l = 17;
		        }else if (button0.getSelectedItem()=="18"){
		            l = 18;
		        }else if (button0.getSelectedItem()=="19"){
		            l = 19;
		        }else if (button0.getSelectedItem()=="20"){
		            l = 20;
		        }else if (button0.getSelectedItem()=="21"){
		            l = 21;
		        }else if (button0.getSelectedItem()=="22"){
		            l = 22;
		        }else if (button0.getSelectedItem()=="23"){
		            l = 23;
		        }else if (button0.getSelectedItem()=="24"){
		            l = 24;
		        }else if (button0.getSelectedItem()=="25"){
		            l = 25;
		        }else if (button0.getSelectedItem()=="26"){
		            l = 26;
		        }else if (button0.getSelectedItem()=="27"){
		            l = 27;
		        }else if (button0.getSelectedItem()=="28"){
		            l = 28;
		        }else if (button0.getSelectedItem()=="29"){
		            l = 29;
		        }else if (button0.getSelectedItem()=="30"){
		            l = 30;
		        }else if (button0.getSelectedItem()=="31"){
		            l = 31;
		        }else if (button0.getSelectedItem()=="32"){
		            l = 32;
		        }else if (button0.getSelectedItem()=="33"){
		            l = 33;
		        }else if (button0.getSelectedItem()=="34"){
		            l = 34;
		        }else if (button0.getSelectedItem()=="35"){
		            l = 35;
		        }else if (button0.getSelectedItem()=="36"){
		            l = 36;
		        }else if (button0.getSelectedItem()=="37"){
		            l = 37;
		        }else if (button0.getSelectedItem()=="38"){
		            l = 38;
		        }else if (button0.getSelectedItem()=="39"){
		            l = 39;
		        }else if (button0.getSelectedItem()=="40"){
		            l = 40;
		        }else if (button0.getSelectedItem()=="41"){
		            l = 41;
		        }else if (button0.getSelectedItem()=="42"){
		            l = 42;
		        }else if (button0.getSelectedItem()=="43"){
		            l = 43;
		        }else if (button0.getSelectedItem()=="44"){
		            l = 44;
		        }else if (button0.getSelectedItem()=="45"){
		            l = 45;
		        }else if (button0.getSelectedItem()=="46"){
		            l = 46;
		        }else if (button0.getSelectedItem()=="47"){
		            l = 47;
		        }else if (button0.getSelectedItem()=="48"){
		            l = 48;
		        }else if (button0.getSelectedItem()=="49"){
		            l = 49;
		        }else if (button0.getSelectedItem()=="50"){
		            l = 50;
		        }else if (button0.getSelectedItem()=="51"){
		            l = 51;
		        }else if (button0.getSelectedItem()=="52"){
		            l = 52;
		        }else if (button0.getSelectedItem()=="53"){
		            l = 53;
		        }else if (button0.getSelectedItem()=="54"){
		            l = 54;
		        }else if (button0.getSelectedItem()=="55"){
		            l = 55;
		        }else if (button0.getSelectedItem()=="56"){
		            l = 56;
		        }else if (button0.getSelectedItem()=="57"){
		            l = 57;
		        }else if (button0.getSelectedItem()=="58"){
		            l = 58;
		        }else if (button0.getSelectedItem()=="59"){
		            l = 59;
		        }else if (button0.getSelectedItem()=="60"){
		            l = 60;
		        }else if (button0.getSelectedItem()=="61"){
		            l = 61;
		        }else if (button0.getSelectedItem()=="62"){
		            l = 62;
		        }else if (button0.getSelectedItem()=="63"){
		            l = 63;
		        }else if (button0.getSelectedItem()=="64"){
		            l = 64;
		        }else if (button0.getSelectedItem()=="65"){
		            l = 65;
		        }else if (button0.getSelectedItem()=="66"){
		            l = 66;
		        }else if (button0.getSelectedItem()=="67"){
		            l = 67;
		        }else if (button0.getSelectedItem()=="68"){
		            l = 68;
		        }else if (button0.getSelectedItem()=="69"){
		            l = 69;
		        }else if (button0.getSelectedItem()=="70"){
		            l = 70;
		        }else if (button0.getSelectedItem()=="71"){
		            l = 71;
		        }else if (button0.getSelectedItem()=="72"){
		            l = 72;
		        }else if (button0.getSelectedItem()=="73"){
		            l = 73;
		        }else if (button0.getSelectedItem()=="74"){
		            l = 74;
		        }else if (button0.getSelectedItem()=="75"){
		            l = 75;
		        }else if (button0.getSelectedItem()=="76"){
		            l = 76;
		        }else if (button0.getSelectedItem()=="77"){
		            l = 77;
		        }else if (button0.getSelectedItem()=="78"){
		            l = 78;
		        }else if (button0.getSelectedItem()=="79"){
		            l = 79;
		        }else if (button0.getSelectedItem()=="80"){
		            l = 80;
		        }else if (button0.getSelectedItem()=="81"){
		            l = 81;
		        }else if (button0.getSelectedItem()=="82"){
		            l = 82;
		        }else if (button0.getSelectedItem()=="83"){
		            l = 83;
		        }else if (button0.getSelectedItem()=="84"){
		            l = 84;
		        }else if (button0.getSelectedItem()=="85"){
		            l = 85;
		        }else if (button0.getSelectedItem()=="86"){
		            l = 86;
		        }else if (button0.getSelectedItem()=="87"){
		            l = 87;
		        }else if (button0.getSelectedItem()=="88"){
		            l = 88;
		        }else if (button0.getSelectedItem()=="89"){
		            l = 89;
		        }else if (button0.getSelectedItem()=="90"){
		            l = 90;
		        }else if (button0.getSelectedItem()=="91"){
		            l = 92;
		        }else if (button0.getSelectedItem()=="93"){
		            l = 93;
		        }else if (button0.getSelectedItem()=="94"){
		            l = 94;
		        }else if (button0.getSelectedItem()=="95"){
		            l = 95;
		        }else if (button0.getSelectedItem()=="96"){
		            l = 96;
		        }else if (button0.getSelectedItem()=="97"){
		            l = 97;
		        }else if (button0.getSelectedItem()=="98"){
		            l = 98;
		        }else if (button0.getSelectedItem()=="99"){
		            l = 99;
		        }else if (button0.getSelectedItem()=="100"){
		            l = 100;
		       
		        }else {
		            System.out.println("Erreur Scroll Bar");
		        }
		        System.out.println("la valeur de l est de :");
		        System.out.println(l);

		       ArrayList<ArrayList<Complex>> fftaj = new ArrayList<ArrayList<Complex>>();
		        
		       fftaj = lanceur.Create(l,N); //(nombrede val , puissance de 2)
		       XYLineChartExample FView = new XYLineChartExample(fftaj,N);
		       controller.initCourbe(FView);
		    

		    } catch(NumberFormatException nfe) {
		        System.out.println("Mauvaise entrée");
		        
		    }
		    
		    
	        }
		
			
		}
		
		
		
		/**
		* @see java.util.Observer#update(java.util.Observable, java.lang.Object) */
		@Override
		public void update(Observable o, Object arg) 
		{
			if (arg instanceof Integer)
				field.setValue((Integer)arg);
			
		System.out.println("[FieldVolumeView] : Vous avez choisi une valeur");
	}

		
	
}