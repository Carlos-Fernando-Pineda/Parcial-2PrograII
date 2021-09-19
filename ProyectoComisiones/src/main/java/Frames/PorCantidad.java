/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Datos.AccesoDatos;
import Datos.AccesoDatosImpl;
import Excepciones.LecturaDatosEx;
import Negocio.NominaVendedores;
import Negocio.NominaVendedoresImpl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author carlo
 */
public class PorCantidad extends JFrame implements ActionListener{
    private final AccesoDatos datos;
    private static final String nombreArchivo = "C:\\tmp\\prograII\\vendedores.txt";
    private static final NominaVendedores vendedores = new NominaVendedoresImpl();
    
    JButton introducir;
    JTextField numero;
    
    PorCantidad(){
        this.datos = new AccesoDatosImpl();
        
        introducir = new JButton();
        introducir.setText("Buscar");
        introducir.addActionListener(this);
        introducir.setFocusable(false);
        numero = new JTextField();
        numero.setText("No_Buscar");
        numero.setPreferredSize(new Dimension(150,40));
        numero.setFont(new Font("Consolas",Font.PLAIN,15));
        
        this.add(introducir);
        this.add(numero);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==introducir){
            Double Cantidad = Double.parseDouble(numero.getText());
            String r = null;
            try{
                r=datos.buscar(nombreArchivo, Cantidad);
            }catch(LecturaDatosEx ex){
                System.out.println("Error de lectura a datos");
                ex.printStackTrace(System.out);
            }
            JOptionPane.showMessageDialog(null, "El resultado es: "+r, "Informacion", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            Menu menu = new Menu();
        }
    }
}
