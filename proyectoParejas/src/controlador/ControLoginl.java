/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.BaseDatos;

import vista.FRM_VentanaPrincipal;
import vista.Login;
import vista.VentanaUsuario;


/**
 *
 * @author Andrey
 */
public class ControLoginl implements ActionListener{

    Login login;
    BaseDatos base;
   
    FRM_VentanaPrincipal ventana;
    public ControLoginl(Login login) {
        this.login=login;
        base=new BaseDatos();
      
       
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
       if(e.getActionCommand().equalsIgnoreCase("Entrar")) 
       
          if(base.buscarUsuario(login.devolverUsuario()))
          {
              System.out.println("encontro usuario");
            if(base.buscarContrasena(login.devolverPassword()))
            {
               System.out.println("encontro contrasena");
              ventana= new FRM_VentanaPrincipal();
              ventana.setVisible(true);
              login.cerrar();
              
            }
          }
       else
           {
               JOptionPane.showMessageDialog(null,"no se encuentra");
           
          /*if(metodos.buscarLogin(login.devolverUsuario(),login.devolverPassword()))
           {
             JOptionPane.showMessageDialog(null,"se encuentra ususario");
             //  ventana.setVisible(true);
           }
           //else
           //{
               
           //}*/
       }
    }
    
}
