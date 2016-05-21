/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.PrincipalVentana;

/**
 *
 * @author JoséFabián
 */
public class ControlaRadio {

    String tipo="nada";
    PrincipalVentana ventana;
    public ControlaRadio(PrincipalVentana ventana) {
        this.ventana=ventana;
       // tipo=ventana.selet();
//        devolver();
        imp();
    }
//    
//    public void devolver()
//    {
//        tipo=ventana.selet();
//    }
    
    public void imp(){
        System.out.println(tipo);
    }
    
}
