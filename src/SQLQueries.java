import java.sql.ResultSet;
import java.sql.Statement;


public class SQLQueries {
    
    String searchFrom;
    String searchTo;
    ResultSet Rs;
    Statement stm;
    
    properties prop = new properties();
    String tableSuffix = prop.getProperty("tableSuffix");
   

    public SQLQueries(){}
    
    public void getSQLSearch(String searchFrom, String searchTo){
        this.searchFrom = searchFrom;
        this.searchTo = searchTo;
    }
    
    
    //ASSIGNMENT NOT DONE METHODS
    
    public String getSQLAssignmentNotDoneModel(){
        
        
       
        return "SELECT Ah.Nr,Ah.Date, Ah.KdMatch, Ah.Netto0, Ah.Ek, Ah.RefAngebot, Ah.AhTxt FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = 0 ORDER BY " +tableSuffix+ ".Ah.Date DESC;"; 

    }
      
    public String getSQLAssigmentNotDoneModelSearch(){
        return "SELECT Ah.Nr,Ah.Date, Ah.KdMatch, Ah.Netto0, Ah.Ek, Ah.RefAngebot, Ah.RefRechnung, Ah.AhTxt FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = 0 AND Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"'" + "ORDER BY " +tableSuffix+ ".Ah.Date DESC;";

    }
    
   
    public String getSQLCountAssigmentNotDone() {
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = '0';";         
    }

    public String getSQLCountAssigmentNotDoneSearch() {
        return "SELECT COUNT (*) FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = '0'AND Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
    }

    public String getSQLSumEkAssigmentNotDone(){
        return "SELECT SUM(Ah.Ek) FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = 0;";
    
    }
    
    public String getSQLSumEkAssigmentNotDoneSearch(){
        return "SELECT SUM(Ah.Ek) FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = 0 AND Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
    }
    
    
    public String getSQLSumNettoAssigmentNotDone(){
        return "SELECT SUM(Ah.Netto0) FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = 0;";
        
    }
    
