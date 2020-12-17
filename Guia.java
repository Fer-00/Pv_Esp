import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Guia extends JFrame
{
	public char lingua;
	public String receita;
	public JLabel[] proced = new JLabel[3];

	public Guia(char auxL, String nomeReceita)
	{

		setLayout(new FlowLayout());
		lingua = auxL;
		receita = nomeReceita;

		if (lingua == 'p')
		{
			try
			{
				FileReader rec = new FileReader("RecP.txt");
            	BufferedReader leitor = new BufferedReader(rec);
 
            	String linha; 
 
            	while ((linha = leitor.readLine()) != null)
            	{
            		if (linha.equals(receita))
            		{
            			for (int i = 0;i < 3;++i)
            			{
            				proced[i] = new JLabel(linha);
            				proced[i].setFont(new Font("Arial", Font.BOLD, 16));
            				add(proced[i]);
            				linha = leitor.readLine();
            			}
            		}
            		else
            			continue;
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
            		if (linha.equals(receita))
            		{
            			for (int i = 0;i < 3;++i) 
            			{
            				proced[i] = new JLabel(linha);
            				proced[i].setFont(new Font("Arial", Font.BOLD, 16));
            				add(proced[i]);
            				linha = leitor.readLine();
            			}
            		}
            		else
            			continue;
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
}