
package Model;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class FileOperations {
    public static ArrayList<InvoiceHeader> readFile(){
        ArrayList<InvoiceHeader> InvoiceHeaderList = new ArrayList<InvoiceHeader>();

        String Line = "";  
        String HeaderPath ="";
        String LinePath ="";
        try   
        {    
        JFileChooser Chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        JOptionPane.showMessageDialog(null,"Choose Header File first then choose the Invoice Line file");
        //Get path of the Header file
        int Press = Chooser.showSaveDialog(null);
        if (Press == JFileChooser.APPROVE_OPTION)
               HeaderPath = Chooser.getSelectedFile().getAbsolutePath();
        else
               HeaderPath = "Operation Canceled";
        //Get path of the Line file
        int Press2 = Chooser.showSaveDialog(null);
        if (Press2 == JFileChooser.APPROVE_OPTION)
               LinePath = Chooser.getSelectedFile().getAbsolutePath();
        else
               LinePath = "Operation Canceled";
        
        BufferedReader BF = new BufferedReader(new FileReader(HeaderPath));  
       // InvoiceHeader IH = new InvoiceHeader(Data[0], Data[1], Data[2]);
        while ((Line = BF.readLine()) != null){         
            String[] Data = Line.split(",");    // use comma as separator  
           InvoiceHeaderList.add(new InvoiceHeader(Integer.parseInt(Data[0]), Data[1], Data[2]));
           }        
        }   
       catch (IOException X){  
            X.printStackTrace();  
        } 
        
         
        return InvoiceHeaderList;
    }
    
}
