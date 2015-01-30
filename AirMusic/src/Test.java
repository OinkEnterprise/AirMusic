import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import com.leapmotion.leap.*;

import gui.GUI;


class SampleListener extends Listener{
	private boolean S = false;

	private boolean pomI = false;
	private boolean pomD = false;
	GUI gui;
	
	AudioClip sonidoKickSoft = Applet.newAudioClip(getClass()
			.getResource("/Kick_soft.wav"));
	AudioClip sonidoKickHard = Applet.newAudioClip(getClass()
			.getResource("/Kick_hard.wav"));
	AudioClip sonidoSnareSoft = Applet.newAudioClip(getClass().getResource(
			"/Snare_soft.wav"));
	AudioClip sonidoSnareHard = Applet.newAudioClip(getClass().getResource(
			"/Snare_hard.wav"));

	
	MIDIt current = new MIDIt();
	Integer Set = new Integer(1);
	KeyListenerS kl = new KeyListenerS(Set);
	float y = 0;
	float x = 0;
	
    public void onConnect(Controller controller) {
        //System.out.println("Connected");
        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
        controller.config().setFloat("Gesture.Swipe.MinLength", 200.0f);
        controller.config().setFloat("Gesture.Swipe.MinVelocity", 750f);
        controller.config().save();
        gui = new GUI();
        kl = new KeyListenerS(Set);
        gui.addKeyListener(kl);
    }
    

    public void onFrame(Controller controller) {
    	 Frame frame = controller.frame();
         long timeStamp = frame.timestamp();
         //FingerList extendedFingerList = frame.fingers().extended();
         
         boolean S2;
         if(!S) S=swipe(frame);
	        else{
	        	S2=swipe(frame);
	        	if(!S2){
	        		gui.cambiarPantalla();
	        		S=!S;
	        		if(Set.equals(1)) Set=2;
	        		else Set=1;
	        	}
	        }
	        
         if(Set.equals(1)){
         if(controller.frame().hands().count() == 1){
	          Hand hand = controller.frame().hands().get(0);
	         
	         boolean tambor = formaMano(hand);
	         int pos = posicionMano(hand); 
	         
	        /*
	        boolean tambor = formaMano(hand);
	        int pos = posicionMano(hand);
	        boolean hola = gesto(hand);*/
	       
	        boolean pomI2;
	        
	        if(!pomI) pomI=tamborIzq(hand);
	        else{
	        	pomI2=tamborIzq(hand);
	        	if(!pomI2){
	        		gui.playActL();
	        		sonidoKickHard.play();
	        		pomI=!pomI;
	        	}
	        }
	        
	        
	        boolean pomD2;
	        
	        if(!pomD) pomD=tamborDcha(hand);
	        else{
	        	pomD2=tamborDcha(hand);
	        	if(!pomD2){
	        		//gui.cambiarPantalla();
	        		gui.playActR();
	        		sonidoSnareHard.play();
	        		pomD=!pomD;
	        	}
	        }     
         }else{
        	 Hand hand1 = controller.frame().hands().get(0);
        	 Hand hand2 = controller.frame().hands().get(1);
	         
	         boolean tambor1 = formaMano(hand1);
	         boolean tambor2 = formaMano(hand2);
	         int posIzq = posicionMano(hand1); 
	         int posDer = posicionMano(hand2);
	         
	        /*
	        boolean tambor = formaMano(hand);
	        int pos = posicionMano(hand);
	        boolean hola = gesto(hand);*/
	       
	        boolean pomI2;
	        
	        if(!pomI) pomI=tamborIzq(hand1);
	        else{
	        	pomI2=tamborIzq(hand1);
	        	if(!pomI2){
	        		gui.playActL();
	        		sonidoKickHard.play();
	        		pomI=!pomI;
	        	}
	        }
	        
	        
	        boolean pomD2;
	        
	        if(!pomD) pomD=tamborDcha(hand2);
	        else{
	        	pomD2=tamborDcha(hand2);
	        	if(!pomD2){
	        		//gui.cambiarPantalla();
	        		gui.playActR();
	        		sonidoSnareHard.play();
	        		pomD=!pomD;
	        	}
	        }     
         }
         }
         else{
        	 //frame = controller.frame();
             
             if (!frame.hands().isEmpty()) {

                 // Get the first hand
                 Hand hand = frame.hands().get(0);

     //Get hand position
     Vector a = hand.palmPosition();
     float vertical   = a.getY();

     float horizontal = a.getX();

     //if(vertical != y){
         y = a.getY();
                 current.p = (int) y;

         if (y > 1269)
         {
             current.p = 1270;
         }

         else if (y < 1)
         {
             current.p = 0;
         }

         else
         {
         current.p = (int) y;
         }
     //}

     //if(horizontal != x){
     //current.increaseV();

         x=a.getX();
         current.v = (int) x;

                if (x > 127 )
                 {
                     current.v = 127;
                 }

                 else if (x < 0)
                 {
                     current.v = 0;
                 }

                 else
                 {
                     current.v = (int) y;
                 }
     //}


     //if(horizontal < x){
     //current.decreaseV();
     //x=horizontal;
     //dot.panel.moveDot(x, y);
     //}
     }
         }
    }
    
    
    public boolean formaMano(Hand hand){
    	boolean correcto = false;
        FingerList extendedFingerList = hand.fingers().extended(); 
        if(extendedFingerList.count() == 1 && extendedFingerList.get(0).type() == Finger.Type.TYPE_INDEX){
        	correcto = true;
        }else if(extendedFingerList.count() == 2 &&
        		(extendedFingerList.get(0).type() == Finger.Type.TYPE_INDEX || extendedFingerList.get(1).type() == Finger.Type.TYPE_INDEX) &&
        		(extendedFingerList.get(0).type() == Finger.Type.TYPE_THUMB || extendedFingerList.get(1).type() == Finger.Type.TYPE_THUMB)){
        	correcto = true;
        }else {
        	correcto = false;
        }
        
        return correcto;
    }
    
