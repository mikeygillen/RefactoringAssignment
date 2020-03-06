import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class NewCustomer extends Menu implements Interface{

    private String password;
    JButton add;
    JPanel panel2;
    String 	PPS,firstName,surname,DOB,CustomerID;

    public NewCustomer() {
        f1 = new JFrame("Create New Customer");
        f1.setSize(400, 300);
        f1.setLocation(200, 200);
        f1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        Container content1 = f1.getContentPane();
        content1.setLayout(new BorderLayout());

        firstNameLabel = new JLabel("First Name:", SwingConstants.RIGHT);
        surnameLabel = new JLabel("Surname:", SwingConstants.RIGHT);
        pPPSLabel = new JLabel("PPS Number:", SwingConstants.RIGHT);
        dOBLabel = new JLabel("Date of birth", SwingConstants.RIGHT);
        firstNameTextField = new JTextField(20);
        surnameTextField = new JTextField(20);
        pPSTextField = new JTextField(20);
        dOBTextField = new JTextField(20);
        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(firstNameLabel);
        panel.add(firstNameTextField);
        panel.add(surnameLabel);
        panel.add(surnameTextField);
        panel.add(pPPSLabel);
        panel.add(pPSTextField);
        panel.add(dOBLabel);
        panel.add(dOBTextField);

        panel2 = new JPanel();
        add = new JButton("Add");

        add.addActionListener(e -> {

            PPS = pPSTextField.getText();
            firstName = firstNameTextField.getText();
            surname = surnameTextField.getText();
            DOB = dOBTextField.getText();
            password = "";

            CustomerID = "ID" + PPS;

            f1.dispose();

            boolean loop = true;
            while (loop) {
                password = JOptionPane.showInputDialog(f, "Enter 7 character Password;");

                if (password.length() != 7)//Making sure password is 7 characters
                {
                    JOptionPane.showMessageDialog(null, null, "Password must be 7 characters long", JOptionPane.ERROR_MESSAGE);
                } else {
                    loop = false;
                }
            }

            ArrayList<CustomerAccount> accounts = new ArrayList<>();
            Customer customer = new Customer(PPS, surname, firstName, DOB, CustomerID, password, accounts);

            customerList.add(customer);

            JOptionPane.showMessageDialog(null, "CustomerID = " + CustomerID + "\n Password = " + password, "Customer created.", JOptionPane.INFORMATION_MESSAGE);
            menuStart();
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(e -> {
            f1.dispose();
            menuStart();
        });

        panel2.add(add);
        panel2.add(cancel);

        content1.add(panel, BorderLayout.CENTER);
        content1.add(panel2, BorderLayout.SOUTH);

        f1.setVisible(true);
    }
}
