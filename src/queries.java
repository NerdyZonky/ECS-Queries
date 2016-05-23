import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;

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
    