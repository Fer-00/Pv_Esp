import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

public class Receitas extends JFrame
{
	private JLabel head;

	public Receitas(char lingua, char auxp, char auxc)
	{
		if (lingua == 'p')
		{
			head = new JLabel("Receitas da/do " + retornaPais(pais,lingua),SwingConstants.CENTER);
			add(head);
		}
		else if (lingua == 'e') 
		{
			head = new JLabel("Recetas de el/la " + retornaPais(pais,lingua),SwingConstants.CENTER);
			add(head);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Ocorreu um erro","Ocurrio un error",JOptionPane.WARNING_MESSAGE);
			this.setVisible(false);
			this.dispose();
		}
		private String retornaPais(char aux, char lingua)
		{
			char[] paises = {'u','a','p','c','q','s','r','m'};
			String[] nomePaisesP = {"Uruguai","Argentina","Paraguai","Chile","Equador","Espanha","Costa Rica","México"};
			String[] nomePaisesE = {"Uruguay","Argentina","Paraguay","Chile","Ecuador","España","Costa Rica","México"};
			
			if (lingua == 'p')
			{
				for (int i; i = 0; i = i + 2) {
					if (aux == paises[i])
					{
						return nomePaisesP[i];
					}
					else
						continue;
				}
			}
			else if (lingua == 'e') 
			{
				for (int i; i = 0; i = i + 2) {
					if (aux == paises[i])
					{
						return nomePaisesE[i];
					}
					else
						continue;
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Ocorreu um erro","Ocurrio un error",JOptionPane.WARNING_MESSAGE);
				this.setVisible(false);
				this.dispose();
			}
		}
	}
}