package gui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ProduccionMusical extends Principal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<JLabel> sets;
	private JLabel actR=new JLabel("");
	private JLabel actL=new JLabel("");
	private JLabel actRp=new JLabel("");
	private JLabel actLp=new JLabel("");
	private JLabel botonera=new JLabel("");
	private List<int[]> colorsKick = new ArrayList();
	private List<int[]> colorsSnare = new ArrayList();
	
	public ProduccionMusical(){
		super();
		int w,h;
		/*
		sets = new ArrayList<JLabel>();
		w = GUI.trans((new ImageIcon(GUI.class.getResource("/images/produccion_musical/boton.png"))).getIconWidth(),GUI.ratioW);
		h = GUI.trans((new ImageIcon(GUI.class.getResource("/images/produccion_musical/boton.png"))).getIconHeight(),GUI.ratioH);
		for(int i = 0; i < 10; i++){
			sets.add(new JLabel(""));
			sets.get(i).setForeground(Color.WHITE);
			sets.get(i).setFont(new Font("Times New Roman", Font.PLAIN, 10));
			sets.get(i).setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/produccion_musical/boton.png"),w,h)));
			sets.get(i).setBounds((w+5)*i+30, GUI.trans(994,GUI.ratioH), 100, 100);
			sets.get(i).setVisible(true);
			this.add(sets.get(i));
		}*/
		
		w = GUI.trans((new ImageIcon(GUI.class.getResource("/images/produccion_musical/botonera.png"))).getIconWidth(),GUI.ratioW);
		h = GUI.trans((new ImageIcon(GUI.class.getResource("/images/produccion_musical/botonera.png"))).getIconHeight(),GUI.ratioH);
		botonera.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/produccion_musical/botonera.png"),w,h)));
		botonera.setBounds(5, GUI.trans(985,GUI.ratioH), w, h);
		botonera.setVisible(true);
		add(botonera);
		
		w = GUI.trans((new ImageIcon(GUI.class.getResource("/images/produccion_musical/zona_accion.png"))).getIconWidth(),GUI.ratioW);
		h = GUI.trans((new ImageIcon(GUI.class.getResource("/images/produccion_musical/zona_accion.png"))).getIconHeight(),GUI.ratioH);
		actR.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/produccion_musical/zona_accion.png"),w,h)));
		actR.setBounds(GUI.trans(242,GUI.ratioW), GUI.trans(724,GUI.ratioH), w, h);
		actR.setVisible(true);
		add(actR);
		
		actL.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/produccion_musical/zona_accion.png"),w,h)));
		actL.setBounds(GUI.trans(242,GUI.ratioW)+w+10, GUI.trans(724,GUI.ratioH), w, h);
		actL.setVisible(true);
		add(actL);
		
		actRp.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/produccion_musical/zona_accion.png"),w,h)));
		actRp.setBounds(GUI.trans(242,GUI.ratioW), GUI.trans(724,GUI.ratioH), w, h);
		actRp.setVisible(false);
		add(actRp);
		
		actLp.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/produccion_musical/zona_accion.png"),w,h)));
		actLp.setBounds(GUI.trans(242,GUI.ratioW)+w+10, GUI.trans(724,GUI.ratioH), w, h);
		actLp.setVisible(false);
		add(actLp);
		
		
		
		//Colors
				colorsKick.add(new int[]{255,0,30});
				colorsKick.add(new int[]{255,0,50});
				colorsKick.add(new int[]{255,0,70});
				colorsKick.add(new int[]{255,0,90});
				colorsKick.add(new int[]{255,0,110});
				colorsKick.add(new int[]{255,0,130});
				
				colorsSnare.add(new int[]{0,50,250});
				colorsSnare.add(new int[]{0,70,250});
				colorsSnare.add(new int[]{0,90,250});
				colorsSnare.add(new int[]{0,110,250});
				colorsSnare.add(new int[]{0,130,250});
				colorsSnare.add(new int[]{0,150,250});
				colorsSnare.add(new int[]{0,170,250});
				colorsSnare.add(new int[]{0,190,250});
		
	}
	

	public void playActL(){
		int w,h;
		w = GUI.trans((new ImageIcon(GUI.class.getResource("/images/produccion_musical/zona_accion.png"))).getIconWidth(),GUI.ratioW);
		h = GUI.trans((new ImageIcon(GUI.class.getResource("/images/produccion_musical/zona_accion.png"))).getIconHeight(),GUI.ratioH);
		GUI.changeColorIcon(actLp, "/images/produccion_musical/zona_accion.png", colorsSnare,w,h);
		GUI.setVisibleTime(actL, 500, false);
		GUI.setVisibleTime(actLp, 500, true);
	}
	
	public void playActR(){
		int w,h;
		w = GUI.trans((new ImageIcon(GUI.class.getResource("/images/produccion_musical/zona_accion.png"))).getIconWidth(),GUI.ratioW);
		h = GUI.trans((new ImageIcon(GUI.class.getResource("/images/produccion_musical/zona_accion.png"))).getIconHeight(),GUI.ratioH);
		GUI.changeColorIcon(actRp, "/images/produccion_musical/zona_accion.png", colorsKick,w,h);
		GUI.setVisibleTime(actR, 500, false);
		GUI.setVisibleTime(actRp, 500, true);
	}

}
