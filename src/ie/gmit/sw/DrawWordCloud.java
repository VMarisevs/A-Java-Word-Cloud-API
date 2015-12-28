package ie.gmit.sw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DrawWordCloud {
	private BufferedImage image;
	Graphics graphics;
	
	public DrawWordCloud(){
		image = new BufferedImage(600, 10000, BufferedImage.TYPE_4BYTE_ABGR);
		graphics = image.getGraphics();
	}
	
	public void drawWordCloudImage(Word[] words){
		
		
		// graphics.drawString(words[0].getWord(), 0, 35);
		int posy = 0;
		for (int i = words.length-1, j = 0; i > 0 ; i-- , j++){
			int fontSize = words[i].getFrequency()* 25;
			posy += words[i].getFrequency()* 25;
			Font font = new Font(Font.SANS_SERIF, Font.PLAIN, words[i].getFrequency()* 25 );
			graphics.setColor(Color.red);
			graphics.setFont(font);
			graphics.drawString(words[i].getWord(), 0 , posy);
			System.out.println(words[i].getWord() + ":" + words[i].getFrequency());
		}
		
	}
	
	// filename must be just the name, *.png is default extension
	public void save(String filename) throws IOException{
		graphics.dispose();
		ImageIO.write(image, "png", new File( filename + ".png"));
	}
	
	public static void main(String[] args) throws IOException {
		WordCloudMap wcm = new WordCloudMap("./stopwords.txt");
		Word[] words = wcm.generate("./assignment-description.txt");
		
		DrawWordCloud dwc = new DrawWordCloud();
		dwc.drawWordCloudImage(words);
		dwc.save("image");
	}
}
