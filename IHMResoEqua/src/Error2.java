import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
public class Error2 extends JFrame {
	JPanel pan = new JPanel();
	JLabel error = new JLabel("<html>La Valeurs de la precision doit <br>etre de l'ordre de 10<sup>-n</sup></html>");
		Error2()
		{
			this.setTitle("VALUE ERROR");
			this.setSize(300, 100);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setVisible(true);
			error.setBorder(BorderFactory.createLineBorder(Color.red));
			pan.add(error);
			this.setContentPane(pan);
		}
}
