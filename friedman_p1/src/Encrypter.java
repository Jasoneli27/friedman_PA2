

public class Encrypter {
	public static final int INT_LENGTH = 4;
	
	public static int[] encryptProcess(int[] array) {
		//Encrypts by adding 7, using the remainder of dividing by 10, swapping 1 and 3, then swapping 2 and 4
		for ( int i = 0 ; i < INT_LENGTH ; i++ ) {
			array[i] = (array[i] + 7) % 10;
		}
		
		array = Application.swap(array, 0, 2);
		
		array = Application.swap(array, 1, 3);
		
		return array;
	}
	
	public static int[] encrypt(int toEncrypt) {
		final int INT_LENGTH = 4;
		
		String temp = Integer.toString(toEncrypt);
		int[] encrypting = new int[INT_LENGTH];
		
		// Changes each digit of the integer into an integer array
		for ( int i = 0 ; i < temp.length() ; i++ ) {
			encrypting[i] = temp.charAt(i) - '0';
		}
		
		// This fixes an error when the first entered values are 0
		encrypting = Application.zerosFix(encrypting, toEncrypt);
		
		encrypting = encryptProcess(encrypting);
		
		return encrypting;
	}
}