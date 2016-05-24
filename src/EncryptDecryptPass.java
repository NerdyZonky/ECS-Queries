/**@author Marco Schubert*/
/**encrypts/decrypts password
*gets values from properties class 
*/

public class EncryptDecryptPass {
    
    properties prop = new properties();

    public EncryptDecryptPass(){}
       

    public String encryptPassword(String pass){
        
        String encryptedPassword = null;
        
        try{
            encryptedPassword = passcryptor.encrypt(pass);
          
            
        }
        catch(Exception e) { 
            System.out.println("bug"+e.getMessage()); }
        
        
        return encryptedPassword;
        
       
    }
    
    
   public String decryptPassword(){
        
        String decryptedPassword = null;
        
        try{
            decryptedPassword = passcryptor.decrypt(prop.getProperty("password"));
            
        }
        catch(Exception e) { 
            System.out.println("bug"+e.getMessage()); }
        
        return decryptedPassword;
    }
    
    }
        
    
    

