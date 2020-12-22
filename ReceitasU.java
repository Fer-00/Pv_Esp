import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public class ReceitasU extends JFrame implements ActionListener
{
	private final JLabel head;
	private final JButton ret;
	private final JPanel cont = new JPanel(new GridLayout(0,1,20,20));
	private final char lingua, categoria;
	private final ArrayList<String> titulos = new ArrayList<>();
    private final JButton[] receitas = new JButton[5];


	public ReceitasU(char auxL, char auxC)
	{
		setLayout(new BorderLayout());

		cont.setBorder(new EmptyBorder(20,20,20,20));
		cont.setBackground(new Color(255,222,173));
		add(cont, BorderLayout.NORTH);

		lingua = auxL;
		categoria = auxC;
		head = new JLabel();

		if (lingua == 'p')
		{
			head.setText("Receitas do Uruguai");
			head.setFont(new Font("Arial", Font.BOLD, 20));
			head.setBorder(new EmptyBorder(10,100,30,30));
			cont.add(head);
			retornaReceitas(categoria);
		}
		else if (lingua == 'e') 
		{
			head.setText("Recetas de el Uruguay");
			head.setFont(new Font("Arial", Font.BOLD, 20));
			head.setBorder(new EmptyBorder(10,100,30,30));
			cont.add(head);
			retornaReceitas(categoria);
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
		cont.add(ret,BorderLayout.SOUTH);
	}

	private String retornaArquivo()
	{
		if (lingua == 'p')
			return "RecPU.txt";
		else if (lingua == 'e')
			return "RecEU.txt";
		else
			return "";
	}

	private void retornaReceitas(char categoria)
	{
		String arquivo = retornaArquivo();

		try
		{
			FileReader rec = new FileReader(arquivo);
            BufferedReader leitor = new BufferedReader(rec);
 
           	String linha; 

            while ((linha = leitor.readLine()) != null)
           	{
         		if(linha!=null && linha.length()>0)
           		{
           			if (linha.charAt(0) == categoria)
           			{
           				linha = leitor.readLine();
           		    	titulos.add(linha);
            		}
	            	else
    	        		continue;
    	       	}
    	    }
            	
           	for (int i = 0;i < titulos.size();++i)
           	{
           		receitas[i] = new JButton(titulos.get(i));
           		receitas[i].setFont(new Font("Arial", Font.BOLD, 15));
           		receitas[i].setSize(15,50);
           		receitas[i].setBorder(new EmptyBorder(8, 8, 8, 8));
           		receitas[i].addActionListener(this);
           		cont.add(receitas[i]);	
           	}

            rec.close();
		}
		
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null,"Ocorreu um erro","Ocurrio un error",JOptionPane.WARNING_MESSAGE);
			dispose();
		}
	}

	@Override
		public void actionPerformed(ActionEvent evt)
		{
			if (evt.getSource() == ret)
			{
				dispose();
				CategoriasU cat = new CategoriasU(lingua);
				cat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				cat.setSize(550,700);
				cat.setResizable(false);
				cat.setLocationRelativeTo(null);
				cat.setVisible(true);
			}
			else{
				for (int i = 0;i < titulos.size(); ++i)
				{
					if (evt.getSource() == receitas[i])
					{
						dispose();
						GuiaU guia = new GuiaU(lingua,titulos.get(i),categoria);
						guia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						guia.setResizable(false);
						guia.setSize(550,700);
						guia.setLocationRelativeTo(null);
						guia.setVisible(true);
					}
					else
						continue;
				}
			}
		}
}