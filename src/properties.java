import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


public class properties {
    
    private String server;
    private String port;
    private String database;
    private String user;
    private String password;
    
    private String view;
    private String search;
    private String searchFrom;
    private String searchTo;
    
    
    Properties prop = new Properties();
    
    public void setProperty(String server, String port, String database, String user, String password){
        
        this.server = server;
        this.port = port;
        this.database =database;
        this.user = user;
        this.password = password;
        
        
       
	OutputStream output = null;

	try {

		output = new FileOutputStream("config.properties");

		// set the properties value
		this.prop.setProperty("server", this.server);
		this.prop.setProperty("port", this.port);
		this.prop.setProperty("database", this.database);
                this.prop.setProperty("user", this.user);
                this.prop.setProperty("password", this.password);

		// save properties to project root folder
		prop.store(output, null);

	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
    }
    

    public String getProperty(String name){
        
        Properties prop = new Properties();
        
        InputStream input = null;

	try {

		input = new FileInputStream("config.properties");

		// load a properties file
		prop.load(input);
		

	} catch (IOException ex) {
		ex.printStackTrace();
	}
        
        if("server".equals(name)){
            return prop.getProperty("server");
        }
        
        if ("port".equals(name)){
            return prop.getProperty("port");
        }
        
        if("database".equals(name)){
            return prop.getProperty("database");
        }
        
        if("user".equals(name)){
            return prop.getProperty("user");
        }
        
        if("password".equals(name)){
            return prop.getProperty("password");
        }
        
        return null;
    }
    
    
    
    public void setView(String view){
        
        this.view = view;
	OutputStream output = null;

	try {
		output = new FileOutputStream("config.view");

		// set the properties value
		this.prop.setProperty("view", this.view);


		// save properties to project root folder
		prop.store(output, null);

	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
    }
    
    
    public void setAssignmentNotDoneCsvData(String view){
        
        this.view = view;
	OutputStream output = null;

	try {
		output = new FileOutputStream("config.view");

		// set the properties value
		this.prop.setProperty("view", this.view);


		// save properties to project root folder
		prop.store(output, null);

	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
    }
    
    
    
    
     public String getView(String name){
        
        Properties prop = new Properties();
        
        InputStream input = null;

	try {

		input = new FileInputStream("config.view");

		// load a properties file
		prop.load(input);
		

	} catch (IOException ex) {
		ex.printStackTrace();
	}
        
        if("view".equals(name)){
            return prop.getProperty("view");
        }
        
        return null;
    }
     
     
     
     
     
public void setSearch(String search,String searchFrom, String searchTo){
        
        this.search = search;
        this.searchFrom = searchFrom;
        this.searchTo = searchTo;
        
        
       
	OutputStream output = null;

	try {

		output = new FileOutputStream("config.search");

		// set the properties value
                this.prop.setProperty("search", this.search);
		this.prop.setProperty("searchFrom", this.searchFrom);
		this.prop.setProperty("SearchTo", this.searchTo);
		// save properties to project root folder
		prop.store(output, null);

	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
    }
     
     
    public String getSearch(String name){
        
        Properties prop = new Properties();
        
        InputStream input = null;

	try {

		input = new FileInputStream("config.search");

		// load a properties file
		prop.load(input);
		

	} catch (IOException ex) {
		ex.printStackTrace();
	}
        
        if("search".equals(name)){
            return prop.getProperty("search");
        }
        
        if("searchFrom".equals(name)){
            return prop.getProperty("searchFrom");
        }
        
        if ("searchTo".equals(name)){
            return prop.getProperty("searchTo");
        }
        
        return null;
    }
    
    
 
    
}
