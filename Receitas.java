import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane; 
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;

public class Receitas extends JFrame implements ActionListener
{
	private JLabel head;
	public char lingua;
	public ArrayList<String> titulos = new ArrayList<>();
    public JButton[] receitas = new JButton[100];


	public Receitas(char auxL, char pais, char categoria)
	{
		setLayout(new FlowLayout());
		lingua = auxL;

		if (lingua == 'p')
		{
			head = new JLabel("Receitas da/do " + retornaPais(pais));
			add(head);
			retornaReceitas(pais,categoria);
		}
		else if (lingua == 'e') 
		{
			head = new JLabel("Recetas de el/la " + retornaPais(pais));
			add(head);
			retornaReceitas(pais,categoria);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Ocorreu um erro","Ocurrio un error",JOptionPane.WARNING_MESSAGE);
			this.setVisible(false);
			this.dispose();
		}
	}
	
	public String retornaPais(char aux)
	{
		char[] paises = {'u','a','p','c','q','s','r','m'};
		String[] nomePaisesP = {"Uruguai","Argentina","Paraguai","Chile","Equador","Espanha","Costa Rica","México"};
		String[] nomePaisesE = {"Uruguay","Argentina","Paraguay","Chile","Ecuador","España","Costa Rica","México"};
			
		if (lingua == 'p')
		{
			for (int i = 0; i < 8; ++i)
			{
				if (aux == paises[i])
					return nomePaisesP[i];
				else
					continue;
			}
		}
		else if (lingua == 'e') 
		{
			for (int i = 0; i < 8; ++i)
			{
				if (aux == paises[i])
					return nomePaisesE[i];
				else
					continue;
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Ocorreu um erro","Ocurrio un error",JOptionPane.WARNING_MESSAGE);
			dispose();
		}
		return " ";
	}

	public void retornaReceitas(char pais, char categoria)
	{
		String identificador = new StringBuilder().append(pais).append(categoria).toString();

		if (lingua == 'p')
		{
			try
			{
				FileReader rec = new FileReader("RecP.txt");
            	BufferedReader leitor = new BufferedReader(rec);
 
            	String linha; 
 
            	while ((linha = leitor.readLine()) != null)
            	{
            		if (linha.equals(identificador))
            		{
            			linha = leitor.readLine(); 
            		    titulos.add(linha); 
            		}
            		else
            			continue;
            	}
            	
            	for (int i = 0;i < titulos.size();++i)
            	{
            		receitas[i] = new JButton(titulos.get(i));
            		receitas[i].setSize(20,10);
            		receitas[i].addActionListener(this);
            		add(receitas[i]);	
            	}

            	rec.close();
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null,"Ocorreu um erro","Ocurrio un error",JOptionPane.WARNING_MESSAGE);
				dispose();
			}
		}
		
		else if (lingua == 'e')
		{
			try
			{
				FileReader rec = new FileReader("RecE.txt");
            	BufferedReader leitor = new BufferedReader(rec);
 
            	String linha;
            	while ((linha = leitor.readLine()) != null)
            	{
            		if (linha.equals(identificador))
            		{
            			linha = leitor.readLine();
            		    titulos.add(linha);
	            	}
            		else
            			continue;
            	}
            	
            	for (int i = 0;i < titulos.size();++i)
            	{
            		receitas[i] = new JButton(titulos.get(i));
            		receitas[i].addActionListener(this);
            		add(receitas[i]);	
            	}

            	rec.close();
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null,"Ocorreu um erro","Ocurrio un error",JOptionPane.WARNING_MESSAGE);
				dispose();
			}
		}
		
		else
		{
			JOptionPane.showMessageDialog(null,"Ocorreu um erro","Ocurrio un error",JOptionPane.WARNING_MESSAGE);
			dispose();
		}
		
	}

	@Override
		public void actionPerformed(ActionEvent evt)
		{
			for (int i = 0;i < titulos.size(); ++i)
			{
				if (evt.getSource() == receitas[i])
				{
					dispose();
					Guia guia = new Guia(lingua,titulos.get(i));
					guia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					guia.setSize(400,400);
					guia.setLocationRelativeTo(null);
					guia.setVisible(true);
				}
				else
					continue;
			}
		}
}