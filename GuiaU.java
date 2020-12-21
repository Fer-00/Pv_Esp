import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public class GuiaU extends JFrame
{
	private final JPanel title, process;
	public final JPanel img;
	private final char lingua;
	public int acumulador = 0; 
	private final String receita;
	private final ArrayList<String> fases = new ArrayList<>();
	private final JLabel titulo, imagem;
	public final JCheckBox[] processo = new JCheckBox[50];

	public GuiaU(char auxL, String nomeReceita)
	{
		setLayout(new BorderLayout());

		title = new JPanel(new BorderLayout());
		process = new JPanel(new GridLayout(0,1,5,5));
		img = new JPanel(new BorderLayout());

		add(title,BorderLayout.NORTH);
		add(process,BorderLayout.CENTER);
		add(img,BorderLayout.SOUTH);

		lingua = auxL;
		receita = nomeReceita;

		titulo = new JLabel(receita);
		titulo.setFont(new Font("Arial",Font.BOLD,18));
		titulo.setBorder(new EmptyBorder(20,50,20,50));
		title.add(titulo);

		String arquivo = retornaArquivo();
		Handler handler = new Handler();	
        imagem = new JLabel();
			
		try
		{
			FileReader rec = new FileReader(arquivo);
           	BufferedReader leitor = new BufferedReader(rec);

            String linha; 
 
           	while ((linha = leitor.readLine()) != null)
           	{
           		if (linha.equals(receita))
           		{
           			for (int i = 0;i < 3;++i)
           			{
           				if (i == 0)
           					linha = leitor.readLine();
           				else if (i == 1) 
           				{
           					String[] splitted = linha.split(":");
           					for (int j = 0; j < splitted.length; ++j)
           						fases.add(splitted[j]);
           					acumulador = splitted.length;
	           				linha = leitor.readLine();
           				}
           				else if (i == 2)
           				{
           					Icon aux = new ImageIcon(getClass().getResource("M.jpg"));
	            			imagem.setIcon(aux);
	            			imagem.setBorder(new EmptyBorder(20,125,20,50));
			            	img.add(imagem);
			            	img.setVisible(false);
	           				linha = leitor.readLine();
            			}
           				else
           				{
							JOptionPane.showMessageDialog(null,"Ocorreu um erro","Ocurrio un error",JOptionPane.WARNING_MESSAGE);
							dispose();
           				}
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
		for (int i = 0; i < fases.size(); i++) {
			processo[i] = new JCheckBox(fases.get(i));
			processo[i].setFont(new Font("Arial",Font.PLAIN, 14));
           	processo[i].addItemListener(handler);
           	process.add(processo[i]);
		}
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

	private class Handler implements ItemListener
	{
		public Handler()
		{
		}
		
		@Override
			public void itemStateChanged(ItemEvent event)
			{
				int aux = 0;
				for (int i = 0; i < acumulador; ++i) {
					if (processo[i].isSelected())
					{
						++aux;
						if (aux == acumulador)
							img.setVisible(true);
					}
					else
					{
						aux = 0;
						break;
					}
				}
			}
	}
					
}