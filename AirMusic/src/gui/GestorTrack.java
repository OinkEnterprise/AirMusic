package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GestorTrack extends Principal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Track> t;
	
	public GestorTrack(){
		super();
		t = new ArrayList<Track>();
		for (int i = 0; i < 9; i++){
			t.add(new Track(i,1416,100));
			t.get(i).setVisible(true);
			add(t.get(i));
		}
	}
	
	@Override
    public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
        Graphics2D g2d = (Graphics2D) g;
        int[] x = {256,260,252};
        int[] y = {972,976,968};
        g2d.setColor(new Color(253,59,59));
        Polygon p = new Polygon();
        p.addPoint( 272   , 980 );
        p.addPoint( 280 , 972   );
        p.addPoint( 288 ,980  );
        g2d.drawPolygon(p);
        g2d.fillPolygon(p);
        
        
        
        
	}
	
	
	private class Track extends JPanel {

		private static final long serialVersionUID = 1L;
		
		private final int[][] colors={{240,110,170},{64,102,24},{0,54,99},{158,0,57},
									  {242,101,34},{237,28,36},{57,181,74},{223,14,114},{0,148,238}};
		
		private static final int PLAY=0;
		private static final int LOOP=1;
		private static final int PAUSE=2;
		private static final int STOP=3;
		
		private int n;
		private int width;
		private int height;
		private float duracion;
		private int estado;
		
		public Track(int n,int w, int h){
			super(null);
			this.n=n;
			width=w;
			height=h;
			this.setBackground(new Color(35,35,35));
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
