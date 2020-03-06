import java.awt.*;
import java.util.Date;
import javax.swing.*;

public class Menu extends JFrame implements Interface{
    public int position = 0;
	public Customer customer = null;
	public CustomerAccount acc = new CustomerAccount();
	JFrame f, f1;
	 JLabel firstNameLabel, surnameLabel, pPPSLabel, dOBLabel, customerIDLabel, passwordLabel;
	 static JTextField firstNameTextField, surnameTextField, pPSTextField, dOBTextField, customerIDTextField, passwordTextField;
	Container content;
	Customer e;

	public static void main(String[] args) {
		Menu driver = new Menu();
		driver.menuStart();
	}

	public void menuStart() {
		new MainMenu();
	}

	public void admin() {
		dispose();
		new AdminDriver();
	}

	public void customer() {
		dispose();
		new CustomerDriver();
	}
	public void transactionActionDisplay(String type, double amount) {
		String euro = "\u20ac";
		if (type.equals("Withdraw")) {
			acc.setBalance(acc.getBalance() - amount);
		}else {
			acc.setBalance(acc.getBalance() + amount);
		}

		Date date = new Date();
		String date2 = date.toString();

		AccountTransaction transaction = new AccountTransaction(date2, type, amount);
		acc.getTransactionList().add(transaction);

		JOptionPane.showMessageDialog(f, euro + amount + " Confirmed." ,type,  JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() + euro ,type,  JOptionPane.INFORMATION_MESSAGE);
	}

	public void correctPin(){
		int count = 3;
		int checkPin = ((CustomerCurrentAccount) acc).getAtm().getPin();
		boolean loop = true;

		while(loop) {
			if(count == 0) {
				JOptionPane.showMessageDialog(f, "Pin entered incorrectly 3 times. ATM card locked."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);
				((CustomerCurrentAccount) acc).getAtm().setValid(false);
				customer();
				loop = false;
			}
			else {
				String Pin = JOptionPane.showInputDialog(f, "Enter 4 digit PIN;");
				int i = Integer.parseInt(Pin);

				if (checkPin == i) {
					loop = false;
					((CustomerCurrentAccount) acc).getAtm().setValid(true);
					JOptionPane.showMessageDialog(f, "Pin entry successful", "Pin", JOptionPane.INFORMATION_MESSAGE);
				} else {
					count--;
					JOptionPane.showMessageDialog(f, "Incorrect pin. " + count + " attempts remaining.", "Pin", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
}