package ie.gmit.sw;

import java.io.*;

public class BufferedReaderFileParser implements BufferedReaderParser {

	@Override
	public void parse(BufferedReader in,  WordCloudMap wcm) throws IOException {

		
		StringBuilder word = new StringBuilder();
		WordValidator wordValidator = WordValidator.getInstance();
		
		int intChar;
		while ((intChar = in.read()) != -1){
			
			if (wordValidator.validate(word, intChar)){
				// inserting into map
				wcm.validateWord(word.toString());
				// removing previous word
				word.setLength(0);
			}		
		}		
	}

}
