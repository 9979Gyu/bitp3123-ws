/**
 * 
 */
package serverwordcount;

/**
 * @author yuqin
 *
 */
public class TextGenerator {
	
	// Declare variable
	private String text = "Distributed System Development";

	public TextGenerator() { }
	/**
	 * this method will return the value
	 * that stored in variable text
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * this method will store the value into variable text
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	

}
