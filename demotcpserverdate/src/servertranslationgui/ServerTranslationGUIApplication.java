/**
 * 
 */
package servertranslationgui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author yuqin
 *
 */
public class ServerTranslationGUIApplication {

	/**
	 * @param args
	 */
    public static void main(String[] args) throws IOException {

    	// Declare variables 
    	ServerSocket serverSocket = null;
    	
    	// Bind serverSocket to a port
        int portNo = 4312;
        serverSocket = new ServerSocket(portNo);
        ServerTranslationFrame serverFrame = new ServerTranslationFrame();
		serverFrame.setVisible(true);
		
		int totalRequest = 0;
        
        while (true) {
        	
        	// Message to indicate server is alive
			serverFrame.updateServerStatus(false);
        	
        	// Accept client request for connection
            Socket clientSocket = serverSocket.accept();
            
            // Create input stream
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            
            // Read user selection
            int textIndex = dis.readInt();
            int languageIndex = dis.readInt();


            // Translate the text into the target language
            TranslationGeneratorGUI translationGenerator = new TranslationGeneratorGUI();
            String translation = translationGenerator.translate(textIndex, languageIndex);

            // Create output stream
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            
            // Write translation result
            dos.writeBytes(translation);

            dos.flush();
            
            // Close all stream
            dos.close();
            dis.close();
            clientSocket.close();
            
            totalRequest ++;
			
			// Update request status
			serverFrame.updateRequestStatus(
					"Data sent to the client: " + translation);
			serverFrame.updateRequestStatus(
					"Accepted connection to from the " + 
					"client. Total request = " + totalRequest);
        }
        
    }
    
}
