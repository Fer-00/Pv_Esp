import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Tela1 extends JFrame implements ActionListener
{
    private JPanel esquerda, direita;
    private JLabel descricao, bandeira;
    private JButton okay;

    public Tela1(){

        setLayout(new BorderLayout());

        esquerda = new JPanel (new BorderLayout());
        direita = new JPanel (new BorderLayout());

        add(esquerda, BorderLayout.WEST);
        add(direita, BorderLayout.EAST);

        descricao = new JLabel("Informações do Uruguai"); //setFont
        esquerda.add(descricao, BorderLayout.CENTER);

        Icon u = new ImageIcon (getClass().getResource("Ub.jpeg"));
        bandeira = new JLabel();
        bandeira.setIcon(u);

        okay = new JButton("Okay");
        okay.addActionListener(this);

        direita.add(bandeira, BorderLayout.NORTH);
        direita.add(okay, BorderLayout.SOUTH);
    
    }

    @Override
        public void actionPerformed (ActionEvent evt) 
        {
            JOptionPane.showMessageDialog(null, "Você clicou no botão");
        }
}