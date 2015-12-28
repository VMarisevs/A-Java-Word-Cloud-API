package ie.gmit.sw;

import java.awt.*;
import java.util.Random;

public class Word {

	public static int MAX_FONT_SIZE = 100;
	public static int[] FONT_TYPE = {Font.PLAIN, Font.ITALIC, Font.BOLD};
	public static String[] FONT_STYLE = {Font.SANS_SERIF, Font.MONOSPACED};
	public static Color[] TEXT_COLOR = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY
			, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK
			, Color.RED, Color.WHITE, Color.YELLOW};
	
	
	private String word;
	private int frequency;
	private Font font;
	private Color color;
	private int fontSize;
	private int textWidth;
	
	public Word(String _word){
		word = _word;
		frequency = 1;
	}

	@Override
	public String toString() {
		return "Word [word=" + word + ", frequency=" + frequency + "]";
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public String getWord() {
		return word;
	}
	
	public void setFont(int maxFreq){
		
		fontSize = (int)((float)frequency / (float)maxFreq * Word.MAX_FONT_SIZE);
		
		Random random = new Random();
		
		int fontType = random.nextInt(Word.FONT_TYPE.length);
		int fontStyle = random.nextInt(Word.FONT_STYLE.length);
		
		font = new Font(Word.FONT_STYLE[fontStyle], Word.FONT_TYPE[fontType] , fontSize);
		
		int textColor = random.nextInt(Word.TEXT_COLOR.length);
		color = Word.TEXT_COLOR[textColor];
	}
	
	public Font getFont(){
		return font;
	}
	
	public int getFontSize(){
		return fontSize;
	}
	
	public Color getColor(){
		return color;
	}

	public void setTextWidth(int textWidth){
		this.textWidth = textWidth;
	}
	
	public int getTextWidth(){
		return textWidth;
	}
}
