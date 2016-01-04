package ie.gmit.sw;

import java.io.*;
import java.util.*;

public class StopWordMap {
	
	private Map<String, Integer> map = new HashMap<String, Integer>();
	
	private static StopWordMap instance;
	
	private StopWordMap(){}
	
	public static StopWordMap getInstance(){
		
		if (instance == null){
			instance = new StopWordMap();
		}
		
		return instance;
	}
	
	// populating map with words
	public void load(String filename) throws IOException{
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		String word;
		
		while ((word = bufferedReader.readLine()) != null) {
			// if we already have this word in map, ignore it
			if (!map.containsKey(word))
				map.put(word,0);
	    }
		
		bufferedReader.close();
	}
	
	// delegate job to the map
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}
	
	
	/*
	 * this part is just for class testing
	 */
	private void display(){
		for (Map.Entry<String, Integer> word : map.entrySet()){
			System.out.println(word.getKey() + " " + word.getValue());
		}
	}
}
