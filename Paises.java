import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Paises extends JFrame
{
	public JButton[] paises = new JButton[8]; 
	public final char[] abrev = {'u', 'a', 'p', 'c', 'q', 's', 'r', 'm'}; // Uruguai, Argentina, Paraguai, Chile, Equador, Espanha, Costa Rica e México
	private final String[] nomePaisP = {"Uruguai","Argentina","Paraguai","Chile","Equador","Espanha","Costa Rica","México"};
	private final String[] nomePaisE = {"Uruguay","Argentina","Paraguay","Chile","Ecuador","España","Costa Rica","México"};
	private final String[] icones = {"U.png","A.png","P.png","C.png","EQ.png","E.png","CR.png","M.png"};

	public Paises(char lingua)
	{
		setLayout(new FlowLayout());

		if (lingua == 'p')
		{
			for (int i = 0;i<8;++i)
			{
				Icon icon = new ImageIcon(getClass().getResource(icones[i])); 
				paises[i] = new JButton(nomePaisP[i],icon);
				paises[i].setSize(15,50);
				paises[i].setFont(new Font("Arial", Font.BOLD, 16));
				paises[i].addActionListener(new PPort());
				add(paises[i]);
			}
		}
		else if(lingua == 'e')
		{
			for (int i = 0;i<8;++i)
			{
				Icon icon = new ImageIcon(getClass().getResource(icones[i])); 
				paises[i] = new JButton(nomePaisE[i],icon);
				paises[i].setSize(15,50);
				paises[i].setFont(new Font("Arial", Font.BOLD, 16));
				paises[i].addActionListener(new PEsp());
				add(paises[i]);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Ocorreu um erro","Ocurrio un error",JOptionPane.WARNING_MESSAGE);
			this.setVisible(false);
			dispose();
		}
	}

	class PPort implements ActionListener
	{
		char pais;

		@Override
			public void actionPerformed(ActionEvent e)
			{
				for (int i = 0;i < 8;++i)
				{
					if (e.getSource() == paises[i])
						pais = abrev[i];
				}

				dispose();
				Categorias cat = new Categorias('p',pais);
				cat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				cat.setSize(500,650);
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
				for (int i = 0;i < 8;++i)
				{
					if (e.getSource() == paises[i])
						pais = abrev[i];
				}

				dispose();
				Categorias cat = new Categorias('e',pais);
				cat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				cat.setSize(500,650);
				cat.setLocationRelativeTo(null);
				cat.setVisible(true);
			}
	} 
}