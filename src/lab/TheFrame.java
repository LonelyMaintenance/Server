package lab;
import java.awt.BorderLayout; 
import javax.swing.JFrame; 
 public class TheFrame extends JFrame { 
 
   ThePanel aPanel; 
 
   TheFrame(ThePanel aPanel) {     
	   super();                        
	   this.aPanel=aPanel;  
	   setTitle("The View");  
	   setSize(500, 400); 
 setVisible(true); 
 
setDefaultCloseOperation(EXIT_ON_CLOSE); 
setLayout(new BorderLayout());  
add(aPanel, BorderLayout.CENTER); 
} 
} 