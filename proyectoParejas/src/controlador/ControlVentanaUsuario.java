/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import modelo.BaseDatos;

import vista.FRM_VentanaPrincipal;
import vista.VentanaUsuario;

/**
 *
 * @author Andrey
 */
public class ControlVentanaUsuario implements ActionListener{
    
    VentanaUsuario ventaUsuario;
     BaseDatos base;
    FRM_VentanaPrincipal pricipal;
    public ControlVentanaUsuario(VentanaUsuario ventaUsuario) {
       
         base=new BaseDatos();
         this.ventaUsuario=ventaUsuario;
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("Buscar"))
        {
            if(base.existenciaUsuario(ventaUsuario.devolverCedula()))
            {
               ventaUsuario.mostrar(base.arregloUsuario);
               ventaUsuario.ventana3();
               ventaUsuario.botones3();
            }
            else
            {
                  JOptionPane.showMessageDialog(null,"no se encuentra cedula");
                  ventaUsuario.ventana2();
                  ventaUsuario.botones2();
            }
            
        }
        if(e.getActionCommand().equalsIgnoreCase("Agregar"))
        {
           
           if(ventaUsuario.conprobarContrasena())
           {
               base.registrarUsuario(ventaUsuario.devolverInfo());
               JOptionPane.showMessageDialog(null,"se agrego usuario");
               ventaUsuario.inicioVentana();
               ventaUsuario.inicioBotones();
           }
           else
           {
               ventaUsuario.mensaje("Las contraseñas son distintas");
           }
          
            //System.out.println(metodos.mostrarUsuario());
           
           
           }
           
            
        
        if(e.getActionCommand().equalsIgnoreCase("Modificar"))
        {
            base.modificarUsuario(ventaUsuario.devolverInfo());
            ventaUsuario.inicioVentana();
            ventaUsuario.inicioBotones();
        }
        if(e.getActionCommand().equalsIgnoreCase("Eliminar"))
        {
            base.eliminarUsuario(ventaUsuario.devolverCedula());
            ventaUsuario.inicioVentana();
            ventaUsuario.inicioBotones();
        }
        
    }
   
}
