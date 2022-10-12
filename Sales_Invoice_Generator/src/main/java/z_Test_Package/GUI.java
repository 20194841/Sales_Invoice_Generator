
package z_Test_Package;

import javax.swing.*;
import java.awt.*;

public class GUI extends Frame{
   
    public void Main_Frame(){
         String data[][]={ {"101","Amit","670000"},    
                          {"102","Jai","780000"},    
                          {"101","Sachin","700000"}};    
          String column[]={"ID","NAME","SALARY"};    
          
        //Creating Objects
        JFrame frame = new JFrame("Sales Invoice Generator");
        JPanel panel = new JPanel();
        JPanel Right_panel = new JPanel(); 
        JPanel Left_panel = new JPanel();
        JMenuBar menu = new JMenuBar();
        JToolBar toolbar = new JToolBar();
        //toolbar.setRollover(true);
        //JPanel X = new JPanel(new GridLayout(1,2,3,3));
        
        //Creating the MenuBar
        JMenu m1 = new JMenu("FILE");
        menu.add(m1);
        JMenuItem menu_button_1 = new JMenuItem("Load");
        JMenuItem menu_button_2 = new JMenuItem("Save");
        m1.add(menu_button_1);
        m1.add(menu_button_2);
        toolbar.add(menu);
        

        //labels declaration
        JLabel Left_label = new JLabel("Invoice Table");
        JLabel Right_label_1 = new JLabel("Invoice Number");
        JLabel Right_label_1_1 = new JLabel("23");
        JLabel Right_label_2 = new JLabel("Invoice Date");
        JLabel Right_label_3 = new JLabel("Customer Name");
        JLabel Right_label_4 = new JLabel("Invoice Items");

        //Button declaration 
        JButton creat = new JButton("Create New Invoice");
        JButton delete = new JButton("Delet Invoice");       
        JButton save = new JButton("Save");
        JButton cancel = new JButton("Cancel");
        
        //Text field declaration 
        JTextField Text1 = new JTextField(20);
        JTextField Text2 = new JTextField(20);      
        
            
    /*JTable Table=new JTable(data,column);    
    Table.setBounds(30,40,200,300);          
    JScrollPane sp=new JScrollPane(Table);    */
        
      
        Right_panel.setLayout(new GridLayout(0,2));
        Left_panel.setLayout(new BorderLayout());
        Left_panel.setBorder(BorderFactory.createLineBorder(Color.black));
        Right_panel.setBorder(BorderFactory.createLineBorder(Color.black));



      

        //Left_panel.setLayout(new GridLayout(6, 2));
        //Add componants to the panels 
        Right_panel.add(Right_label_1); // Components Added using Flow Layout
        Right_panel.add(Right_label_1_1);
        Right_panel.add(Right_label_2);
        Right_panel.add(Text1);
        Right_panel.add(Right_label_3);
        Right_panel.add(Text2);
        Right_panel.add(save);
        Right_panel.add(cancel);
        
        Left_panel.add(Left_label); // Components Added using Flow Layout
        Left_panel.add(creat);
        Left_panel.add(delete);

        
        panel.setLayout(new GridLayout(1,2));
        panel.add(Left_panel);
        //panel.add
        panel.add(Right_panel);
        
        //Adding Components to the frame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        Left_panel.add(BorderLayout.NORTH, Left_label);
        Left_panel.add(BorderLayout.SOUTH, creat);
        Left_panel.add(BorderLayout.SOUTH, delete);
        frame.getContentPane().add(BorderLayout.NORTH, toolbar);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        
    }
    
}
