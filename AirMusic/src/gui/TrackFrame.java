package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TrackFrame extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel foto=new JLabel("");
	
	public TrackFrame(){
		super(null);
		this.setBackground(new Color(60,60,60));
		int w,h;
		
		w = GUI.trans((new ImageIcon(GUI.class.getResource("/images/general/tracks.png"))).getIconWidth(),GUI.ratioW);
		h = GUI.trans((new ImageIcon(GUI.class.getResource("/images/general/tracks.png"))).getIconHeight(),GUI.ratioH);
		foto.setIcon(new ImageIcon(GUI.resize(GUI.class.getResource("/images/general/tracks.png"),w,h)));
		foto.setBounds(5, GUI.trans(565,GUI.ratioH), w, h);
		foto.setVisible(true);
		add(foto);
		
		
		
	}
	
	private class Track extends JPanel {

		private static final long serialVersionUID = 1L;
		
		private final int[][] colors={{240,110,170},{64,102,24},{0,54,99},{158,0,57},
									  {242,101,34},{237,28,36},{57,181,74},{223,14,114},{0,148,238}};
		
		private static final int PLAY=0;
		private static final int LOOP=1;
		private static final int PAUSE=2;
		private static final int STOP=3;
		private static final int REC=4;
		
		private int n;
		private int width;
		private int height;
		private float duracion;
		private int estado;
		
		private JLabel foto=new JLabel("");
		
		public Track(int n,int w, int h){
			super(null);
			this.n=n;
			width=w;
			height=h;
			this.setBackground(new Color(60,60,60));
			int h_bound=72+100*n;
			setBounds(16,h_bound,w,h);
			duracion=-1;
			estado=STOP;
			
			
		}
		
		@Override
	    public void paintComponent(Graphics g) {

	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;
			BasicStroke bs1 = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);
			g2d.setColor(new Color(68,68,68));
			g2d.setStroke(bs1);
			
			g2d.drawLine(0, 1, 1416, 1);
			for (int i = 1; i < 4; i++)
				g2d.drawLine(0, i*25, 1416, i*25);
			g2d.drawLine(0, 99, 1416,99);
			
			g2d.drawLine(1, 0, 1, 100);
			g2d.drawLine(7, 0, 7, 100);
			for (int i = 1; i <= 7; i++){
				g2d.drawLine(177*i-3, 0, 177*i-3, 100);
				g2d.drawLine(177*i+3, 0, 177*i+3, 100);
			}
			g2d.drawLine(1408, 0, 1408, 100);
			g2d.drawLine(1415, 0, 1415, 100);
			
			//g2d.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
			
			
			g2d.setColor(new Color(253,59,59));
			g2d.drawLine(265, 0, 265, 100);
			
	    }
		
		public void setEstado(int estado){
			this.estado=estado;
			repaint();
		}
		
		public void iniciar(int duracion, int estado){
			this.estado=estado;
			this.duracion=duracion;
			repaint();
		}
	}

}
