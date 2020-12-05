package trabalho_final_adriane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Categorias extends JFrame
{
	private JButton d, s, r, o, b, a; // doces, salgados, refeições, sobremesas e bebidas e bebidas alcoolicas
	public char pais;
	
	public Categorias(char lingua, char aux)
	{
		setLayout(new FlowLayout());

		pais = aux;
		if (lingua == 'p')
		{
			r = new JButton("Refeições");
			r.addActionListener(new CPort());
			add(r);
			s = new JButton("Salgados");
			s.addActionListener(new CPort());
			add(s);
			b = new JButton("Bebidas");
			b.addActionListener(new CPort());
			add(b);
			o = new JButton("Sobremesas");
			o.addActionListener(new CPort());
			add(o);
			d = new JButton("Doces");
			d.addActionListener(new CPort());
			add(d);
			a = new JButton("Coquetéis");
			a.addActionListener(new CPort());
			add(a);
		}
		else if (lingua == 'e')
		{
			r = new JButton("Comidas");
			r.addActionListener(new CPort());
			add(r);
			s = new JButton("Bocadillos");
			s.addActionListener(new CPort());
			add(s);
			b = new JButton("Bebidas");
			b.addActionListener(new CPort());
			add(b);
			o = new JButton("Postres");
			o.addActionListener(new CPort());
			add(o);
			d = new JButton("Dulces");
			d.addActionListener(new CPort());
			add(d);
			a = new JButton("Cócteles");
			a.addActionListener(new CPort());
			add(a);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Ocorreu um erro","Ocurrio un error",JOptionPane.WARNING_MESSAGE);
			this.setVisible(false);
			this.dispose();
		}

	}

	class CPort implements ActionListener
	{ 
		char cat;

		@Override
			public void actionPerformed(ActionEvent e)
			{
				if ( e.getSource() == r )
					cat = 'r';
    			else if ( e.getSource() == o )
    				cat = 'o';
    			else if ( e.getSource() == s )
    				cat = 's';
    			else if ( e.getSource() == d )
    				cat = 'd';
    			else if ( e.getSource() == b )
    				cat = 'b';
    			else
    				cat = 'a';
				
				//Receitas rec = new Receitas('p',cat);
				//rec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				//rec.setSize(400,100);
				//rec.setLocationRelativeTo(null);
				//rec.setVisible(true);
				//this.setVisible(false);
				//this.dispose();
			}
	}

	class CEsp implements ActionListener
	{
		char cat;

		@Override
			public void actionPerformed(ActionEvent e)
			{
				if ( e.getSource() == r )
					cat = 'r';
    			else if ( e.getSource() == o )
    				cat = 'o';
    			else if ( e.getSource() == s )
    				cat = 's';
    			else if ( e.getSource() == d )
    				cat = 'd';
    			else if ( e.getSource() == b )
    				cat = 'b';
    			else
    				cat = 'a';

				//Receitas rec = new Receitas('e',cat);
				//rec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				//rec.setSize(400,100);
				//rec.setLocationRelativeTo(null);
				//rec.setVisible(true);
				//this.setVisible(false);
				//this.dispose();
			}
	}
}