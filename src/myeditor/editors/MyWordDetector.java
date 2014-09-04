package myeditor.editors;

import org.eclipse.jface.text.rules.IWordDetector;

/**
 * A Java aware word detector.
 */
public class MyWordDetector implements IWordDetector {

	public boolean isWordPart(char character) {
		return Character.isJavaIdentifierPart(character);
	}
	
	public boolean isWordStart(char character) {
		return Character.isJavaIdentifierStart(character);
	}
}
