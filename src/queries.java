import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;

/**@author Marco Schubert*/
/**sets jTable model and executes SQL queries from SQLQueries class;
*gets values from properties class;
*sets SQL connection from connectDB class;
*execute SQL query through SQLQueries class;
*decrypts password through EncryptDecryptPass class 
*/
public class queries {
 
    private final String server;
    private final String port;
    private final String database;
    private final String user;
    private final String password;

    private String view;
    private String statement;
    private String statement1;

    ResultSet Rs;
    Statement stm;
    connectDB conn=new connectDB();
    properties prop = new properties();
    DefaultTableModel model = new DefaultTableModel();
    SQLQueries sql = new SQLQueries();
    EncryptDecryptPass edp = new EncryptDecryptPass();

    public queries(){

        this.server = prop.getProperty("server");
        this.port = prop.getProperty("port");
        this.database = prop.getProperty("database");
        this.user = prop.getProperty("user");
        this.password = edp.decryptPassword();
    }
    
  
    //assignment model
    public DefaultTableModel getAssignmentModel(String statement){
        
        this.statement1 = statement;

        model.addColumn("Auftrags_Nr.");
        model.addColumn("Datum");
        model.addColumn("Kunde");
        model.addColumn("Netto_Preis");
        model.addColumn("EK_Preis");
        model.addColumn("Angebot");
        model.addColumn("Text");

        try {

            stm=conn.connect(server, port, database, user, password).createStatement();
            ResultSet Rs=stm.executeQuery(this.statement1);

            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString("Nr"),Rs.getString("Date"),Rs.getString("KdMatch"),Rs.getString("Netto0"),Rs.getString("Ek"), Rs.getString("RefAngebot") , Rs.getString("AhTxt")});

            }
        } 

        catch (Exception e) {
            System.err.println(e);
        }

        return model;      
    }
    
    
    
  
    
    
    //offer whithout assignment model
    
    public DefaultTableModel getOfferWithoutAssignmentModel(String statement){
        
        this.statement1 = statement;

        model.addColumn("Angebots_Nr.");
        model.addColumn("Datum");
        model.addColumn("Kunde");
        model.addColumn("Kunden_Nr.");
        model.addColumn("Auftrag");

        try {

            stm=conn.connect(server, port, database, user, password).createStatement();
            ResultSet Rs=stm.executeQuery(this.statement1);

            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString("Nr"),Rs.getString("Date"),Rs.getString("KdMatch"),Rs.getString("KdNr"),Rs.getString("RefAuftrag")});

            }
        } 

        catch (Exception e) {
            System.err.println(e);
        }

        return model;      
    }
    
    
    // negative stock model
    
    public DefaultTableModel getNegativeStockModel(String statement){
        
        this.statement1 = statement;

        model.addColumn("Artikel_Nr.");
        model.addColumn("Ist-Bestand");
        model.addColumn("Kostenstelle");
        model.addColumn("Warengruppe");
        model.addColumn("Lager");

        try {

            stm=conn.connect(server, port, database, user, password).createStatement();
            ResultSet Rs=stm.executeQuery(this.statement1);

            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString("ArtNr"),Rs.getString("Ist"),Rs.getString("Kst"),Rs.getString("WHG"),Rs.getString("Lager")});

            }
        } 

        catch (Exception e) {
            System.err.println(e);
        }

        return model;      
    }
    
    
    // punctual delivery model
    
    public DefaultTableModel getPunctualDeliveryModel(String statement){
        
        this.statement1 = statement;

        model.addColumn("AuftragsNr");
        model.addColumn("LieferscheinNr");
        model.addColumn("Lieferdatum Soll");
        model.addColumn("Lieferdatum Ist");

        try {

            stm=conn.connect(server, port, database, user, password).createStatement();
            ResultSet Rs=stm.executeQuery(this.statement1);

            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString("AuftragsNr"),Rs.getString("LieferscheinNr"),Rs.getString("AuftragsDatum"),Rs.getString("LieferscheinDatum")});

            }
        } 

        catch (Exception e) {
            System.err.println(e);
        }

        return model;      
    }
    
    
    // gross profit model
    
    public DefaultTableModel getGrossProfitModel(String statement){
        
        this.statement1 = statement;

        model.addColumn("Januar");
        model.addColumn("Februar");
        model.addColumn("März");
        model.addColumn("April");
        model.addColumn("Mai");
        model.addColumn("Juni");
        model.addColumn("Juli");
        model.addColumn("August");
        model.addColumn("September");
        model.addColumn("Oktober");
        model.addColumn("November");
        model.addColumn("Dezember");
        model.addColumn("Gesamt");

        try {

            stm=conn.connect(server, port, database, user, password).createStatement();
            ResultSet Rs=stm.executeQuery(this.statement1);

            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString("Januar"),Rs.getString("Februar"),Rs.getString("Maerz"),Rs.getString("April"),Rs.getString("Mai"),Rs.getString("Juni"),Rs.getString("Juli"),Rs.getString("August"),Rs.getString("September"),Rs.getString("Oktober"),Rs.getString("November"),Rs.getString("Dezember"),Rs.getString("Ertrag_Gesamt")});

            }
        } 

        catch (Exception e) {
            System.err.println(e);
        }

        return model;      
    }
    
    
    
    //sales model
    
    public DefaultTableModel getSalesModel(String statement){
        
        this.statement1 = statement;

        model.addColumn("Januar");
        model.addColumn("Februar");
        model.addColumn("März");
        model.addColumn("April");
        model.addColumn("Mai");
        model.addColumn("Juni");
        model.addColumn("Juli");
        model.addColumn("August");
        model.addColumn("September");
        model.addColumn("Oktober");
        model.addColumn("November");
        model.addColumn("Dezember");
        model.addColumn("Gesamt");

        try {

            stm=conn.connect(server, port, database, user, password).createStatement();
            ResultSet Rs=stm.executeQuery(this.statement1);

            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString("Januar"),Rs.getString("Februar"),Rs.getString("Maerz"),Rs.getString("April"),Rs.getString("Mai"),Rs.getString("Juni"),Rs.getString("Juli"),Rs.getString("August"),Rs.getString("September"),Rs.getString("Oktober"),Rs.getString("November"),Rs.getString("Dezember"),Rs.getString("Umsatz_Gesamt")});

            }
        } 

        catch (Exception e) {
            System.err.println(e);
        }

        return model;      
    }
    
    
    //margin modell
    
    public DefaultTableModel getMarginModel(String statement){
        
        this.statement1 = statement;

        model.addColumn("VK(€)");
        model.addColumn("EK(€)");
        model.addColumn("Absolut(€)");
        model.addColumn("Relativ(%)");

        try {

            stm=conn.connect(server, port, database, user, password).createStatement();
            ResultSet Rs=stm.executeQuery(this.statement1);

            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString("VK"),Rs.getString("EK"),Rs.getString("Marge_absolut"),Rs.getString("Marge_relativ")});

            }
        } 

        catch (Exception e) {
            System.err.println(e);
        }

        return model;      
    }
    
    
    //fire up SQL command
    
    public String sqlCommand(String statement){

        this.statement = statement;

        try {
            stm=conn.connect(server, port, database, user, password).createStatement();
            ResultSet Rs=stm.executeQuery(this.statement);
            if(Rs.next())
                return Rs.getString(1);
            } 
            catch (Exception e) {
                System.err.println(e);
            }  
            return null; 
        }
   
    
    
    // round values and get percent
    public String roundPercentValues(String value1, String value2){

        double storevalue1DBL = Double.parseDouble(value1); //convert value to double
        double storevalue2DBL = Double.parseDouble(value2);       //convert value to double
        double assignmentNotDonePercent = (storevalue1DBL/storevalue2DBL * 100); // get value in percent
        double roundAssignmentNotDonePercent = Math.round(assignmentNotDonePercent *100)/100.0d; // round value 
        String roundAssignmentNotDonePercentString = Double.toString(roundAssignmentNotDonePercent); //convert values to string again
        return roundAssignmentNotDonePercentString;          
    }
}
    