package ie.gmit.UnitTests;

import static org.junit.Assert.*;

import java.io.*;
import java.net.URL;

import org.junit.*;

import ie.gmit.sw.*;


public class BufferedReaderUrlParserTest {

	private URL url;
	private BufferedReader in;
	private WordCloudMap wcm;
	
	private Exception exception;
	
	@Before
	public void setup() throws IOException{
		url = new URL("https://en.wikipedia.org/wiki/Tag_cloud");
		in = new BufferedReader(new InputStreamReader(url.openStream()));
		wcm = new WordCloudMap(StopWordMap.getInstance());
	}
	
	@After
	public void tearDown(){
		url = null;
		in = null;
		wcm = null;
		exception = null;
	}
	
	/*
	 * Testing url parser
	 */
	@Test
	public void urlParserTest(){
		        
        try {
        	BufferedReaderParser bufferedReaderParser = new BufferedReaderUrlParser();
            bufferedReaderParser.parse(in, wcm);
            in.close();
		} catch (Exception e) {
			exception = e;
		}
        
        assertEquals(null,exception);
	}
}
