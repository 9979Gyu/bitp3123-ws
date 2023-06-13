/**
 * 
 */
package clienttranslation;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author yuqin
 *
 */
public class ClientTranslationApplication {
	
	/**
	 * @param args
	 */
    public static void main(String[] args) {
    	
        try {
        	
        	// Connect to the server at localhost, port = 4312
            int serverSidePort = 4312;
            Socket socket = new Socket(InetAddress.getLocalHost(), serverSidePort);
            
            // Create object
            Scanner userInput = new Scanner(System.in);
            
            // Declare variables 
            int languageOption = 0;
            int languageIndex = 0;
            int textOption = 0;
            int textIndex = 0;
            
            // Validate user selection
            while(languageOption < 1 || languageOption > 3)
            {

            	System.out.println("\nAvailable options:");
                System.out.println("1. English to Bahasa Malaysia");
                System.out.println("2. English to Arabic");
                System.out.println("3. English to Korean");
                System.out.print("Enter the number of the translation option: ");

                // Receive user input
                languageOption = userInput.nextInt();         
                
            }
            
            // Assign value into languageIndex;
            languageIndex = languageOption;
            
            userInput.nextLine();

            // Validate user selection
            while(textOption < 1 || textOption > 6)
            {

            	System.out.println("\nAvailable options:");
                System.out.println("1. Good morning");
                System.out.println("2. Good night");
                System.out.println("3. How are you?");
                System.out.println("4. Thank you");
                System.out.println("5. Goodbye");
                System.out.println("6. What’s up?");
                System.out.print("Enter the text to be translated: ");
                
                // Receive user input
                textOption = userInput.nextInt();  
                
            }
            
            // Assign value into languageIndex;
            textIndex = textOption - 1;

            // Create output stream
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            // Write user selection
            dos.writeInt(textIndex);
            dos.writeInt(languageIndex);

            // Create input stream
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            
            // Read from the network and display the value
            String translation = bufferedReader.readLine();
            System.out.println("\nTranslation: " + translation);

            // Close all stream
            dos.close();
            bufferedReader.close();
            socket.close();

        } 
        catch (IOException e) {
           
        	e.printStackTrace();
        	
        }
        
    }
    
}
