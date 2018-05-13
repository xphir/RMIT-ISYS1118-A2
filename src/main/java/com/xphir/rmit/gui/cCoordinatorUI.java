package com.xphir.rmit.gui;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;

import com.xphir.rmit.gui.MainUI;

public class cCoordinatorUI extends JFrame implements ActionListener  
{  

           
        JButton jb1=new JButton();
        JButton jb2=new JButton(); 
        JPanel jp1,jp2,jp3,jp4=null;  
        JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6,jlb7 =null;  

        public static void main(String[] args)
        {  
          cCoordinatorUI  ui=new cCoordinatorUI();  
        }  
 
        public  cCoordinatorUI()     
        {  

             
            jb1=new JButton("View Task");  
            jb1.setForeground(Color.BLUE);
            jb2=new JButton("Assign Task");  
            jb2.setForeground(Color.BLUE);

            jp1=new JPanel();  
            jp2=new JPanel();  
            jp3=new JPanel();  

            jlb1=new JLabel("Hello");  
            jlb2=new JLabel("Welcome Back");  
            jlb2.setForeground(Color.red);
            jlb3=new JLabel("ID:");
            jlb4=new JLabel("News:"); 
            jlb4.setForeground(Color.red);
            jlb5=new JLabel("No School Today!");  
            jlb6=new JLabel(new MainUI().CC_name);
            jlb7=new JLabel(new MainUI().CC_num);

            jp1.add(jlb1); 
            jp1.add(jlb6);
            jp1.add(jlb2);  
            jp1.add(jlb3);
            jp1.add(jlb7);

            jp2.add(jb1);  
            jp2.add(jb2);  

            jp3.add(jlb4);
            jp3.add(jlb5); 

            add(jp1);  
            add(jp2);  
            add(jp3);  
            
            setLayout(new GridLayout(4,3,50,50));  
            setTitle("Rmit HR System");  
            setSize(400,350);  
            setLocation(200, 200);       

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

            this.setVisible(true); 
            jb1.addActionListener(this);
            jb2.addActionListener(this);


        }

        public void actionPerformed(ActionEvent e) {  
             
        	 if(e.getSource() == jb1){           
        		 
        		           
                
        		 new viewTasks();
                }
             
             else if(e.getSource() == jb2){   
            	 
            	 JOptionPane.showMessageDialog(null,"Coming soon, Michael is working on it!","OOOOps...", JOptionPane.WARNING_MESSAGE);           
                  
            	 
                }

        }  
} 