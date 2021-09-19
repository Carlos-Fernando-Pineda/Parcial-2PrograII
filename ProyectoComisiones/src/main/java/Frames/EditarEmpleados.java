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
public class EditarEmpleados extends JFrame implements ActionListener{
    private static final String nombreArchivo = "C:\\tmp\\prograII\\vendedores.txt";
    private static final NominaVendedores vendedores = new NominaVendedoresImpl();
    JButton introducir;
    JTextField codigo, nombre, enero, febrero, marzo;
    EditarEmpleados(){
        
        codigo = new JTextField();
        codigo.setText("Codigo");
        codigo.setPreferredSize(new Dimension(150,40));
        codigo.setFont(new Font("Consolas",Font.PLAIN,15));
        nombre = new JTextField();
        nombre.setText("Nombre");
        nombre.setPreferredSize(new Dimension(150,40));
        nombre.setFont(new Font("Consolas",Font.PLAIN,15));
        enero = new JTextField();
        enero.setText("Enero");
        enero.setPreferredSize(new Dimension(150,40));
        enero.setFont(new Font("Consolas",Font.PLAIN,15));
        febrero = new JTextField();
        febrero.setText("Febrero");
        febrero.setPreferredSize(new Dimension(150,40));
        febrero.setFont(new Font("Consolas",Font.PLAIN,15));
        marzo = new JTextField();
        marzo.setText("Marzo");
        marzo.setPreferredSize(new Dimension(150,40));
        marzo.setFont(new Font("Consolas",Font.PLAIN,15));
        introducir = new JButton();
        introducir.setText("Introducir");
        introducir.addActionListener(this);
        introducir.setFocusable(false);
        
        this.add(codigo);
        this.add(nombre);
        this.add(enero);
        this.add(febrero);
        this.add(marzo);
        this.add(introducir);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==introducir){
            ClsVendedoresJDBC vendeJDBC = new ClsVendedoresJDBC();
            ClsVendedor nuevo = new ClsVendedor();
            int code = Integer.parseInt(codigo.getText());
            String name = nombre.getText();
            nuevo.setNombre(name);
            Double E = Double.parseDouble(enero.getText());
            nuevo.setEnero(E);
            Double F = Double.parseDouble(febrero.getText());
            nuevo.setFebrero(F);
            Double M = Double.parseDouble(marzo.getText());
            nuevo.setMarzo(M);
            vendeJDBC.actualizar(nuevo);
            vendedores.Editar(nombreArchivo, name, code, 1);
            vendedores.Editar(nombreArchivo, String.valueOf(enero), code, 2);
            vendedores.Editar(nombreArchivo, String.valueOf(febrero), code, 3);
            vendedores.Editar(nombreArchivo, String.valueOf(marzo), code, 4);
            this.dispose();
            JOptionPane.showMessageDialog(null, "Empleado editado correctamente.", "Actualizacion de empleado", JOptionPane.PLAIN_MESSAGE);
            Menu menu = new Menu();           
        }
    }
    
}
