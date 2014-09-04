package myeditor.editors;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

/**
 * A java aware white space detector.
 */
public class MyWhitespaceDetector implements IWhitespaceDetector {

	public boolean isWhitespace(char character) {
		return Character.isWhitespace(character);
	}
}
