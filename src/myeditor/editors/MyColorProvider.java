package myeditor.editors;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class MyColorProvider {
	public static final RGB MULTI_LINE_COMMENT = new RGB(128, 128, 255);
	public static final RGB SINGLE_LINE_COMMENT = new RGB(64, 128, 64);
	public static final RGB KEYWORD = new RGB(128, 0, 0);
	public static final RGB TYPE = new RGB(0, 128, 0);
	public static final RGB STRING = new RGB(0, 0, 192);
	public static final RGB DEFAULT = new RGB(0, 0, 0);

	protected Map<RGB, Color> fColorTable= new HashMap<RGB, Color>(6);

	/**
	 * Release all of the color resources held onto by the receiver.
	 */	
	public void dispose() {
		Iterator<Color> e= fColorTable.values().iterator();
		while (e.hasNext())
			 e.next().dispose();
	}
	
	/**
	 * Return the color that is stored in the color table under the given RGB
	 * value.
	 * 
	 * @param rgb the RGB value
	 * @return the color stored in the color table for the given RGB value
	 */
	public Color getColor(RGB rgb) {
		Color color= fColorTable.get(rgb);
		if (color == null) {
			color= new Color(Display.getCurrent(), rgb);
			fColorTable.put(rgb, color);
		}
		return color;
	}

}
