import javax.swing.JFrame;

public class Executor{
	
	public static void main(String[] args) {
		Lingua tela = new Lingua();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		tela.setSize(550,700);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		tela.setVisible(true);
	}

}