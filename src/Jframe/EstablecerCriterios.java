package Jframe;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import prototipo.SaveAndRead;
import prototipo.model.CriterioHasProyecto;
import prototipo.model.Criterios;
import prototipo.model.Proyectos;

/**
 *
 * @author GusAPC
 */
public class EstablecerCriterios extends javax.swing.JFrame {

    private List<Criterios> criterios = new ArrayList<>();
    private List<Proyectos> proyectos = new ArrayList<>();
    private List<CriterioHasProyecto> criterioHasProyecto = new ArrayList<>();


    int suma = 0;
    
    public EstablecerCriterios(List<Criterios> criterios, List<Proyectos> proyectos, List<CriterioHasProyecto> criterioHasProyecto) {
        initComponents(); 
        this.criterios = criterios;
        this.proyectos = proyectos;
        this.criterioHasProyecto = criterioHasProyecto;
        
        tblCriterios.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                TableModel matriz;
                matriz = tblCriterios.getModel();
                suma = 0;
                for( int i = 0 ; i < criterios.size(); i++){
                    int p = Integer.parseInt(matriz.getValueAt(i, 2).toString());
                    criterios.get(i).setPonderacion(p);
                    suma += p;
                }
                lbSuma.setText(suma + "%");
            }
          });
        updateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCriterios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnRegistroSiguiente = new javax.swing.JButton();
        lbSuma = new javax.swing.JLabel();

        jButton2.setText("->");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Añadir criterio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadircriterio(evt);
            }
        });

        tblCriterios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Criterio", "Tipo", "Ponderacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCriterios);

        jLabel1.setText("Establecimiento de criterios");

        btnRegistroSiguiente.setText("->");
        btnRegistroSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstablecerCriteriosSigueinte(evt);
            }
        });

        lbSuma.setText("0%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 325, Short.MAX_VALUE)
                                .addComponent(lbSuma)
                                .addGap(30, 30, 30)
                                .addComponent(btnRegistroSiguiente))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(btnRegistroSiguiente))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbSuma)
                        .addGap(32, 32, 32))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEstablecerCriteriosSigueinte(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstablecerCriteriosSigueinte
        if( suma == 100){
            SaveAndRead s = new SaveAndRead();
            s.saveCriterios(criterios);
            s.saveProyectos(proyectos);
            s.saveCriterioHasProyecto(criterioHasProyecto);
            RegisProyect regisProyect = new RegisProyect(criterios, proyectos, criterioHasProyecto);
            regisProyect.setTitle("suaj");
            regisProyect.setVisible(true);
            dispose();
        }
        else JOptionPane.showMessageDialog(null, "la suma de las ponderaciones debe ser 100 :v");

    }//GEN-LAST:event_btnEstablecerCriteriosSigueinte

    private void btnAnadircriterio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadircriterio
        NuevoCriterio nuevoCriterio = new NuevoCriterio(criterios);
        nuevoCriterio.setDefaultCloseOperation(NuevoCriterio.DO_NOTHING_ON_CLOSE);
        nuevoCriterio.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                nuevoCriterio.dispose();
            }
            @Override
             public void windowClosed(WindowEvent e) {
                updateTable();
            }
        });
        nuevoCriterio.setTitle("suaj");
        nuevoCriterio.setVisible(true);
    }//GEN-LAST:event_btnAnadircriterio

    private void updateTable(){
        
        String matris[][] = new String[criterios.size()][3];
        
        int i = 0;
        for(Criterios c: criterios) { 
            matris[i][0] = c.getNombre();
            if(c.getTipo()) matris[i][1] = "Cuantitativo";
            else matris[i][1] = "Cualitativo";
            matris[i][2] = "" + c.getPonderacion();
            i++;
        }
        
        tblCriterios.setModel(new javax.swing.table.DefaultTableModel(
            matris,
            new String [] {
                "Criterio", "Tipo", "Ponderacion"
            }
        ));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistroSiguiente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbSuma;
    private javax.swing.JTable tblCriterios;
    // End of variables declaration//GEN-END:variables
}