    public String getSQLSumNettoAssigmentNotDoneSearch(){    
        return "SELECT SUM(Ah.Netto0) FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = 0 AND Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
    }
    
    
    public String getSQLCountAssigmentDone(){
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = '1';";
    }
    
    
    public String getSQLCountAssigmentDoneSearch(){
        
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".Ah WHERE " +tableSuffix+ ".Ah.Erledigt = '1' AND Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
    
    
    public String getSQLCountAssigmentAll(){
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".Ah;";
    }

    public String getSQLCountAssigmentAllSearch(){
        return "SELECT COUNT (*) FROM " +tableSuffix+ ".Ah WHERE Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
    }
    
    
    //WITHOUT OFFER METHODS
    
    public String getSQLAssignmentWithoutOfferModel(){
        return "SELECT Kah.Nr,Kah.Date,Kah.KdMatch,Kah.KdNr,Kah.RefAuftrag FROM " +tableSuffix+ ".Kah WHERE Kah.RefAuftrag = '' ORDER BY Kah.Date DESC;"; 

    }
      
    public String getSQLAssignmentWithoutOfferModelSearch(){
        return "SELECT Kah.Nr,Kah.Date,Kah.KdMatch,Kah.KdNr,Kah.RefAuftrag FROM " +tableSuffix+ ".Kah WHERE Kah.RefAuftrag = '' AND Kah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"'" + "ORDER BY Kah.Date DESC;";

    }
    
    
    public String getSQLCountAssignmentWithoutOffer() {
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".Kah WHERE " +tableSuffix+ ".Kah.RefAuftrag= '';";         
    }
    
    public String getSQLCountAssignmentWithoutOfferSearch() {
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".Kah WHERE " +tableSuffix+ ".Kah.RefAuftrag= '' AND Kah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";        
    }
    
    
    public String getSQLCountAssignmentWithOffer() {
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".Kah WHERE NOT " +tableSuffix+ ".Kah.RefAuftrag= '';";         
    }
    
    public String getSQLCountAssignmentWithOfferSearch() {
            return "SELECT COUNT (*) FROM " +tableSuffix+ ".Kah WHERE NOT " +tableSuffix+ ".Kah.RefAuftrag= '' AND Kah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";        
    }
    

    public String getSQLCountAssignmentAllOfferWithoutAssignment(){
        return "SELECT COUNT (Kah.RefAuftrag) FROM " +tableSuffix+ ".Kah ;";
    }
    
    
    public String getSQLCountAssignmentAllOfferWithoutAssignmentSearch(){
        return "SELECT COUNT (Kah.RefAuftrag) FROM " +tableSuffix+ ".Kah WHERE Kah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
    }
    

    //NEGATIVE STOCK METHODS
    
    
    public String getSQLNegativeStockModel(){
        return "SELECT " +tableSuffix+ ".ArtBestand.ArtNr, " +tableSuffix+ ".ArtBestand.Ist, " +tableSuffix+ ".Art.Kst, " +tableSuffix+ ".Art.WHG," +tableSuffix+ ".ArtBestand.Lager FROM " +tableSuffix+ ".ArtBestand INNER JOIN " +tableSuffix+ ".Art ON " +tableSuffix+ ".ArtBestand.ArtNr = " +tableSuffix+ ".Art.Nr WHERE " +tableSuffix+ ".ArtBestand.Ist < 0 AND " +tableSuffix+ ".Art.Kst = '5410' AND NOT " +tableSuffix+ ".Art.WHG = 'TEXT' AND NOT " +tableSuffix+ ".Art.WHG = 'DIENST' ORDER BY " +tableSuffix+ ".ArtBestand.Ist ;"; 

    }
    
    public String getSQLCountNegativeStock(){
        return "SELECT COUNT (*) FROM " +tableSuffix+ ".ArtBestand INNER JOIN " +tableSuffix+ ".Art ON " +tableSuffix+ ".ArtBestand.ArtNr = " +tableSuffix+ ".Art.Nr WHERE " +tableSuffix+ ".ArtBestand.Ist < 0 AND " +tableSuffix+ ".Art.Kst = '5410' AND NOT " +tableSuffix+ ".Art.WHG = 'TEXT' AND NOT " +tableSuffix+ ".Art.WHG = 'DIENST';";
    }
    
    
    public String getSQLSumNegativeStock(){
        return "SELECT SUM (" +tableSuffix+ ".ArtBestand.Ist) FROM " +tableSuffix+ ".ArtBestand INNER JOIN " +tableSuffix+ ".Art ON " +tableSuffix+ ".ArtBestand.ArtNr = " +tableSuffix+ ".Art.Nr WHERE " +tableSuffix+ ".ArtBestand.Ist < 0 AND " +tableSuffix+ ".Art.Kst = '5410' AND NOT " +tableSuffix+ ".Art.WHG = 'TEXT' AND NOT " +tableSuffix+ ".Art.WHG = 'DIENST';";
    }
    
    public String getSQCountPositiveStock(){
        return "SELECT COUNT (*) FROM " +tableSuffix+ ".ArtBestand INNER JOIN " +tableSuffix+ ".Art ON " +tableSuffix+ ".ArtBestand.ArtNr = " +tableSuffix+ ".Art.Nr WHERE " +tableSuffix+ ".ArtBestand.Ist > 0 AND " +tableSuffix+ ".Art.Kst = '5410' AND NOT " +tableSuffix+ ".Art.WHG = 'TEXT' AND NOT " +tableSuffix+ ".Art.WHG = 'DIENST';";
    }
    
    public String getSQLSumPostitiveStock(){
        return "SELECT SUM (" +tableSuffix+ ".ArtBestand.Ist) FROM " +tableSuffix+ ".ArtBestand INNER JOIN " +tableSuffix+ ".Art ON " +tableSuffix+ ".ArtBestand.ArtNr = " +tableSuffix+ ".Art.Nr WHERE " +tableSuffix+ ".ArtBestand.Ist > 0 AND " +tableSuffix+ ".Art.Kst = '5410' AND NOT " +tableSuffix+ ".Art.WHG = 'TEXT' AND NOT " +tableSuffix+ ".Art.WHG = 'DIENST';";
    }
    
    public String getSQCountNullStock(){
        return "SELECT COUNT (*) FROM " +tableSuffix+ ".ArtBestand INNER JOIN " +tableSuffix+ ".Art ON " +tableSuffix+ ".ArtBestand.ArtNr = " +tableSuffix+ ".Art.Nr WHERE " +tableSuffix+ ".ArtBestand.Ist = 0 AND " +tableSuffix+ ".Art.Kst = '5410' AND NOT " +tableSuffix+ ".Art.WHG = 'TEXT' AND NOT " +tableSuffix+ ".Art.WHG = 'DIENST';";
    }
    
    public String getSQLSumNullStock(){
        return "SELECT SUM (" +tableSuffix+ ".ArtBestand.Ist) FROM " +tableSuffix+ ".ArtBestand INNER JOIN " +tableSuffix+ ".Art ON " +tableSuffix+ ".ArtBestand.ArtNr = " +tableSuffix+ ".Art.Nr WHERE " +tableSuffix+ ".ArtBestand.Ist = 0 AND " +tableSuffix+ ".Art.Kst = '5410' AND NOT " +tableSuffix+ ".Art.WHG = 'TEXT' AND NOT " +tableSuffix+ ".Art.WHG = 'DIENST';";
    }
     
}


