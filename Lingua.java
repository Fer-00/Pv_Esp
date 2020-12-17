import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Lingua extends JFrame implements ActionListener
{
	private JPanel fundo, centro, baixo;
	private JLabel livro, back;
	private JRadioButton e, p;
	private ButtonGroup lin;
	private JButton ok;
	public char lingua;

	public Lingua()
	{
		setLayout(new BorderLayout());

		fundo = new JPanel();
		fundo.setLayout(new BorderLayout());
		add(fundo);

		Icon couro = new ImageIcon(getClass().getResource("couro.jpeg"));
		back = new JLabel();
		back.setIcon(couro);
		fundo.add(back,BorderLayout.CENTER);

		centro = new JPanel(new BorderLayout());
		baixo = new JPanel(new BorderLayout());
		centro.setBorder(BorderFactory.createLineBorder(Color.RED));
		fundo.add(centro,BorderLayout.CENTER);
		fundo.add(baixo,BorderLayout.SOUTH);

		livro = new JLabel("Livro de Receitas");
		livro.setFont(new Font("Arial", Font.BOLD, 36));
		centro.add(livro,BorderLayout.CENTER);

		e = new JRadioButton("Español");
		e.setFont(new Font("Arial", Font.ITALIC, 14));
		p = new JRadioButton("Português");
		p.setFont(new Font("Arial", Font.ITALIC, 14));
		baixo.add(e,BorderLayout.WEST);
		baixo.add(p,BorderLayout.EAST);

		lin = new ButtonGroup();
		lin.add(e);
		lin.add(p);

		e.addItemListener(new lingua());
		p.addItemListener(new lingua());
		
		ok = new JButton("Ok");
		ok.setFont(new Font("Arial", Font.BOLD, 14));
		ok.addActionListener(this);
		baixo.add(ok,BorderLayout.SOUTH);
	}

	@Override
		public void actionPerformed (ActionEvent evt)
		{
			Paises paises = new Paises(lingua);
			paises.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			paises.setSize(500,650);
			paises.setLocationRelativeTo(null);
			paises.setVisible(true);
			this.dispose();
		}

	private class lingua implements ItemListener
	{
		public lingua()
		{
		}

		@Override
			public void itemStateChanged(ItemEvent event)
			{
				if (e.isSelected())
				{
					lingua = 'e';
					livro.setText("Libro de Cocina");
				}
				else
				{
					lingua = 'p';
					livro.setText("Livro de Receitas");
				}
			}

	}
}