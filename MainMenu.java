import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainMenu extends Menu{

    public MainMenu(){
        f = new JFrame("User Type");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) { System.exit(0); }
        });

        JPanel userTypePanel = new JPanel();
        final ButtonGroup userType = new ButtonGroup();
        JRadioButton radioButton;
        userTypePanel.add(radioButton = new JRadioButton("Existing Customer"));
        radioButton.setActionCommand("Customer");
        userType.add(radioButton);

        userTypePanel.add(radioButton = new JRadioButton("Administrator"));
        radioButton.setActionCommand("Administrator");
        userType.add(radioButton);

        userTypePanel.add(radioButton = new JRadioButton("New Customer"));
        radioButton.setActionCommand("New Customer");
        userType.add(radioButton);

        JPanel continuePanel = new JPanel();
        JButton continueButton = new JButton("Continue");
        continuePanel.add(continueButton);

        Container content = f.getContentPane();
        content.setLayout(new GridLayout(2, 1));
        content.add(userTypePanel);
        content.add(continuePanel);

        continueButton.addActionListener(ae -> {
            String user = userType.getSelection().getActionCommand(  );

            //if user selects NEW CUSTOMER--------------------------------------------------------------------------------------
            if(user.equals("New Customer"))
            {
                new NewCustomer();
            }

            //if user select ADMIN----------------------------------------------------------------------------------------------
            if(user.equals("Administrator")	)
            {
                new AdminLogin();
            }

            //if user selects CUSTOMER ----------------------------------------------------------------------------------------
            if(user.equals("Customer")	) {
                new CustomerLogin();
            }
            //-----------------------------------------------------------------------------------------------------------------------
        });f.setVisible(true);
    }
}
