package Jframe;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import prototipo.model.Criterios;
/**
 *
 * @author GusAPC
 */
public class NuevoCriterio extends javax.swing.JFrame {

    private List<Criterios> criterios = new ArrayList<>();

    
    public NuevoCriterio(List<Criterios> c ) {
        this.criterios = c;
        initComponents();
        JRadioButton cuantitativo = rBtnCuantitativo;
        cuantitativo.setActionCommand("true");
        JRadioButton cuanlitativo = rBtnCuanlitativo;
        cuanlitativo.setActionCommand("false");
        cuantitativo.setSelected(true);
        ButtonGroup radiogrup = rdbtnGrup;
        radiogrup.add(cuanlitativo);
        radiogrup.add(cuantitativo);
        JComboBox<String> opciones = comBoxopciones;
        opciones.removeAllItems();
        opciones.addItem("Menor");
        opciones.addItem("Mayor");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdbtnGrup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNamecriterio = new javax.swing.JTextField();
        btnAddcriterio = new javax.swing.JButton();
        rBtnCuantitativo = new javax.swing.JRadioButton();
        rBtnCuanlitativo = new javax.swing.JRadioButton();
        comBoxopciones = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nuevo Criterio");

        jLabel2.setText("Nombre Criterio");

        txtNamecriterio.setToolTipText("");
        txtNamecriterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamecriterioActionPerformed(evt);
            }
        });

        btnAddcriterio.setText("+");
        btnAddcriterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddcriterioActionPerformed(evt);
            }
        });

        rBtnCuantitativo.setText("Cuantitativo ( el criterio acepta valores numericos )");

        rBtnCuanlitativo.setText("Cualitativo ( se acepta una de las categorias establecidas )");
        rBtnCuanlitativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnCuanlitativoActionPerformed(evt);
            }
        });

        comBoxopciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comBoxopciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comBoxopcionesActionPerformed(evt);
            }
        });

        jLabel3.setText("Mejor calificacion es otorgada al valor");

        jButton4.setText("?");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPregunta(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddcriterio))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNamecriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(rBtnCuanlitativo)
                                        .addComponent(rBtnCuantitativo, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comBoxopciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNamecriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(rBtnCuantitativo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBtnCuanlitativo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comBoxopciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnAddcriterio)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamecriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamecriterioActionPerformed
    }//GEN-LAST:event_txtNamecriterioActionPerformed

    private void btnAddcriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddcriterioActionPerformed
        Criterios c = new Criterios();
        String temp = txtNamecriterio.getText().replace(" ", "");
        if(temp.equals("")) c.setNombre("Criterio " + criterios.size());
        else c.setNombre(txtNamecriterio.getText());
        c.setTipo(Boolean.valueOf(rdbtnGrup.getSelection().getActionCommand()));
        if(comBoxopciones.getSelectedItem().toString().equals("Menor")) c.setMejor(true);
        else c.setMejor(false);
        c.setPonderacion(0);
        c.setID(criterios.size()+1);
        c.setDefaul(false);
        criterios.add(c);
        dispose();
    }//GEN-LAST:event_btnAddcriterioActionPerformed

    private void rBtnCuanlitativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnCuanlitativoActionPerformed
    }//GEN-LAST:event_rBtnCuanlitativoActionPerformed

    private void comBoxopcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBoxopcionesActionPerformed
    }//GEN-LAST:event_comBoxopcionesActionPerformed

    private void btnPregunta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPregunta
        JOptionPane.showMessageDialog(null, "Suponga que se ha creado un nuevo criterio cuantitativo X y \n en la lista desplegable se ha elegido \"Mayor para otrogarle \n la mejor calificación. Si con dicho criterio se evalúan 3 \n proyectos (A, B y C), cuyos valores de x son: 100, 20 y 300 \n respectivamente, será mejor evaluado el proyecto C porque \n corresponde al mayor valor de la lista.  \n \n Si el criterio fuera cualitativo, entonces la opción de \"Mayor\" \n correspondería a la categoría \"Muy alto\"");
    }//GEN-LAST:event_btnPregunta


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddcriterio;
    private javax.swing.JComboBox<String> comBoxopciones;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton rBtnCuanlitativo;
    private javax.swing.JRadioButton rBtnCuantitativo;
    private javax.swing.ButtonGroup rdbtnGrup;
    private javax.swing.JTextField txtNamecriterio;
    // End of variables declaration//GEN-END:variables
}
