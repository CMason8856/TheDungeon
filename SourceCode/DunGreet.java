import javax.swing.JOptionPane;

public class DunGreet{
	public static void main (String[] args){
		String name = "The Dungeon";
		String message = "Hello there, I am Dungeon. You must be one of the programmers.\n" +
							"I am the game you will be working on.\n" +
							"Whatever I become will be a result of the hard work that you and your fellow coders put in.\n" +
							"The most important thing is to have fun while you work. Do not forget that.\n" +
							"So good luck and let see what can be made of me.";
		Message(message, name);
	}
	private static void Message(String message, String name){
		JOptionPane salutation = new JOptionPane();
		salutation.showMessageDialog(null, message, name, JOptionPane.INFORMATION_MESSAGE);
	}
}

