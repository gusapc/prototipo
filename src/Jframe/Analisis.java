package Jframe;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import prototipo.SaveAndRead;
import prototipo.model.CriterioHasProyecto;
import prototipo.model.Criterios;
import prototipo.model.Proyectos;

/**
 *
 * @author GusAPC
 */
public class Analisis extends javax.swing.JFrame {

    private List<Criterios> criterios = new ArrayList<>();
    private List<Proyectos> proyectos = new ArrayList<>();
    private List<CriterioHasProyecto> criterioHasProyecto = new ArrayList<>();
    private int prioridades[] = null;
    List<Proyectos> p = null;
    public Analisis() {
        initComponents();
    }
    public Analisis(List<Criterios> criterios, List<Proyectos> proyectos, List<CriterioHasProyecto> criterioHasProyecto, int prioridades[] ) {
        initComponents(); 
        this.criterios = criterios;
        this.proyectos = proyectos;
        this.criterioHasProyecto = criterioHasProyecto;
        this.prioridades = prioridades;
        String[] columns = new String[3];
        columns[0] = "Prioridad";
        columns[1] = "Proyecto";
        columns[2] = "Costo";
        String row [][] = new String[proyectos.size()][3];
        p = new ArrayList<>();
        int i = 1;
        do{
            for(int j = 0; j < prioridades.length ; j++){
                if(i == prioridades[j]){
                    p.add(proyectos.get(j));
                    i++;
                }
            }
        }while(p.size() != proyectos.size());
        for(int j = 0; j < p.size(); j++){
            row[j][0] = j + 1 + "";
            row[j][1] = p.get(j).getNombre();
            row[j][2] = "" + p.get(j).getCosto();
        }
        tblResultados.setModel(new javax.swing.table.DefaultTableModel(row, columns));
        
        txtInput.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                List<Double> sumas = new ArrayList<>();
                List<String> Nombres = new ArrayList<>();
                if(Asignacion.isNumeric(txtInput.getText())){
                    double dinero = Double.parseDouble(txtInput.getText());
                    System.out.println("*********");
                    for(int i = 0; i < row.length ; i++){
                        double tempSuma = 0;
                        String nombresSuma = "";
                        System.out.println("-----");
                        for(int j = 0 + i; j < row.length ; j++){
                            tempSuma += Double.parseDouble(row[j][2].toString());
                            nombresSuma += row[j][1].toString() + ", ";
                            System.out.println("tempSuma = " + tempSuma);
                            if(tempSuma <= dinero){
                                sumas.add(tempSuma);
                                Nombres.add(nombresSuma);
                            }
                        }
                    }
                }
                String nombresFinal = "";
                double mayor = 0;
                for(int i = 0; i < sumas.size(); i++){
                    if(sumas.get(i) > mayor){
                        mayor = sumas.get(i);
                        nombresFinal = Nombres.get(i);
                    }
                    System.out.println("sumas " + sumas.get(i));
                }
                
                lbProyectos.setText(nombresFinal);
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAnalisisAnterior = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbProyectos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAnalisisAnterior.setText("<-");
        btnAnalisisAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisisAnteriorActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("Presupuesto de inversión");

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(tblResultados);

        jLabel2.setText("Proyectos prioritarios ejecutables");

        jLabel3.setText("con el presupuesto de inversión");

        lbProyectos.setText("Proyectos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAnalisisAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 107, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(66, 66, 66)
                .addComponent(lbProyectos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbProyectos)
                        .addGap(60, 60, 60)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalisisAnterior)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalisisAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisisAnteriorActionPerformed
        // TODO add your handling code here:
        Matriz matriz = new Matriz(criterios, proyectos, criterioHasProyecto);
        matriz.setTitle("suaj");
        matriz.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAnalisisAnteriorActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Se eliminaran toda la información");
        SaveAndRead s = new SaveAndRead();
        s.deleteFileCriterioHasProyecto();
        s.deleteFileCriterios();
        s.deleteFileProyectos();
        
        List<Criterios> c = new ArrayList<>();
        List<Proyectos> p = new ArrayList<>();
        List<CriterioHasProyecto> cHp = new ArrayList<>();
        c.add(new Criterios(1, "Duración(en meses)", true, true, 15, true));
        c.add(new Criterios(2, "VPN", true, false, 25, true));
        c.add(new Criterios(3, "PRI", true, true, 20, true));
        c.add(new Criterios(4, "Riesgo", false, true, 20, true));
        c.add(new Criterios(5, "Generación de tecnología propietaria", false, false, 15, true));
        s.saveCriterios(c);
        Home home = new Home(c, p, cHp);
        home.setTitle("suaj");
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnEliminarActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Analisis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalisisAnterior;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbProyectos;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txtInput;
    // End of variables declaration//GEN-END:variables
}
