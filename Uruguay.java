import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class Uruguay extends JFrame implements ActionListener
{
	private final char lingua;
    private final JPanel esquerda, direita;
    private final JLabel bandeira, mapa;
    private final JTextArea descricao;
    private final JButton ok,ret;

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
        	descricao.setText("        O Uruguai é um país da América do Sul, localizado na parte oriental do Cone Sul. Faz fronteira com o Brasil a nordeste, com a Argentina a oeste e sudoeste e tem costas no Oceano Atlântico ao sul. Possui 176.215 km, seu PIB nominal é de US $ 62.893, seu IDH é de 0,8174 e sua taxa de alfabetização é de 98,7%. De acordo com os dados do último censo do INE em 2011, a população do Uruguai é de 3.286.314 habitantes, o que ocupa o décimo lugar entre os países da América do Sul e tem como língua oficial o espanhol. É uma república presidencial subdividida em dezenove departamentos. A capital e cidade mais populosa do país é Montevidéu, com 1,3 milhão de habitantes, e cuja área metropolitana gira em torno de 2 milhões, o que representa 56,3% do total nacional.");
        	descricao.setFont(new Font("Arial", Font.PLAIN, 15));
        	descricao.setEditable(false);
        	descricao.setWrapStyleWord(true);
        	descricao.setLineWrap(true);
    	    descricao.setOpaque(false);
        	descricao.setBorder(new EmptyBorder(10, 2, 0, 2));
		}
		else if(lingua == 'e')
		{
        	descricao.setText("        Uruguay, es un país de América del Sur, situado en la parte oriental del Cono Sur. Limita al noreste con Brasil, al oeste y suroeste con Argentina y tiene costas en el océano Atlántico por el sur. Abarca 176.215 km, su PIB nominal és USD 62.893, su IDH és 0,8174 y su tasa de alfabetización és 98,7%. Según los datos del último censo del INE en 2011, la población de Uruguay es de 3.286.314 habitantes​, con lo que figura en la décima posición entre los países sudamericanos y su idioma oficial es el español. Es una república presidencialista subdividida en diecinueve departamentos. La capital y ciudad más poblada del país es Montevideo, con 1,3 millones de habitantes, y cuya área metropolitana ronda los 2 millones, lo que representa el 56,3 % del total nacional.");
        	descricao.setFont(new Font("Arial", Font.PLAIN, 15));
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
		mapa.setBorder(new EmptyBorder(40, 80, 80, 0));
		mapa.setIcon(m);

		esquerda.add(descricao, BorderLayout.NORTH);
		esquerda.add(mapa, BorderLayout.CENTER);

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

		Icon r = new ImageIcon (getClass().getResource("ret.png"));
		ret = new JButton("",r);
		ret.setBorder(null);
		ret.setOpaque(false);
		ret.setContentAreaFilled(false);
		ret.setBorderPainted(false);
		ret.addActionListener(this);
		esquerda.add(ret, BorderLayout.SOUTH);

		direita.add(bandeira, BorderLayout.NORTH);
		direita.add(ok, BorderLayout.SOUTH);
	}

	@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == ret)
			{
				dispose();
				Lingua tela = new Lingua();
				tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				tela.setSize(550,700);
				tela.setResizable(false);
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);	
			}
			else{
				dispose();
				CategoriasU cat = new CategoriasU(lingua);
				cat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				cat.setSize(550,700);
				cat.setResizable(false);
				cat.setLocationRelativeTo(null);
				cat.setVisible(true);
			}
		}
}