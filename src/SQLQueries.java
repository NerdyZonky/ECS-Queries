import java.sql.ResultSet;
import java.sql.Statement;


public class SQLQueries {
    
    String searchFrom;
    String searchTo;
    ResultSet Rs;
    Statement stm;

    public SQLQueries(){}
    
    public void getSQLSearch(String searchFrom, String searchTo){
        this.searchFrom = searchFrom;
        this.searchTo = searchTo;
    }
    
    
    //ASSIGNMENT NOT DONE METHODS
    
    public String getSQLAssignmentNotDoneModel(){
        return "SELECT Ah.Nr,Ah.Date, Ah.KdMatch, Ah.Netto0, Ah.Ek, Ah.RefAngebot, Ah.AhTxt FROM TFW_M001.Ah WHERE TFW_M001.Ah.Erledigt = 0 ORDER BY TFW_M001.Ah.Date DESC;"; 

    }
      
    public String getSQLAssigmentNotDoneModelSearch(){
        return "SELECT Ah.Nr,Ah.Date, Ah.KdMatch, Ah.Netto0, Ah.Ek, Ah.RefAngebot, Ah.RefRechnung, Ah.AhTxt FROM TFW_M001.Ah WHERE TFW_M001.Ah.Erledigt = 0 AND Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"'" + "ORDER BY TFW_M001.Ah.Date DESC;";

    }
    
   
    public String getSQLCountAssigmentNotDone() {
            return "SELECT COUNT (*) FROM TFW_M001.Ah WHERE TFW_M001.Ah.Erledigt = '0';";         
    }

    public String getSQLCountAssigmentNotDoneSearch() {
        return "SELECT COUNT (*) FROM TFW_M001.Ah WHERE TFW_M001.Ah.Erledigt = '0'AND Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
    }

    public String getSQLSumEkAssigmentNotDone(){
        return "SELECT SUM(Ah.Ek) FROM TFW_M001.Ah WHERE TFW_M001.Ah.Erledigt = 0;";
    
    }
    
    public String getSQLSumEkAssigmentNotDoneSearch(){
        return "SELECT SUM(Ah.Ek) FROM TFW_M001.Ah WHERE TFW_M001.Ah.Erledigt = 0 AND Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
    }
    
    
    public String getSQLSumNettoAssigmentNotDone(){
        return "SELECT SUM(Ah.Netto0) FROM TFW_M001.Ah WHERE TFW_M001.Ah.Erledigt = 0;";
        
    }
    
