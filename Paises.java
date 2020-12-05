import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Paises extends JFrame
{
	private JButton u, a, p, c, eq, es, cr, m; // Uruguai, Argentina, Paraguai, Chile, Equador, Espanha, Costa Rica e México
	
	Icon iu = new ImageIcon(getClass().getResource("U.png"));
	Icon ia = new ImageIcon(getClass().getResource("A.png"));
	Icon ip = new ImageIcon(getClass().getResource("P.png"));
	Icon ic = new ImageIcon(getClass().getResource("C.png"));
	Icon ieq = new ImageIcon(getClass().getResource("EQ.png"));
	Icon ies = new ImageIcon(getClass().getResource("E.png"));
	Icon icr = new ImageIcon(getClass().getResource("CR.png"));
	Icon im = new ImageIcon(getClass().getResource("M.png"));

	public Paises(char lingua)
	{
		setLayout(new FlowLayout());

		if (lingua == 'p')
		{
			u = new JButton("Uruguai",iu);
			u.addActionListener(new PPort());
			add(u);
			a = new JButton("Argentina",ia);
			a.addActionListener(new PPort());
			add(a);
			p = new JButton("Paraguai",ip);
			p.addActionListener(new PPort());
			add(p);
			c = new JButton("Chile",ic);
			c.addActionListener(new PPort());
			add(c);
			eq = new JButton("Equador",ieq);
			eq.addActionListener(new PPort());
			add(eq);
			es = new JButton("Espanha",ies);
			es.addActionListener(new PPort());
			add(es);
			cr = new JButton("Costa Rica",icr);
			cr.addActionListener(new PPort());
			add(cr);
			m = new JButton("México",im);
			m.addActionListener(new PPort());
			add(m);	
		}
		else if(lingua == 'e')
		{
			u = new JButton("Uruguay",iu);
			u.addActionListener(new PEsp());
			add(u);
			a = new JButton("Argentina",ia);
			a.addActionListener(new PEsp());
			add(a);
			p = new JButton("Paraguay",ip);
			p.addActionListener(new PEsp());
			add(p);
			c = new JButton("Chile",ic);
			c.addActionListener(new PEsp());
			add(c);
			eq = new JButton("Ecuador",ieq);
			eq.addActionListener(new PEsp());
			add(eq);
			es = new JButton("España",ies);
			es.addActionListener(new PEsp());
			add(es);
			cr = new JButton("Costa Rica",icr);
			cr.addActionListener(new PEsp());
			add(cr);
			m = new JButton("México",im);
			m.addActionListener(new PEsp());
			add(m);	
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Ocorreu um erro","Ocurrio un error",JOptionPane.WARNING_MESSAGE);
			this.setVisible(false);
			this.dispose();
		}
	}

	class PPort implements ActionListener
	{
		char pais;

		@Override
			public void actionPerformed(ActionEvent e)
			{
				if ( e.getSource() == u )
					pais = 'u';
    			else if ( e.getSource() == a )
    				pais = 'a';
    			else if ( e.getSource() == p )
    				pais = 'p';
    			else if ( e.getSource() == c )
    				pais = 'c';
    			else if ( e.getSource() == eq )
    				pais = 'q';
    			else if ( e.getSource() == es )
    				pais = 's';
    			else if ( e.getSource() == cr )
    				pais = 'r';
    			else
    				pais = 'm';

				dispose();
				Categorias cat = new Categorias('p',pais);
				cat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				cat.setSize(400,100);
				cat.setLocationRelativeTo(null);
				cat.setVisible(true);
			}
	}

	class PEsp implements ActionListener
	{
		char pais;

		@Override
			public void actionPerformed(ActionEvent e)
			{
				if ( e.getSource() == u )
					pais = 'u';
    			else if ( e.getSource() == a )
    				pais = 'a';
    			else if ( e.getSource() == p )
    				pais = 'p';
    			else if ( e.getSource() == c )
    				pais = 'c';
    			else if ( e.getSource() == eq )
    				pais = 'q';
    			else if ( e.getSource() == es )
    				pais = 's';
    			else if ( e.getSource() == cr )
    				pais = 'r';
    			else
    				pais = 'm';
				
				dispose();
				Categorias cat = new Categorias('e',pais);
				cat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				cat.setSize(400,100);
				cat.setLocationRelativeTo(null);
				cat.setVisible(true);
			}
	} 
}