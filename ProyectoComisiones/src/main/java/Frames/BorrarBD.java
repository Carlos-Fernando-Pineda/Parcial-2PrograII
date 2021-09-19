/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Datos.ClsVendedoresJDBC;
import Dominio.ClsVendedor;
import Negocio.NominaVendedores;
import Negocio.NominaVendedoresImpl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author carlo
 */
public class BorrarBD extends JFrame implements ActionListener{
    private static final NominaVendedores vendedores = new NominaVendedoresImpl();
    JButton delete;
    JTextField code;
    BorrarBD(){
        this.setTitle("Empleado a borrar");
        delete = new JButton();
        delete.setText("Borrar");
        delete.addActionListener(this);
        delete.setFocusable(false);
        code = new JTextField();
        code.setText("ID a borrar");
        code.setPreferredSize(new Dimension(150,40));
        code.setFont(new Font("Consolas",Font.PLAIN,15));
        
        this.add(delete);
        this.add(code);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==delete){
            ClsVendedoresJDBC vendeJDBC = new ClsVendedoresJDBC();
            ClsVendedor nuevo = new ClsVendedor();
            nuevo.setCodigo(Integer.parseInt(code.getText()));
            vendeJDBC.borrar(nuevo);
            JOptionPane.showMessageDialog(null, "El registro ha sido eliminado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            Menu menu = new Menu();
        }
        
    }
}