    public String getSQLSumNettoAssigmentNotDoneSearch(){    
        return "SELECT SUM(Ah.Netto0) FROM TFW_M001.Ah WHERE TFW_M001.Ah.Erledigt = 0 AND Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
    }
    
    
    public String getSQLCountAssigmentDone(){
            return "SELECT COUNT (*) FROM TFW_M001.Ah WHERE TFW_M001.Ah.Erledigt = '1';";
    }
    
    
    public String getSQLCountAssigmentDoneSearch(){
        
            return "SELECT COUNT (*) FROM TFW_M001.Ah WHERE TFW_M001.Ah.Erledigt = '1' AND Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
    
    
    public String getSQLCountAssigmentAll(){
            return "SELECT COUNT (*) FROM TFW_M001.Ah;";
    }

    public String getSQLCountAssigmentAllSearch(){
        return "SELECT COUNT (*) FROM TFW_M001.Ah WHERE Ah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
    }
    
    
    //WITHOUT OFFER METHODS
    
    public String getSQLAssignmentWithoutOfferModel(){
        return "SELECT Kah.Nr,Kah.Date,Kah.KdMatch,Kah.KdNr,Kah.RefAuftrag FROM TFW_M001.Kah WHERE Kah.RefAuftrag = '' ORDER BY Kah.Date DESC;"; 

    }
      
    public String getSQLAssignmentWithoutOfferModelSearch(){
        return "SELECT Kah.Nr,Kah.Date,Kah.KdMatch,Kah.KdNr,Kah.RefAuftrag FROM TFW_M001.Kah WHERE Kah.RefAuftrag = '' AND Kah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"'" + "ORDER BY Kah.Date DESC;";

    }
    
    
    public String getSQLCountAssignmentWithoutOffer() {
            return "SELECT COUNT (*) FROM TFW_M001.Kah WHERE TFW_M001.Kah.RefAuftrag= '';";         
    }
    
    public String getSQLCountAssignmentWithoutOfferSearch() {
            return "SELECT COUNT (*) FROM TFW_M001.Kah WHERE TFW_M001.Kah.RefAuftrag= '' AND Kah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";        
    }
    
    
    public String getSQLCountAssignmentWithOffer() {
            return "SELECT COUNT (*) FROM TFW_M001.Kah WHERE NOT TFW_M001.Kah.RefAuftrag= '';";         
    }
    
    public String getSQLCountAssignmentWithOfferSearch() {
            return "SELECT COUNT (*) FROM TFW_M001.Kah WHERE NOT TFW_M001.Kah.RefAuftrag= '' AND Kah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";        
    }
    

    public String getSQLCountAssignmentAllOfferWithoutAssignment(){
        return "SELECT COUNT (Kah.RefAuftrag) FROM TFW_M001.Kah ;";
    }
    
    
    public String getSQLCountAssignmentAllOfferWithoutAssignmentSearch(){
        return "SELECT COUNT (Kah.RefAuftrag) FROM TFW_M001.Kah WHERE Kah.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
    }
    

    //NEGATIVE STOCK METHODS
    
    
    public String getSQLNegativeStockModel(){
        return "SELECT TFW_M001.ArtBestand.ArtNr, TFW_M001.ArtBestand.Ist, TFW_M001.Art.Kst, TFW_M001.Art.WHG,TFW_M001.ArtBestand.Lager FROM TFW_M001.ArtBestand INNER JOIN TFW_M001.Art ON TFW_M001.ArtBestand.ArtNr = TFW_M001.Art.Nr WHERE TFW_M001.ArtBestand.Ist < 0 AND TFW_M001.Art.Kst = '5410' AND NOT TFW_M001.Art.WHG = 'TEXT' AND NOT TFW_M001.Art.WHG = 'DIENST' ORDER BY TFW_M001.ArtBestand.Ist ;"; 

    }
    
    public String getSQLCountNegativeStock(){
        return "SELECT COUNT (*) FROM TFW_M001.ArtBestand INNER JOIN TFW_M001.Art ON TFW_M001.ArtBestand.ArtNr = TFW_M001.Art.Nr WHERE TFW_M001.ArtBestand.Ist < 0 AND TFW_M001.Art.Kst = '5410' AND NOT TFW_M001.Art.WHG = 'TEXT' AND NOT TFW_M001.Art.WHG = 'DIENST';";
    }
    
    
    public String getSQLSumNegativeStock(){
        return "SELECT SUM (TFW_M001.ArtBestand.Ist) FROM TFW_M001.ArtBestand INNER JOIN TFW_M001.Art ON TFW_M001.ArtBestand.ArtNr = TFW_M001.Art.Nr WHERE TFW_M001.ArtBestand.Ist < 0 AND TFW_M001.Art.Kst = '5410' AND NOT TFW_M001.Art.WHG = 'TEXT' AND NOT TFW_M001.Art.WHG = 'DIENST';";
    }
    
    public String getSQCountPositiveStock(){
        return "SELECT COUNT (*) FROM TFW_M001.ArtBestand INNER JOIN TFW_M001.Art ON TFW_M001.ArtBestand.ArtNr = TFW_M001.Art.Nr WHERE TFW_M001.ArtBestand.Ist > 0 AND TFW_M001.Art.Kst = '5410' AND NOT TFW_M001.Art.WHG = 'TEXT' AND NOT TFW_M001.Art.WHG = 'DIENST';";
    }
    
    public String getSQLSumPostitiveStock(){
        return "SELECT SUM (TFW_M001.ArtBestand.Ist) FROM TFW_M001.ArtBestand INNER JOIN TFW_M001.Art ON TFW_M001.ArtBestand.ArtNr = TFW_M001.Art.Nr WHERE TFW_M001.ArtBestand.Ist > 0 AND TFW_M001.Art.Kst = '5410' AND NOT TFW_M001.Art.WHG = 'TEXT' AND NOT TFW_M001.Art.WHG = 'DIENST';";
    }
    
    public String getSQCountNullStock(){
        return "SELECT COUNT (*) FROM TFW_M001.ArtBestand INNER JOIN TFW_M001.Art ON TFW_M001.ArtBestand.ArtNr = TFW_M001.Art.Nr WHERE TFW_M001.ArtBestand.Ist = 0 AND TFW_M001.Art.Kst = '5410' AND NOT TFW_M001.Art.WHG = 'TEXT' AND NOT TFW_M001.Art.WHG = 'DIENST';";
    }
    
    public String getSQLSumNullStock(){
        return "SELECT SUM (TFW_M001.ArtBestand.Ist) FROM TFW_M001.ArtBestand INNER JOIN TFW_M001.Art ON TFW_M001.ArtBestand.ArtNr = TFW_M001.Art.Nr WHERE TFW_M001.ArtBestand.Ist = 0 AND TFW_M001.Art.Kst = '5410' AND NOT TFW_M001.Art.WHG = 'TEXT' AND NOT TFW_M001.Art.WHG = 'DIENST';";
    }
     
}


