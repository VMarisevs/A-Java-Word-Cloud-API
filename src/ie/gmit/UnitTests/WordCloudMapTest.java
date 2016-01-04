package ie.gmit.UnitTests;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ie.gmit.sw.*;

public class WordCloudMapTest {

	private StopWordMap swm;
	private WordCloudMap wcm;
	
	@Before
	public void setup() throws IOException{
		swm = StopWordMap.getInstance();
		swm.load("./stopwords.txt");
		wcm = new WordCloudMap(swm);
	}
	@After
	public void tearDown(){
		wcm = null;
		swm = null;
	}
	
	/*
	 * Testing WordCloudMap for file not found exception
	 */
	@Test(expected=FileNotFoundException.class)
	public void cantGenerateWordCloudFromFile() throws IOException{
		wcm.generate("./ThisFileDoesntExists");
	}
	
	/*
	 * Testing WordCloudMap for inserted from file 
	 */
	@Test
	public void generateWordCloudFromFile() throws IOException{
		Word[] words = wcm.generate("./assignment-description.txt");
		assertTrue(words.length > 0);
	}
	
	/*
	 * Testing WordCloudMap generation from random url
	 * that doesn't exists 
	 */
	@Test(expected=ConnectException.class)
	public void cantGenerateWordCloudFromUrl() throws IOException{
		wcm.generate("http://localhost/This-Url-Doesnt-Exists");
	}
	
	/*
	 * Testing WordCloudMap for inserted from url 
	 */
	@Test
	public void generateWordCloudFromUrl() throws IOException{
		Word[] words = wcm.generate("https://en.wikipedia.org/wiki/Tag_cloud");
		assertTrue(words.length > 0);
	}
	
	
}
