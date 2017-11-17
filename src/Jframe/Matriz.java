package Jframe;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import prototipo.SaveAndRead;
import prototipo.model.CriterioHasProyecto;
import prototipo.model.Criterios;
import prototipo.model.Proyectos;

/**
 *
 * @author GusAPC
 */
public class Matriz extends javax.swing.JFrame {

    private List<Criterios> criterios = new ArrayList<>();
    private List<Proyectos> proyectos = new ArrayList<>();
    private List<CriterioHasProyecto> criterioHasProyecto = new ArrayList<>();
    int prioridades[] = null; 
    public Matriz() {
        initComponents();
    }

    public Matriz(List<Criterios> criterios, List<Proyectos> proyectos, List<CriterioHasProyecto> criterioHasProyecto) {
        initComponents();
        SaveAndRead s = new SaveAndRead();
        
        this.criterios = s.readCriterios();
        this.proyectos = proyectos;
        this.criterioHasProyecto =  criterioHasProyecto;
        String[] columns = new String[proyectos.size() + 2];
        prioridades = new int[proyectos.size()];
        columns[0] = "Criterios";
        columns[1] = "Ponderación";
        for(int i = 2, j=0; j< proyectos.size(); i++, j++){
            columns[i] = proyectos.get(j).getNombre();
        }
        String row [][] = new String[criterios.size()][proyectos.size()+2];
        
        for(int i = 0; i< criterios.size(); i++){
            row[i][0] = criterios.get(i).getNombre();
            row[i][1] = criterios.get(i).getPonderacion() + "%";
        }    
        tblMatriz.setModel(new javax.swing.table.DefaultTableModel(row, columns));
        insert();

        String total[] = new String[proyectos.size() + 2];
        String prioridad[] = new String[proyectos.size() + 2];
        double paraPrioridad[] = new double[proyectos.size()];
        double paraPrioridadTemp[] = new double[proyectos.size()];
        total[0] = "";
        total[1] = "Total";
        for(int c = 2 ; c < tblMatriz.getColumnCount() ;c++){
            double suma = 0;
            for(int r = 0; r < tblMatriz.getRowCount(); r++){
                double ponderacion = Double.parseDouble(tblMatriz.getValueAt(r, 1).toString().replace("%", ""))/100;
                double temp = ponderacion*(Double.parseDouble(tblMatriz.getValueAt(r, c).toString()));
                suma =  suma+temp;
            }
            int i = c-2;
            paraPrioridad[i] = suma;
            total[c] = suma + "";
        }
        for (int x = 0; x<paraPrioridad.length; x++) paraPrioridadTemp[x] = paraPrioridad[x];
        Arrays.sort(paraPrioridad);
        int p  = proyectos.size();
        DefaultTableModel model = (DefaultTableModel) tblMatriz.getModel();
        model.addRow(total);    
        for(int i = 0; i<paraPrioridad.length ; i++){
            for(int j = 0; j<paraPrioridad.length ; j++){
                if(paraPrioridad[i] == paraPrioridadTemp[j]){
                    prioridad[2+j] = p + "";
                    p--;
                }
            }
        }
        prioridad[0] = "";
        prioridad[1] = "Prioridad";
        for(int i = 0; i < proyectos.size() ; i++){
            prioridades[i] = Integer.parseInt(prioridad[i + 2]);
        }
        model.addRow(prioridad);
        
    }

    void insert(){
        for(CriterioHasProyecto chp: criterioHasProyecto){
            String s = chp.getValor();
            if(s.equals("Muy baja")) s = "0";
            if(s.equals("Baja")) s = "1";
            if(s.equals("Moderado")) s = "2";
            if(s.equals("Alta")) s = "3";
            if(s.equals("Muy alta")) s = "4";            
            tblMatriz.setValueAt(s, (int) chp.getIdProyecto(), ((int) chp.getIdCriterio())+1);
        }
        for(int row = 0 ; row<tblMatriz.getRowCount() ; row++){
            int menorCalificacion = ((tblMatriz.getColumnCount()-1)*2)-3;
            int mayorCalificacion = 1;
            double[] result = new double[tblMatriz.getColumnCount()-2];
            double[] orden = new double[tblMatriz.getColumnCount()-2];
            int[] grade = new int[tblMatriz.getColumnCount()-2];
            for (int col = 2, n = 0; col<tblMatriz.getColumnCount(); col++, n++) {
                result[n] = Double.parseDouble((String) tblMatriz.getModel().getValueAt(row, col));
            }
            for (int x = 0; x<result.length; x++) orden[x] = result[x];
            Arrays.sort(orden);
            for(double o: orden){
                for(int g = 0; g<tblMatriz.getColumnCount()-2; g++){
                    if(o==result[g]){
                        if(criterios.get(row).getMejor()){
                            grade[g] = menorCalificacion;
                            menorCalificacion = menorCalificacion-2;
                        }else{
                            grade[g] = mayorCalificacion;
                            mayorCalificacion = mayorCalificacion+2;
                        }
                    }
                }
            }
            for (int col = 2, n = 0; col<tblMatriz.getColumnCount(); col++, n++) {
                tblMatriz.setValueAt(grade[n] /*+ " | " + result[n]*/, row, col);
            } 
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMatriz = new javax.swing.JTable();
        btnMatrizAnterio = new javax.swing.JButton();
        btnMatrizSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Matriz de desicioón con ponderación y peso");

        jLabel2.setText("Interpretación de los pesos obtenidos: Mayor es mejor");

        jLabel3.setText("=( 1 muy bajo <<--->> N muy alto =)");

        tblMatriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblMatriz);

        btnMatrizAnterio.setText("<-");
        btnMatrizAnterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatrizAnterioActionPerformed(evt);
            }
        });

        btnMatrizSiguiente.setText("->");
        btnMatrizSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatrizSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)))))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnMatrizAnterio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMatrizSiguiente))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMatrizAnterio)
                    .addComponent(btnMatrizSiguiente)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMatrizAnterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatrizAnterioActionPerformed
        // TODO add your handling code here:
        SaveAndRead s = new SaveAndRead();
        s.saveCriterios(criterios);
        s.saveProyectos(proyectos);
        s.saveCriterioHasProyecto(criterioHasProyecto);
        Asignacion asignacion = new Asignacion(criterios, proyectos, criterioHasProyecto);
        asignacion.setTitle("suaj");
        asignacion.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMatrizAnterioActionPerformed

    private void btnMatrizSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatrizSiguienteActionPerformed
        // TODO add your handling code here:
        Analisis analisis = new Analisis(criterios, proyectos, criterioHasProyecto, prioridades);
        analisis.setTitle("suaj");
        analisis.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMatrizSiguienteActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Matriz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMatrizAnterio;
    private javax.swing.JButton btnMatrizSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMatriz;
    // End of variables declaration//GEN-END:variables

}
