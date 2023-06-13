/**
 * 
 */
package servertranslation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yuqin
 *
 */
public class ServerTranslationApplication {

	/**
	 * @param args
	 */
    public static void main(String[] args) throws IOException {
        
    	ServerSocket serverSocket = null;

        try {
        	
        	// Bind serverSocket to a port
            int portNo = 4312;
            serverSocket = new ServerSocket(portNo);
            
            System.out.println("Waiting for request...");
            
            while (true) {
            	
            	// Accept client request for connection
                Socket clientSocket = serverSocket.accept();

                // Create input stream
                DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
                
                // Read user selection
                int textIndex = dis.readInt();
                int languageIndex = dis.readInt();

                // Translate the text into the target language
                TranslationGenerator translationGenerator = new TranslationGenerator();
                String translation = translationGenerator.translate(textIndex, languageIndex);

                // Create output stream
                DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
                
                // Write translation result
                dos.writeUTF(translation);

                // Close all stream
                dis.close();
                dos.close();
                clientSocket.close();
            }

        } 
        catch (IOException e) {
            
        	if (serverSocket != null)
                serverSocket.close();
            
            e.printStackTrace();
        }
        
    }
    
}
