package view;

import java.awt.Color;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class TopToolbar extends JToolBar {
	
	private JButton openMaps;
	private JButton openWiki;
	private JButton info;
	
	public TopToolbar() {
		openMaps = new JButton("Mappe");
		openWiki = new JButton("Manuale");
		info = new JButton("Info");
		
		this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		this.add(openMaps);
		this.add(openWiki);
		this.add(info);
		initListeners();
	}
	
	private void initListeners() {
		this.openMaps.addActionListener(e -> {
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			    try {
					Desktop.getDesktop().browse(new URI("https://www.google.it/maps"));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public JButton getMapsBtn() {
		return openMaps;
	}

	public JButton getWikiBtn() {
		return openWiki;
	}

	public JButton getInfoBtn() {
		return info;
	}
	
}
