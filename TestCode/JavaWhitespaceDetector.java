package javaeditor;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

/**
 * A java aware white space detector.
 */
public class JavaWhitespaceDetector implements IWhitespaceDetector {

	public boolean isWhitespace(char character) {
		return Character.isWhitespace(character);
	}
}