    public int posicionMano(Hand hand){
    	int pos = 0; // 0 para izquierda, 1 para derecha.
    	
    	if(hand.palmPosition().getX() <= 0){
    		pos = 1;
    	}else{
    		pos = 0;
    	}
    	
    	return pos;
    }
    
    public boolean tamborIzq(Hand hand){
    	boolean hecho = false;
    	
    	boolean tambor = formaMano(hand);
        int pos = posicionMano(hand);
    	
    	if (hand.palmPosition().getY() < 150){
    		hecho = true;
    	}else{
    		hecho = false;
    	}
    	
    	if (tambor && pos == 0 && hecho){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public boolean tamborDcha(Hand hand){
    	boolean hecho = false;
    	
    	boolean tambor = formaMano(hand);
        int pos = posicionMano(hand);
    	
    	if (hand.palmPosition().getY() < 150){
    		hecho = true;
    	}else{
    		hecho = false;
    	}
    	
    	if (tambor && pos == 1 && hecho){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    
    public boolean swipe(Frame frame){
    	if(frame.hands().get(0).fingers().extended().count() >= 3){
		    for(Gesture gesture : frame.gestures()){
		        if(gesture.type() == Gesture.Type.TYPE_SWIPE)
		        	return true;
		    }
    	}
		return false;
		
    
    }
    
    
    
    
    
}

class KeyListenerS implements KeyListener{
	
	Integer Set;
	
	public KeyListenerS(Integer s){
		Set=s;
	}
	
	@Override
    public void keyTyped(KeyEvent e) {
    	// TODO Auto-generated method stub
    	if(e.getKeyChar()=='1' || e.getKeyChar()=='2'){
    		Set = new Integer(e.getKeyChar());
    	}
    	System.out.println("Que pasa:" + Set);
    	
    }
    @Override
    public void keyPressed(KeyEvent e) {
    	if(e.getKeyChar()=='1' || e.getKeyChar()=='2'){
    		Set = new Integer(e.getKeyChar());
    	}
    	System.out.println("Que pasa:" + Set);
    	
    }
    @Override
    public void keyReleased(KeyEvent e) {
    	
    	
    }
	
}







class Sample {
    public static void main(String[] args) {
    	
    	
        // Create a sample listener and controller
        SampleListener listener = new SampleListener();
        Controller controller = new Controller();
        
        // Have the sample listener receive events from the controller
        controller.addListener(listener);
        
        MIDIt dude = listener.current;

        Thread midi = new Thread(dude);
        midi.start();
        /*Thread otroT = new Thread(otro);
        otroT.start();*/
        
        
        
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        listener.gui.setVisible(true);

        // Keep this process running until Enter is pressed
        //System.out.println("Press Enter to quit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Remove the sample listener when done
        controller.removeListener(listener);
    }
}
