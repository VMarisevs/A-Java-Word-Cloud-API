package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class BufferedReaderUrlParser implements BufferedReaderParser {

	
	
	@Override
	public void parse(BufferedReader in, WordCloudMap wcm) throws IOException {
		StringBuilder word = new StringBuilder();
		
		WordValidator wordValidator = WordValidator.getInstance();
		
		// this variable is responsible for getting into body part
		boolean bodyPart = false;
		// this variable is responsible for ignoring the tags
		boolean tag = true; // starts from true, because we are still in body tag
		
		int intChar;
		while ((intChar = in.read()) != -1){
			
			char nextChar = (char)intChar;
			
			//if we haven't got the bodyPart yet
			if (!bodyPart){
				
				if (nextChar == '<' || nextChar == 'b' || nextChar == 'o' || nextChar == 'd' || nextChar == 'y'){
					// concatinating the string
					word.append(nextChar);
					
					if (new String("<body").equals(word.toString())){	
						bodyPart = true;
					}
					
				} else{					
					word.setLength(0);
				}
			} else{
				// after we going into body part, strip tags and populate map
				
				if (tag){
					if (nextChar == '>') {
						tag = false;
						word.setLength(0);
					}
				}else{
					if (nextChar == '<') {
						tag = true;
						word.setLength(0);
					}else{
						// if it is not start of the tag, then it is text
						if (wordValidator.validate(word, intChar)){
							// inserting into map
							wcm.validateWord(word.toString());
							// removing previous word
							word.setLength(0);
						}
					}
				}
				
			}
		}
		
	}

	
	private void validateWord(char nextChar){
		
	}
	
	public static void main(String[] args) throws IOException {
		/*
		StopWordMap swm = StopWordMap.getInstance();
		swm.load("./stopwords.txt");
		WordCloudMap wcm = new WordCloudMap(swm);
		wcm.generate("https://en.wikipedia.org/wiki/Tag_cloud");
		//wcm.generate("./assignment-description.txt");
		*/
		URL oracle = new URL("https://en.wikipedia.org/wiki/Tag_cloud");
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
        
        BufferedReaderParser bufferedReaderParser = new BufferedReaderUrlParser();
        bufferedReaderParser.parse(in, new WordCloudMap(StopWordMap.getInstance()));
        //insertIntoMap(in);
        in.close();
	}
}
