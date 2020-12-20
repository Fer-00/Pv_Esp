import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class Uruguay extends JFrame implements ActionListener
{
	public final char lingua;
    private final JPanel esquerda, direita;
    private final JLabel bandeira, mapa;
    private final JTextArea descricao;
    private final JButton ok;

	public Uruguay(char lin)
	{
		lingua = lin;

		setLayout(new BorderLayout());

		esquerda = new JPanel (new BorderLayout());
        esquerda.setBackground(new Color(243,241,166));
    
        direita = new JPanel (new BorderLayout());
        direita.setBackground(new Color(173,216,230));
        direita.setBorder(new EmptyBorder(8, 8, 8, 8));

        add(esquerda, BorderLayout.WEST);
        add(direita, BorderLayout.EAST);

        descricao = new JTextArea("",0,25);

		if (lingua == 'p')
		{
        	descricao.setText("                       Uruguai                    Os Uruguaios são vorazes devoradores de carne, e a Parrillada e o Matambre são dos pratos regionais mais populares. Mas também o Chivito, uma delicosa sanduíche de bife, é bastante conhecido. De entre os petiscos típicos, são de salientar os Olímpicos e os Húngaros. O chá e o Mate são ingeridos em quantidades astronómicas, assim como o Clericó, uma mistura de vinho branco com sumo de frutas, género sangria branca. Como sugestões do Comezainas, ficam as receitas de Carne Estufada e de Garrapiñada.Fonte: comezainas.clix.pt");
        	descricao.setFont(new Font("Arial", Font.BOLD, 16));
        	descricao.setEditable(false);
        	descricao.setWrapStyleWord(true);
        	descricao.setLineWrap(true);
    	    descricao.setOpaque(false);
        	descricao.setBorder(new EmptyBorder(10, 2, 0, 2));
		}
		else if(lingua == 'e')
		{
        	descricao.setText("        Uruguay, es un país de América del Sur, situado en la parte oriental del Cono Sur. Limita al noreste con Brasil, al oeste y suroeste con Argentina y tiene costas en el océano Atlántico por el sur. Abarca 176.215 km, su PIB nominal és USD 62.893, su IDH és 0,8174 y su tasa de alfabetización és 98,7%. Según los datos del último censo del INE en 2011, la población de Uruguay es de 3.286.314 habitantes​, con lo que figura en la décima posición entre los países sudamericanos y su idioma oficial es el español. Es una república presidencialista subdividida en diecinueve departamentos. La capital y ciudad más poblada del país es Montevideo, con 1,3 millones de habitantes, y cuya área metropolitana ronda los 2 millones, lo que representa el 56,3 % del total nacional.");
        	descricao.setFont(new Font("Arial", Font.PLAIN, 14));
        	descricao.setEditable(false);
        	descricao.setLineWrap(true);
        	descricao.setWrapStyleWord(true);
    	    descricao.setOpaque(false);
        	descricao.setBorder(new EmptyBorder(10, 2, 0, 2));
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Ocorreu um erro","Ocurrio un error",JOptionPane.WARNING_MESSAGE);
			this.setVisible(false);
			dispose();
		}

		Icon m = new ImageIcon (getClass().getResource("M.jpg"));
		mapa = new JLabel();
		mapa.setBorder(new EmptyBorder(40, 60, 80, 0));
		mapa.setIcon(m);

		esquerda.add(descricao, BorderLayout.NORTH);
		esquerda.add(mapa, BorderLayout.SOUTH);

		Icon u = new ImageIcon (getClass().getResource("Ub.jpeg"));
		bandeira = new JLabel();
		bandeira.setIcon(u);

		Icon e = new ImageIcon (getClass().getResource("Ue.png"));
		ok = new JButton("",e);
		ok.setBorder(null);
		ok.setOpaque(false);
		ok.setContentAreaFilled(false);
		ok.setBorderPainted(false);
		ok.addActionListener(this);

		direita.add(bandeira, BorderLayout.NORTH);
		direita.add(ok, BorderLayout.SOUTH);
	}

	@Override
		public void actionPerformed(ActionEvent e)
		{
			dispose();
			CategoriasU cat = new CategoriasU(lingua);
			cat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			cat.setSize(500,650);
			cat.setResizable(false);
			cat.setLocationRelativeTo(null);
			cat.setVisible(true);
		}
}