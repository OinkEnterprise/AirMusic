package gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Principal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JLabel borde = new JLabel("");
	public JLabel logo = new JLabel("");
	public JLabel pantallas = new JLabel("");
	public JButton settings;
	public JButton exit;
	
	public Principal(){
		super(null);
		int w,h;
		this.setBackground(new Color(35,35,35));
		
		borde.setBounds(0, 0, 10, GUI.screenSize.height);
		borde.setIcon(new ImageIcon(GUI.class.getResource("/images/tracks/borde.png")));
		borde.setVisible(true);
		
		w=GUI.trans(120, GUI.ratioW);
		h=GUI.trans(46, GUI.ratioH);
		logo.setBounds(GUI.prinSize.width-w, GUI.prinSize.height-h, w, h);
		logo.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/logo.png"),w,h)));
		logo.setVisible(true);
		
		
		w=GUI.trans(140, GUI.ratioW);
		h=GUI.trans(53, GUI.ratioH);
		pantallas.setBounds(15, 2, w, h);
		pantallas.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/cambiarPant.png"),w,h)));
		pantallas.setVisible(true);
		
		w=GUI.trans(24, GUI.ratioW);
		h=GUI.trans(36, GUI.ratioH);
		JButton exit = new JButton("");
		exit.setBounds(GUI.prinSize.width-w-10, 5, w, h);
		exit.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/exit.png"),w,h)));
		exit.setOpaque(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		
		
		int wa=GUI.trans(24, GUI.ratioW);
		w=GUI.trans(41, GUI.ratioW);
		h=GUI.trans(42, GUI.ratioH);
		JButton settings = new JButton("");
		settings.setBounds(GUI.prinSize.width-w-wa-15, 2, w, h);
		settings.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/settings.png"),w,h)));
		//settings.setIcon(new ImageIcon(GUI.class.getResource("/images/general/settings.png")));
		settings.setOpaque(false);
		settings.setContentAreaFilled(false);
		settings.setBorderPainted(false);
		
		exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
		

		this.add(borde);
		this.add(logo);
		this.add(pantallas);
		add(settings);
		add(exit);
	}
	

}
