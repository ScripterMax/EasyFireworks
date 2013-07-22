package at.xer0.EasyFireworks.util;



public class Cryptex {
	
	//http://stackoverflow.com/questions/15999221/caesars-box-encryption-decryption-program
	
	public static String encrypt(String plaintext) {
	    // TODO put encryption code below this line
	    plaintext = plaintext.replaceAll("\\s+", "");// removes white space
	    plaintext = plaintext.toLowerCase();// converts capitol letters to lower
	    // case

	    char[] charArray = plaintext.toCharArray();
	    // takes individual characters from the arguments and puts them into an
	    // array

	    int x = charArray.length; // assigns the length of charArray to x
	    int y = 0;
	    while (y < x) {
	        ++y;
	        if ((y == Math.floor(y)) && y * y >= x) {
	        // tests if y is an integer
	        // increases y until it is an integer
	            break;
	        }// above code finds the the length of the sides of the box
	    }
	    char[][] box = new char[y][y];// creates a 2d array
	    int pos = 0;
	    for (int i = 0; i < box.length; i++) {
	        for (int j = 0; j < box[i].length; j++) {
	            if (pos < plaintext.length()) {
	                box[i][j] = plaintext.charAt(pos);
	                pos++;
	            // fills the array with the characters from the text to be
	            // encrypted
	            }
	        } 
	    }
	    String encrypted = "";
	    for (int i = 0; i < box.length; i++) {
	        for (int j = 0; j < box.length; j++) {
	            if (box[j][i] != 0) {// tells the program to ignore null values
	                encrypted += box[j][i];
	            }
	            // prints out the letters in the box by column
	        }

	    }
	    return encrypted;

	// Put encryption code above this line

	}

	public static String decrypt(String cyphertext) {
	    // TODO put decryption code below this line
	    cyphertext = cyphertext.replaceAll("\\s+", "");// removes white space
	    cyphertext = cyphertext.toLowerCase();// converts capitol letters to lower case

	    char[] charArray = cyphertext.toCharArray();
	    // takes individual characters from the arguments and puts them into an
	    // array

	    int x = charArray.length; // assigns the length of charArray to x
	    int y = 0;
	   while (y < x) {
	        ++y;
	        if ((y == Math.floor(y)) && y * y >= x) {
	            // tests if y is an integer
	            // increases y until it is an integer
	            break;
	        }// above code finds the the length of the sides of the box
	    }
	    char[][] box = new char[y][y];// creates a 2d array
	    int pos = 0;
	    for (int i = 0; i < box.length; i++) {
	        for (int j = 0; j < box[i].length; j++) {
	            if (pos < cyphertext.length()) {
	                box[i][j] = cyphertext.charAt(pos);
	                pos++;
	            }
	        }
	        // fills the array with the characters from the text to be
	        // encrypted
	    }
	    String decrypted = "";
	    for (int i = 0; i < box.length; i++) {
	        for (int j = 0; j < box[i].length; j++) {
	            if (box[j][i] != 0) {// tells the program to ignore null values
	                decrypted += box[j][i];
	                // prints out the letters in the box by column
	            }

	        }
	    }

	    return decrypted;
	    // Put decryption code above this line
	    }

}
