package com.xphir.rmit.gui;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  

public class MainUI extends JFrame implements ActionListener {  

    //Functions    
    JButton jb1,jb2=null;    
    JPanel jp1,jp2,jp3,jp4,jp5 =null;  
    JTextField jtf=null;  
    JLabel jlb1,jlb2,jlb3,jlb4 =null;  
    JPasswordField jpf=null;  
    ButtonGroup bg=null;  

    //User name and password  
    final String CC_name="Michael";  
    final String CC_pwd="1234"; 
    final String CC_num="CC3574846"; 
    final String AP_name="Michael";  
    final String AP_pwd="1234";  
    final String AP_num="AP3574846"; 

    public static void main(String[] args) {  

        MainUI mUI=new MainUI();  
    }
    
    public MainUI()  
    {  
         //Set Buttons 
        jb1=new JButton("LOGIN");
        jb1.setPreferredSize(new Dimension(100,30));
        jb2=new JButton("EXIT");
        jb2.setPreferredSize(new Dimension(100,30));
        
        //Set Listeners 
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
        

        
        //set Panels
        jp1=new JPanel();  
        jp2=new JPanel();  
        jp3=new JPanel();  
        jp4=new JPanel();                 
        jp5=new JPanel();
        
        //set Labels
        jlb1=new JLabel("User Num:");  
        jlb2=new JLabel("Password:");  
        jlb3=new JLabel("RMIT HR SYSTEM",JLabel.CENTER);
        jlb3.setForeground(Color.red);
        jlb3.setFont(new Font("Dialog",1,20));
        
        jtf=new JTextField(10);
        jpf=new JPasswordField(10);  
        
        
        jp1.add(jlb3);
        
        jp2.add(jlb1);  
        jp2.add(jtf);  

        jp3.add(jlb2);  
        jp3.add(jpf);  
        
        jp4.add(jb1);       
        jp4.add(jb2);

        //Put them in Frame  
        add(jp1);  
        add(jp2);  
        add(jp3);  
        add(jp4);  

        
        setLayout(new GridLayout(5,1));                 
        setTitle("Rmit HR System");          
        setSize(400,300);         
        setLocation(400, 200);           
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        setVisible(true);  
        setResizable(true);  

    }  
    
    //choice of Course Coordinator or Approver
    public void actionPerformed(ActionEvent e) {            

        if(e.getActionCommand()=="LOGIN")  
        {  
        	if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())  
            {  
                JOptionPane.showMessageDialog(null,"Please enter user name and password to lgoin the system!","WRONG!",JOptionPane.WARNING_MESSAGE);  
            }
            
            //if Login with Course Coordinator ID
        	else if(jtf.getText().substring(0,2).equals("CC"))  
            {  
                  cCoordinatorlogin();                               
            }
        	
            //if Login with Approver ID
        	else if(jtf.getText().substring(0,2).equals("AP"))  
            {  
                  Approverlogin();                               
            }  
        	
        	else if(jtf.getText() !="CC"||jtf.getText() !="AP")
            {
            	JOptionPane.showMessageDialog(null,"Invaild ID","LOGIN",JOptionPane.WARNING_MESSAGE);
            }
      
        	  
        }  
    
         
         else if(e.getActionCommand()=="EXIT")  
         	{  
        	JOptionPane.showMessageDialog(null,"BYE BYE : )","EXIT",JOptionPane.WARNING_MESSAGE);           
            dispose();   
         	} 
      	}



    //Course Coordinator Login check
    public void cCoordinatorlogin()  
    {  
        if(CC_num.equals(jtf.getText())&&CC_pwd.equals(jpf.getText()))  
        {            
            JOptionPane.showMessageDialog(null,"Course Coordinator Login Successfully!","LOGIN",JOptionPane.WARNING_MESSAGE);           
            dispose();        
            clear();
            cCoordinatorUI  ui=new cCoordinatorUI();
            
        }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"Please enter user name and password to lgoin the system!","WRONG!",JOptionPane.WARNING_MESSAGE);  
        }else if(jtf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"Please enter user name!","!WRONG!",JOptionPane.WARNING_MESSAGE);  
        }else if(jpf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"Please enter password!","!WRONG!",JOptionPane.WARNING_MESSAGE);  
        }else  
        {  
            JOptionPane.showMessageDialog(null,"Invaild ID or passwrod! Please enter again!","!WRONG!",JOptionPane.ERROR_MESSAGE);  
            
            clear();  
        }  
    } 
    
    //Approver Login check 
    public void Approverlogin()  
    {  
        if(AP_num.equals(jtf.getText())&&AP_pwd.equals(jpf.getText()))  
        {  

             JOptionPane.showMessageDialog(null,"Approver Login Successfully!","LOGIN",JOptionPane.WARNING_MESSAGE);  
             clear();         
             dispose();    
             ApproverUI ui=new ApproverUI();     
        }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"Please enter user name and password to lgoin the system!","WRONG!",JOptionPane.WARNING_MESSAGE);  
        }else if(jtf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"Please enter user name!","!WRONG!",JOptionPane.WARNING_MESSAGE);  
        }else if(jpf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"Please enter password!","!WRONG!",JOptionPane.WARNING_MESSAGE);  
        }else 
        {  
            JOptionPane.showMessageDialog(null,"Invaild ID or passwrod! Please enter again!","!WRONG!",JOptionPane.ERROR_MESSAGE);  
            clear();    
        }  
    }  
    
    //clear the inputed user name and the password
    public  void clear()  
    {  
        jtf.setText("");  
        jpf.setText("");  
    }  

} 