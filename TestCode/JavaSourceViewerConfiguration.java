package javaeditor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;

public class JavaSourceViewerConfiguration extends TextSourceViewerConfiguration {
	
	
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return new String[] {
				IDocument.DEFAULT_CONTENT_TYPE,
				JavaPartitionScanner.JAVA_MULTILINE_COMMENT,
				JavaPartitionScanner.JAVA_SINGLELINE_COMMENT
		};
	}
	
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {

//		MessageDialog.openInformation(
//				null,
//				"", //$NON-NLS-1$
//				"JavaEditorPlugin.getDefault() = "+JavaEditorPlugin.getDefault()); //$NON-NLS-1$
		
		JavaColorProvider provider= JavaEditorPlugin.getDefault().getJavaColorProvider();
		PresentationReconciler reconciler= new PresentationReconciler();
//		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
		
		DefaultDamagerRepairer dr= new DefaultDamagerRepairer(JavaEditorPlugin.getDefault().getJavaCodeScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		NonRuleBasedDamagerRepairer ndr =
			new NonRuleBasedDamagerRepairer(
				new TextAttribute(provider.getColor(JavaColorProvider.MULTI_LINE_COMMENT)));
//		dr= new DefaultDamagerRepairer(new SingleTokenScanner(new TextAttribute(provider.getColor(JavaColorProvider.MULTI_LINE_COMMENT))));
		reconciler.setDamager(ndr, JavaPartitionScanner.JAVA_MULTILINE_COMMENT);
		reconciler.setRepairer(ndr, JavaPartitionScanner.JAVA_MULTILINE_COMMENT);
		
		ndr =
			new NonRuleBasedDamagerRepairer(
				new TextAttribute(provider.getColor(JavaColorProvider.SINGLE_LINE_COMMENT)));
//		dr= new DefaultDamagerRepairer(new SingleTokenScanner(new TextAttribute(provider.getColor(JavaColorProvider.MULTI_LINE_COMMENT))));
		reconciler.setDamager(ndr, JavaPartitionScanner.JAVA_SINGLELINE_COMMENT);
		reconciler.setRepairer(ndr, JavaPartitionScanner.JAVA_SINGLELINE_COMMENT);

		return reconciler;
	}
	
//	public String getConfiguredDocumentPartitioning(ISourceViewer sourceViewer) {
//		return JavaEditorPlugin.JAVA_PARTITIONING;
//	}
	
}
