/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Supply;

/**
 *
 * @author fatiq
 */
public class TabelSupply extends AbstractTableModel{

    private List<Supply> list = new ArrayList<>();
    private final String[] headerName = {"NO", "NO Supply", "Tanggal", "Petugas","Supplier","Total"};
    
    public void clear (){
        list.clear();
        fireTableDataChanged();
    }
    
    public void setData(List<Supply> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Supply mod){
        list.set(index, mod);
        fireTableRowsUpdated(index, index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return headerName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0){
            return "   "+ (rowIndex +1);
        } else {
            switch (columnIndex-1){
                case 0 : return list.get(rowIndex).getSupplyPK().getNoSupply();
                case 1 : return list.get(rowIndex).getTgl();
                case 2 : return list.get(rowIndex).getPegawai().getNama();
                case 3 : return list.get(rowIndex).getSupplier().getNama();
                case 4 : return list.get(rowIndex).getTotal();
                default : return null;
            }
            
        }
    }
    
    @Override
    public String getColumnName(int column){
        if (column == 0){
            return "   "+headerName[column];
        } else {
            return headerName[column];
        }
    }
    
}
