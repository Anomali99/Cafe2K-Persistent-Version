/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.DetailPembelian;
import model.Pembelian;

/**
 *
 * @author fatiq
 */
public class TabelDetailP extends AbstractTableModel{
    
    private Pembelian mod = new Pembelian();
    private List<DetailPembelian> list = new ArrayList();
    private final String[] headerName = {"NO", "Kode Menu", "Nama", "Keterangan","Harga","Jumlah","Subtotal"};
    
    public void clear (){
        list.clear();
        fireTableDataChanged();
    }
    
    public void setData(Pembelian mod){
        clear();
        this.mod = mod;
        this.list.addAll(mod.getDetailPembelianCollection());
        fireTableDataChanged();
    }
    
    public void setData(int index, DetailPembelian mod){
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
                case 0 : return list.get(rowIndex).getMenu().getKodeMenu();
                case 1 : return list.get(rowIndex).getMenu().getNama();
                case 2 : return list.get(rowIndex).getKeterangan();
                case 3 : return list.get(rowIndex).getMenu().getHarga();
                case 4 : return list.get(rowIndex).getJumlah();
                case 5 : return list.get(rowIndex).getSubtotal();
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
