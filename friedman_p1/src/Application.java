/*
 * First it ask the user to enter 1 or 2 to encrypt or decrypt, making them retry if nether are entered
 * Then it prompt them to enter a four-digit integer
 * Then based on whether they entered 1 or 2 the program calls Encrypter.encrypt or Decrypter.decrypt
 * Finally it prints out the returned array
 */

import java.util.Scanner;

public class Application {
	public static int[] swap(int[] array, int place1, int place2) {
		int temp;
		
		temp = array[place1];
		array[place1] = array[place2];
		array[place2] = temp;
		
		return array;
	}
	
	public static int[] zerosFix(int[] array, int determiningValue) {
		if (determiningValue < 999) {
			array = Application.swap(array, 2, 3);
			array = Application.swap(array, 1, 2);
			array = Application.swap(array, 0, 1);
		}
		
		if (determiningValue < 99) {
			array = Application.swap(array, 2, 3);
			array = Application.swap(array, 1, 2);
		}
		
		if (determiningValue < 9) {
			array = Application.swap(array, 2, 3);
		}
		
		return array;
	}
	
	public static void printArray(int[] array) {
		for (int i = 0 ; i < array.length ; i++ ) {
			System.out.print(array[i]);
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int encryptionSelector;
		
		do {
			System.out.print("Enter 1 to encrypt\nEnter 2 to decrypt\n");
			
			encryptionSelector = in.nextInt();
			
			if (encryptionSelector != 1 && encryptionSelector != 2) {
				System.out.print("Invalid entry. Enter a 1 or a 2.\n\n");
			}
		} while(encryptionSelector != 1 && encryptionSelector != 2);
		
		if (encryptionSelector == 1) {
			int toEncrypt;
			
			System.out.print("Enter four-digit integer to encrypt: ");
			
			toEncrypt = in.nextInt();
			
			System.out.print("The encrypted number is: ");
			
			printArray(Encrypter.encrypt(toEncrypt));
		} else {
			int toDecrypt;
			
			System.out.print("Enter four-digit interger to decrypt: ");
			
			toDecrypt = in.nextInt();
			
			System.out.print("The decrypted number is: ");
			
			printArray(Decrypter.decrypt(toDecrypt));

		}
		
		in.close();
	}
}