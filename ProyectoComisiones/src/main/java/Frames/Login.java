/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author carlo
 */
public class Login extends JFrame implements ActionListener{
    private final String Usuario = "Carlos2202";
    private final String Password = "enanon";
    JButton button;
    JTextField Username;
    JTextField Contra;
    
    public Login(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        button = new JButton("Submit");
        button.addActionListener(this);
        button.setAlignmentX(JButton.WEST);
        
        Username = new JTextField();
        Username.setPreferredSize(new Dimension(250,40));
        Username.setAlignmentX(JTextField.CENTER);
        Username.setFont(new Font("Consolas",Font.PLAIN,25));
        Username.setForeground(Color.green);
        Username.setBackground(Color.black);
        Username.setCaretColor(Color.white);
        Username.setText("username");
        
        Contra = new JTextField();
        Contra.setPreferredSize(new Dimension(250,40));
        Contra.setFont(new Font("Consolas",Font.PLAIN,25));
        Contra.setAlignmentX(JTextField.EAST);
        Contra.setForeground(Color.green);
        Contra.setBackground(Color.black);
        Contra.setCaretColor(Color.white);
        Contra.setText("password");
        
        
        this.add(button);
        this.add(Contra);
        this.add(Username);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            this.dispose();
            String user = Username.getText();
            String pass = Contra.getText();
            boolean igualesN = user.equals(Usuario);
            boolean igualesC = pass.equals(Password);
            if(igualesN && igualesC){
                System.out.println("Welcome "+ Username.getText());
                Menu menu = new Menu();
                               
            }else{
                this.dispose();
                JOptionPane.showMessageDialog(null, "Usuario incorrecto.", "Error de informacion.", JOptionPane.ERROR_MESSAGE);
                Login login = new Login();
            }

            
            
            
            //button.setEnabled(false);
            //textField.setEditable(false);
        }
    }
    
}
