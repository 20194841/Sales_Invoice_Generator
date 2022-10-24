package view;

import controller.*;
import model.InvoiceHeader;
import model.InvoiceLine;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.LoadedInvoices;

public class GUI extends JFrame {

     // txt field declaration
    private static JTextField invoiceNumber;
    private static JTextField invoiceDate;
    private static JTextField customerName;
    private static JTextField invoiceTotal;
    
    // table declaration
    private static final String[] InvoicesTableHeader = new String[]{"No.","Date","Customer","Total"};
    private static final String[] LineTableHeader = new String[]{"No.","Item Name","Item Price","Count","Item Total"};
    private static DefaultTableModel LineTableModel;
    private static DefaultTableModel InvoicesTableModel;
    private static JTable invoicesTable;
    private static JTable LineTable;
    
  
    // initial data
    static String InitialCS;
    static String InitialID;
    static String[][] InitialTD;

    public GUI() {
        
        // top menu declaration and initialaization
        JMenu menu = new JMenu("File");
        JMenuItem loadFile = new JMenuItem("Load File");
        ActionHandeler Action = new ActionHandeler();
        loadFile.addActionListener((ActionListener) Action);
        menu.add(loadFile);
        JMenuItem saveFile = new JMenuItem("Save File");
        saveFile.addActionListener((ActionListener) Action);
        menu.add(saveFile);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        // table model
        InvoicesTableModel = new DefaultTableModel() {};
        InvoicesTableModel.setColumnIdentifiers(InvoicesTableHeader);

        invoicesTable = new JTable(InvoicesTableModel);
        invoicesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        MouseClick invoicesTableListener = new MouseClick();
        invoicesTable.addMouseListener(invoicesTableListener);
        JPanel invoicesPanel = new JPanel();
        invoicesPanel.setBorder(BorderFactory.createTitledBorder("Invoice Table"));
        JScrollPane sp2 = new JScrollPane(invoicesTable);
        sp2.setPreferredSize(new Dimension(380, 310));
        invoicesPanel.add(sp2);

        
        // Create new invoice button Declaration
        JButton createNewInvoice = new JButton("Create New Invoice");
        createNewInvoice.addActionListener((ActionListener) Action);

        // Delete invoice button Declaration
        JButton deleteInvoice = new JButton("Delete Invoice");
        deleteInvoice.addActionListener((ActionListener) Action);

        // Left side panel Declaration
        JPanel leftSidePanel = new JPanel();
        leftSidePanel.add(invoicesPanel);
        leftSidePanel.add(createNewInvoice);
        leftSidePanel.add(deleteInvoice);
        this.add(leftSidePanel);

        // Invoice number text field Declaration
        invoiceNumber = new JTextField(20);

        // Invoice date text field Declaration
        invoiceDate = new JTextField  (20);
        
        // Customer name text field Declaration
        customerName = new JTextField (20);
        LineInformation customerNameListener = new LineInformation();
        customerName.addActionListener(customerNameListener);

        // Invoice total text field Declaration
        invoiceTotal = new JTextField (20);

        // Invoice form Declaration
        JPanel invoiceFormPanel = new JPanel();
        invoiceFormPanel.setLayout(new GridLayout(4,2));
        invoiceFormPanel.add(new JLabel("Invoice Number"));
        invoiceFormPanel.add(invoiceNumber);
        invoiceFormPanel.add(new JLabel("Invoice Date"));
        invoiceFormPanel.add(invoiceDate);
        invoiceFormPanel.add(new JLabel("Customer Name"));
        invoiceFormPanel.add(customerName);
        invoiceFormPanel.add(new JLabel("Invoice Total"));
        invoiceFormPanel.add(invoiceTotal);


        // Invoice items table Declaration
        LineTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells in first and last columns are false
                return column != 0 && column != 4;
            }
        };
        LineTableModel.setColumnIdentifiers(LineTableHeader);
        LineTable = new JTable(LineTableModel);
        LineTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        LineTable itemsTableListener = new LineTable();
        LineTableModel.addTableModelListener(itemsTableListener);
        JPanel invoiceItemsPanel = new JPanel();
        invoiceItemsPanel.setLayout(new FlowLayout());
        invoiceItemsPanel.setBorder(BorderFactory.createTitledBorder("Invoice Items"));
        JScrollPane sp1 = new JScrollPane(LineTable);
        sp1.setPreferredSize(new Dimension(380, 240));
        invoiceItemsPanel.add(sp1);

        // Save button Declaration
        JButton createItem = new JButton("Create Item");
        createItem.addActionListener((ActionListener) Action);

        // Cancel button Declaration
        JButton deleteItem = new JButton("Delete Item");
        deleteItem.addActionListener((ActionListener) Action);

        // Left side panel Declaration 
        JPanel rightSidePanel = new JPanel();
        rightSidePanel.setLayout(new FlowLayout());
        rightSidePanel.add(invoiceFormPanel);
        rightSidePanel.add(invoiceItemsPanel);
        rightSidePanel.add(createItem);
        rightSidePanel.add(deleteItem);
        this.add(rightSidePanel);
        this.setVisible(true);
        
        
        // frame Declaration
        this.setTitle("SIG");
        this.setSize(1000, 500);
        this.setLocation(300,150);
        this.setLayout(new GridLayout(1,2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void AddRow() {
        int x=3;
        int number=x;
        String date ="Enter Date";
        String name ="Enter Name";
        InvoiceHeader newInvoice = new InvoiceHeader(number,date,name);
        LoadedInvoices.updateInvoice(newInvoice);
        GUI.updateInvoicesTable(LoadedInvoices.getInvoices());
        GUI.resetItemsTableAndInvoiceFormToDefault();
        x++;   
} 

    public static void updateInvoicesTable(ArrayList<InvoiceHeader> invoices) {
        // Update the invoices table with the array list of invoices provided
        if(invoices != null && invoices.size()>0) {
            String[][] tableData = new String[invoices.size()][4];
            for(int index = 0 ; index < invoices.size() ; index++)
            {
                tableData[index][0] = Integer.toString(invoices.get(index).getInvoiceNum());
                tableData[index][1] = invoices.get(index).getInvoiceDate();
                tableData[index][2] = invoices.get(index).getCustomerName();
                double total = 0;
                if (invoices.get(index).getInvoiceLines() == null || invoices.get(index).getInvoiceLines().size() == 0) {
                }
                else {
                    for (InvoiceLine item : invoices.get(index).getInvoiceLines()) {
                        total = total + (item.getCount() * item.getItemPrice());
                    }
                }
                tableData[index][3] = Double.toString(total);
            }
            InvoicesTableModel.setDataVector(tableData,InvoicesTableHeader);
            InvoicesTableModel.fireTableDataChanged();
        } else{
            
            InvoicesTableModel.setNumRows(0);
            InvoicesTableModel.fireTableDataChanged();
        }
    }


    public static void updateLineTableAndInvoiceForm(InvoiceHeader invoice) {
        if (invoice == null) 
        {
            return;
        }
        // Update the invoice form and the items table with the provided invoice info
        invoiceNumber.setText(Integer.toString(invoice.getInvoiceNum()));
        invoiceDate.setText(invoice.getInvoiceDate());
        customerName.setText(invoice.getCustomerName());
        InitialCS = invoice.getCustomerName();
        InitialID = invoice.getInvoiceDate();

        ArrayList<InvoiceLine> items = invoice.getInvoiceLines();
        double total = 0;
        if (items == null || items.size() == 0) {
            LineTableModel.setNumRows(0);
            LineTableModel.fireTableDataChanged();
        }
        else {
            String[][] itemsData= new String[items.size()][5];
            for (int index = 0 ; index< items.size() ; index++) {
                total = total + (items.get(index).getCount() * items.get(index).getItemPrice());
                itemsData[index][0] = Integer.toString(invoice.getInvoiceNum());
                itemsData[index][1] = items.get(index).getItemName();
                itemsData[index][2] = Double.toString(items.get(index).getItemPrice());
                itemsData[index][3] = Integer.toString(items.get(index).getCount());
                itemsData[index][4] = Double.toString(items.get(index).getCount() * items.get(index).getItemPrice());
            }
            LineTableModel.setDataVector(itemsData,LineTableHeader);
            InitialTD = itemsData;
            LineTableModel.fireTableDataChanged();
        }
        invoiceTotal.setText(Double.toString(total));
    }

    public static void resetItemsTableAndInvoiceFormToDefault() {
        invoiceNumber.setText("");
        invoiceDate.setText("");
        customerName.setText("");
        invoiceTotal.setText("");
        InitialID = "";
        InitialCS = "";
        InitialTD = null;
        LineTableModel.setNumRows(0);
        LineTableModel.fireTableDataChanged();
    }

    public static int getSelectedInvoiceNumber() {
        if (invoicesTable.getSelectedRow() == -1)
        {
            return -1;
        }
        return Integer.parseInt(invoicesTable.getValueAt(invoicesTable.getSelectedRow(),0).toString());
    }

    public static int getInvoiceNumber() {
        return Integer.parseInt(invoiceNumber.getText());
    }

    public static int getSelectedItemIndex() {
        return LineTable.getSelectedRow();
    }
}
