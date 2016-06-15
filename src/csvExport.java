
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JTable;
import javax.swing.table.TableModel;




/**@author Marco Schubert*/
/**generates a csv file from current jTable in assignment class and place file on choosen path of destination;
*gets jTable thorugh assignment class
*/
public class csvExport {
    
    
    FileChooser choose = new FileChooser();
    assignment as = new assignment();

    public void writeCSVfile(JTable table) throws IOException, ClassNotFoundException, SQLException{
        String file = "/home/marco/Downloads/test.xls";
        TableModel model = table.getModel();
        FileWriter out = new FileWriter(file);
        String groupExport = "";
        for (int i = 0; i < (model.getColumnCount()); i++) {//* disable export from TableHeaders
            groupExport = String.valueOf(model.getColumnName(i));
            out.write(String.valueOf(groupExport) + "\t");
        }
        out.write("\n");
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < (model.getColumnCount()); j++) {
                if (model.getValueAt(i, j) == null) {
                    out.write("null" + "\t");
                } else {
                    groupExport = String.valueOf(model.getValueAt(i, j));
                    out.write(String.valueOf(groupExport) + "\t");
                }
            }
            
            out.write("\n");
        }
        
        
        out.close();
    }
    
    

    
    
    
    
 
    
    
    
    
    
}
