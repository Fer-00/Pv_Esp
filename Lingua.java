import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class Lingua extends JFrame implements ActionListener
{
	private JPanel fundo, centro, baixo;
	private JLabel livro, back;
	private final JRadioButton e, p;
	private final ButtonGroup lin;
	private final JButton ok;
	public char lingua;

	public Lingua(){
		Lingua lin = new Lingua(1);
		lin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		lin.setSize(500,650);
		lin.setResizable(false);
		lin.setLocationRelativeTo(null);
		lin.setVisible(true);	
	}

	public Lingua(int um)
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
		baixo = new JPanel(new BorderLayout());fundo.add(centro,BorderLayout.CENTER);
		fundo.add(baixo,BorderLayout.SOUTH);

		livro = new JLabel("Livro de Receitas");
		livro.setFont(new Font("Arial", Font.BOLD, 36));
		livro.setBorder(new EmptyBorder(0, 70, 0, 60));
		centro.add(livro,BorderLayout.CENTER);

		e = new JRadioButton("Español");
		e.setFont(new Font("Arial", Font.ITALIC, 14));
		e.setBorder(new EmptyBorder(35, 35, 35, 35));
		p = new JRadioButton("Português");
		p.setFont(new Font("Arial", Font.ITALIC, 14));
		p.setBorder(new EmptyBorder(35, 35, 35, 35));
		baixo.add(e,BorderLayout.WEST);
		baixo.add(p,BorderLayout.EAST);

		lin = new ButtonGroup();
		lin.add(e);
		lin.add(p);

		e.addItemListener(new lingua());
		p.addItemListener(new lingua());
		
		Icon co = new ImageIcon (getClass().getResource("Co.png"));
        ok = new JButton("", co);
		ok.setBorder(new EmptyBorder(0, 40, 40, 40));
        ok.setBorder(null);
        ok.setOpaque(false);
        ok.setContentAreaFilled(false);
        ok.setBorderPainted(false);
		ok.addActionListener(this);
		baixo.add(ok,BorderLayout.SOUTH);
	}

	@Override
		public void actionPerformed (ActionEvent evt)
		{
			Uruguay uruguay = new Uruguay(lingua);
			uruguay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			uruguay.setSize(500,650);
			uruguay.setResizable(false);
			uruguay.setLocationRelativeTo(null);
			uruguay.setVisible(true);
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
					livro.setBorder(new EmptyBorder(0, 90, 0, 60));
				}
				else
				{
					lingua = 'p';
					livro.setText("Livro de Receitas");
					livro.setBorder(new EmptyBorder(0, 70, 0, 60));
				}
			}
	}
}