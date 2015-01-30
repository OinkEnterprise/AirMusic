package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TrackFrame tracks;
	private GestorTrack gestor;
	private ProduccionMusical productor;
	
	
	private boolean gestorB; 
	private double ratio=0.23;
	protected static Dimension screenSize;
	protected static Dimension prinSize;
	protected static Dimension tracksSize;
	protected static double ratioW;
	protected static double ratioH;
	private static Random rand = new Random();

	
	protected static BufferedImage resize(URL path, int newW, int newH) {
		BufferedImage bufferedImage = loadImage(path.getPath());
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return bufim;
    }
	
	protected static BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return bufim;
    }
	
	private static BufferedImage loadImage(String pathName) {
        BufferedImage bimage = null;
        try {
            bimage = ImageIO.read(new File(pathName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bimage;
    }
	
	protected static int trans(double d, double ratio){
		return (int)Math.round(d*ratio);
	}
	
	
	
	
	
	
	private static BufferedImage colorImage(BufferedImage image, List<int[]> colors, int w, int h) {
		image = resize(image,w,h);
		int[] color = colors.get(rand.nextInt(colors.size()-1));
        int width = image.getWidth();
        int height = image.getHeight();
        WritableRaster raster = image.getRaster();

        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                pixels[0] = color[0];
                pixels[1] = color[1];
                pixels[2] = color[2];
                raster.setPixel(xx, yy, pixels);
            }
        }
        return image;
    }
	
	protected static void changeColorIcon(JLabel image, String file, List<int[]> colors,int w, int h){
		try {
			image.setIcon(new ImageIcon(colorImage(ImageIO.read(GUI.class.getResource(file)), colors,w,h)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected static void setVisibleTime(final JLabel image, long time, final boolean visible){
		image.setVisible(visible);
		Timer myTimer = new Timer();
		TimerTask task = new TimerTask(){
			@Override
			public void run() {
				image.setVisible(!visible);
			}
		};
		myTimer.schedule(task, time);
	}
	
	
	
	
	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		prinSize = new Dimension((int)Math.round(screenSize.width*(1-ratio)), screenSize.height);
		tracksSize = new Dimension((int)Math.round(screenSize.width*ratio), screenSize.height);
		ratioW = screenSize.width/1920.0;
		ratioH = screenSize.height/1080.0;
		
		setBounds(0, 0, screenSize.width, screenSize.height);
		
		
		gestor = new GestorTrack();
		productor = new ProduccionMusical();
		tracks = new TrackFrame();
		
		gestor.setBounds(tracksSize.width, 0, prinSize.width, prinSize.height);
		productor.setBounds(tracksSize.width, 0, prinSize.width, prinSize.height);
		tracks.setBounds(0, 0, tracksSize.width, tracksSize.height);
		
		gestorB=false;
		gestor.setVisible(gestorB);
		productor.setVisible(!gestorB);
		tracks.setVisible(true);
		
		
		getContentPane().setLayout(null);
		getContentPane().add(tracks);
		getContentPane().add(gestor);
		getContentPane().add(productor);
		
		
		
		
		
		//full screen
		GraphicsDevice device  = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		
		setVisible(false);
        //remove the frame from being displayable.
        dispose();
        //remove borders around the frame
        setUndecorated(true);
        //make the window fullscreen.
        device.setFullScreenWindow(this);
        setResizable(false);
        setAlwaysOnTop(false);
        //show the frame
        setVisible(true);
		
	}
	
	
	
	//Acciones principal
	public void cambiarPantalla(){
		gestorB=!gestorB;
		gestor.setVisible(gestorB);
		productor.setVisible(!gestorB);
		repaint();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//Acciones de producción musical
	public void playActL(){
		productor.playActL();
	}
	
	public void playActR(){
		productor.playActR();
	}
	
	
	
}