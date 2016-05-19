package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.BaseDatos;
import modelo.MetodosEstudiantes;
import vista.FRM_MantenimientoEstudiantes;
import vista.PrincipalVentana;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener{
    
    public MetodosEstudiantes metodosEstudiantes;
    FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes;
    BaseDatos baseDatos;
    PrincipalVentana principal;
    PrincipalVentana pri;
    int num;
    
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes)
    {
        metodosEstudiantes= new MetodosEstudiantes();
        pri=new PrincipalVentana();
        this.frm_MantenimientoEstudiantes=frm_MantenimientoEstudiantes;
        baseDatos=new BaseDatos();
        principal=new PrincipalVentana();
        if(pri.seleccion().equalsIgnoreCase("archivo"))
        {
            num=1;
            JOptionPane.showMessageDialog(null,"entro a archivos pero no esta activado");
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(num==2)
        {
            
        
        if(e.getActionCommand().equals("Agregar"))
        {
//            metodosEstudiantes.agregarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            baseDatos.registrarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta");
            frm_MantenimientoEstudiantes.resetearGUI();
//            if(principal.seleccion.equals("Archivos"))
//            {
//               frm_MantenimientoEstudiantes.mostrarMensaje("guarda en archivos");
//            }
            
        }
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("Consulta_Rapida"))
        {            
            buscar();
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            if(baseDatos.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion()))
            {
                System.out.println("correcto");
            }
            else
            {
                System.out.println("no");
            }
            
            
           // metodosEstudiantes.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
           //metodosEstudiantes.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            if(baseDatos.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
            {
                 System.out.println("se elimino estudiante");
            }
            else
            {
                 frm_MantenimientoEstudiantes.mostrarMensaje("Cedula no se encuentra");
            }
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
       else if(num==1)
        {
             
            
        }
    }
    public void buscar()
    {
        if(frm_MantenimientoEstudiantes.verificarCedula(frm_MantenimientoEstudiantes.devolverCedula()))
        {
            if(baseDatos.existenciaEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
            {
               frm_MantenimientoEstudiantes.mostrarInformacion(baseDatos.arregloEstudiante);
               frm_MantenimientoEstudiantes.habilitarEdicion();
            }
            else
            {
                frm_MantenimientoEstudiantes.habilitarAgregar();
            }
        }
        else
        {
           frm_MantenimientoEstudiantes.mostrarMensaje("Cedula se escribio mal");
        }
        
    }
    
}
