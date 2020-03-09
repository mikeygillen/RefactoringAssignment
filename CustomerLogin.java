import javax.swing.*;

public class CustomerLogin extends Menu implements Interface {

    public CustomerLogin(){
        boolean loop = true, loop2 = true;
        boolean found = false;
        Customer customer = null;
        while(loop)
        {
            String customerID = JOptionPane.showInputDialog(f, "Enter Customer ID:");

            for (Customer aCustomer: customerList){

                if(aCustomer.getCustomerID().equals(customerID))//search customer list for matching customer ID
                {
                    found = true;
                    customer = aCustomer;
                }
            }

            if(!found)
            {
                int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.NO_OPTION)
                {
                    f.dispose();
                    loop = false;
                    loop2 = false;
                    menuStart();
                }
            }
            else
            {
                loop = false;
            }
        }

        while(loop2)
        {
            String customerPassword = JOptionPane.showInputDialog(f, "Enter Customer Password;");

            if(!customer.getPassword().equals(customerPassword))//check if customer password is correct
            {
                int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect password. Try again?", JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.NO_OPTION){
                    f.dispose();
                    loop2 = false;
                    menuStart();
                }
            }
            else
            {
                e = customer;
                customer();
                loop2 =false;
            }
        }
    }
}
