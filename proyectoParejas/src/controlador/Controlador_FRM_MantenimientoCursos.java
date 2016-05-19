package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.BaseDatos;
import modelo.MetodosCursos;
import vista.FRM_MantenimientoCursos;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MantenimientoCursos implements ActionListener{

    FRM_MantenimientoCursos frm_mantenimientoCursos;
    public MetodosCursos metodosCursos;
   public BaseDatos baseDatos;
    
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frm_mantenimientoCursos)
    {
        this.frm_mantenimientoCursos=frm_mantenimientoCursos;
        baseDatos=new BaseDatos();
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equals("Agregar"))
        {
            //if(frm_mantenimientoCursos.verificar(frm_mantenimientoCursos.devolverInformacion()))
            //{
                baseDatos.registrarCurso(frm_mantenimientoCursos.devolverInformacion());
               frm_mantenimientoCursos.mostrarMensaje("El estudiante fue registrado de forma correcta");
               frm_mantenimientoCursos.resetearGUI();
              
            //}
            //else
            //{
              //  JOptionPane.showMessageDialog(null,"es incorrecto el nombre");
            //}
            
        }
        if(evento.getActionCommand().equals("Consultar") || evento.getActionCommand().equals("ConsultaRapida"))
        {
            buscar();
        }
        if(evento.getActionCommand().equals("Modificar"))
        {
            baseDatos.modificarCurso(frm_mantenimientoCursos.devolverInformacion());
            frm_mantenimientoCursos.mostrarMensaje("El estudiante fue modificado de forma correcta.");
            frm_mantenimientoCursos.resetearGUI();     
        }
        if(evento.getActionCommand().equals("Eliminar"))
        {
            baseDatos.eliminarCurso(frm_mantenimientoCursos.devolverSigla());
            frm_mantenimientoCursos.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            frm_mantenimientoCursos.resetearGUI();
        }
    
    }
    public void buscar()
    {
        if(baseDatos.existenciaCurso(frm_mantenimientoCursos.devolverSigla()))
            {
                frm_mantenimientoCursos.mostrarInformacion(baseDatos.arregloCurso);
                frm_mantenimientoCursos.habilitarEdicion();
            }
            else
            {
                frm_mantenimientoCursos.mostrarMensaje("La sigla buscada no se encuentra.");
                frm_mantenimientoCursos.habilitarAgregar();
            }
    
    }

    

    
}
