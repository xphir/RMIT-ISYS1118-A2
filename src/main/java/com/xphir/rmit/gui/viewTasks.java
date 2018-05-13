package com.xphir.rmit.gui;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

public class viewTasks extends JFrame  
{  

    public viewTasks()  
    {  
        intiComponent();  
    }  

      
    private void intiComponent()  
    {  
         
        String[] columnNames =  
        { "ID","LengthHrs","Title","Location","Day","Time","Type","Start Date","End Date","Code","Qual","Staff"};  
        Object[][] obj=new Object[12][12]; 
        for (int i=0;i<12;i++)  
        {  
            for(int j=0;j<12;j++)  
            {  
                switch (j)  
                {  
                case 0:  
                	obj[0][0] = "CSIC1";
                    obj[0][1] = "2"; 
                    obj[0][2] = "Lecture 3"; 
                    obj[0][3] = "80:02:05"; 
                    obj[0][4] = "Wednesday";
                    obj[0][5] = "1500";
                    obj[0][6] = "Marketing";
                    obj[0][7] = "15/02/2018";
                    obj[0][8] = "18/06/2018";
                    obj[0][9] = "CSOC2675";
                    obj[0][10]= "BIT";
                    obj[0][11]= "CS34";
                    
                    break;  
                case 1:  
                	obj[1][0] = "";
                    obj[1][1] = ""; 
                    obj[1][2] = ""; 
                    obj[1][3] = ""; 
                    obj[1][4] = "";
                    obj[1][5] = "";
                    obj[1][6] = "";
                    obj[1][7] = "";
                    obj[1][8] = "";
                    obj[1][9] = "";
                    obj[1][10]= "";
                    obj[1][11]= ""; 
                    break;  
                case 2:  
                	obj[2][0] = "";
                    obj[2][1] = ""; 
                    obj[2][2] = ""; 
                    obj[2][3] = ""; 
                    obj[2][4] = "";
                    obj[2][5] = "";
                    obj[2][6] = "";
                    obj[2][7] = "";
                    obj[2][8] = "";
                    obj[2][9] = "";
                    obj[2][10]= "";
                    obj[2][11]= ""; 
                    break;  
                  

                }  
            }  
        }  

        JTable table=new JTable(obj, columnNames);
        
        TableColumn column=null;                     
        int colunms = table.getColumnCount();  
        for(int i=0;i<colunms;i++)  
        {  
            column = table.getColumnModel().getColumn(i);  
            column.setPreferredWidth(100);  
        }   
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);                   
        JScrollPane scroll = new JScrollPane(table);   
        scroll.setSize(300, 50);         

        add(scroll); 

        this.setLocation(450, 200); 
        this.setSize(1225, 265);
        this.setVisible(true);    
    }  

    public static void main(String[] args)  
    {  
        new viewTasks();  
    }  
}  