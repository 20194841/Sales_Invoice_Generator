
package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class FileOperations {
    public static ArrayList<InvoiceHeader> readFile(){
        ArrayList<InvoiceHeader> InvoiceHeaderList = new ArrayList<InvoiceHeader>();
        String Line = "";  
        String Path ="";
        int i = 0 ;
        try   
        {  
        JFileChooser Chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int Press = Chooser.showSaveDialog(null);
        if (Press == JFileChooser.APPROVE_OPTION)
               Path = Chooser.getSelectedFile().getAbsolutePath();
        else
               Path = "Operation Canceled";
        BufferedReader BF = new BufferedReader(new FileReader(Path));  
        InvoiceHeader IH = new InvoiceHeader();
        while ((Line = BF.readLine()) != null){         
            String[] Data = Line.split(",");    // use comma as separator  
            IH.setInvoiceNumber(Integer.parseInt(Data[0]));
            IH.setInvoiceDate(Data[1]);
            IH.setCustomerName(Data[2]);
            InvoiceHeaderList.add(IH);      
           }  
        }   
       catch (IOException X){  
            X.printStackTrace();  
        } 
        return InvoiceHeaderList;
    }
    
}
