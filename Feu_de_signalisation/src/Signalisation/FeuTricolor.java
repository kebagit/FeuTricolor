package Signalisation;
import java.awt.BorderLayout; 
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

public class FeuTricolor extends JFrame implements ActionListener  {

    JButton demarrer; 
    JButton arreter; 
    Boolean i; 
    //create constructor method 
    public FeuTricolor(String title) { 
      // creation du boutton demarrer
    	demarrer = new JButton("demarrer"); 
      //creation du boutton arreter
    	arreter = new JButton("arreter"); 
      //Action listeners 
      demarrer.addActionListener(this); 
      arreter.addActionListener(this); 
      //creation des Bouttons JPanel 
      JPanel buttonPanel = new JPanel(); 
      buttonPanel.add(demarrer); 
      buttonPanel.add(arreter); 
      Container c = getContentPane(); 
      c.add(buttonPanel, BorderLayout.SOUTH); 

      setSize(200, 400); 
      setLocationRelativeTo(null); 
      setResizable(false); 
      setVisible(true); 
      setDefaultCloseOperation(EXIT_ON_CLOSE); 
    } 

    public void paint(Graphics g){ 
      super.paint(g); 
      g.setColor(Color.black); 
      g.fillOval(50,50,100,100); 
      g.fillOval(50,155,100,100); 
      g.fillOval(50,260,100,100); 
    } 

  
    public void actionPerformed(ActionEvent e){ 
      if(e.getSource() == demarrer){ 
        i = true; 
        new ThreadExtend(this).start(); 
      }else{ 
        i = false; 
      } 
    } 
    public class ThreadExtend extends Thread { 
      Graphics g; 
      JFrame frame; 

      public ThreadExtend(JFrame frame){ 
        this.frame = frame; 
        g = frame.getGraphics(); 
      } 
      public void run(){ 
        while(i) { 
          try{ 
            red(g); 
            if(!i) { 
              break; 
            } 
            Thread.sleep(1000); 
            amber(g); 
            if(!i) { 
              break; 
            } 
            Thread.sleep(1000); 
            green(g); 
            if(!i){ 
              break; 
            } 
            Thread.sleep(1000); 


          }catch(InterruptedException e) { 
             e.printStackTrace(); 
         } 
        } 
      }  

    } 
    public void red(Graphics g){ 
      g.setColor(Color.black); 
      g.fillOval(52, 262, 96, 96); 
      g.setColor(new Color(255,0,0)); 
      g.fillOval(52, 52, 96, 96); 
    } 
    public void amber(Graphics g){ 
      g.setColor(Color.black); 
      g.fillOval(52, 52, 96, 96); 
      g.setColor(new Color(250,170,0)); 
      g.fillOval(52, 157, 96, 96); 
    } 
    public void green(Graphics g){ 
      g.setColor(Color.black); 
      g.fillOval(52, 157, 96, 96); 
      g.setColor(new Color(0,250,0)); 
      g.fillOval(52, 262, 96, 96); 
    } 
    public static void main(String[] args) { 
        new FeuTricolor("Affichage"); 

      } 


}
