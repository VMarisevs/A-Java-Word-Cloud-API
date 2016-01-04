package ie.gmit.UnitTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.*;

import static org.junit.Assert.*;

import ie.gmit.sw.StopWordMap;

public class StopWordMapTest {

	private StopWordMap swm;
	
	@Before
	public void setup(){
		swm = StopWordMap.getInstance();
	}
	
	@After
	public void tearDown(){
		swm = null;
	}
	
	/*
	 * This test expects file not found exception
	 */
	@Test(expected=FileNotFoundException.class)
	public void fileDoesntExistsException() throws IOException{
		swm.load("./ThisFileDoesntExists");
	}
	
	/*
	 * stop words loaded, and tested 
	 * on first word in file
	 */
	@Test
	public void readDefaultStopWords() throws IOException{
		swm.load("./stopwords.txt");
		assertTrue(swm.containsKey("a"));
	}
}
