/*
 * CheckBoxList demo
 * 
 * Tutorial dibuat oleh javadanphp.blogspot.com
 * anda bisa menggunakan class-class yang ada pada tutorial ini tanpa
 * menghilangkan copyright ini
 * 
 * anda dapt menggunakan class tanpa jaminan dari javadanphp.blogspot.com
 * akan kerusakan yang mungkin ditimbulkan oleh tutorial ini
 * 
 * Salam
 * javadanphp.blogspot.com
 * 
 */
package migrasidata2.pluginsclass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Kang Opik
 */
public class CheckBoxList extends JList implements ListSelectionListener {
    private Color listForeground, listBackground;

    HashSet pilihan = new HashSet();
    int toggleIndex = -1;
    boolean toggleWasSelected;

    public CheckBoxList() {
        super();
        getSelectedColor();
        setCellRenderer (new CheckBoxListRenderer());
        addListSelectionListener (this);
    }
    
    private void getSelectedColor(){
        UIDefaults uid = UIManager.getLookAndFeel().getDefaults();
        listForeground =uid.getColor ("List.foreground");
        listBackground =uid.getColor ("List.background");
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (! e.getValueIsAdjusting()) {
            removeListSelectionListener (this);
            
            // cek apakah di-check atau sebaliknya
            HashSet newSelections = new HashSet();
            int size = getModel().getSize();
            for (int i=0; i<size; i++) {
                if (getSelectionModel().isSelectedIndex(i)) {
                    newSelections.add (new Integer(i));
                }
            }
            
            //men-chech yang sebelumnya dipilih
            Iterator it = pilihan.iterator();
            while (it.hasNext()) {
                int index = ((Integer) it.next()).intValue();
                getSelectionModel().addSelectionInterval(index, index);
            }
            
            it = newSelections.iterator();
            while (it.hasNext()) {
                Integer nextInt = (Integer) it.next();
                int index = nextInt.intValue();
                if (pilihan.contains (nextInt))
                    getSelectionModel().removeSelectionInterval (index, index);
                else
                    getSelectionModel().addSelectionInterval (index, index);
            }
            
            // ingat pilihan yang telah dipilih
            pilihan.clear();
            for (int i=0; i<size; i++) {
                if (getSelectionModel().isSelectedIndex(i)) {
                    pilihan.add (new Integer(i));
                }
            }
            
            addListSelectionListener (this);
        }
    }
    
    
    class CheckBoxListRenderer extends JComponent implements ListCellRenderer { 
        DefaultListCellRenderer defaultCellCellRenderer; 
        JCheckBox checkbox;    
        public CheckBoxListRenderer() {
            setLayout (new BorderLayout());
            defaultCellCellRenderer = new DefaultListCellRenderer();
            checkbox = new JCheckBox();
            add (checkbox, BorderLayout.WEST);
            add (defaultCellCellRenderer, BorderLayout.CENTER);
        }

        @Override
        public Component getListCellRendererComponent(
                JList list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus){
            defaultCellCellRenderer.getListCellRendererComponent (
                    list, 
                    value, 
                    index, 
                    isSelected, 
                    cellHasFocus);

            checkbox.setSelected (isSelected);

            Component[] comps = getComponents();
            for (int i=0; i<comps.length; i++) {
                comps[i].setForeground (listForeground);
                comps[i].setBackground (listBackground);
            }
            return this;
        }
    }
}
