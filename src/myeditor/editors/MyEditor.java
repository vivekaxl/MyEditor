package myeditor.editors;


import org.eclipse.ui.editors.text.TextEditor;

/**
 * Step 2
 * Add syntx coloring
 */
public class MyEditor extends TextEditor {

	public MyEditor()
	{
		super();
		//setSourceViewerConfiguration(new MySourceViewerConfig());
		setSourceViewerConfiguration(new MySourceViewerConfiguration());
				setDocumentProvider(new MyDocumentProvider());
	}
}

