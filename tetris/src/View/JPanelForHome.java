package View;

import javax.swing.*;
import java.awt.*;

public class JPanelForHome extends JPanel {
    public JPanelForHome(String a) {
        setLayout(null);
        setLocation(0, 0);

        JLabel welcome=new JLabel(a);
        welcome.setFont(new Font("Serif", Font.BOLD, 50));
        welcome.setBounds(350,25,500,200);
        add(welcome);




        setBackground(Color.gray);
        setSize(900, 750);

        setVisible(false);


    }

}
