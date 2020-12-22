import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public class GuiaU extends JFrame implements ActionListener
{
	private final JPanel title, process;
	private final JPanel img;
	private final char lingua, cat;
	private int acumulador = 0; 
	private final String receita;
	private final JButton ret,fec;
	private final ArrayList<String> fases = new ArrayList<>();
	private final JLabel titulo, imagem;
	private final JCheckBox[] processo = new JCheckBox[50];

	public GuiaU(char auxL, String nomeReceita, char auxC)
	{
		setLayout(new BorderLayout());

		title = new JPanel(new BorderLayout());
		title.setBackground(new Color(222,184,135));
		process = new JPanel(new GridLayout(0,1,5,5));
		process.setBackground(new Color(245,222,179));
		img = new JPanel(new BorderLayout());
		img.setBackground(new Color(245,222,179));

		add(title,BorderLayout.NORTH);
		add(process,BorderLayout.CENTER);
		add(img,BorderLayout.SOUTH);

		lingua = auxL;
		cat = auxC;
		receita = nomeReceita;

		titulo = new JLabel(receita,SwingConstants.CENTER);
		titulo.setFont(new Font("Arial",Font.BOLD,18));
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
           					Icon aux = new ImageIcon(getClass().getResource(linha));
	            			imagem.setIcon(aux);
	            			imagem.setBorder(new EmptyBorder(20,150,20,50));
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
			processo[i].setToolTipText("Marque todos");
			processo[i].setBorder(null);
			processo[i].setOpaque(false);
			processo[i].setContentAreaFilled(false);
			processo[i].setBorderPainted(false);
           	processo[i].addItemListener(handler);
           	process.add(processo[i]);
		}

		Icon r = new ImageIcon (getClass().getResource("ret.png"));
		
		ret = new JButton("",r);
		ret.setBorder(null);
		ret.setOpaque(false);
		ret.setContentAreaFilled(false);
		ret.setBorderPainted(false);
		ret.addActionListener(this);
		img.add(ret,BorderLayout.WEST);

		Icon x = new ImageIcon (getClass().getResource("x.png"));
		
		fec = new JButton("",x);
		fec.setBorder(null);
		fec.setOpaque(false);
		fec.setContentAreaFilled(false);
		fec.setBorderPainted(false);
		fec.addActionListener(this);
		img.add(fec,BorderLayout.EAST);
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
	
	@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == ret)
			{	
    			dispose();
				ReceitasU rec = new ReceitasU(lingua,cat);
				rec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				rec.getContentPane().setBackground(new Color(255,222,173));
				rec.setSize(550,700);
				rec.setResizable(false);
				rec.setLocationRelativeTo(null);
				rec.setVisible(true);
			}
			else
				dispose();
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