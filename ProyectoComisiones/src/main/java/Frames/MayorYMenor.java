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
public class MayorYMenor extends JFrame implements ActionListener{
    private final AccesoDatos datos;
    private static final String nombreArchivo = "C:\\tmp\\prograII\\vendedores.txt";
    private static final NominaVendedores vendedores = new NominaVendedoresImpl();
    
    JButton enero, febrero, marzo;
    
    MayorYMenor(){
        this.datos = new AccesoDatosImpl();
        
        this.setTitle("Escoger un mes para mostrar los datos");
        enero = new JButton();
        enero.setText("Enero");
        enero.addActionListener(this);
        enero.setFocusable(false);
        febrero = new JButton();
        febrero.setText("Febrero");
        febrero.addActionListener(this);
        febrero.setFocusable(false);
        marzo = new JButton();
        marzo.setText("Marzo");
        marzo.addActionListener(this);
        marzo.setFocusable(false);
        
        this.add(enero);
        this.add(febrero);
        this.add(marzo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==enero){
        int mes = 1;
        Double M = 0.0;
        Double m = 0.0;
        String N = null;
        String n = null;
        try {
            List<MdVendedor> vendedores = datos.listar(nombreArchivo);
            for (MdVendedor vendedor : vendedores){
                String[] DatosVendedores = vendedor.toString().split("\\|");
                if(Double.valueOf(DatosVendedores[mes]) > M){
                    M = Double.valueOf(DatosVendedores[mes]);
                    N = DatosVendedores[0];
                }
                if (Double.valueOf(DatosVendedores[mes]) < m){
                    m = Double.valueOf(DatosVendedores[mes]);
                    n = DatosVendedores[0];
                }
            }
            if (N != null && n != null){
                JOptionPane.showMessageDialog(null, "El Mayor es: "+ N+" con ventas de : "+M+"\nEl Menor es: "+n+" con ventas de: "+m, "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (LecturaDatosEx ex){
            System.out.println("Error en la lectura de Datos");
            ex.printStackTrace(System.out);
        }this.dispose();
        Menu menu = new Menu();
        }else if(e.getSource()==febrero){
        int mes = 2;
        Double M = 0.0;
        Double m = 0.0;
        String N = null;
        String n = null;
        try {
            List<MdVendedor> vendedores = datos.listar(nombreArchivo);
            for (MdVendedor vendedor : vendedores){
                String[] DatosVendedores = vendedor.toString().split("\\|");
                if(Double.valueOf(DatosVendedores[mes]) > M){
                    M = Double.valueOf(DatosVendedores[mes]);
                    N = DatosVendedores[0];
                     }
                if (Double.valueOf(DatosVendedores[mes]) < m){
                    m = Double.valueOf(DatosVendedores[mes]);
                    n = DatosVendedores[0];
                }
            }
            if (N != null && n != null){
                JOptionPane.showMessageDialog(null, "El Mayor es: "+ N+" con ventas de : "+M+"\nEl Menor es: "+n+" con ventas de: "+m, "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (LecturaDatosEx ex){
            System.out.println("Error en la lectura de Datos");
            ex.printStackTrace(System.out);
        }this.dispose();
        Menu menu = new Menu();
        }else if(e.getSource()==marzo){
        int mes = 3;
        Double M = 0.0;
        Double m = 0.0;
        String N = null;
        String n = null;
        try {
            List<MdVendedor> vendedores = datos.listar(nombreArchivo);
            for (MdVendedor vendedor : vendedores){
                String[] DatosVendedores = vendedor.toString().split("\\|");
                if(Double.valueOf(DatosVendedores[mes]) > M){
                    M = Double.valueOf(DatosVendedores[mes]);
                    N = DatosVendedores[0];
                     }
                if (Double.valueOf(DatosVendedores[mes]) < m){
                    m = Double.valueOf(DatosVendedores[mes]);
                    n = DatosVendedores[0];
                }
            }
            if (N != null && n != null){
                JOptionPane.showMessageDialog(null, "El Mayor es: "+ N+" con ventas de : "+M+"\nEl Menor es: "+n+" con ventas de: "+m, "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (LecturaDatosEx ex){
            System.out.println("Error en la lectura de Datos");
            ex.printStackTrace(System.out);
        }this.dispose();
        Menu menu = new Menu();
        }
    }
}
