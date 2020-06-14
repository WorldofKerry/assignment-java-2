import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Questions {
    
	public static void main(String[] args) {

        int[] testArray = {2, 4, 5, 1, 3, 5, 4};
        int targetSum = 6;
        // Expected pairs are (to be printed on the console):
        // (2, 4)
        // (1, 5)
        findPairs(testArray, targetSum);
        
        System.out.println("radar" + ": " + isPalindrome("radar"));
        System.out.println("bob" + ": " + isPalindrome("bob"));
        System.out.println("asdfdsa" + ": " + isPalindrome("asdfdsa"));
//        System.out.println("ape" + ": " + isPalindrome("ape"));
//        System.out.println("" + ": " + isPalindrome("")); //hmmmmmmmm
//        System.out.println("sdf" + ": " + isPalindrome("sdf"));
//        System.out.println("iii" + ": " + isPalindrome("iii"));
        
    }
    
	static void findPairs(int[] testArray, int targetSum) {
		Set<String> set = new LinkedHashSet<String>();
        //checks for pairs
    	for (int index1 = 0; index1 < testArray.length-1; index1++) {
    		for (int index2 = index1+1; index2 < testArray.length; index2++) {
    			//System.out.println("(" + testArray[index1] + ", " + testArray[index2] + ")"); 
    			if ((testArray[index1] + testArray[index2] == targetSum)) {
    				//ensures the numbers in each pair is from least to greatest
    				if (testArray[index1] < testArray[index2]) {
    					//removes duplicates
    					set.add("(" + testArray[index1] + ", " + testArray[index2] + ")");
    				} else {
    					//removes duplicates
    					set.add("(" + testArray[index2] + ", " + testArray[index1] + ")");
    				}
    			}
    		}
    	}    	
    	for (String s : set) {
    		System.out.println(s);
    	}        
    }
	
    static boolean isPalindrome(String testString) {
    	String reversedString = "";
    	for (int i = 0; i < testString.length(); i++) {
    		reversedString += testString.charAt(testString.length()-1-i);
    	}
    	return testString.equals(reversedString);
    }

}  