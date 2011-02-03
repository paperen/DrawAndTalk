package cs2ts6.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * 
 * @author Ian Field
 * Creates the Canvas panel. This is a 640px x 480px white-background panel.
 * It includes a toolbar for drawing.
 */
public class DrawingPanel extends JPanel implements MouseMotionListener, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7531407885742074028L;
	private JButton brush, clear, brushSize;
	private JPanel canvas;
	//TODO Draw point using pointpacket
	//TODO Possible change 'canvas' to type Canvas
	public DrawingPanel(){
		JPanel panel = new JPanel(); //Panel with tooblar + canvas
		canvas = new JPanel(); //White area
		//canvas.setSize(new Dimension(640, 480));
		canvas.setPreferredSize(new Dimension(640, 480));
		JToolBar toolbar = new JToolBar();
		
		brush = new JButton("Brush");//TODO Add reflection for image
		brush.setToolTipText("Brush");
		brush.addActionListener(this);
		
		clear = new JButton("Clear");//TODO Add reflection for image
		clear.setToolTipText("Clear canvas");
		clear.setEnabled(false);//TODO Support teacher admin
		clear.addActionListener(this);
		
		brushSize = new JButton("Brush Size");//TODO Add reflection for image
		brushSize.setToolTipText("Brush size");
		brushSize.addActionListener(this);
		
		toolbar.setOrientation(1);//TODO Check vertical
		toolbar.add(brush);
		toolbar.add(brushSize);
		toolbar.add(clear);
		toolbar.setFloatable(false);
		
		canvas.setBackground(Color.WHITE);
		panel.add("West", toolbar);
		panel.add("East", canvas);
		add(panel);
	}
	
	/**
	 * Sends PointPacket for live authoring
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Send coordinate data + colour on move
		Point drawLoc = e.getPoint();
		System.out.println(drawLoc);
		//TODO Get colour
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == brush){
			//do something
		}
		
	}

}
