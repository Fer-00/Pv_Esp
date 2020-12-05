package trabalho_final_adriane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Paises extends JFrame implements ActionListener
{
	private JButton u, a, p, c, eq, es, cr, m; // Uruguai, Argentina, Paraguai, Chile, Equador, Espanha, Costa Rica e México
	
	Icon iu = new ImageIcon(getClass().getResource("U.png"));
	Icon ia = new ImageIcon(getClass().getResource("A.png"));
	Icon ip = new ImageIcon(getClass().getResource("P.png"));
	Icon ic = new ImageIcon(getClass().getResource("C.png"));
	Icon ieq = new ImageIcon(getClass().getResource("EQ.png"));
	Icon ies = new ImageIcon(getClass().getResource("E.png"));
	Icon icr = new ImageIcon(getClass().getResource("CR.png"));
	Icon im = new ImageIcon(getClass().getResource("ME.png"));

	public Paises(char lingua)
	{
		setLayout(new FlowLayout());

		if (lingua == "p")
		{
			u = new JButton("Uruguai",iu,SwingConstants.LEFT);
			a = new JButton("Argentina",ia,SwingConstants.LEFT);
			p = new JButton("Paraguai",ip,SwingConstants.LEFT);
			c = new JButton("Chile",ic,SwingConstants.LEFT);
			eq = new JButton("Equador",ieq,SwingConstants.RIGHT);
			es = new JButton("Espanha",ies,SwingConstants.RIGHT);
			cr = new JButton("Costa Rica",icr,SwingConstants.RIGHT);
			m = new JButton("México",im,SwingConstants.RIGHT);	
		}
		else
		{
			u = new JButton("Uruguay",iu,SwingConstants.LEFT);
			a = new JButton("Argentina",ia,SwingConstants.LEFT);
			p = new JButton("Paraguay",ip,SwingConstants.LEFT);
			c = new JButton("Chile",ic,SwingConstants.LEFT);
			eq = new JButton("Ecuador",ieq,SwingConstants.RIGHT);
			es = new JButton("España",ies,SwingConstants.RIGHT);
			cr = new JButton("Costa Rica",icr,SwingConstants.RIGHT);
			m = new JButton("México",im,SwingConstants.RIGHT);	
		}
	}

	@Override
		public void ActionPerformed (ActionEvent evt)
		{
			 = new ();
			.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			.setSize(400,100);
			.setLocationRelativeTo(null);
			.setVisible(true);
			this.dispose();
		} 
}