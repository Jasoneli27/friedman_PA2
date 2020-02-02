

public class Decrypter {
	public static final int INT_LENGTH = 4;
	
	public static int[] decryptProcess(int[] array) {
		//Decrypts by adding 3, using the remainder of dividing by 10, swapping 1 and 3, then swapping 2 and 4
		for ( int i = 0 ; i < INT_LENGTH ; i++ ) {
			array[i] = (array[i] + 3) % 10;
		}
		
		array = Application.swap(array, 0, 2);
		
		array = Application.swap(array, 1, 3);
		
		return array;
	}
	
 	public static int[] decrypt(int toDecrypt) {
		
		String temp = Integer.toString(toDecrypt);
		int[] decrypting = new int[INT_LENGTH];
		
		// Changes each digit of the integer into an integer array
		for ( int i = 0 ; i < temp.length() ; i++ ) {
			decrypting[i] = temp.charAt(i) - '0';
		}
		
		// The if statements fix an error when the first entered values are 0
		decrypting = Application.zerosFix(decrypting, toDecrypt);
		
		decrypting = decryptProcess(decrypting);
		
		return decrypting;
		
	}
}