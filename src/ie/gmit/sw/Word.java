package ie.gmit.sw;

public class Word {

	private String word;
	private int frequency;
	
	public Word(String _word){
		word = _word;
		frequency = 1;
	}

	@Override
	public String toString() {
		return "Word [word=" + word + ", frequency=" + frequency + "]";
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
