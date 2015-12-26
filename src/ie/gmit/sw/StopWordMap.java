package ie.gmit.sw;

import java.io.*;
import java.util.*;

public class StopWordMap {

	private Map<String, Integer> map = new HashMap<String, Integer>();
	
	public void load(String filename) throws IOException{
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		String word;
		
		while ((word = bufferedReader.readLine()) != null) {
			map.put(word,0);
	    }
		
		bufferedReader.close();
	}
	
	
	private void display(){
		for (Map.Entry<String, Integer> word : map.entrySet()){
			System.out.println(word.getKey() + " " + word.getValue());
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		StopWordMap swm = new StopWordMap();
		swm.load("./stopwords.txt");
		swm.display();
	}
}
