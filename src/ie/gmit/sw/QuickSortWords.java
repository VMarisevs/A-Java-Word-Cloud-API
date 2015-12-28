package ie.gmit.sw;

import java.util.Map;

public class QuickSortWords {

	private Word[] words;
	
	public QuickSortWords(Map<String, Word>  map){
		words = new Word[map.size()];
		referenceToArray(map);
		quicksort(0,map.size()-1);
		// display();
	}
	
	public Word[] getSortedArray(){
		return words;
	}
	
	private void referenceToArray(Map<String, Word>  map){
		
		int counter = 0;
		for (Map.Entry<String, Word> entry : map.entrySet()){
			words[counter++] = entry.getValue();
		}
	}
	
	private void display(){
		for (int i = 0; i < words.length; i++){
			System.out.println(words[i].getWord() + " " + words[i].getFrequency() + "\n");
		}
	}
	
	/*
	 * This QuickSort algorithm implementation was taken from
	 * http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
	 * 
	 */
	
	private void quicksort(int low, int high) {
		 int i = low, j = high;

		 // Get the pivot element from the middle of the list		
		 int pivot = words[low + (high-low)/2].getFrequency();		
		 // Divide into two lists
		 while (i <= j) {
				 /* If the current value from the left list is smaller then the pivot
				  * element then get the next element from the left list
				  */
				 while (words[i].getFrequency() < pivot) {
					 i++;
				 }
				 
				/* If the current value from the right list is larger then the pivot
				 * element then get the next element from the right list
				 */
				while (words[j].getFrequency() > pivot) {
					j--;
				}
	
				/*
				 * If we have found a values in the left list which is larger then
				 * the pivot element and if we have found a value in the right list
				 * which is smaller then the pivot element then we exchange the values.
				 * As we are done we can increase i and j
				 */
				if (i <= j) {
					exchange(i, j);
					i++;
					j--;
				}
		    }
		 
		    // Recursion
		    if (low < j)
		    	quicksort(low, j);
		    if (i < high)
		    	quicksort(i, high);
	 }
	 
	private void exchange(int i, int j) {
		Word word = words[i];
		words[i] = words[j];
		words[j] = word;
	}
}
