package io;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class FileIOTest {
	FileIO fileio = new FileIO();
	
	public static String resourcesPath = "src/test/resources/";
	
	@Test
	public void testReadFileValidInput() {
		int[] expectedNumbers = new int[] {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		String validInputFilepath = resourcesPath.concat("numbers_valid.txt");
		
		Assert.assertArrayEquals(expectedNumbers, fileio.readFile(validInputFilepath));
	}
	
	@Rule 
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testReadFileInexistentFileException() {
		String validInputFilepath = resourcesPath.concat("fake.txt");
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
		fileio.readFile(validInputFilepath);
	}
	
	@Test
	public void testReadFileEmptyFileException() {
		String validInputFilepath = resourcesPath.concat("empty_file.txt");
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
		fileio.readFile(validInputFilepath);
	}

}
