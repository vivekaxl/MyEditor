package myeditor.editors;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.*;

/**
 * This scanner recognizes the JavaDoc comments and Java multi line comments.
 */
public class MyPartitionScanner extends RuleBasedPartitionScanner {

	public final static String JAVA_MULTILINE_COMMENT = "__java_multiline_comment"; //$NON-NLS-1$
	public final static String JAVA_SINGLELINE_COMMENT = "__java_singleline_comment"; //$NON-NLS-1$
//	public final static String[] JAVA_PARTITION_TYPES = new String[] { JAVA_MULTILINE_COMMENT };

	/**
	 * Detector for empty comments.
	 */
	static class EmptyCommentDetector implements IWordDetector {

		public boolean isWordStart(char c) {
			return (c == '/');
		}

		public boolean isWordPart(char c) {
			return (c == '*' || c == '/');
		}
	}
	
	static class WordPredicateRule extends WordRule implements IPredicateRule {
		
		private IToken fSuccessToken;
		
		public WordPredicateRule(IToken successToken) {
			super(new EmptyCommentDetector());
			fSuccessToken= successToken;
			addWord("/**/", fSuccessToken); //$NON-NLS-1$
		}
		
		public IToken evaluate(ICharacterScanner scanner, boolean resume) {
			return super.evaluate(scanner);
		}

		public IToken getSuccessToken() {
			return fSuccessToken;
		}
	}

	/**
	 * Creates the partitioner and sets up the appropriate rules.
	 */
	public MyPartitionScanner() {
		super();

		IToken linecomment= new Token(JAVA_SINGLELINE_COMMENT);
		IToken multicomment= new Token(JAVA_MULTILINE_COMMENT);

		List<IPredicateRule> rules= new ArrayList<IPredicateRule>();

		// Add rule for single line comments.
		rules.add(new EndOfLineRule("//", linecomment)); //$NON-NLS-1$
		// Add rules for multi-line comments.
		rules.add(new MultiLineRule("/*", "*/", multicomment/*, (char) 0, true*/)); //$NON-NLS-1$ //$NON-NLS-2$

		// Add rule for strings and character constants.
		rules.add(new SingleLineRule("\"", "\"", Token.UNDEFINED, '\\')); //$NON-NLS-2$ //$NON-NLS-1$
		rules.add(new SingleLineRule("'", "'", Token.UNDEFINED, '\\')); //$NON-NLS-2$ //$NON-NLS-1$

		// Add special case word rule.
//		rules.add(new WordPredicateRule(comment));

		IPredicateRule[] result= new IPredicateRule[rules.size()];
		result = rules.toArray(result);
		setPredicateRules(result);
	}
}

