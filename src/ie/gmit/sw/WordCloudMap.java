package ie.gmit.sw;

import java.io.*;
import java.net.*;
import java.util.*;


public class WordCloudMap {

	private Map<String, Word> map = new HashMap<String, Word>();
	
	private StopWordMap stopWordMap;
	
	private BufferedReaderParser bufferedReaderParser;
	
	public WordCloudMap(StopWordMap stopWordFile) throws IOException{
		this.stopWordMap = stopWordFile;
	}
	
	public Word[] generate(String urlOrFile) throws IOException{
		// detects if the url was passed
		if (urlOrFile.substring(0,4).equals("http")){
			populateFromUrl(urlOrFile);
		} else{
			populateFromFile(urlOrFile);
		}
		QuickSortWords qsort = new QuickSortWords(map);
		
		return qsort.getSortedArray();
	}
	
	private void populateFromUrl(String urlName) throws IOException{
		
		
		URL oracle = new URL(urlName);
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
        
        bufferedReaderParser = new BufferedReaderUrlParser();
        bufferedReaderParser.parse(in, this);
        //insertIntoMap(in);
        in.close();
        
	}
	
	private void populateFromFile(String fileName) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		//insertIntoMap(in);
		bufferedReaderParser = new BufferedReaderFileParser();
		bufferedReaderParser.parse(in, this);
		in.close();
	}
	
	public void validateWord(String word){
		/*
		 * Assume that stop words would be always lower case.
		 * In this case validation would be case insensitive,
		 * ! But note that result will be calculated like case SENSITIVE
		 */
		if (!stopWordMap.containsKey(word.toLowerCase()))
			put(word);
	}
	
	private Word put(String key) {
		
		Word word;
		
		if (map.containsKey(key)){
			word = map.get(key);
			int value = word.getFrequency();
			word.setFrequency(++value);
			
		} else {
			word = new Word(key);
		}
			
		return map.put(key, word);
	}

	public static void main(String[] args) throws IOException {
		StopWordMap swm = StopWordMap.getInstance();
		swm.load("./stopwords.txt");
		WordCloudMap wcm = new WordCloudMap(swm);
		//wcm.generate("https://en.wikipedia.org/wiki/Tag_cloud");
		wcm.generate("./assignment-description.txt");
		//System.out.println(wcm.map);
	}
}
