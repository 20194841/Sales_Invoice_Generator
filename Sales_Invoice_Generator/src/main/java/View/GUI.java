
package View;

import Controller.ActionHandeler;
import Model.FileOperations;
import Model.InvoiceHeader;
import Model.InvoiceLine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class GUI {
    public void Main_Frame(){
        InvoiceHeader IH = new InvoiceHeader();
        
        ArrayList<InvoiceHeader> IHL = new ArrayList<InvoiceHeader>();
        ArrayList<InvoiceLine> ILL = new ArrayList<InvoiceLine>();


        //Creating Objects
        JFrame frame = new JFrame("Sales Invoice Generator");
        JPanel panel = new JPanel();
        JPanel RightPanel = new JPanel(); 
        JPanel LeftPanel = new JPanel();
        JPanel RightTop = new JPanel();
        JPanel RightCenter = new JPanel();
        JPanel RightSouth = new JPanel();
        JPanel LeftCenter = new JPanel();
        JPanel LeftSouth = new JPanel();
        JTable HeaderTable = new JTable();
        JTable LineTable = new JTable();
        JMenuBar menu = new JMenuBar();
        JToolBar toolbar = new JToolBar();
       
        //Creating the MenuBar
        JMenu m1 = new JMenu("FILE");
        menu.add(m1);
        JMenuItem menu_button_1 = new JMenuItem("Load");
        JMenuItem menu_button_2 = new JMenuItem("Save");
        m1.add(menu_button_1);
        m1.add(menu_button_2);
        toolbar.add(menu);
    
        //labels declaration and initialaization
        JLabel LeftLabel = new JLabel("  Invoice Table");
        JLabel RightLabel_1 = new JLabel(" Invoice Number");
        JLabel RightLabel_1_1 = new JLabel("23");
        JLabel RightLabel_2 = new JLabel(" Invoice Date");
        JLabel RightLabel_2_1 = new JLabel("10/10/2020");
        JLabel RightLabel_3 = new JLabel(" Customer Name");
        JLabel RightLabel_3_1 = new JLabel(" Mohamed Elbadri");
        JLabel RightLabel_4 = new JLabel(" Total");
        JLabel RightLabel_4_1 = new JLabel(" 50"+"  LE");
        JLabel RightLabel_5 = new JLabel(" Invoice Items");
        //Separators declaration 
        JLabel NewLine_1 = new JLabel(" ");
        JLabel NewLine_2 = new JLabel(" ");
        JLabel NewLine_3 = new JLabel(" ");
        JLabel NewLine_4 = new JLabel(" ");
        JLabel NewLine_5 = new JLabel(" ");
        JLabel NewLine_6 = new JLabel(" ");
        JLabel NewLine_7 = new JLabel(" ");
        JLabel NewLine_8 = new JLabel(" ");

        //Button declaration and initialaization
        JButton creat = new JButton("Create New Invoice");
        JButton delete = new JButton("Delete Invoice");       
        JButton save = new JButton("Add New Item");
        JButton cancel = new JButton("Delete Item");
        
        //Table initialaization
        HeaderTable.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] {"NO.","DATE","NAME","TOTAL"}));
        LineTable.setModel(new DefaultTableModel(
                new Object[][] {},              
                new String[] {"NO.","ITEM NAME","ITEM PRICE","COUNT","ITEM TOTAL"}));
        JScrollPane LeftTable = new JScrollPane(HeaderTable);
        JScrollPane RightTable = new JScrollPane(LineTable);
        HeaderTable.setFillsViewportHeight(true);
        LineTable.setFillsViewportHeight(true);
        
        //Load Last state
        DefaultTableModel IHModel = (DefaultTableModel) HeaderTable.getModel();
        DefaultTableModel ILModel = (DefaultTableModel) LineTable.getModel();
        
        
        //Main panel declaration and initialization
        panel.setLayout(new GridLayout(1,2));
        panel.add(LeftPanel);
        panel.add(RightPanel);      
               
        //Set Layout of the panels
        RightPanel.setLayout(new BorderLayout());
        LeftPanel.setLayout(new BorderLayout());
        LeftSouth.setLayout(new FlowLayout());
        RightSouth.setLayout(new FlowLayout());
        RightTop.setLayout(new GridLayout(9,2));

        //Set border to the panels
        LeftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        RightPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        //Components Added using Flow Layout
        RightTop.add(RightLabel_1); 
        RightTop.add(RightLabel_1_1);
        RightTop.add(NewLine_1);            //separator
        RightTop.add(NewLine_2);            //separator
        RightTop.add(RightLabel_2);
        RightTop.add(RightLabel_2_1);
        RightTop.add(NewLine_3);            //separator
        RightTop.add(NewLine_4);            //separator
        RightTop.add(RightLabel_3);
        RightTop.add(RightLabel_3_1);
        RightTop.add(NewLine_5);            //separator
        RightTop.add(NewLine_6);            //separator 
        RightTop.add(RightLabel_4);
        RightTop.add(RightLabel_4_1);
        RightTop.add(NewLine_7);            //separator
        RightTop.add(NewLine_8);            //separator 
        RightTop.add(RightLabel_5);
        RightSouth.add(save);
        RightSouth.add(cancel);
        RightCenter.add(RightTable);

        // Components Added in the left panel
        LeftSouth.add(creat);
        LeftSouth.add(delete);     
        LeftCenter.add(LeftTable);

        // Add componants to the panel
        RightPanel.add(BorderLayout.NORTH, RightTop);
        RightPanel.add(BorderLayout.CENTER,RightCenter);
        RightPanel.add(BorderLayout.SOUTH, RightSouth);
        LeftPanel.add(BorderLayout.NORTH, LeftLabel);
        LeftPanel.add(BorderLayout.CENTER,LeftCenter);
        LeftPanel.add(BorderLayout.SOUTH, LeftSouth);
        
        //Action
        ActionHandeler Action = new ActionHandeler();
        menu_button_1.addActionListener((ActionListener) Action);
        menu_button_2.addActionListener((ActionListener) Action);

        
        //frame declaration
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.getContentPane().add(BorderLayout.NORTH, toolbar);
        frame.getContentPane().add(panel);
        frame.setVisible(true); 
    }  
}
