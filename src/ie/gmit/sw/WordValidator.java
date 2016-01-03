package ie.gmit.sw;

public class WordValidator {

	private static WordValidator instance;
	
	private WordValidator(){}
	
	public static WordValidator getInstance(){
		
		if (instance == null){
			instance = new WordValidator();
		}
		
		return instance;
	}
	
	public boolean validate(StringBuilder word, int intChar){
		
		/*
		 * If current char is in the range of A-Z or a-z we adding it to the word
		 * In case current char is _ or - or number, we are checking
		 * if new word is more than 0 chars long.
		 * Only in that case number or - _ are part of the word
		 */
		char nextChar = (char)intChar;
		
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
				return true;
				// inserting into map
				//wcm.validateWord(word.toString());
				// removing previous word
				//word.setLength(0);
			}
		}
		
		
		return false;
	}
}
