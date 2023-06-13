/**
 * 
 */
package clientcountword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author yuqin
 *
 */
public class ClientWordCountApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args)
			throws UnknownHostException, IOException {
		
		int serverSidePort = 4231;
		
		// Launch client-side frame
		ClientFrame clientFrame = new ClientFrame();
		clientFrame.setVisible(true);
		
		// Connect to the server @ localhost, port 4231
		Socket socket = new Socket(InetAddress.getLocalHost(), serverSidePort);
		
		// Update the status of the connection
		clientFrame.updateConnectionStatus(socket.isConnected());
		
		// Read from network
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		// Display the text and number of words
		String text = bufferedReader.readLine();
		clientFrame.updateServerText(text);
		String[] words = text.split(" ");
		int wordNum = words.length;
		clientFrame.updateWordNum(wordNum);
		
		
		// Close everything
		bufferedReader.close();
		socket.close();

	}

}
