package javaeditor;

import org.eclipse.ui.editors.text.TextEditor;

public class JavaEditor extends TextEditor{
//	private ColorManager colorManager;
	/*
	 *      plugin.xmlのeditorタグはicon属性も必須であることに注意する。
	 */

	public static final String EDITOR_ID = "javaeditor.JavaEditor"; //$NON-NLS-1$
	public JavaEditor() {
		super();
		setSourceViewerConfiguration(new JavaSourceViewerConfiguration());
		setDocumentProvider(new JavaDocumentProvider());
	}

	public void dispose() {
//		if (fOutlinePage != null)
//		fOutlinePage.setInput(null);
		super.dispose();
	}
}
