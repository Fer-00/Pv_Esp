package trabalho_final_adriane;

import javax.swing.JFrame;

public class Executor{
	
	public static void main(String[] args) {
		
		Lingua lin = new Lingua();
		lin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		lin.setSize(400,400);
		lin.setLocationRelativeTo(null);
		lin.setVisible(true);	
	}

}