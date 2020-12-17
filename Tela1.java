import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class Tela1 extends JFrame implements ActionListener
{
    private final JPanel esquerda, direita;
    private final JLabel bandeira,mapa;
    private final JTextArea descricao;
    private final JButton okay;

    public Tela1()
    {

        setLayout(new BorderLayout());

        esquerda = new JPanel (new BorderLayout());
        esquerda.setBackground(new Color(243,241,166));
    
        direita = new JPanel (new BorderLayout());
        direita.setBackground(new Color(173,216,230));
        direita.setBorder(new EmptyBorder(8, 8, 8, 8));

        add(esquerda, BorderLayout.WEST);
        add(direita, BorderLayout.EAST);

        descricao = new JTextArea("                       Uruguai                    Os Uruguaios são vorazes devoradores de carne, e a Parrillada e o Matambre são dos pratos regionais mais populares. Mas também o Chivito, uma delicosa sanduíche de bife, é bastante conhecido. De entre os petiscos típicos, são de salientar os Olímpicos e os Húngaros. O chá e o Mate são ingeridos em quantidades astronómicas, assim como o Clericó, uma mistura de vinho branco com sumo de frutas, género sangria branca. Como sugestões do Comezainas, ficam as receitas de Carne Estufada e de Garrapiñada.Fonte: comezainas.clix.pt",0,21);
        descricao.setFont(new Font("Arial", Font.BOLD, 16));
        descricao.setEditable(false);
        descricao.setLineWrap(true);
        descricao.setOpaque(false);
        descricao.setBorder(new EmptyBorder(10, 0, 0, 0));

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
        okay = new JButton("OK",e);
        okay.setBorder(null);
        okay.setOpaque(false);
        okay.setContentAreaFilled(false);
        okay.setBorderPainted(false);
        okay.addActionListener(this);

        direita.add(bandeira, BorderLayout.NORTH);
        direita.add(okay, BorderLayout.SOUTH);
    
    }

    @Override
        public void actionPerformed (ActionEvent evt) 
        {
            ImageIcon c = new ImageIcon(getClass().getResource("alfajor2.gif"));
            JOptionPane.showMessageDialog(null, "Um exemplo...", "Clicou no Botão", JOptionPane.INFORMATION_MESSAGE, c);
        }
}