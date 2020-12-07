import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
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
	public char lingua;

	public Lingua()
	{
		setLayout(new FlowLayout());

		livro = new JLabel("Livro de Receitas");
		add(livro);

		e = new JRadioButton("Español");
		p = new JRadioButton("Português");
		add(e);
		add(p);

		lin = new ButtonGroup();
		lin.add(e);
		lin.add(p);

		e.addItemListener(new lingua());
		p.addItemListener(new lingua());
		
		ok = new JButton("Ok");
		ok.addActionListener(this);
		add(ok);
	}

	@Override
		public void actionPerformed (ActionEvent evt)
		{
			Paises paises = new Paises(lingua);
			paises.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			paises.setSize(400,100);
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