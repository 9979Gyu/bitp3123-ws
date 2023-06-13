/**
 * 
 */
package serverwordcount;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author yuqin
 *
 */
public class ServerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// Frame component
	private JLabel lblServerStatus;
	private JTextArea txtRequestStatus;
	
	// Frame dimension
	private int width = 700;
	private int height = 500;
	
	public ServerFrame () {
		
		this.setLayout(new BorderLayout());
		this.setTitle("TCP Application: Server Side");
		this.setSize(new Dimension(width, height));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLocationRelativeTo(null);
		
		// initialize component
		this.lblServerStatus = new JLabel("-");
		this.txtRequestStatus = new JTextArea(20, 70);
		
		loadComponent();
	}
	
	private JPanel getServerStatusPanel(Font font) {
		
		JPanel panel = new JPanel();
		JLabel lblServer = new JLabel("Server status: ");
		
		lblServer.setFont(font);
		lblServerStatus.setFont(font);
		lblServer.setBackground(Color.WHITE);
		lblServer.setOpaque(true);
		lblServerStatus.setBackground(Color.WHITE);
		lblServerStatus.setOpaque(true);
		
		panel.add(lblServer);
		panel.add(lblServerStatus);
		
		return panel;
		
	}
	
	private JPanel getRequestStatusPanel() {
		
		JPanel panel = new JPanel();
		
		txtRequestStatus.setText("\n > Server is running");
		txtRequestStatus.setEditable(false);
		
		txtRequestStatus.setFont(new Font("Courier", Font.PLAIN, 15));
		
		// Add component to panel
		panel.add(txtRequestStatus);
		
		return panel;
	}
	
	private Font getFontStyle() {
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
		
		return font;
	}
	
	public void loadComponent() {
		
		Font font = this.getFontStyle();
		JPanel topPanel = this.getServerStatusPanel(font);
		this.add(topPanel, BorderLayout.NORTH);
		
		JPanel centrePanel = this.getRequestStatusPanel();
		this.add(centrePanel, BorderLayout.CENTER);
		
	}
	
	public void updateServerStatus(boolean result) {
		
		String status = "Waiting for connection.";
		
		if(result)
			status = "Received connection.";
		
		this.lblServerStatus.setText(status);
		
	}
	
	public void updateRequestStatus(String status) {
		
		String currentText = this.txtRequestStatus.getText();
		txtRequestStatus.setEditable(true);
		
		status += "\n > " + currentText;
		this.txtRequestStatus.setText(status);
		txtRequestStatus.setEditable(false);
	}
}
