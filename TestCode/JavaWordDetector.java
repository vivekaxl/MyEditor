package javaeditor;

import org.eclipse.jface.text.rules.IWordDetector;

/**
 * A Java aware word detector.
 */
public class JavaWordDetector implements IWordDetector {

	public boolean isWordPart(char character) {
		return Character.isJavaIdentifierPart(character);
	}
	
	public boolean isWordStart(char character) {
		return Character.isJavaIdentifierStart(character);
	}
}

