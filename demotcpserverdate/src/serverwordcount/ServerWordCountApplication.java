/**
 * 
 */
package serverwordcount;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yuqin
 *
 */
public class ServerWordCountApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int portNo = 4231;
		ServerFrame serverFrame = new ServerFrame();
		serverFrame.setVisible(true);
		
		try {
			
			// Bind to port number
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			TextGenerator textGenerator = new TextGenerator();
			
			int totalRequest = 0;
			
			// Listen continuously for request of connection
			while(true) {
			
				// Message to indicate server is alive
				serverFrame.updateServerStatus(false);
				
				// Accept client request
				Socket socket = serverSocket.accept();
				
				// Generate text 
				String text = textGenerator.getText();

				// Respond to the client
				OutputStream outputStream = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(outputStream);
				dos.writeUTF(text);
				
				// Close all stream
				dos.close();
				outputStream.close();
				
				totalRequest ++;
				
				// Update request status
				serverFrame.updateRequestStatus(
						"Data sent to the client: " + text);
				serverFrame.updateRequestStatus(
						"Accepted connection to from the " + 
						"client. Total request = " + totalRequest);
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
