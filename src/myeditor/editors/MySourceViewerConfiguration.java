package myeditor.editors;


import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;

public class MySourceViewerConfiguration extends TextSourceViewerConfiguration {
	
	
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return new String[] {
				IDocument.DEFAULT_CONTENT_TYPE,
				MyPartitionScanner.JAVA_MULTILINE_COMMENT,
				MyPartitionScanner.JAVA_SINGLELINE_COMMENT
		};
	}
	
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {

//		MessageDialog.openInformation(
//				null,
//				"", //$NON-NLS-1$
//				"JavaEditorPlugin.getDefault() = "+JavaEditorPlugin.getDefault()); //$NON-NLS-1$
		MyEditorPlugin test = new MyEditorPlugin();
		MyColorProvider provider= test.getDefault().getJavaColorProvider();
		PresentationReconciler reconciler= new PresentationReconciler();
//		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
		
		DefaultDamagerRepairer dr= new DefaultDamagerRepairer(MyEditorPlugin.getDefault().getJavaCodeScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		NonRuleBasedDamagerRepairer ndr =
			new NonRuleBasedDamagerRepairer(
				new TextAttribute(provider.getColor(MyColorProvider.MULTI_LINE_COMMENT)));
//		dr= new DefaultDamagerRepairer(new SingleTokenScanner(new TextAttribute(provider.getColor(JavaColorProvider.MULTI_LINE_COMMENT))));
		reconciler.setDamager(ndr, MyPartitionScanner.JAVA_MULTILINE_COMMENT);
		reconciler.setRepairer(ndr, MyPartitionScanner.JAVA_MULTILINE_COMMENT);
		
		ndr =
			new NonRuleBasedDamagerRepairer(
				new TextAttribute(provider.getColor(MyColorProvider.SINGLE_LINE_COMMENT)));
//		dr= new DefaultDamagerRepairer(new SingleTokenScanner(new TextAttribute(provider.getColor(JavaColorProvider.MULTI_LINE_COMMENT))));
		reconciler.setDamager(ndr, MyPartitionScanner.JAVA_SINGLELINE_COMMENT);
		reconciler.setRepairer(ndr, MyPartitionScanner.JAVA_SINGLELINE_COMMENT);

		return reconciler;
	}
	
//	public String getConfiguredDocumentPartitioning(ISourceViewer sourceViewer) {
//		return JavaEditorPlugin.JAVA_PARTITIONING;
//	}
	
}
