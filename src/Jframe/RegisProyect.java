package Jframe;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import prototipo.SaveAndRead;
import prototipo.model.CriterioHasProyecto;
import prototipo.model.Criterios;
import prototipo.model.Proyectos;

/**
 *
 * @author GusAPC
 */
public class RegisProyect extends javax.swing.JFrame {

    private List<Criterios> criterios;
    private List<Proyectos> proyectos;
    private List<CriterioHasProyecto> criterioHasProyecto;

    public RegisProyect(List<Criterios> criterios, List<Proyectos> proyectos, List<CriterioHasProyecto> criterioHasProyecto) {
        initComponents();
        this.criterios = criterios;
        this.proyectos = proyectos;
        this.criterioHasProyecto = criterioHasProyecto;
        seeProjects();
    }

    public RegisProyect() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnResProySigueinte = new javax.swing.JButton();
        btnResProyAnterior = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTaDescrip = new javax.swing.JTextArea();
        txtIdenti = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTaRegistrados = new javax.swing.JTextArea();
        btnAddProject = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Registro de proyectos");

        btnResProySigueinte.setText("->");
        btnResProySigueinte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResProySigueinteActionPerformed(evt);
            }
        });

        btnResProyAnterior.setText("<-");
        btnResProyAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResProyAnteriorActionPerformed(evt);
            }
        });

        txtTaDescrip.setColumns(20);
        txtTaDescrip.setRows(5);
        jScrollPane1.setViewportView(txtTaDescrip);

        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });

        txtTaRegistrados.setEditable(false);
        txtTaRegistrados.setColumns(20);
        txtTaRegistrados.setRows(5);
        jScrollPane2.setViewportView(txtTaRegistrados);

        btnAddProject.setText("Añadir Proyecto");
        btnAddProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProjectActionPerformed(evt);
            }
        });

        jLabel2.setText("Identificador:");

        jLabel3.setText("Descrioción:");

        jLabel4.setText("Costo:");

        jLabel5.setText("Proyectso registrados:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(txtIdenti)
                    .addComponent(txtCosto)
                    .addComponent(btnAddProject, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnResProyAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnResProySigueinte)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdenti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(21, 21, 21)
                .addComponent(btnAddProject)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResProySigueinte)
                    .addComponent(btnResProyAnterior))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 667, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void btnResProyAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResProyAnteriorActionPerformed
        SaveAndRead s = new SaveAndRead();
        s.saveCriterios(criterios);
        s.saveProyectos(proyectos);
        s.saveCriterioHasProyecto(criterioHasProyecto);
        EstablecerCriterios establecerCriterios = new EstablecerCriterios(criterios, proyectos, criterioHasProyecto);
        establecerCriterios.setTitle("suaj");
        establecerCriterios.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnResProyAnteriorActionPerformed

    private void btnAddProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProjectActionPerformed
        Proyectos proyecto = new Proyectos();
        proyecto.setID(1 + (long)proyectos.size());
        proyecto.setNombre(txtIdenti.getText());
        proyecto.setDescripcion(txtTaDescrip.getText());
        proyecto.setCosto(Double.valueOf(txtCosto.getText()));
        proyectos.add(proyecto);
        txtTaRegistrados.setText(txtTaRegistrados.getText() + proyecto.getNombre() + " | " + proyecto.getCosto() + "\n");
        txtIdenti.setText("");
        txtTaDescrip.setText("");
        txtCosto.setText("");       
    }//GEN-LAST:event_btnAddProjectActionPerformed

    private void btnResProySigueinteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResProySigueinteActionPerformed
        if(proyectos.size() >= 2){
            SaveAndRead s = new SaveAndRead();
            s.saveCriterios(criterios);
            s.saveProyectos(proyectos);
            s.saveCriterioHasProyecto(criterioHasProyecto);
            Asignacion asignacion = new Asignacion(criterios, proyectos, criterioHasProyecto);
            asignacion.setTitle("suaj");
            asignacion.setVisible(true);
            dispose();
        }
        else JOptionPane.showMessageDialog(null, "debes tener por lo menos dos proyectos ");
    }//GEN-LAST:event_btnResProySigueinteActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisProyect().setVisible(true);
            }
        });
    }
    
    public void seeProjects(){
        for(Proyectos p: proyectos){
            txtTaRegistrados.setText(txtTaRegistrados.getText() + p.getNombre() + " | " + p.getCosto() + "\n");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProject;
    private javax.swing.JButton btnResProyAnterior;
    private javax.swing.JButton btnResProySigueinte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtIdenti;
    private javax.swing.JTextArea txtTaDescrip;
    private javax.swing.JTextArea txtTaRegistrados;
    // End of variables declaration//GEN-END:variables
}
