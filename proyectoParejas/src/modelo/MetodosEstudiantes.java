package modelo;

import java.util.ArrayList;
import vista.FRM_MantenimientoEstudiantes;
import vista.PrincipalVentana;

/**
 *
 * @author tecnologiamultimedia
 */
public class MetodosEstudiantes {
    
    private ArrayList <Estudiante> arrayEstudiantes;
    String arregloInformacionConsultada[]=new String[2];
    BaseDatos baseDatos;
    ArchivoEstudiante archivoEstudiante;
   // FRM_MantenimientoEstudiantes estudiantes;
    
    public MetodosEstudiantes()
    {
        arrayEstudiantes=new ArrayList <Estudiante>();
        baseDatos=new BaseDatos();
        //estudiantes=new FRM_MantenimientoEstudiantes();
        //agregarEstudiante(new String[] {"123","Step","Puntarenas"});
        if(PrincipalVentana.numSeleccion==1){
                 verificarArchivoEstudiante();
        }
    }
//    public boolean comprobarExistenciaBaseDatosU()
//    {
//        
//    }
    public void agregarEstudiante(String informacion[])
    {
        Estudiante temporal=new Estudiante(informacion[0], informacion[1], informacion[2]);
        arrayEstudiantes.add(temporal);
       // baseDatos.registrarEstudiante(informacion[0], informacion[1], informacion[2]);
        
    }
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            System.out.println(arrayEstudiantes.get(contador).getInformacion());
        
        }
    
    }
    public boolean consultarEstudiante(String cedula)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(cedula))
            {
                arregloInformacionConsultada[0]=arrayEstudiantes.get(contador).getNombrecompleto();
                arregloInformacionConsultada[1]=arrayEstudiantes.get(contador).getDireccion();
                existe=true;
            }
        
        }
        return existe;
    }
    
    public void modificarEstudiante(String arreglo[])
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(arreglo[0]))
            {
                arrayEstudiantes.get(contador).setNombrecompleto(arreglo[1]);
                arrayEstudiantes.get(contador).setDireccion(arreglo[2]);
            }
        }
    }
    public void eliminarEstudiante(String arreglo[])
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(arreglo[0]))
            {
                arrayEstudiantes.remove(contador);
            }
        }
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }    
    
     public void verificarArchivoEstudiante()
    {
        boolean verificar=archivoEstudiante.existeArchivoEstudiante();
        if(verificar)
        {
            arrayEstudiantes=archivoEstudiante.leerInformacionCompletaEstudiante();
            System.out.println("se cargaron los datos..");
        }
        else
        {
            archivoEstudiante.crearArchivoEstudiante();
            System.out.println("se creo el archivo");
        }
        
    }
      public void guardarArchivoEstudiante()
    {
        archivoEstudiante.crearArchivoEstudiante();
        for(int i=0;i<arrayEstudiantes.size();i++)
        {
            archivoEstudiante.escribirInfoEnElArchivoEstudiante(arrayEstudiantes.get(i));
            System.out.println("se guardo en archivo");
        }
    }
//    public void mostrarInformacion()
//    {
//        for(int contador=0;contador<arrayEstudiantes.size();contador++)
//        {
//            System.out.println(arrayEstudiantes.get(contador).getInformacion());
//        
//        }
//    
//    }
//    public boolean consultarEstudiante(String cedula)
//    {
//        boolean existe=false;
//        
//        for(int contador=0;contador<arrayEstudiantes.size();contador++)
//        {
//            if(arrayEstudiantes.get(contador).getCedula().equals(cedula))
//            {
//                arregloInformacionConsultada[0]=arrayEstudiantes.get(contador).getNombrecompleto();
//                arregloInformacionConsultada[1]=arrayEstudiantes.get(contador).getDireccion();
//                existe=true;
//            }
//        
//        }
//        return existe;
//    }
//    
//    public void modificarEstudiante(String arreglo[])
//    {
//        for(int contador=0;contador<arrayEstudiantes.size();contador++)
//        {
//            if(arrayEstudiantes.get(contador).getCedula().equals(arreglo[0]))
//            {
//                arrayEstudiantes.get(contador).setNombrecompleto(arreglo[1]);
//                arrayEstudiantes.get(contador).setDireccion(arreglo[2]);
//            }
//        }
//    }
//    public void eliminarEstudiante(String arreglo[])
//    {
//        for(int contador=0;contador<arrayEstudiantes.size();contador++)
//        {
//            if(arrayEstudiantes.get(contador).getCedula().equals(arreglo[0]))
//            {
//                arrayEstudiantes.remove(contador);
//            }
//        }
//    }
//    public String[] getArregloInformacion()
//    {
//        return this.arregloInformacionConsultada;
//    } 
}
