package utp.misiontic2022.c2.reto5.vista;


import utp.misiontic2022.c2.reto5.controlador.ControladorRequerimientos;
import utp.misiontic2022.c2.reto5.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.reto5.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.reto5.modelo.vo.Requerimiento_3;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class VentanaRequerimientos extends JFrame
{
    private ControladorRequerimientos controller;
    private JTable table, table2, table3;


    public VentanaRequerimientos()
    {
        controller = new ControladorRequerimientos();

        initUI();
        setLocationRelativeTo(null);
    }
    
    private void initUI(){
        setTitle("Interfaz Reto 5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,800);

        var tbd = new JTabbedPane();

        getContentPane().add(tbd, BorderLayout.CENTER);
        // Pestañas
        var panel = new JPanel();
        var panel2 = new JPanel();
        var panel3 = new JPanel();

        panel.setLayout(new BorderLayout());
        tbd.addTab("Consulta Requerimiento 1", panel);

        panel2.setLayout(new BorderLayout());
        tbd.addTab("Consulta Requerimiento 2", panel2);

        panel3.setLayout(new BorderLayout());
        tbd.addTab("Consulta Requerimiento 3", panel3);
        //---

        var panelEntrada = new JPanel();
        var panelEntrada2 = new JPanel();
        var panelEntrada3 = new JPanel();
        //panelEntrada.add(new JLabel("Requerimiento 1"));

        var button = new JButton("Consultar");
        button.addActionListener(e -> cargarTable1());
        panelEntrada.add(button);
        
        panel.add(panelEntrada, BorderLayout.PAGE_START);

        var button2 = new JButton("Consultar");
        button2.addActionListener(e -> cargarTable2());
        panelEntrada2.add(button2);
        
        panel2.add(panelEntrada2, BorderLayout.PAGE_START);

        var button3 = new JButton("Consultar");
        button3.addActionListener(e -> cargarTable3());
        panelEntrada3.add(button3);
        
        panel3.add(panelEntrada3, BorderLayout.PAGE_START);

        table = new JTable();
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        table2 = new JTable();
        panel2.add(new JScrollPane(table2), BorderLayout.CENTER);

        table3 = new JTable();
        panel3.add(new JScrollPane(table3), BorderLayout.CENTER);
    }

    private void cargarTable1()
    {
        try
        {            
            var list = controller.consultarRequerimiento1();
            var tableModel = new Requerimiento1TableModel();

            tableModel.setData(list);

            table.setModel(tableModel);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarTable2()
    {
        try
        {            
            var list = controller.consultarRequerimiento2();
            var tableModel = new Requerimiento2TableModel();

            tableModel.setData(list);

            table2.setModel(tableModel);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarTable3()
    {
        try
        {            
            var list = controller.consultarRequerimiento3();
            var tableModel = new Requerimiento3TableModel();

            tableModel.setData(list);

            table3.setModel(tableModel);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private class Requerimiento1TableModel extends AbstractTableModel
    {
        private ArrayList<Requerimiento_1> data;

        public void setData(ArrayList<Requerimiento_1> data)
        {
            this.data = data;
        }

        @Override
        public String getColumnName(int column)
        {
            switch(column){
                case 0:
                    return "Nombre Material";
                case 1:
                    return "Precio por Unidad";
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() 
        {
            return data.size();
        }

        @Override
        public int getColumnCount() 
        {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) 
        {
            var registro = data.get(rowIndex);

            switch(columnIndex)
            {
                case 0:
                    return registro.getNombreMaterial();
                case 1:
                    return registro.getPrecioUnidad();
            }
            return null;
        }
        
    }

    private class Requerimiento2TableModel extends AbstractTableModel
    {
        private ArrayList<Requerimiento_2> data;

        public void setData(ArrayList<Requerimiento_2> data)
        {
            this.data = data;
        }

        @Override
        public String getColumnName(int column)
        {
            switch(column){
                case 0:
                    return "Contructora";
                case 1:
                    return "Ciudad";
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() 
        {
            return data.size();
        }

        @Override
        public int getColumnCount() 
        {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) 
        {
            var registro = data.get(rowIndex);

            switch(columnIndex)
            {
                case 0:
                    return registro.getConstructora();
                case 1:
                    return registro.getCiudad();
            }
            return null;
        }
        
    }

    private class Requerimiento3TableModel extends AbstractTableModel
    {
        private ArrayList<Requerimiento_3> data;

        public void setData(ArrayList<Requerimiento_3> data)
        {
            this.data = data;
        }

        @Override
        public String getColumnName(int column)
        {
            switch(column){
                case 0:
                    return "Proveedor";
                case 1:
                    return "Nombre Material";
                case 2:
                    return "Importado";
                case 3:
                    return "Precio por Unidad";
                case 4:
                    return "Cantidad";
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() 
        {
            return data.size();
        }

        @Override
        public int getColumnCount() 
        {
            return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) 
        {
            var registro = data.get(rowIndex);

            switch(columnIndex)
            {
                case 0:
                    return registro.getNombreMaterial();
                case 1:
                    return registro.getPrecioUnidad();
                case 2:
                    return registro.getImportado();
                case 3:
                    return registro.getPrecioUnidad();
                case 4:
                    return registro.getCantidad();
            }
            return null;
        }
        
    }
}
