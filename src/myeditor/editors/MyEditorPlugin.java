package myeditor.editors;

import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class MyEditorPlugin extends AbstractUIPlugin{
//	public final static String JAVA_PARTITIONING= "__java_editor_partitioning"; //$NON-NLS-1$

	private static MyEditorPlugin fgInstance;
	private MyColorProvider fColorProvider;
	private MyCodeScanner fCodeScanner;

	/**
	 * Creates a new plug-in instance.
	 */
	public MyEditorPlugin() {
		fgInstance= this;
	}

	/**
	 * Returns the default plug-in instance.
	 * 
	 * @return the default plug-in instance
	 */
	public static MyEditorPlugin getDefault() {
		return fgInstance;
	}

	/**
	 * Returns the singleton Java color provider.
	 * 
	 * @return the singleton Java color provider
	 */
	public MyColorProvider getJavaColorProvider() {
		if (fColorProvider == null)
			fColorProvider= new MyColorProvider();
		return fColorProvider;
	}

	/**
	 * Returns the singleton Java code scanner.
	 * 
	 * @return the singleton Java code scanner
	 */
	public RuleBasedScanner getJavaCodeScanner() {
		if (fCodeScanner == null)
			fCodeScanner= new MyCodeScanner(getJavaColorProvider());
		return fCodeScanner;
	}


}