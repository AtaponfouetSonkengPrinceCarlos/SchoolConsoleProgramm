import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.GradientPaint;

public class Panneau2 extends JPanel {
	public void paintComponent(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getWidth());
		Graphics2D g2d = (Graphics2D)g;
		GradientPaint gp = new GradientPaint(0, 0,Color.pink, 30, 30, Color.blue, true);
		g2d.setPaint(gp);
		Font font = new Font("Comics Sans MS", Font.BOLD,25);
		g2d.setFont(font);
	}
}
