import java.sql.ResultSet;
import java.sql.Statement;


/**@author Marco Schubert*/
/**returns String of SQL query syntax;
*gets values from poperties class*/
public class SQLQueries {
    
    String searchFrom;
    String searchTo;
    ResultSet Rs;
    Statement stm;
    
    properties prop = new properties();
    private final String tableSuffix = prop.getProperty("tableSuffix");
    private final String engine = prop.getProperty("engine");
   

    public SQLQueries(){}
    
    public void getSQLSearch(String searchFrom, String searchTo){
        this.searchFrom = searchFrom;
        this.searchTo = searchTo;
    }
    
    
    //ASSIGNMENT NOT DONE METHODS
    
    public String getSQLAssignmentNotDoneModel(){
        
        if(this.engine.equals("MySQL")){
            return "SELECT Nr,Date, KdMatch, Netto0, Ek, RefAngebot, AhTxt FROM TFW_M001_Ah WHERE Erledigt = 0 ORDER BY Date DESC ";
        }
        
        else{
            return "SELECT Ah.Nr,Ah.Date, Ah.KdMatch, Ah.Netto0, Ah.Ek, Ah.RefAngebot, Ah.AhTxt FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = 0 ORDER BY " +tableSuffix+ ".Ah.Date DESC;"; 
        }
    }
      
    public String getSQLAssigmentNotDoneModelSearch(){
        
        if(this.engine.equals("MySQL")){
            return "SELECT Nr,Date, KdMatch, Netto0, Ek, RefAngebot, RefRechnung, AhTxt FROM " +tableSuffix+ "_Ah WHERE Erledigt = 0 AND Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"'" + "ORDER BY Date DESC;";
        }
        
        else{
        return "SELECT Ah.Nr,Ah.Date, Ah.KdMatch, Ah.Netto0, Ah.Ek, Ah.RefAngebot, Ah.RefRechnung, Ah.AhTxt FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = 0 AND Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"'" + "ORDER BY " +tableSuffix+ ".Ah.Date DESC;";
        
        }
    }
    
   
    public String getSQLCountAssigmentNotDone() {
        
        if(this.engine.equals("MySQL")){
            return "SELECT COUNT(*) FROM " +tableSuffix+ "_Ah WHERE Erledigt = '0';"; 
        }
        
        else{
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = '0';";
        }
            
    }

