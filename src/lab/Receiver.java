package lab;
import java.io.IOException;  
import java.io.ObjectInputStream;  
import java.io.PrintWriter;  
import java.net.*; 

 public class Receiver { 
 
ServerSocket serverSocket = null; 
Socket clientSocket = null; 
ObjectInputStream in = null; 
PrintWriter out=null; 
 public void receive() { 
	 establishContact();  
	 TheFrame theFrame=null; 
	 ThePanel panel = null; 
 
 try { 
	 panel = (ThePanel) 
			 in.readObject(); 
	 } catch(IOException ex){ 
		 ex.printStackTrace(); 
		 } catch(ClassNotFoundException ex){ 
			 ex.printStackTrace(); 
		 } theFrame= new TheFrame(panel);  
		 System.out.println("Panel info: " + panel.getInfo()); 
		 closeConnection(); 
		 } 
		  public void establishContact() { 
			  try { 
				  serverSocket= new ServerSocket(999); 
				  System.out.println("Waiting for client");
				  }  catch (IOException e) { 
					  System.out.println("Could not listen on port: 12345");  
					  System.exit(-1); 
					  } 
		  
		  try { 
			  clientSocket = serverSocket.accept(); 
		  System.out.println("Client accepted");
		  
		  
		  } catch (IOException e) {           
			  System.out.println("Accept failed: 1234");            
			  System.exit(-1); 
		  }
		  try {            
			  out = new PrintWriter( clientSocket.getOutputStream(), true);                                        in = new ObjectInputStream(clientSocket.getInputStream()); } catch (IOException ioe) { System.out.println("Failed in creating streams");  System.exit(-1); } 
		  
		 }      
		  private void closeConnection() { 
			  try {            
				  clientSocket.close(); 
				  serverSocket.close(); 
			 }catch (IOException e) {           
				 System.out.println("Could not close");           
				 System.exit(-1);    
				 }       
		 } 
		 } 