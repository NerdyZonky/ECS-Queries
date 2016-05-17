import java.sql.*;

public class connectDB {
    
    Connection con;
    properties prop = new properties();
    private String server;
    private String port;
    private String database;
    private String user;
    private String password;
    private String url;
    private String driver;
    private boolean pass = false;
    
    
    public connectDB(){}

    public Connection connect(String server, String port, String database, String user, String password){
 
        this.server = server;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
        
        if(prop.getProperty("engine").equals("MS-SQL")){
            this.url = "jdbc:sqlserver://" + this.server + ":" + this.port +";DatabaseName=" + this.database;
            this.driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        }
        
        else{
            this.url = "jdbc:mysql://" + this.server + ":" + this.port +";DatabaseName=" + this.database;
            this.driver = "com.mysql.jdbc.Driver";
        }
        
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
            System.out.println("Initialisierung fehlgeschlagen.Es wurde kein Treiber gefunden!");
        }
        
        try {
            con = DriverManager.getConnection(this.url, this.user, this.password);
            this.pass = true;
            
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return con;
    }
    
    public boolean getPass(){
        return this.pass;
    }
}