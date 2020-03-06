import java.util.ArrayList;

public class Helper extends Menu {

    public static boolean isNumeric(String str)  // a method that tests if a string is numeric
    {
        try
        {
            Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public static void displayCustomer(ArrayList<Customer> customerList, int position){
        firstNameTextField.setText(customerList.get(position).getFirstName());
        surnameTextField.setText(customerList.get(position).getSurname());
        pPSTextField.setText(customerList.get(position).getPPS());
        dOBTextField.setText(customerList.get(position).getDOB());
        customerIDTextField.setText(customerList.get(position).getCustomerID());
        passwordTextField.setText(customerList.get(position).getPassword());
    }
}
