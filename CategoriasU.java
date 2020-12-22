import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class CategoriasU extends JFrame implements ActionListener
{
	private final JPanel alto, baixo;
	private final JLabel img;
	private final JTextArea desc;
	private final JButton ret;
	private final JButton[] categorias = new JButton[6]; 
	private final char[] cats = {'r','s','b','o','d','a'};
	private final String[] categoriasP = {"Refeições","Salgados","Bebidas","Sobremesas","Doces","Coquetéis"};
	private final String[] categoriasE = {"Comidas","Salados","Bebidas","Postres","Dulces","Cócteles"};
	private final char lingua;
	
	public CategoriasU(char aux)
	{
		setLayout(new BorderLayout());

		alto = new JPanel(new BorderLayout());
		alto.setBackground(new Color(173,216,230));
		baixo = new JPanel(new GridLayout(2,3,5,10));
		baixo.setBackground(new Color(255,255,255));
		baixo.setBorder(new EmptyBorder(0,30,80,30));

		add(alto,BorderLayout.NORTH);
		add(baixo,BorderLayout.SOUTH);

		Icon flag = new ImageIcon(getClass().getResource("Gast.png"));
		img = new JLabel();
		img.setBorder(new EmptyBorder(20,145,38,60));
		img.setIcon(flag);
		alto.add(img,BorderLayout.SOUTH);

		lingua = aux;

		desc = new JTextArea("",0,30);

		if (lingua == 'p')
		{
        	desc.setText("        A gastronomia do Uruguai é, basicamente, o resultado da fusão das cozinhas italiana e espanhola, o que determina as semelhanças com a culinária argentina. A isso se soma a de outros países europeus, a culinária crioula e, em menor medida, a culinária indígena. Essa diversidade de contribuições é um dos fatores diferenciadores da culinária do Rio da Prata em relação ao resto da América Latina. Por isso, é possível encontrar comidas e bebidas típicas trazidas pelos emigrantes europeus e adaptadas às possibilidades e disponibilidade do Uruguai.");
        	desc.setFont(new Font("Arial", Font.BOLD, 15));
        	desc.setEditable(false);
        	desc.setWrapStyleWord(true);
        	desc.setLineWrap(true);
    	    desc.setOpaque(false);
        	desc.setBorder(new EmptyBorder(20, 20, 20, 20));
        	alto.add(desc, BorderLayout.NORTH);
		
			for (int i = 0; i < 6; ++i)
			{
				categorias[i] = new JButton(categoriasP[i]);
				categorias[i].setBackground(new Color(135,206,235));
				categorias[i].setFont(new Font("Arial", Font.BOLD, 16));
				categorias[i].setBorder(new EmptyBorder(4, 4, 4, 4));
				categorias[i].addActionListener(this);
				baixo.add(categorias[i]);
			}
		}
		else if (lingua == 'e')
		{
        	desc.setText("        La gastronomía de Uruguay es, básicamente, el resultado de la fusión de las cocinas italiana y española, lo que determina las similitudes con la cocina Argentina. A esto se agrega la de otros países europeos, de la cocina criolla y, en menor medida, de la cocina indígena. Esta diversidad de aportes es uno de los factores diferenciadores de la cocina rioplatense de la del resto de América Latina. Por ello, es posible encontrar comidas y bebidas típicas traídas por los emigrantes europeos y adaptadas a las posibilidades y disponibilidad en el Uruguay.");
        	desc.setFont(new Font("Arial", Font.BOLD, 15));
        	desc.setEditable(false);
        	desc.setWrapStyleWord(true);
        	desc.setLineWrap(true);
    	    desc.setOpaque(false);
        	desc.setBorder(new EmptyBorder(20, 20, 20, 20));
        	alto.add(desc, BorderLayout.NORTH);

			for (int i = 0; i < 6; ++i)
			{
				categorias[i] = new JButton(categoriasE[i]);
				categorias[i].setBackground(new Color(135,206,235));
				categorias[i].setFont(new Font("Arial", Font.BOLD, 16));
				categorias[i].setBorder(new EmptyBorder(4, 4, 4, 4));
				categorias[i].addActionListener(this);
				baixo.add(categorias[i]);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Ocorreu um erro","Ocurrio un error",JOptionPane.WARNING_MESSAGE);
			this.setVisible(false);
			this.dispose();
		}

		Icon r = new ImageIcon (getClass().getResource("ret.png"));
		ret = new JButton("",r);
		ret.setBorder(null);
		ret.setOpaque(false);
		ret.setContentAreaFilled(false);
		ret.setBorderPainted(false);
		ret.addActionListener(this);
		baixo.add(ret,BorderLayout.EAST);
	}

	char cat;
	
	@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == ret)
			{
				dispose();
				Uruguay uruguay = new Uruguay(lingua);
				uruguay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				uruguay.setSize(550,700);
				uruguay.setResizable(false);
				uruguay.setLocationRelativeTo(null);
				uruguay.setVisible(true);
			}
			else{
	
				for (int i = 0;i < 6;++i)
				{
					if (e.getSource() == categorias[i])
						cat = cats[i];
					else
						continue;
				}

    			dispose();
				ReceitasU rec = new ReceitasU(lingua,cat);
				rec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				rec.setSize(550,700);
				rec.getContentPane().setBackground(new Color(255,222,173));
				rec.setResizable(false);
				rec.setLocationRelativeTo(null);
				rec.setVisible(true);
			}
		}
}