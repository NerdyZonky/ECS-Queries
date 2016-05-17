
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;



public class FileChooser {
    
    String fileToSaveST;
    
    public FileChooser(){
        
        JFrame parentFrame = new JFrame();
        //FileFilter filter = new FileNameExtensionFilter("Plaintext: csv","csv");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
       // fileChooser.addChoosableFileFilter(filter);

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
