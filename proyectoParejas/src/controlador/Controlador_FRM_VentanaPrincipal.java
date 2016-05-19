package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.BaseDatos;
import vista.FRM_MantenimientoCursos;
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_Matricula;
import vista.FRM_VentanaPrincipal;
import vista.Login;
import vista.VentanaUsuario;

/**
 *
 * @author tecnologiamultimedia
 */


    
public class Controlador_FRM_VentanaPrincipal implements ActionListener{

    FRM_MantenimientoEstudiantes frm_MantenimientoEstufiantes;
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    FRM_Matricula frm_Matricula;
    BaseDatos base;
    VentanaUsuario ventanaUsario;
    Login login;
    FRM_VentanaPrincipal ventana;
    public Controlador_FRM_VentanaPrincipal(FRM_VentanaPrincipal ventana)
    {
        this.ventana=ventana;
        frm_MantenimientoEstufiantes= new FRM_MantenimientoEstudiantes();
        frm_MantenimientoCursos= new FRM_MantenimientoCursos();
        frm_Matricula=new FRM_Matricula(frm_MantenimientoEstufiantes, frm_MantenimientoCursos);
//        base=new BaseDatos();
//        if(base.numUsuarios()>=1)
//        {
//            login=new Login();
//            login.setVisible(true);
//           
//        }
//        else
//        {
//            
//             ventanaUsario=new VentanaUsuario();
//             ventanaUsario.setVisible(true);
//            
//        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);
        }
        if(e.getActionCommand().equals("Estudiantes"))
        {
            frm_MantenimientoEstufiantes.setVisible(true);    
        }
        if(e.getActionCommand().equals("Cursos"))
        {
            frm_MantenimientoCursos.setVisible(true);
        }
        if(e.getActionCommand().equals("Matricula"))
        {
            frm_Matricula.setVisible(true);
            frm_Matricula.colocarCodigo(base.codigoMatricula());
        }
    }
    
}