    public String getSQLCountAssigmentNotDoneSearch() {
        if(this.engine.equals("MySQL")){
            return "SELECT COUNT(*) FROM " +tableSuffix+ "_Ah WHERE Erledigt = '0'AND Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
        
        else{
            return "SELECT COUNT(*) FROM " +tableSuffix+ ".Ah WHERE Ah.Erledigt = '0'AND Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
        
    }

    public String getSQLSumEkAssigmentNotDone(){
        
        if(this.engine.equals("MySQL")){
            return "SELECT SUM(Ek) FROM " +tableSuffix+ "_Ah WHERE Erledigt = 0;";
        }
        
        else{
            return "SELECT SUM(Ah.Ek) FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = 0;";
        }

    }
    
    public String getSQLSumEkAssigmentNotDoneSearch(){
        
        if(this.engine.equals("MySQL")){
            return "SELECT SUM(Ek) FROM " +tableSuffix+ "_Ah WHERE Erledigt = 0 AND Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
        
        else{
            return "SELECT SUM(Ah.Ek) FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = 0 AND Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        } 
    }
    
    
    public String getSQLSumNettoAssigmentNotDone(){
        
        if(this.engine.equals("MySQL")){
           return "SELECT SUM(Netto0) FROM " +tableSuffix+ "_Ah WHERE Erledigt = 0;"; 
        }
        
        else{
            return "SELECT SUM(Ah.Netto0) FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = 0;";
        }       
    }
    
    public String getSQLSumNettoAssigmentNotDoneSearch(){    
        
        if(this.engine.equals("MySQL")){
            return "SELECT SUM(Netto0) FROM " +tableSuffix+ "_Ah WHERE Erledigt = 0 AND Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
        
        else{
            return "SELECT SUM(Ah.Netto0) FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = 0 AND Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
    }
    
    
    
    public String getSQLCountAssigmentDone(){
        
        if(this.engine.equals("MySQL")){
            return "SELECT COUNT(*) FROM " +tableSuffix+ "_Ah WHERE Erledigt = '1';";
        }
        
        else{
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = '1';";
        }     
    }
    
    
    public String getSQLCountAssigmentDoneSearch(){
        
        if(this.engine.equals("MySQL")){
             return "SELECT COUNT(*) FROM " +tableSuffix+ "_Ah WHERE Erledigt = '1' AND Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
        
        else{
            return "SELECT COUNT(*) FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = '1' AND Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }   
    }
    
    
    public String getSQLCountAssigmentAll(){
        
        if(this.engine.equals("MySQL")){
            return "SELECT COUNT(*) FROM " +tableSuffix+ "_Ah;";
        }
        
        else{
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".Ah;";
        }     
    }

    public String getSQLCountAssigmentAllSearch(){
        
        if(this.engine.equals("MySQL")){
            return "SELECT COUNT(*) FROM " +tableSuffix+ "_Ah WHERE Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
        
        else{
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".Ah WHERE Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
    }
    
    
    //WITHOUT OFFER METHODS
    
    public String getSQLAssignmentWithoutOfferModel(){
        
        if(this.engine.equals("MySQL")){
            return "SELECT Nr,Date,KdMatch,KdNr,RefAuftrag FROM " +tableSuffix+ "_Kah WHERE RefAuftrag = '' ORDER BY Date DESC;"; 
        }
        
        else{
            return "SELECT Kah.Nr,Kah.Date,Kah.KdMatch,Kah.KdNr,Kah.RefAuftrag FROM " +tableSuffix+ ".Kah WHERE Kah.RefAuftrag = '' ORDER BY Kah.Date DESC;"; 
        }  
    }
      
    public String getSQLAssignmentWithoutOfferModelSearch(){
        
        if(this.engine.equals("MySQL")){
           return "SELECT Nr,Date,KdMatch,KdNr,RefAuftrag FROM " +tableSuffix+ "_Kah WHERE RefAuftrag = '' AND Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"'" + "ORDER BY Date DESC;";
        }
        
        else{
            return "SELECT Kah.Nr,Kah.Date,Kah.KdMatch,Kah.KdNr,Kah.RefAuftrag FROM " +tableSuffix+ ".Kah WHERE Kah.RefAuftrag = '' AND Kah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"'" + "ORDER BY Kah.Date DESC;";
        }
        
    }
    
    
    public String getSQLCountAssignmentWithoutOffer() {
        
        if(this.engine.equals("MySQL")){
            return "SELECT COUNT(*) FROM " +tableSuffix+ "_Kah WHERE RefAuftrag= '';"; 
        }
        
        else{
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".Kah WHERE " +tableSuffix+ ".Kah.RefAuftrag= '';";
        }
                     
    }
    
    public String getSQLCountAssignmentWithoutOfferSearch() {
        
        if(this.engine.equals("MySQL")){
            return "SELECT COUNT(*) FROM " +tableSuffix+ "_Kah WHERE RefAuftrag= '' AND Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
        
        else{
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".Kah WHERE " +tableSuffix+ ".Kah.RefAuftrag= '' AND Kah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
                    
    }
    
    
    public String getSQLCountAssignmentWithOffer() {
        
        if(this.engine.equals("MySQL")){
            return "SELECT COUNT(*) FROM " +tableSuffix+ "_Kah WHERE NOT RefAuftrag= '';"; 
        }
        
        else{
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".Kah WHERE NOT " +tableSuffix+ ".Kah.RefAuftrag= '';";
        }
                     
    }
    
    public String getSQLCountAssignmentWithOfferSearch() {
        
        if(this.engine.equals("MySQL")){
            return "SELECT COUNT(*) FROM " +tableSuffix+ "_Kah WHERE NOT RefAuftrag= '' AND Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
        
        else{
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".Kah WHERE NOT " +tableSuffix+ ".Kah.RefAuftrag= '' AND Kah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
                    
    }
    

    public String getSQLCountAssignmentAllOfferWithoutAssignment(){
        
        if(this.engine.equals("MySQL")){
           return "SELECT COUNT(RefAuftrag) FROM " +tableSuffix+ "_Kah ;"; 
        }
        
        else{
            return "SELECT COUNT (Kah.RefAuftrag) FROM " +tableSuffix+ ".Kah ;";
        }
        
    }
    
    
    public String getSQLCountAssignmentAllOfferWithoutAssignmentSearch(){
        
        if(this.engine.equals("MySQL")){
            return "SELECT COUNT(RefAuftrag) FROM " +tableSuffix+ "_Kah WHERE Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
        
        else{
            return "SELECT COUNT (Kah.RefAuftrag) FROM " +tableSuffix+ ".Kah WHERE Kah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
        
    }
    

    //NEGATIVE STOCK METHODS
    
    
    public String getSQLNegativeStockModel(){
        
        if(engine.equals("MySQL")){
            return "SELECT ArtNr, Ist, Kst, WHG, " +tableSuffix+ "_ArtBestand.Lager as Lager FROM " +tableSuffix+ "_Art INNER JOIN " +tableSuffix+ "_ArtBestand ON ArtNr = Nr WHERE Ist < 0 AND Kst = '5410' AND NOT WHG = 'TEXT' AND NOT WHG = 'DIENST' ORDER BY Ist;"; 
        }
        
        else{
            return "SELECT " +tableSuffix+ ".ArtBestand.ArtNr, " +tableSuffix+ ".ArtBestand.Ist, " +tableSuffix+ ".Art.Kst, " +tableSuffix+ ".Art.WHG," +tableSuffix+ ".ArtBestand.Lager FROM " +tableSuffix+ ".ArtBestand INNER JOIN " +tableSuffix+ ".Art ON " +tableSuffix+ ".ArtBestand.ArtNr = " +tableSuffix+ ".Art.Nr WHERE " +tableSuffix+ ".ArtBestand.Ist < 0 AND " +tableSuffix+ ".Art.Kst = '5410' AND NOT " +tableSuffix+ ".Art.WHG = 'TEXT' AND NOT " +tableSuffix+ ".Art.WHG = 'DIENST' ORDER BY " +tableSuffix+ ".ArtBestand.Ist ;"; 

        }
        
    }
    
    public String getSQLCountNegativeStock(){
        
        if(this.engine.equals("MySQL")){
            return "SELECT COUNT(*) FROM " +tableSuffix+ "_ArtBestand INNER JOIN " +tableSuffix+ "_Art ON ArtNr = Nr WHERE Ist < 0 AND Kst = '5410' AND NOT WHG = 'TEXT' AND NOT WHG = 'DIENST';";
        }
        
        else{
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".ArtBestand INNER JOIN " +tableSuffix+ ".Art ON " +tableSuffix+ ".ArtBestand.ArtNr = " +tableSuffix+ ".Art.Nr WHERE " +tableSuffix+ ".ArtBestand.Ist < 0 AND " +tableSuffix+ ".Art.Kst = '5410' AND NOT " +tableSuffix+ ".Art.WHG = 'TEXT' AND NOT " +tableSuffix+ ".Art.WHG = 'DIENST';";
        }
        
    }
    
    
    public String getSQLSumNegativeStock(){
        
        if(this.engine.equals("MySQL")){
            return "SELECT SUM(Ist) FROM " +tableSuffix+ "_ArtBestand INNER JOIN " +tableSuffix+ "_Art ON ArtNr = Nr WHERE Ist < 0 AND Kst = '5410' AND NOT WHG = 'TEXT' AND NOT WHG = 'DIENST';";
        }
        
        else{
            return "SELECT SUM (" +tableSuffix+ ".ArtBestand.Ist) FROM " +tableSuffix+ ".ArtBestand INNER JOIN " +tableSuffix+ ".Art ON " +tableSuffix+ ".ArtBestand.ArtNr = " +tableSuffix+ ".Art.Nr WHERE " +tableSuffix+ ".ArtBestand.Ist < 0 AND " +tableSuffix+ ".Art.Kst = '5410' AND NOT " +tableSuffix+ ".Art.WHG = 'TEXT' AND NOT " +tableSuffix+ ".Art.WHG = 'DIENST';";
        }
        
    }
    
    public String getSQCountPositiveStock(){
        
        if(this.engine.equals("MySQL")){
            return "SELECT COUNT(*) FROM " +tableSuffix+ "_ArtBestand INNER JOIN " +tableSuffix+ "_Art ON ArtNr = Nr WHERE Ist > 0 AND Kst = '5410' AND NOT WHG = 'TEXT' AND NOT WHG = 'DIENST';";
        }
        else{
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".ArtBestand INNER JOIN " +tableSuffix+ ".Art ON " +tableSuffix+ ".ArtBestand.ArtNr = " +tableSuffix+ ".Art.Nr WHERE " +tableSuffix+ ".ArtBestand.Ist > 0 AND " +tableSuffix+ ".Art.Kst = '5410' AND NOT " +tableSuffix+ ".Art.WHG = 'TEXT' AND NOT " +tableSuffix+ ".Art.WHG = 'DIENST';";
        }
    }
    
    public String getSQLSumPostitiveStock(){
        
        if(this.engine.equals("MySQL")){
            return "SELECT SUM(Ist) FROM " +tableSuffix+ "_ArtBestand INNER JOIN " +tableSuffix+ "_Art ON ArtNr = Nr WHERE Ist > 0 AND Kst = '5410' AND NOT WHG = 'TEXT' AND NOT WHG = 'DIENST';";
        }
        
        else{
            return "SELECT SUM (" +tableSuffix+ ".ArtBestand.Ist) FROM " +tableSuffix+ ".ArtBestand INNER JOIN " +tableSuffix+ ".Art ON " +tableSuffix+ ".ArtBestand.ArtNr = " +tableSuffix+ ".Art.Nr WHERE " +tableSuffix+ ".ArtBestand.Ist > 0 AND " +tableSuffix+ ".Art.Kst = '5410' AND NOT " +tableSuffix+ ".Art.WHG = 'TEXT' AND NOT " +tableSuffix+ ".Art.WHG = 'DIENST';";
        }
        
    }
    
    public String getSQCountNullStock(){
        
        if(this.engine.equals("MySQL")){
            return "SELECT COUNT(*) FROM " +tableSuffix+ "_ArtBestand INNER JOIN " +tableSuffix+ "_Art ON ArtNr = Nr WHERE Ist = 0 AND Kst = '5410' AND NOT WHG = 'TEXT' AND NOT WHG = 'DIENST';";
        }
        
        else{
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".ArtBestand INNER JOIN " +tableSuffix+ ".Art ON " +tableSuffix+ ".ArtBestand.ArtNr = " +tableSuffix+ ".Art.Nr WHERE " +tableSuffix+ ".ArtBestand.Ist = 0 AND " +tableSuffix+ ".Art.Kst = '5410' AND NOT " +tableSuffix+ ".Art.WHG = 'TEXT' AND NOT " +tableSuffix+ ".Art.WHG = 'DIENST';";
    
        }
        
    }
    
    public String getSQLSumNullStock(){
        
        if(this.engine.equals("MySQL")){
           return "SELECT SUM(ArtBestand.Ist) FROM " +tableSuffix+ "_ArtBestand INNER JOIN " +tableSuffix+ "_Art ON ArtBestand.ArtNr = Art.Nr WHERE ArtBestand.Ist = 0 AND Art.Kst = '5410' AND NOT Art.WHG = 'TEXT' AND NOT Art.WHG = 'DIENST';"; 
        }
        
        else{
            return "SELECT SUM (" +tableSuffix+ ".ArtBestand.Ist) FROM " +tableSuffix+ ".ArtBestand INNER JOIN " +tableSuffix+ ".Art ON " +tableSuffix+ ".ArtBestand.ArtNr = " +tableSuffix+ ".Art.Nr WHERE " +tableSuffix+ ".ArtBestand.Ist = 0 AND " +tableSuffix+ ".Art.Kst = '5410' AND NOT " +tableSuffix+ ".Art.WHG = 'TEXT' AND NOT " +tableSuffix+ ".Art.WHG = 'DIENST';";
        }
        
        
    }
     
}


