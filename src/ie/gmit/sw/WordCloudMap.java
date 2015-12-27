package ie.gmit.sw;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


public class WordCloudMap {

	private Map<String, Integer> map = new HashMap<String, Integer>();
	
	public void populate(String urlOrFile) throws IOException{
		// detects if the url was passed
		if (urlOrFile.substring(0,4).equals("http")){
			populateFromUrl(urlOrFile);
		} else{
			System.out.println("file");
		}
	}
	
	private void populateFromUrl(String urlName) throws IOException{
		
		
		URL oracle = new URL(urlName);
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
        
	}
	
	private void populateFromFile(String fileName){
		
	}
	
	public static void main(String[] args) throws IOException {
		WordCloudMap wcm = new WordCloudMap();
		wcm.populate("https://en.wikipedia.org/wiki/Tag_cloud");
	}
}
