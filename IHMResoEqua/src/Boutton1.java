import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Boutton1 extends JButton implements MouseListener {
	private String name;
	GradientPaint gp;
	public Boutton1(String str){
	super(str);
	this.name = str;
 gp = new GradientPaint(0, 0,Color.BLUE, 0, 20, Color.CYAN, true);
	this.addMouseListener(this);	
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, this.getWidth(),this.getHeight());
		Font font = new Font("Comics Sans MS", Font.BOLD,15);
		g2d.setFont(font);
		g2d.setColor(Color.white);
		g2d.drawString(this.name, this.getWidth()/10, this.getHeight()/2+5);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		gp = new GradientPaint(0, 0,Color.BLUE, 0, 20, Color.BLUE, true);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		gp = new GradientPaint(0, 0,Color.BLUE, 0, 20, Color.CYAN, true);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		gp = new GradientPaint(0, 0,Color.BLUE, 0, 20, Color.PINK, true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		gp = new GradientPaint(0, 0,Color.BLUE, 0, 20, Color.CYAN, true);
	}

}
