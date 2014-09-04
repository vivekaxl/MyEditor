package javaeditor;

import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.ui.plugin.AbstractUIPlugin;


public class JavaEditorPlugin extends AbstractUIPlugin{
//	public final static String JAVA_PARTITIONING= "__java_editor_partitioning"; //$NON-NLS-1$

	private static JavaEditorPlugin fgInstance;
	private JavaColorProvider fColorProvider;
	private JavaCodeScanner fCodeScanner;

	/**
	 * Creates a new plug-in instance.
	 */
	public JavaEditorPlugin() {
		fgInstance= this;
	}

	/**
	 * Returns the default plug-in instance.
	 * 
	 * @return the default plug-in instance
	 */
	public static JavaEditorPlugin getDefault() {
		return fgInstance;
	}

	/**
	 * Returns the singleton Java color provider.
	 * 
	 * @return the singleton Java color provider
	 */
	public JavaColorProvider getJavaColorProvider() {
		if (fColorProvider == null)
			fColorProvider= new JavaColorProvider();
		return fColorProvider;
	}

	/**
	 * Returns the singleton Java code scanner.
	 * 
	 * @return the singleton Java code scanner
	 */
	public RuleBasedScanner getJavaCodeScanner() {
		if (fCodeScanner == null)
			fCodeScanner= new JavaCodeScanner(getJavaColorProvider());
		return fCodeScanner;
	}
}
