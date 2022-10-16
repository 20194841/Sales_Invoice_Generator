
package View;

import javax.swing.*;
import java.awt.*;


public class GUI {
    public void Main_Frame(){
         String data[][]={ {"101","Amit","670000"},    
                          {"102","Jai","780000"},    
                          {"101","Sachin","700000"}};    
          String column[]={"ID","NAME","SALARY"};    
          
        //Creating Objects
        JFrame frame = new JFrame("Sales Invoice Generator");
        JPanel panel = new JPanel();
        JPanel RightPanel = new JPanel(); 
        JPanel LeftPanel = new JPanel();
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
        JLabel LeftLabel = new JLabel("Invoice Table");
        JLabel RightLabel_1 = new JLabel("Invoice Number");
        JLabel RightLabel_1_1 = new JLabel("23");
        JLabel RightLabel_2 = new JLabel("Invoice Date");
        JLabel RightLabel_3 = new JLabel("Customer Name");
        JLabel RightLabel_4 = new JLabel("Invoice Items");

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
        
      
        RightPanel.setLayout(new GridLayout(0,2));
        LeftPanel.setLayout(new BorderLayout());
        LeftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        RightPanel.setBorder(BorderFactory.createLineBorder(Color.black));



      

        //LeftPanel.setLayout(new GridLayout(6, 2));
        //Add componants to the panels 
        RightPanel.add(RightLabel_1); // Components Added using Flow Layout
        RightPanel.add(RightLabel_1_1);
        RightPanel.add(RightLabel_2);
        RightPanel.add(Text1);
        RightPanel.add(RightLabel_3);
        RightPanel.add(Text2);
        RightPanel.add(save);
        RightPanel.add(cancel);
        
        LeftPanel.add(LeftLabel); // Components Added using Flow Layout
        LeftPanel.add(creat);
        LeftPanel.add(delete);

        
        panel.setLayout(new GridLayout(1,2));
        panel.add(LeftPanel);
        //panel.add
        panel.add(RightPanel);
        
        //Adding Components to the frame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        LeftPanel.add(BorderLayout.NORTH, LeftLabel);
        LeftPanel.add(BorderLayout.SOUTH, creat);
        LeftPanel.add(BorderLayout.SOUTH, delete);
        frame.getContentPane().add(BorderLayout.NORTH, toolbar);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        
    }
    
}
