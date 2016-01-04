package ie.gmit.UnitTests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ie.gmit.sw.DrawWordCloud;
import ie.gmit.sw.StopWordMap;
import ie.gmit.sw.Word;
import ie.gmit.sw.WordCloudMap;

public class DrawWordCloudTest {

	private StopWordMap swm;
	private WordCloudMap wcm;
	private Word[] words;

	@Before
	public void setup() throws IOException{
		swm = StopWordMap.getInstance();
		swm.load("./stopwords.txt");
		wcm = new WordCloudMap(swm);
		
		words = wcm.generate("./assignment-description.txt");

	}
	
	@After
	public void tearDown(){
	}
	
	/*
	 * Testing draw word cloud class
	 * if it is creating a .png file with words
	 */
	@Test
	public void drawWordCloudImage() throws IOException{
		DrawWordCloud dwc = new DrawWordCloud();
		dwc.drawWordCloudImage(words,1000);
		dwc.save("image");
		
		// note that it will automatically add .png
		File file = new File("./image.png");
		assertTrue(file.exists());
	}
	
}
