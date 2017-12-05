/**
 * Purpose: Data Structure and Algorithms Fall 2017 Final Project
 * Status: Complete and throughly tested
 * Last Update: 12/4/17
 * Submitted: 12/5/17
 * Comment: Test suite and sample run attached
 * @author Tapan Soni
 * @author John Stranahan
 * @version 2017.4.12
 */

public interface AscendinglyOrderedStringListInterface 
{
	boolean isEmpty();
	int size();
	void add(String item) throws ListIndexOutOfBoundsException;
	String get(int index) throws ListIndexOutOfBoundsException;
	void remove(int index) throws ListIndexOutOfBoundsException;
	int search(String item);
	void clear();
} // END AscendinglyOrderedStringListInterface {}
