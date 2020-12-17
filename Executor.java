import javax.swing.JFrame;

public class Executor{
	
	public static void main(String[] args) {
		
		Lingua lin = new Lingua();
		lin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		lin.setSize(500,650);
		lin.setLocationRelativeTo(null);
		lin.setVisible(true);	
	}

}