package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.BaseDatos;
import modelo.MetodosCursos;
import modelo.MetodosEstudiantes;
import modelo.MetodosMatricula;
import vista.FRM_MantenimientoCursos;
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_Matricula;

/**
 *
 * @author vaio01
 */
public class Controlador_FRM_Matricula implements ActionListener {
 
    MetodosCursos metodosCursos;
    MetodosEstudiantes metodosEstudiantes;
    public MetodosMatricula metodosMatricula;
    FRM_Matricula frm_Matricula;
    boolean encontroEstudiante=false;
    boolean encontroCurso=false;
    BaseDatos baseDatos;
    
    public Controlador_FRM_Matricula(FRM_MantenimientoEstudiantes frm_MantenimientoEstufiantes,FRM_MantenimientoCursos fRM_MantenimientoCursos,FRM_Matricula frm_Matricula)
    {
    
        this.metodosCursos=fRM_MantenimientoCursos.controlador.metodosCursos;
        this.metodosEstudiantes=frm_MantenimientoEstufiantes.controlador_FRM_MantenimientoEstudiantes.metodosEstudiantes;
       this.baseDatos=fRM_MantenimientoCursos.controlador.baseDatos;
       
        this.frm_Matricula=frm_Matricula;
        metodosMatricula=new MetodosMatricula(metodosEstudiantes,metodosCursos,this,frm_Matricula);
        baseDatos=new BaseDatos();
        
    }
    public void actionPerformed(ActionEvent e){
        
       if(e.getActionCommand().equals("BuscarCedula"))  
        {
            buscarCedula();
        }
      if(e.getActionCommand().equals("BuscarSigla"))
      {
          if(baseDatos.existenciaCurso(frm_Matricula.devolverSigla()))
          {
            //String arreglo[]=metodosCursos.getArregloInformacion();
            frm_Matricula.colocarNombreCurso(baseDatos.arregloCurso);
            frm_Matricula.habilitarAgregar();
            encontroCurso=true;
          }else
          {
            frm_Matricula.mostrarMensaje("El curso no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
          }
      }
      if(e.getActionCommand().equals("Agregar"))  
        {
            frm_Matricula.agregarInformacionTabla();
            frm_Matricula.limpiarSigla();
           // frm_Matricula.limpiarCedula();
        }
      if(e.getActionCommand().equals("Finalizar"))  
        {
           String arreglo[]=new String[3];
            for(int i=0; i < frm_Matricula.getCantidadFilas();i++)
            {
            arreglo[0]=frm_Matricula.devolverCodigo();
            arreglo[1]=frm_Matricula.devolverDato(i,1);
            arreglo[2]=frm_Matricula.devolverDato(i,3);
            baseDatos.registrarMatricula(arreglo);
            baseDatos.registrarDetalleMatricula(arreglo);
            //baseDatos.
            }
            frm_Matricula.colocarCodigo(baseDatos.codigoMatricula());
            frm_Matricula.resetearVentana();
            encontroEstudiante=false;
            encontroCurso=false;
        }
         
    if(e.getActionCommand().equals("Consultar")) 
        
        {
            
             if(baseDatos.existenciaDetalleMatricula(frm_Matricula.devolverCodigo()))
             {
              //frm_Matricula.mostrarInformacion(baseDatos.arregloDetalle);
              frm_Matricula.agregarInformacionTabla(baseDatos.arregloDetalle);
               frm_Matricula.habilitarOpciones();
             }
            
          else
          {
            
              JOptionPane.showMessageDialog(null,"No existe");
          }
        }
    if(e.getActionCommand().equalsIgnoreCase("Eliminar"))  
        {
          //JOptionPane.showMessageDialog(null,"LOLLLL");
           baseDatos.eliminarMatricula(frm_Matricula.devolverCodigo());
           baseDatos.eliminarDetalleMatricula(frm_Matricula.devolverCodigo());
              //frm_Matricula.colocarCodigo();
               frm_Matricula.resetearVentana();
            encontroEstudiante=false;
            encontroCurso=false;
        }
    }
    
    public void buscarCedula(){
     if(baseDatos.existenciaEstudiante(frm_Matricula.devolverCedula()))
            {
                frm_Matricula.mostrarInformacion(baseDatos.arregloEstudiante);
                encontroEstudiante=true;
            }
            else
            {
                frm_Matricula.mostrarMensaje("La cédula buscada no se encuentra.");
            }
    }
    
    public void verificarConsultas()
    {
     if(encontroEstudiante && encontroCurso){
       this.frm_Matricula.habilitarAgregar();
     }
    }
}

