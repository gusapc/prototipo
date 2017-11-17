package Jframe;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Hashtable;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.text.TableView.TableRow;
import prototipo.SaveAndRead;
import prototipo.model.CriterioHasProyecto;
import prototipo.model.Criterios;
import prototipo.model.Proyectos;

/**
 *
 * @author GusAPC
 */
public class Asignacion extends javax.swing.JFrame {

    private List<Criterios> criterios = new ArrayList<>();
    private List<Proyectos> proyectos = new ArrayList<>();
    private List<CriterioHasProyecto> criterioHasProyecto = new ArrayList<>();

    public Asignacion(List<Criterios> criterios, List<Proyectos> proyectos, List<CriterioHasProyecto> criterioHasProyecto) {
        initComponents();
        this.criterios = criterios;
        this.proyectos = proyectos;
        this.criterioHasProyecto =  criterioHasProyecto;
        String[] columns = new String[proyectos.size() + 1];
        columns[0] = "Criterios";
        int i = 1;
        for(Proyectos p: proyectos) { 
            columns[i] = p.getNombre();
            i++;
        }
        String[] values = new String[] {"Muy baja", "Baja", "Moderado", "Alta", "Muy alta"};
        JComboBox combo =  new JComboBox<String> (values);
        combo.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent e) {
              final JComponent c = (JComponent) e.getSource();
              SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                  c.requestFocus();
                  System.out.println(c);
                  if (c instanceof JComboBox) { System.out.println("a");}
                }
              });
            }
        });
        String matriz [][] = new String[criterios.size()][proyectos.size()];
        i = 0;
        for(Criterios c: criterios) { 
            matriz[i][0] = c.getNombre();
            i++;
        }        
        tblAsignar.setModel(new javax.swing.table.DefaultTableModel(matriz, columns));
        
        EachRowEditor rowEditor = new EachRowEditor(tblAsignar);
        i=0;
        if (criterioHasProyecto.size() >= 1) insert();
        for(Criterios c: criterios) { 
            if(!c.getTipo()){
                rowEditor.setEditorAt(i, new DefaultCellEditor(combo));
                for(Proyectos p: proyectos) { 
                    tblAsignar.getColumn(p.getNombre()).setCellEditor(rowEditor);
                }
            }
            i++;
        }
    }
    public Asignacion() {
        initComponents();
    }
    
    void insert(){
        TableModel matriz;
        matriz = tblAsignar.getModel();
        criterioHasProyecto.forEach((chp)->{
            matriz.setValueAt(chp.getValor(), (int) chp.getIdProyecto(), (int) chp.getIdCriterio());
        });
    }
    
    Boolean save(){
        TableModel matriz;
        matriz = tblAsignar.getModel();
        //proyectos criterios
        for( int i = 0 ; i < matriz.getRowCount(); i++){
            Boolean mejor =  true;
            for( int j = 1 ; j < matriz.getColumnCount(); j++){
                if(matriz.getValueAt(i, j) == null){
                    JOptionPane.showMessageDialog(null, "Algun campo de la tabla esta vacio");
                    return false;
                }
                if(criterios.get(i).getTipo()){
                    if(!isNumeric((String) matriz.getValueAt(i, j))){
                        JOptionPane.showMessageDialog(null, "Algun campo de la tabla no es numerico");
                        return false;
                    }
                }
                criterioHasProyecto.add(new CriterioHasProyecto(i, j, matriz.getValueAt(i, j).toString()));
            }
        }
        return true;
        //System.out.println("tamaño de proyectos: " + proyectos.size() + "  tamaño de criterios: " + criterios.size() + " contador: " + c);
        //System.out.println("tamaño de row: " + tblAsignar.getRowCount() + "  tamaño de col: " + tblAsignar.getColumnCount());

        /*criterioHasProyecto.forEach((chp) -> {
            System.out.println("proyecto id: " + chp.getIdProyecto() + "  criterio id: " + chp.getIdCriterio() + " valor: " + chp.getValor());
        });*/
       
    }
    
    static boolean isNumeric(String cadena){
	try {
		Double.parseDouble(cadena);
		return true;
	} catch (Exception nfe){
		return false;
	}
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAsignacionAnterios = new javax.swing.JButton();
        btnAsignacionSigiente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsignar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAsignacionAnterios.setText("<-");
        btnAsignacionAnterios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignacionAnteriosActionPerformed(evt);
            }
        });

        btnAsignacionSigiente.setText("->");
        btnAsignacionSigiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignacionSigienteActionPerformed(evt);
            }
        });

        tblAsignar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAsignar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnAsignacionAnterios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 494, Short.MAX_VALUE)
                .addComponent(btnAsignacionSigiente)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsignacionAnterios)
                    .addComponent(btnAsignacionSigiente))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignacionAnteriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignacionAnteriosActionPerformed
        // TODO add your handling code here:
        if(save()){
            SaveAndRead s = new SaveAndRead();
            s.saveCriterios(criterios);
            s.saveProyectos(proyectos);
            s.saveCriterioHasProyecto(criterioHasProyecto);
            RegisProyect regisProyect = new RegisProyect(criterios, proyectos, criterioHasProyecto);
            regisProyect.setTitle("suaj");
            regisProyect.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnAsignacionAnteriosActionPerformed

    private void btnAsignacionSigienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignacionSigienteActionPerformed
        // TODO add your handling code here:
        if(save()){
            SaveAndRead s = new SaveAndRead();
            s.saveCriterios(criterios);
            s.saveProyectos(proyectos);
            s.saveCriterioHasProyecto(criterioHasProyecto);
            Matriz matriz = new Matriz(criterios, proyectos, criterioHasProyecto);
            matriz.setTitle("suaj");
            matriz.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnAsignacionSigienteActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Asignacion().setVisible(true);
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignacionAnterios;
    private javax.swing.JButton btnAsignacionSigiente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAsignar;
    // End of variables declaration//GEN-END:variables

    class EachRowEditor implements TableCellEditor {
      protected Hashtable editors;

      protected TableCellEditor editor, defaultEditor;

      JTable table;
      public EachRowEditor(JTable table) {
        this.table = table;
        editors = new Hashtable();
        defaultEditor = new DefaultCellEditor(new JTextField());
      }

      public void setEditorAt(int row, TableCellEditor editor) {
        editors.put(new Integer(row), editor);
      }

      public Component getTableCellEditorComponent(JTable table, Object value,
        boolean isSelected, int row, int column) {
        //editor = (TableCellEditor)editors.get(new Integer(row));
        //if (editor == null) {
        //  editor = defaultEditor;
        //}
      return editor.getTableCellEditorComponent(table, value, isSelected,
            row, column);
      }

      public Object getCellEditorValue() {
        return editor.getCellEditorValue();
      }

      public boolean stopCellEditing() {
        return editor.stopCellEditing();
      }

      public void cancelCellEditing() {
        editor.cancelCellEditing();
      }

      public boolean isCellEditable(EventObject anEvent) {
        selectEditor((MouseEvent) anEvent);
        return editor.isCellEditable(anEvent);
      }

      public void addCellEditorListener(CellEditorListener l) {
        editor.addCellEditorListener(l);
      }

      public void removeCellEditorListener(CellEditorListener l) {
        editor.removeCellEditorListener(l);
      }

      public boolean shouldSelectCell(EventObject anEvent) {
        selectEditor((MouseEvent) anEvent);
        return editor.shouldSelectCell(anEvent);
      }

      protected void selectEditor(MouseEvent e) {
        int row;
      if (e == null) {
          row = table.getSelectionModel().getAnchorSelectionIndex();
        } else {
          row = table.rowAtPoint(e.getPoint());
        }
        editor = (TableCellEditor) editors.get(new Integer(row));
      if (editor == null) {
          editor = defaultEditor;
        }
      }
    }
    
}
