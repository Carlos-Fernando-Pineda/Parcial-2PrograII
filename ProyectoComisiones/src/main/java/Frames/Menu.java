/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Datos.AccesoDatos;
import Datos.AccesoDatosImpl;
import Dominio.MdVendedor;
import Excepciones.LecturaDatosEx;
import Negocio.NominaVendedores;
import Negocio.NominaVendedoresImpl;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author carlo
 */
public class Menu extends JFrame implements ActionListener{
    private final AccesoDatos datos;
    private static final String nombreArchivo= "C:\\tmp\\prograII\\vendedores.txt";
    private static final NominaVendedores vendedores = new NominaVendedoresImpl();
    JButton B1,B2,B3,B4,B5,B6,B7,B8,BSalida;
    
    
    
    
    public Menu(){
        this.datos = new AccesoDatosImpl();
        B1 = new JButton();
        B2 = new JButton();
        B3 = new JButton();
        B4 = new JButton();
        B5 = new JButton();
        B6 = new JButton();
        B7 = new JButton();
        B8 = new JButton();
        BSalida = new JButton();
        
        B1.setText("Iniciar archivo");
        B1.addActionListener(this);
        B1.setFocusable(false);
        B2.setText("Agregar empleado.");
        B2.setFocusable(false);
        B2.addActionListener(this);
        B3.setText("Mayor y Menor Vendedor Por Mes.");
        B3.setFocusable(false);
        B3.addActionListener(this);
        B4.setText("Mayor Vendedor.");
        B4.setFocusable(false);
        B4.addActionListener(this);
        B5.setText("Editar");
        B5.setFocusable(false);
        B5.addActionListener(this);
        B6.setText("Buscar por Cantidad");
        B6.setFocusable(false);
        B6.addActionListener(this);
        B7.setText("Listar Informacion.");
        B7.setFocusable(false);
        B7.addActionListener(this);
        B8.setText("Borrar en base de datos.");
        B8.setFocusable(false);
        B8.addActionListener(this);
        BSalida.setText("Salir.");
        BSalida.setFocusable(false);
        BSalida.addActionListener(this);
        
        this.setTitle("Principal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setSize(750,750);
        this.setLayout(new GridLayout(3,3,10,10));
        this.getContentPane().setBackground(new Color(123,50,250));
        this.add(B1);
        this.add(B2);
        this.add(B3);
        this.add(B4);
        this.add(B5);
        this.add(B6);
        this.add(B7);
        this.add(B8);
        this.add(BSalida);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==B1){
            vendedores.iniciarArchivo(nombreArchivo);
            JOptionPane.showMessageDialog(null, "El archivo ha sido borrado y creado de nuevo!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }else if(e.getSource()==B2){
            AgregarEmpleados add = new AgregarEmpleados();
            this.dispose();        
        }else if(e.getSource()==B3){
            MayorYMenor comision = new MayorYMenor();
            this.dispose();
        }else if(e.getSource()==B4){
            Double M = 0.0;
            String r = null;
            try{
                List<MdVendedor> vendedores = datos.listar(nombreArchivo);
                for(MdVendedor vendedor : vendedores){
                    if(vendedor.getTotal() > M){
                        r = vendedor.getNombre() + "con ventas de: "+vendedor.getTotal();
                    }
                }
                JOptionPane.showMessageDialog(null, "El empleado con Mejores ventas generales es: "+r, "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }catch(LecturaDatosEx ex){
                System.out.println("Error de lectura de datos");
                ex.printStackTrace(System.out);
            }
        }else if(e.getSource()==B5){
            EditarEmpleados edit = new EditarEmpleados();
            this.dispose();           
        }else if(e.getSource()==B6){
            PorCantidad buscar = new PorCantidad();
            this.dispose();
        }else if(e.getSource()==B7){
            BorrarBD borrar = new BorrarBD();
            this.dispose();
        }else if(e.getSource()==B8){
            
        }else if(e.getSource()==BSalida){
            this.dispose();
            JOptionPane.showMessageDialog(null, "Que tenga un buen dia", "Adios", JOptionPane.PLAIN_MESSAGE);
        }else{
            System.out.println("");
        }
    }
    
}
