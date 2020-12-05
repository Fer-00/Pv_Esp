package trabalho_final_adriane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Lingua extends JFrame implements ActionListener
{
	private JLabel livro;
	private JRadioButton e;
	private JRadioButton p;
	private ButtonGroup lin;
	private JButton ok;
	private char lingua;

	public Lingua()
	{
		setLayout(new FlowLayout());

		livro = new JLabel("Livro de Receitas",SwingConstants.CENTER);
		add(livro);

		e = new JRadioButton("Español",SwingConstants.LEFT);
		p = new JRadioButton("Português",SwingConstants.RIGHT);
		add(e);
		add(p);

		lin = new ButtonGroup();
		lin.add(e);
		lin.add(p);

		e.addItemListener(new lingua("Libro de Cocina"));
		p.addItemListener(new lingua());
		
		ok = new JButton("Ok");
		ok.addActionListener(this);
	}

	private class lingua implements ItemListener
	{
		public lingua()
		{
			lingua = "p";
			add(ok,SwingConstants.RIGHT);
		}

		public lingua(String esp)
		{
			lingua = "e";
			livro.setText("Libro de Cocina");
			add(ok,SwingConstants.RIGHT);
		}
	}

	@Override
		public void ActionPerformed (ActionEvent evt)
		{
			Paises paises = new Paises(lingua);
			paises.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			paises.setSize(400,100);
			paises.setLocationRelativeTo(null);
			paises.setVisible(true);
			this.dispose();
		} 
}