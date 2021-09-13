//Author Robert Jones
//09/12/21
//Program Name: SpellCheck
//Purpose: Compare words in one file to another file that acts as dictionary.


package Check;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Check {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		//create variables to store filenames
		String toCheck;   //goes to tcArray
		String dictionary;  //goes to dArray
		
		System.out.println("Enter File to SpellCheck:");
		toCheck = console.next();
		System.out.println("Enter Dictionary File:");
		dictionary = console.next();
		
		List<String> tcArray = new ArrayList<>();	//toCheck Array
		Scanner tc;
			try {
				tc = new Scanner(new File(toCheck));
				while(tc.hasNextLine()) {
					tcArray.add(tc.nextLine());
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		List<String> dArray = new ArrayList<String>();  //dictionary Array
		Scanner d;
			try {
				d = new Scanner(new File(dictionary));
				while(d.hasNextLine()) {
					dArray.add(d.nextLine());
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		//runs the compare method between our two file wordlist arrays
		List<String> misspelled = compare(tcArray, dArray); 
		System.out.println(misspelled);
	
		console.close();
	}

	public static <T> List<T> compare(List<T> tcArray, List<T> dArray) {
		Set<T> set = new HashSet<T>();
		
        set.addAll(tcArray);  //adds all words from the file toCheck
        set.removeAll(dArray);  //then removes all words that exist in the dictionary file

        return new ArrayList<T>(set); //this will leave us with only misspelled words
        
    }
	
}
