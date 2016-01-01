package ie.gmit.sw;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DrawWordCloud {
	private BufferedImage image;
	private Graphics graphics;
		
	public void drawWordCloudImage(Word[] words, int width ){
		
		int height = 50;
		
		for (int i = 0; i < words.length; i++){
			words[i].setFont(words[words.length-1].getFrequency());
			height += words[i].getFontSize();
		}
		
		// init new buffered image
		image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		graphics = image.getGraphics();
		
		/*
		 * This code will display the words in descending order, in the list view
		 */
		
		int y = 0;
		
		for (int i = 0; i < words.length; i++){			
			
			graphics.setColor(words[i].getColor());
			graphics.setFont(words[i].getFont());
			
			y += words[i].getFontSize();
			graphics.drawString(words[i].getWord(), 0 , y);
		}
		
	}
	
	// filename must be just the name, *.png is default extension
	public void save(String filename) throws IOException{
		graphics.dispose();
		ImageIO.write(image, "png", new File( filename + ".png"));
	}
	
	public static void main(String[] args) throws IOException {
		StopWordMap swm = StopWordMap.getInstance();
		swm.load("./stopwords.txt");
		WordCloudMap wcm = new WordCloudMap(swm);
		
		Word[] words = wcm.generate("./assignment-description.txt");
		
		DrawWordCloud dwc = new DrawWordCloud();
		dwc.drawWordCloudImage(words,1000);
		dwc.save("image");
	}
}
