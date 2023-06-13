/**
 * 
 */
package servertranslation;

/**
 * @author yuqin
 *
 */
public class TranslationGenerator {

	// Declare an array
    private String[][] words = {
            {"Good morning", "Good night", "How are you?",
                    "Thank you", "Goodbye", "What’s up?"},
            {"Selamat pagi", "Selamat malam", "Apa khabar?", 
                    "Terima kasih", "Selamat tinggal", "Ada apa?"},
            {"صباح الخير", "تصبح على خير", "كيف حالك؟", "تيريما كاسيه", "سلامات تينجال", "ماذا يجري؟"},
            {"좋은 아침", "안녕히 주무세요", "어떻게 지내세요?",
                    "감사합니다", "안녕", "뭐야?"}
    };

    public TranslationGenerator() { }

    /*
     * This method will translate the text user selected 
     * into the target language and display it
     */
    public String translate(int targetTextIndex, int targetLanguageIndex) {
    	String original = words[0][targetTextIndex];
        String translated = words[targetLanguageIndex][targetTextIndex];
        return  original + " = " + translated;
    }
    
}
