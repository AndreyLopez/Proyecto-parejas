package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.BaseDatos;
import modelo.EstudianteXML;
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
    EstudianteXML xml;
   // int num;
    
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes)
    {
        metodosEstudiantes= new MetodosEstudiantes();
        //pri=new PrincipalVentana();
        this.frm_MantenimientoEstudiantes=frm_MantenimientoEstudiantes;
        baseDatos=new BaseDatos();
        xml=new EstudianteXML(frm_MantenimientoEstudiantes);
        principal=new PrincipalVentana();
       
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getActionCommand().equals("Agregar"))
        {
            if(PrincipalVentana.numSeleccion==2)
          {
            

            baseDatos.registrarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta en base datos");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
            if(PrincipalVentana.numSeleccion==1)
            {
              System.out.println("Se seleccionó archivos");
            }
            if(PrincipalVentana.numSeleccion==3)
            {
                 xml.guardarEnXML(frm_MantenimientoEstudiantes.devolverInformacion());
                 frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta en xml");
                 frm_MantenimientoEstudiantes.resetearGUI();
                
            }
        }
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("Consulta_Rapida"))
        {            
            if(PrincipalVentana.numSeleccion==2){
            buscarBase();
            }
            else if(PrincipalVentana.numSeleccion==1){
             System.out.println("Archivos");
            }
             else if(PrincipalVentana.numSeleccion==3){
            buscarXML();
            }

        }
        
        
        if(e.getActionCommand().equals("Modificar"))
        {
            
            if(PrincipalVentana.numSeleccion==2)
            {
                if(baseDatos.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion()))
                {
                    
                     frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta en base datos.");
                     frm_MantenimientoEstudiantes.resetearGUI();
                }
                else
                {
                    frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante no se encuentra");
                }
                
               
            }
            if(PrincipalVentana.numSeleccion==1)
            {
                System.out.println("Se seleccionó archivos");
            }
            if(PrincipalVentana.numSeleccion==3)
            {
                xml.modificarInformacionDelXml(frm_MantenimientoEstudiantes.devolverInformacion());
                frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta en xml.");
                frm_MantenimientoEstudiantes.resetearGUI();
            }
            
           // metodosEstudiantes.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
//            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta.");
//            frm_MantenimientoEstudiantes.resetearGUI();
        }
        
        
        
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(PrincipalVentana.numSeleccion==2)
            {    
                //metodosEstudiantes.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
                 if(baseDatos.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
                 {
                      
                      frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta base datos");
                      frm_MantenimientoEstudiantes.resetearGUI();
                 }
                 else
                 {
                      frm_MantenimientoEstudiantes.mostrarMensaje("Cedula no se encuentra");
                 }
                 
            }
            if(PrincipalVentana.numSeleccion==1)
            {
                System.out.println("Se seleccionó archivos");
            }
            if(PrincipalVentana.numSeleccion==3)
            {
                 xml.eliminarInformacionDelXml(frm_MantenimientoEstudiantes.devolverCedula());
                 frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta en xml.");
                 frm_MantenimientoEstudiantes.resetearGUI();
            }
            
       }
        
    
    }
    public void buscarBase()
    {
        
            if(baseDatos.existenciaEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
            {
               frm_MantenimientoEstudiantes.mostrarInformacion(baseDatos.arregloEstudiante);
               frm_MantenimientoEstudiantes.habilitarEdicion();
            }
            else
            {
                 frm_MantenimientoEstudiantes.mostrarMensaje("Cedula se escribio mal");
                frm_MantenimientoEstudiantes.habilitarAgregar();
            }
      
       
        
    }
    
     public void buscarXML()
    {
        
            if(xml.consultarInformacionDelXml(frm_MantenimientoEstudiantes.devolverCedula()))
            {
               frm_MantenimientoEstudiantes.mostrarInformacionXML(xml.getArregloInformacion());
               frm_MantenimientoEstudiantes.habilitarEdicion();
            }
            else
            {
                 frm_MantenimientoEstudiantes.mostrarMensaje("Cedula se escribio mal");
                frm_MantenimientoEstudiantes.habilitarAgregar();
            }
      
       
        
    }
    
}
