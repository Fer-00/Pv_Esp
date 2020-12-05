package trabalho_final_adriane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Categorias extends JFrame implements ActionListener
{
	private JButton d, s, r, o, b, a; // doces, salgados, refeições, sobremesas e bebidas e bebidas alcoolicas
	
	public Categorias(char lingua, char pais)
	{
		if (lingua == 'p')
		{
			r = new JButton("Refeições",SwingConstants.LEFT);
			r.addActionListener(new CPort());
			add(r);
			s = new JButton("Salgados",SwingConstants.LEFT);
			s.addActionListener(new CPort());
			add(s);
			b = new JButton("Bebidas",SwingConstants.LEFT);
			b.addActionListener(new CPort());
			add(b);
			o = new JButton("Sobremesas",SwingConstants.RIGHT);
			o.addActionListener(new CPort());
			add(o);
			d = new JButton("Doces",SwingConstants.RIGHT);
			d.addActionListener(new CPort());
			add(d);
			a = new JButton("Drinks",SwingConstants.RIGHT);
			a.addActionListener(new CPort());
			add(a);
		}
		else if (lingua == 'e')
		{
			r = new JButton("Comidas",SwingConstants.LEFT);
			r.addActionListener(new CPort());
			add(r);
			s = new JButton("Bocadillos",SwingConstants.LEFT);
			s.addActionListener(new CPort());
			add(s);
			b = new JButton("Bebidas",SwingConstants.LEFT);
			b.addActionListener(new CPort());
			add(b);
			o = new JButton("Postres",SwingConstants.RIGHT);
			o.addActionListener(new CPort());
			add(o);
			d = new JButton("Dulces",SwingConstants.RIGHT);
			d.addActionListener(new CPort());
			add(d);
			a = new JButton("Cócteles",SwingConstants.RIGHT);
			a.addActionListener(new CPort());
			add(a);
		}
		else
		{
			this.dispose();
			JOptionPane.showMessageDialog(null,"Ocorreu um erro // Ocurrio un error",JOptionPane.WARNING_MESSAGE);
		}

	}
}