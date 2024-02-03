import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.text.NumberFormat;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class SEquation extends JFrame {
	//label du system
	JLabel l1 = new JLabel();
	private JPanel container = new JPanel();
	String[] tab_string = {"1", "2", "3", "4", "5", "6", "7","8", "9", "0", ".","-"};
	Boutton[] tab_button = new Boutton[tab_string.length];
	private Boutton1 ok = new Boutton1("OK");
	//Bouttons dynamique lors de la methode initcoef
	private Boutton a ;
	private Boutton b ;
	private JButton c ;
	//bouttons annuler et set
	private Boutton1 set = new Boutton1("SET");
	private Boutton1 reset = new Boutton1("ANNULER");
	private JTextField jtf = new JTextField ();
	private Panneau ecran = new Panneau();
	private Panneau setpan = new Panneau();
	private JPanel pan = new JPanel();
	private Panneau2 staticscreen = new  Panneau2();
	private Panneau2 dmcscreen = new  Panneau2();
	private Dimension dim = new Dimension(50, 68);
	private Dimension dim1 = new Dimension(80, 30);
	//messsage d'errreur;
	JOptionPane jop1;
	//booleen de verification
	private boolean numberadd = false,next=false,coefval=false,menbercoef=false,epsival=false,nverf=false,resetstatus=true,clickset=false,setcoef=false;
	private String number = new String("");
	private int n=0,i,j;
	private double A[][],B[];
	JPanel center = new JPanel();
	//processus
	private Thread t;
	private Thread t1;
	private Thread t2;
	SEquation()
	{
		this.setTitle("Resolution systèmes equations");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Definition du layout manageur de pan(chiffre)
		container.setLayout(new BorderLayout());
		GridLayout gl = new GridLayout();
		gl.setColumns(4);gl.setRows(3);
		//dimension de ok et reset
		ok.setPreferredSize(dim1);
		set.setPreferredSize(dim1);
		reset.setPreferredSize(dim1);
		pan.setLayout(gl);
		//initialisation des bouttons de pan et attributions d'interface
		for(int i=0;i<tab_button.length;i++)
		{
			tab_button[i] = new Boutton(tab_string[i]);
			tab_button[i].setPreferredSize(dim);
					tab_button[i].addActionListener( new ChiffreListener());
					pan.add(tab_button[i]);
		}
		//style de texte
		Font f = new Font("Tohoma",Font.BOLD,25);
		//definition du layout de l'ecran
		ecran.setLayout(new BorderLayout());
		ecran.add(staticscreen,BorderLayout.WEST);
		ecran.add(dmcscreen,BorderLayout.EAST);
		//dimension de l'ecran
		ecran.setPreferredSize(new Dimension(ecran.getWidth(), 300));ecran.setFont(f);
		//dessination des bordures  de l'ecran
		ecran.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		//draw border center
		center.setBorder(BorderFactory.createLineBorder(Color.black));
		center.setPreferredSize(new Dimension(50, 50));center.setFont(f);
		//sytle
		Font police = new Font("Arial", Font.BOLD, 20);jtf.setFont(police);
		//coulleur du texte de jtf et dimension
	    jtf.addKeyListener(new ClavierListener());
		jtf.setForeground(Color.DARK_GRAY);
		jtf.setPreferredSize(new Dimension(350,50));
		//earing ok and reset
		ok.addActionListener(new OkListener());
		reset.addActionListener(new ResetListener());
		set.addActionListener(new SetCoefListener());
		//add jtf a,ok,reset 
		center.add(jtf);
		center.add(ok);
		center.add(reset);
		//initialisation de l objectif
		JLabel l = new JLabel(""
				+ "<html>"
				+ "<h1><u>Resolutions Systèmes<br>D'équations de la forme</u></h1><br>a11X1 + a12X2+.....a1nXn= b1"
				+ "<br>._________.____________.</br>"
				+ "<br>._________.____________.</br>"
				+ "<br>._________.____________.</br>"
				+ "<br>._________.____________.</br>"
				+ "<br>._________.____________.</br>"
				+ "<br>an1Xn + an2X2+......annXn= bn"
				+ "</html>");
		l.setForeground(Color.WHITE);
		l1.setForeground(Color.cyan);
		l1.setFont(police);
		//add objectif 
		dmcscreen.add(l1);
		staticscreen.add(l);
		container.add(ecran,BorderLayout.NORTH);
		container.add(center,BorderLayout.CENTER);
		container.add(pan,BorderLayout.SOUTH);
		this.setContentPane(container);
		this.setVisible(true);
		Resolution();
	}
	public void Resolution()
	{
		while(true)
		{
			//variable de verification du reset
			resetstatus = true;
			//variable de verification du ok
			next =false;
			while(resetstatus)
			{
				double eps = 0.0,s1,s2,s;
				int c= 0,f=0;
				//variable de varificaton de differents coefficiens
				coefval = false;menbercoef=false;nverf=false;epsival=false;clickset=false;
				//redimenssionement du jtf,center et mise a jour normale en cas d 'annulation
				jtf.setPreferredSize(new Dimension(350,50));
				center.remove(set);
				center.repaint();
						l1.setText("<html>Entrer le nombre de ligne de<br> votre equation ou inconnue.</html>");
						do {
							try
							{
							if(Integer.valueOf(jtf.getText())>0 && next==true)
									{
								n = Integer.valueOf(jtf.getText());
								nverf =true;
									}else {
										if(next==true)
										{
											jop1 = new JOptionPane();
											jop1.showMessageDialog(null, "<html>Le nombre de ligne de votre équation ou <br>inconnue doit etre un entier superieur a zéro</br></html>", "<html><u>number of ligne ERROR</u></html>",JOptionPane.ERROR_MESSAGE);

										next=false;
										}
									}
							}catch(NumberFormatException e)
							{}
						}while(nverf != true);
						next = false;
					   A= new double[n][n];
					   B = new double [n];
					double X[] = new double[n];
					double Y[] = new double[n];
					for( i=0;i<A.length;i++)
					{
						for( j=0;j<A.length;j++)
						{
								l1.setText("Entrer le coefficient a"+(i+1)+(j+1));
								do
								{
										try {
											try {
											if(Double.valueOf(jtf.getText()).isInfinite()==false && next==true)
											{
												coefval = true;
												next=false;
												try {
												A[i][j]=Double.valueOf(jtf.getText()).doubleValue();
												}catch(ArrayIndexOutOfBoundsException e) {}
											}
											}catch(NullPointerException n) {next=false;}
										}catch(NumberFormatException e)
										{
											coefval = false;
										}
										next=false;
								}while(coefval!=true && resetstatus!=false);
							next = false;
							coefval=false;
						}
						l1.setText("Entrer le coefficient b"+(i+1));
						do
						{
						try
						{
							if(Double.valueOf(jtf.getText()).isInfinite()==false && next==true && resetstatus==true)
							{
								menbercoef = true;
								next=false;
								B[i]=Double.valueOf(jtf.getText()).doubleValue();
							}
						}catch(NumberFormatException e)
						{
							next=false;
						}
						next=false;
						}while(menbercoef!=true);
						next =false;
						menbercoef=false;
					}
					jtf.setPreferredSize(new Dimension(300,50));
					set.repaint();
					center.add(set);
					center.repaint();
					next = false;
					String showsystem = new String("");
					next =false;
					String compare = new String("");
					//regex de verification des donnees du jtf
					String regex =new String("^[0-9]+.0+$");
					for(i=0;i<A.length;i++)
					   {
					       for(j=0;j<A.length;j++)
					       {
					    	   if(i==0 && j==0)
					    	   {
					    		   
					    		   compare = compare.valueOf(A[i][j]);
						    		   if(A[i][j]<0)
						    		   {
						    			   if(compare.matches(regex))
						    			   {
						    			   showsystem ="<html>"+(int)A[i][j]+"X"+(j+1);
						    			   }else {
						    				   showsystem ="<html>"+A[i][j]+"X"+(j+1);
						    			   }
						    		   }else {
						    				   if(compare.matches(regex))
							    			   {
							    			   showsystem ="<html>"+(int)A[i][j]+"X"+(j+1);
							    			   }else {
							    				   showsystem ="<html>"+A[i][j]+"X"+(j+1);
							    			   }
						    		   }
					    	   }else
					    	   {
					    		   if(A[i][j]<0)
					    		   {
						    			   if(compare.matches(regex))
						    			   {
						    			   showsystem =showsystem+(int)A[i][j]+"X"+(j+1);
						    			   }else {
						    				   showsystem =showsystem+A[i][j]+"X"+(j+1);
						    			   }
					    		   }else {
						    			   if(j==0)
						    			   {
								    		   if(compare.matches(regex))
							    			   {
							    			   showsystem =showsystem+(int)A[i][j]+"X"+(j+1);
							    			   }else {
							    				   showsystem =showsystem+A[i][j]+"X"+(j+1);
							    			   }
						    		        }else {

									    		   if(compare.matches(regex))
								    			   {
								    			   showsystem =showsystem+"+"+(int)A[i][j]+"X"+(j+1);
								    			   }else {
								    				   showsystem =showsystem+"+"+A[i][j]+"X"+(j+1);
								    			   }
						    		        	}
					    		        }
					    	   }
					       }
					       if(i==A.length && j==A.length)
					       {
					    	   if(compare.valueOf(B[i]).matches(regex))
			    			   {
			    			   showsystem =showsystem+"="+(int)B[i];
			    			   }else {
			    				   showsystem =showsystem+"="+B[i];
			    			   }
					       }
					       else {
					    	   if(compare.valueOf(B[i]).matches(regex))
			    			   {
			    			   showsystem =showsystem+"="+(int)B[i]+"<br>";
			    			   }else {
			    				   showsystem =showsystem+"="+B[i]+"<br>";
			    			   }
					       }
					      
					   }
					while(next==false && clickset==false)
					{
					l1.setText(showsystem+"Votre System est bien<br> ce System?Sinon appuyer<br><u><i>Annuler</i></u><br> pour recommencer.");
					}
					//appel de la demande de precision
					t2 = new Thread(new AskPrecision());
					t2.start();
					next=false;
						do {
							try {
							try{
							if(Math.pow(10, -10000)<=Double.valueOf(jtf.getText()).doubleValue() && Double.valueOf(jtf.getText()).doubleValue()<=Math.pow(10, -1) && Double.valueOf(jtf.getText()).doubleValue()!=0 && next==true && resetstatus==true)
							{
								epsival=true;
								eps = Double.valueOf(jtf.getText()).doubleValue();
							}else {
								if(next==true)
								{
								Error2 e = new Error2();
								next=false;
								}
							}
							}catch(NumberFormatException e)
							{System.out.println("error");}
							}catch(NullPointerException n) {}
							next=false;
						}while(epsival!=true);
						String end = showsystem+"<h2><u>vos solutions sont:</u><h2><br>";
						next =false;
						//calcul
						if(resetstatus)
						{
							for(int i=0;i<A.length;i++)
							{
								X[i] =0;
							}
							double E = Math.pow(10, -20),d=E+1;
							while(d>E)
							{
						        s = 0.0;
						        s2 =0.0;
						        s1=0.0;
								for(int j=1;j<A.length;j++)
								{
									s = s + A[0][j]*X[j];
								}
								next=false;
								Y[0] = (B[0]-s)/(A[0][0]);
								for(int i=1;i<A.length;i++)
								{
									for(int j=0;j<=i-1;j++)
									{
										s1 = s1 + A[i][j]*Y[j];
									}
									for(int j=i+1;j<X.length;j++)
									{
										s2 = s2 +A[i][j]*X[j];
									}
									Y[i] = (B[i]-s1-s2)/A[i][i];
									s = 0.0;
							        s2 =0.0;
							        s1=0.0;
									
								}
								next=false;
								double som1=0,som2=0;
								for(int i=0;i<X.length;i++)
								{
									som1 = som1 + Math.abs((Y[i]-X[i]));
									som2 =som2 + Math.abs(Y[i]);
								}
								d=som1/som2;
								for(int i=0;i<X.length;i++)
								{
									X[i] = Y[i];
								}
							}
							while(next==false || resetstatus==true)
							{
								for(c=f;c<X.length;c++)
								{
									try
									{
								 end = end+"<h1>"+"X"+(c+1)+"="+X[c]+"</h1>";
								 l1.setText(end);
									}catch(ArrayIndexOutOfBoundsException a) {}
								}
								l1.setText(end);
								f=A.length+1;
								center.remove(set);
								container.repaint();
							}
							next=false;
						}
		}
					//begegining of resolutiom
	}
	}
	class ClavierListener implements KeyListener{
		  public void keyPressed(KeyEvent event) {System.out.println("Code touche tapée : " + event.getKeyCode() +" - caractère touche tapée : " + event.getKeyChar());}
		  public void keyTyped(KeyEvent event) {
		  System.out.println("Code touche tapée : " + event.getKeyCode() +" - caractère touche tapée : " + event.getKeyChar());
		  }
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()==10)
            {
				next = true;
				jtf.setText("");
            }
		}
		  }
	class OkListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			next = true;
			jtf.setText("");
			
		}
		
	}
	class ResetListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			i=n+1;j=n+1;
			coefval = true;menbercoef=true;nverf=true;epsival=true;clickset=true;
			resetstatus=false;
			jtf.setText("");
			next=true;
			jtf.setPreferredSize(new Dimension(350,50));
			center.remove(set);
			container.remove(setpan);
			container.add(pan,BorderLayout.SOUTH);
			container.repaint();
			
		}
	}
	class CoefListener implements ActionListener
	{
		//appel de la methode d affectation du coefficient clicquer
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setcoef=false;
			c= new Boutton(((JButton)e.getSource()).getText());
			t = new Thread(new PlayAnimation());
			t.start();
			next=false;
		}
	}
	class SetCoefListener implements ActionListener
	{
		//appel de initcoef
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			t1 = new Thread(new initcoef());
			t1.start();
			clickset=false;
		}
	
	}
	class ChiffreListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			number = ((JButton)e.getSource()).getText();
			if(numberadd && jtf.getText() != "0")
			{
				number = jtf.getText()+number;
				jtf.setText(number);
			}else {
				jtf.setText(number);
				numberadd =true;
			}
		}
		
	}
	class PlayAnimation implements Runnable{
		@Override
		public void run() {
			Set(c);
		}
		}
	class AskPrecision implements Runnable{
		@Override
		public void run() {
			l1.setText("<html>Entrer la precisionn de<br>votre System.</html>");
		}
		}
	class initcoef implements Runnable{
		@Override
		public void run() {
			clickset=true;
			l1.repaint();
			center.remove(set);
			container.remove(pan);
			setpan = new Panneau();
			GridLayout gls = new GridLayout();
			gls.setColumns(n+1);gls.setRows(n);
			setpan.setLayout(gls);
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					a = new Boutton("A"+(i+1)+(j+1));
					a.addActionListener(new CoefListener());
					a.setPreferredSize(dim);
					setpan.add(a);
				}
				b = new Boutton("B"+(i+1));
				b.addActionListener(new CoefListener());
				b.setPreferredSize(dim);
				setpan.add(b);
			}
			container.remove(pan);
			container.add(setpan,BorderLayout.SOUTH);
			setpan.repaint();
			container.repaint();
			do {
				l1.setText("<html><i>Choisissez le coefficient<br> a changer.</i></html>");
				System.out.println(setcoef);
			}while(setcoef==true);
			
		}
		}
	public void Set(JButton b)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.println((i+1));
				if(b.getText().equals("A"+(i+1)+(j+1)))
				{
					next=false;
					container.remove(setpan);
					container.add(pan,BorderLayout.SOUTH);
					pan.repaint();
					container.repaint();
					System.out.println((i+1));
					l1.setText("Entrer le coefficient A"+(i+1)+(j+1));
					System.out.println("A"+(i+1)+(j+1));
					do
					{
							try {
								try {
								if(Double.valueOf(jtf.getText()).isInfinite()==false && next==true)
								{
									coefval = true;
									next=false;
									try {
									A[i][j]=Double.valueOf(jtf.getText()).doubleValue();
									t2 = new Thread(new AskPrecision());
									t2.start();
									System.out.println("OK");
									}catch(ArrayIndexOutOfBoundsException o) {}
								}
								}catch(NullPointerException n) {next=false;}
							}catch(NumberFormatException l)
							{
								coefval = false;
							}
							next=false;
					}while(coefval!=true);
					coefval=false;
					next=false;
					
				}
			}
			if(b.getText().equals("B"+(i+1)))
					{
				next=false;
				container.remove(setpan);
				container.add(pan,BorderLayout.SOUTH);
				pan.repaint();
				container.repaint();
				System.out.println("B1");
				l1.setText("Entrer le coefficient B"+(i+1));
				do
				{
				try
				{
					try {
					if(Double.valueOf(jtf.getText()).isInfinite()==false && next==true && resetstatus==true)
					{
						menbercoef = true;
						next=false;
						B[i]=Double.valueOf(jtf.getText()).doubleValue();
						t2 = new Thread(new AskPrecision());
						t2.start();
						System.out.println("OKB");
					}
					}catch(NullPointerException w) {}
				}catch(NumberFormatException r)
				{
					next=false;
				}
				next=false;
				}while(menbercoef!=true);
				next =false;
				menbercoef=false;
					}
		}
	}
}
