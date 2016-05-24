
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;


/**@author Marco Schubert*/
/**generates a file chooser window*/
public class FileChooser {
    
    String fileToSaveST;
    
    public FileChooser(){
        
        JFrame parentFrame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Wählen Sie einen Speicherort aus");
        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            this.fileToSaveST = fileToSave.getAbsolutePath().toString();
        }
    }
        
    public String getPath(){
        return this.fileToSaveST;
    }
    

    
 
    
}
