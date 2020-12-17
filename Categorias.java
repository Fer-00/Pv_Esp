import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Categorias extends JFrame
{
	public final JButton[] categorias = new JButton[6]; // doces, salgados, refeições, sobremesas e bebidas e bebidas alcoolicas
	public final char[] cats = {'r','s','b','o','d','a'};
	private final String[] categoriasP = {"Refeições","Salgados","Bebidas","Sobremesas","Doces","Coquetéis"};
	private final String[] categoriasE = {"Comidas","Bocadillos","Bebidas","Postres","Dulces","Cócteles"};

	public char pais;
	
	public Categorias(char lingua, char aux)
	{
		setLayout(new FlowLayout());

		pais = aux;

		if (lingua == 'p')
		{
			for (int i = 0; i < 6; ++i)
			{
				categorias[i] = new JButton(categoriasP[i]);
				categorias[i].setSize(15,50);
				categorias[i].setFont(new Font("Arial", Font.BOLD, 16));
				categorias[i].addActionListener(new CPort());
				add(categorias[i]);
			}
		}
		else if (lingua == 'e')
		{
			for (int i = 0; i < 6; ++i)
			{
				categorias[i] = new JButton(categoriasE[i]);
				categorias[i].setSize(15,50);
				categorias[i].setFont(new Font("Arial", Font.BOLD, 16));
				categorias[i].addActionListener(new CEsp());
				add(categorias[i]);
			}
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
				for (int i = 0;i < 6;++i)
				{
					if (e.getSource() == categorias[i])
						cat = cats[i];
					else
						continue;
				}
				
				dispose();
				Receitas rec = new Receitas('p',pais,cat);
				rec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				rec.setSize(500,650);
				rec.setLocationRelativeTo(null);
				rec.setVisible(true);
			}
	}

	class CEsp implements ActionListener
	{
		char cat;

		@Override
			public void actionPerformed(ActionEvent e)
			{
				for (int i = 0;i < 6;++i)
				{
					if (e.getSource() == categorias[i])
						cat = cats[i];
					else
						continue;
				}

    			dispose();
				Receitas rec = new Receitas('e',pais,cat);
				rec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				rec.setSize(500,650);
				rec.setLocationRelativeTo(null);
				rec.setVisible(true);
			}
	}
}