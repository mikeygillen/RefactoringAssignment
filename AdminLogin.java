import javax.swing.*;

public class AdminLogin extends Menu implements Interface {

    public AdminLogin(){
        boolean loop = true, loop2 = true;
        boolean cont = false;
        while(loop)
        {
            String adminUsername = JOptionPane.showInputDialog(f, "Enter Administrator Username:");

            if(!adminUsername.equals("admin"))//search admin list for admin with matching admin username
            {
                int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect Username. Try again?", JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.NO_OPTION)
                {
                    f1.dispose();
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
            String adminPassword = JOptionPane.showInputDialog(f, "Enter Administrator Password;");

            if(!adminPassword.equals("admin11"))//search admin list for admin with matching admin password
            {
                int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect Password. Try again?", JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.NO_OPTION){
                    //f1.dispose();
                    loop2 = false;
                    menuStart();
                }
            }
            else
            {
                loop2 =false;
                cont = true;
            }
        }

        if(cont)
        {
            //f1.dispose();
            admin();
        }
    }
}
