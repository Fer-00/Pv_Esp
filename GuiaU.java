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
	private final String receita;
	private final ArrayList<String> fases = new ArrayList<>();
	private final JLabel titulo;
	public final JLabel imagem;
	public final JCheckBox[] processo = new JCheckBox[50];

	public GuiaU(char auxL, String nomeReceita)
	{
		setLayout(new BorderLayout());

		title = new JPanel(new BorderLayout());
		process = new JPanel(new GridLayout(0,2,5,5));
		img = new JPanel(new BorderLayout());

		add(title,BorderLayout.NORTH);
		add(process,BorderLayout.CENTER);
		add(img,BorderLayout.SOUTH);

		lingua = auxL;
		receita = nomeReceita;

		titulo = new JLabel(receita);
		titulo.setFont(new Font("Arial",Font.BOLD,20));
		titulo.setBorder(new EmptyBorder(20,50,20,50));
		title.add(titulo);

		String arquivo = retornaArquivo();
		Handler handler = new Handler();
			
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
           					continue;
           				else if (i == 1) 
           				{
           					String[] splitted = linha.split(":");
           					for (int j = 0; j < splitted.length; ++j) {
           						fases.add(splitted[0]);
           					}
           				}
           				else if (i == 2)
           				{
           					Icon aux = new ImageIcon(getClass().getResource(linha));
            				imagem = new JLabel();
	            			imagem.setIcon(aux);
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
			public void itemStateChanged(ItemEvent evt)
			{
				for (int i = 0; i < processo.length; ++i) {
					if (processo[i].isSelected())
						continue;
					else
						break;
	            	img.add(imagem);
				}
			}
	}
}