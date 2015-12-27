package ie.gmit.sw;

import java.io.*;
import java.net.*;
import java.util.*;


public class WordCloudMap {

	private Map<String, Integer> map = new HashMap<String, Integer>();
	
	private StopWordMap stopWordMap = new StopWordMap();
	
	public WordCloudMap(String stopWordFile) throws IOException{
		stopWordMap.load(stopWordFile);
	}
	
	public void populate(String urlOrFile) throws IOException{
		// detects if the url was passed
		if (urlOrFile.substring(0,4).equals("http")){
			populateFromUrl(urlOrFile);
		} else{
			populateFromFile(urlOrFile);
		}
	}
	
	private void populateFromUrl(String urlName) throws IOException{
		
		
		URL oracle = new URL(urlName);
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
        	populateFromFile(inputLine);
        in.close();
        
	}
	
	private void populateFromFile(String fileName) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		insertIntoMap(in);
		in.close();
	}
	
	private void insertIntoMap(BufferedReader in) throws IOException{
		
		StringBuilder word = new StringBuilder();
		
		int intChar;
		while ((intChar = in.read()) != -1){
			char nextChar = (char)intChar;
			
			/*
			 * If current char is in the range of A-Z or a-z we adding it to the word
			 * In case current char is _ or - or number, we are checking
			 * if new word is more than 0 chars long.
			 * Only in that case number or - _ are part of the word
			 */
			
			if ((nextChar >= 'A' && nextChar <= 'Z')
				||	
				(nextChar >= 'a' && nextChar <= 'z')
				|| (
						(nextChar == '_' 
							|| nextChar == '-'
								|| nextChar == '\''
									|| (nextChar >= '0') && (nextChar <= '9')
									) && (word.length() > 0))
				){
				// append char to new word
				word.append(nextChar);
				
			} 
				/*
				 * Checking for special character to identify if the word is finished
				 * new line, spaces and other special characters including numbers
				 */
			else if ((intChar == 10) // new line
					||
					((intChar >= 32) // between space (ascii #32) and @ char (ascii #64)
							&& (intChar <= 64))
					||
					((intChar >= 91)
							&& (intChar <= 94)) // between '[' and '^'
					||
					(intChar == 96) // '`'
					||
					((intChar >= 123) 
							&& (intChar <= 126)) // '{' '|' '}' '~' 
					){
				// word is finished
				if (word.length() > 0){
					// inserting into map
					validateWord(word.toString());
					// removing previous word
					word.setLength(0);
				}
			}
		}
	}
	
	private void validateWord(String word){
		/*
		 * Assume that stop words would be always lower case.
		 * In this case validation would be case insensitive,
		 * ! But note that result will be calculated like case SENSITIVE
		 */
		if (!stopWordMap.containsKey(word.toLowerCase()))
			put(word);
	}
	
	private Integer put(String key) {
		int value = 1;
		if (map.containsKey(key)){
			value = map.get(key);
			map.put(key, ++value);
		} else {
			map.put(key, value);
		}
			
		return value;
	}

	public static void main(String[] args) throws IOException {
		WordCloudMap wcm = new WordCloudMap("./stopwords.txt");
		//wcm.populate("https://en.wikipedia.org/wiki/Tag_cloud");
		wcm.populate("./assignment-description.txt");
		System.out.println(wcm.map);
	}
}
