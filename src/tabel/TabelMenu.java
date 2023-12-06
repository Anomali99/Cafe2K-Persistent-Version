/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabel;

import dao.Rupiah;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Menu;

/**
 *
 * @author fatiq
 */
public class TabelMenu extends AbstractTableModel{

    private List<Menu> list = new ArrayList<>();
    private final String[] headerName = {"NO", "Kode Menu", "Nama", "Harga","Stok","Bahan"};
    
    public void clear (){
        list.clear();
        fireTableDataChanged();
    }
    
    public void setData(List<Menu> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Menu mod){
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
                case 0 : return list.get(rowIndex).getKodeMenu();
                case 1 : return list.get(rowIndex).getNama();
                case 2 : return Rupiah.getRp(list.get(rowIndex).getHarga());
                case 3 : return list.get(rowIndex).getStok();
                case 4 : return list.get(rowIndex).getAllBahan();
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
