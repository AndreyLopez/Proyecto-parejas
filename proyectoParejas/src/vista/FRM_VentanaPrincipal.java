/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_VentanaPrincipal;
import modelo.BaseDatos;
//import modelo.BaseDatos;

/**
 *
 * @author tecnologiamultimedia
 */
public class FRM_VentanaPrincipal extends javax.swing.JFrame {

    Controlador_FRM_VentanaPrincipal controlador_FRM_VentanaPrincipal;
    //BaseDatos baseDatos;
    public String tipo;
    public FRM_VentanaPrincipal() {
        //this.tipo=tipo;
        initComponents();
        this.setLocation(200, 100);
        controlador_FRM_VentanaPrincipal=new Controlador_FRM_VentanaPrincipal(this);
        agregarEventos();
   
    }
    public void selet(String palabra){
        tipo=palabra;
    }
    
    public void agregarEventos()
    {
        this.jm_Salir.addActionListener(controlador_FRM_VentanaPrincipal);
        this.jm_Estudiantes.addActionListener(controlador_FRM_VentanaPrincipal);
        this.jm_Cursos.addActionListener(controlador_FRM_VentanaPrincipal);
        this.jm_Matricula.addActionListener(controlador_FRM_VentanaPrincipal);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        TipoDeAlmacenamiento = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        jm_BarraMenu = new javax.swing.JMenuBar();
        jm_Archivo = new javax.swing.JMenu();
        jm_Salir = new javax.swing.JMenuItem();
        jm_Mantenimientos = new javax.swing.JMenu();
        jm_Estudiantes = new javax.swing.JMenuItem();
        jm_Cursos = new javax.swing.JMenuItem();
        jm_Matricula = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(TipoDeAlmacenamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, 20));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, -1, -1));

        jm_Archivo.setText("Archivo");

        jm_Salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jm_Salir.setText("Salir");
        jm_Archivo.add(jm_Salir);

        jm_BarraMenu.add(jm_Archivo);

        jm_Mantenimientos.setText("Mantenimientos");

        jm_Estudiantes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jm_Estudiantes.setText("Estudiantes");
        jm_Mantenimientos.add(jm_Estudiantes);

        jm_Cursos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jm_Cursos.setText("Cursos");
        jm_Mantenimientos.add(jm_Cursos);

        jm_Matricula.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jm_Matricula.setText("Matricula");
        jm_Mantenimientos.add(jm_Matricula);

        jm_BarraMenu.add(jm_Mantenimientos);

        setJMenuBar(jm_BarraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel TipoDeAlmacenamiento;
    private javax.swing.JLabel fondo;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jm_Archivo;
    private javax.swing.JMenuBar jm_BarraMenu;
    private javax.swing.JMenuItem jm_Cursos;
    private javax.swing.JMenuItem jm_Estudiantes;
    private javax.swing.JMenu jm_Mantenimientos;
    private javax.swing.JMenuItem jm_Matricula;
    private javax.swing.JMenuItem jm_Salir;
    // End of variables declaration//GEN-END:variables
}
