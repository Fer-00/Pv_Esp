import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class Lingua extends JFrame implements ActionListener
{
	private final JPanel centro, baixo;
	private final JLabel livro;
	private final JRadioButton e, p;
	private final ButtonGroup lin;
	private final JButton ok;
	public char lingua;

	public Lingua()
	{
		setLayout(new BorderLayout());

		centro = new JPanel(new BorderLayout());
		centro.setBackground(new Color(173,216,230));
		baixo = new JPanel(new BorderLayout());
		baixo.setBorder(new EmptyBorder(0,0,20,0));
		baixo.setBackground(new Color(173,216,230));

		add(centro,BorderLayout.CENTER);
		add(baixo,BorderLayout.SOUTH);

		livro = new JLabel("Livro de Receitas");
		livro.setFont(new Font("Arial", Font.BOLD, 36));
		livro.setBorder(new EmptyBorder(0, 90, 0, 80));
		centro.add(livro,BorderLayout.CENTER);

		e = new JRadioButton("Español");
		e.setFont(new Font("Arial", Font.ITALIC, 14));
		e.setBorder(new EmptyBorder(35, 35, 35, 35));
		e.setOpaque(false);
		e.setContentAreaFilled(false);
		e.setBorderPainted(false);
		
		p = new JRadioButton("Português");
		p.setFont(new Font("Arial", Font.ITALIC, 14));
		p.setBorder(new EmptyBorder(35, 35, 35, 35));
		p.setOpaque(false);
		p.setContentAreaFilled(false);
		p.setBorderPainted(false);
		
		baixo.add(e,BorderLayout.WEST);
		baixo.add(p,BorderLayout.EAST);

		lin = new ButtonGroup();
		lin.add(e);
		lin.add(p);

		e.addItemListener(new Lin());
		p.addItemListener(new Lin());
		
		Icon co = new ImageIcon (getClass().getResource("Co.png"));
        ok = new JButton("", co);
		ok.setBorder(new EmptyBorder(60, 60, 60, 60));
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
			uruguay.setSize(550,700);
			uruguay.setResizable(false);
			uruguay.setLocationRelativeTo(null);
			uruguay.setVisible(true);
			this.dispose();
		}

	private class Lin implements ItemListener
	{
		public Lin()
		{
		}

		@Override
			public void itemStateChanged(ItemEvent event)
			{
				if (e.isSelected())
				{
					lingua = 'e';
					livro.setText("Libro de Cocina");
					livro.setBorder(new EmptyBorder(0, 110, 0, 80));
				}
				else
				{
					lingua = 'p';
					livro.setText("Livro de Receitas");
					livro.setBorder(new EmptyBorder(0, 90, 0, 80));
				}
			}
	}
}