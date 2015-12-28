package ie.gmit.sw;

public class Word {

	private String word;
	private int frequency;
	
	public Word(String _word){
		word = _word;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public String getWord() {
		return word;
	}
	
}
