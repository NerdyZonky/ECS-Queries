import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.poi.xssf.usermodel.*;

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
    
    
    public void getSQLYear(String searchFrom){
        this.searchFrom = searchFrom;
    }
    
    public void getSQLArticle(String searchFrom){
        this.searchFrom = searchFrom;
    }
    
    
    //ASSIGNMENT NOT DONE METHODS
    
    public String getSQLAssignmentNotDoneModel(){
        
        if(this.engine.equals("MySQL")){
            return "SELECT Nr,Date, KdMatch, Netto0, Ek, RefAngebot, AhTxt FROM " +tableSuffix+ "_Ah WHERE Erledigt = 0 ORDER BY Date DESC ";
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
    
    //punctually delivery
    
    public String getSQLPunctualDeliveryModel(){
        if(this.engine.equals("MySQL")){
           return "NOT IMPLEMENTED YET"; 
        }
        
        else{
            return "SELECT " +tableSuffix+ ".Ah.Nr AS AuftragsNr, " +tableSuffix+ ".Lh.Nr AS LieferscheinNr," +tableSuffix+ ".Ah.AhDateLfBis AS AuftragsDatum, " +tableSuffix+ ".Lh.Date AS LieferscheinDatum FROM " +tableSuffix+ ".Ah INNER JOIN " +tableSuffix+ ".Lh ON " +tableSuffix+ ".Ah.Nr = " +tableSuffix+ ".Lh.RefAuftrag WHERE " +tableSuffix+ ".Lh.Date > " +tableSuffix+ ".Ah.AhDateLfBis ORDER BY " +tableSuffix+ ".Ah.Date DESC;";
        }
    }
    
    
    public String getSQLSumNotPunctualPunctualDelivery(){
        if(this.engine.equals("MySQL")){
           return "NOT IMPLEMENTED YET"; 
        }
        
        else{
            return "SELECT COUNT(" +tableSuffix+ ".Ah.Nr) FROM " +tableSuffix+ ".Ah INNER JOIN " +tableSuffix+ ".Lh ON " +tableSuffix+ ".Ah.Nr = " +tableSuffix+ ".Lh.RefAuftrag WHERE " +tableSuffix+ ".Lh.Date > " +tableSuffix+ ".Ah.AhDateLfBis;";
        }
    }
    
    
  
    public String getSQLSumPunctualDelivery(){
        if(this.engine.equals("MySQL")){
           return "NOT IMPLEMENTED YET"; 
        }
        
        else{
            return "SELECT COUNT(" +tableSuffix+ ".Ah.Nr) FROM " +tableSuffix+ ".Ah INNER JOIN " +tableSuffix+ ".Lh ON " +tableSuffix+ ".Ah.Nr = " +tableSuffix+ ".Lh.RefAuftrag WHERE " +tableSuffix+ ".Lh.Date > " +tableSuffix+ ".Ah.AhDateLfBis OR " +tableSuffix+ ".Lh.Date < " +tableSuffix+ ".Ah.AhDateLfBis;";
        }
    }
    
    public String getSQLSumPunctualPunctualDelivery(){
        if(this.engine.equals("MySQL")){
           return "NOT IMPLEMENTED YET"; 
        }
        
        else{
            return "SELECT COUNT(" +tableSuffix+ ".Ah.Nr) FROM " +tableSuffix+ ".Ah INNER JOIN " +tableSuffix+ ".Lh ON " +tableSuffix+ ".Ah.Nr = " +tableSuffix+ ".Lh.RefAuftrag WHERE " +tableSuffix+ ".Lh.Date < " +tableSuffix+ ".Ah.AhDateLfBis;";
        }
    }
    
    public String getSQLPunctualDeliveryModelSearch(){
        if(this.engine.equals("MySQL")){
           return "NOT IMPLEMENTED YET"; 
        }
        
        else{
            return "SELECT " +tableSuffix+ ".Ah.Nr AS AuftragsNr, " +tableSuffix+ ".Lh.Nr AS LieferscheinNr," +tableSuffix+ ".Ah.AhDateLfBis AS AuftragsDatum, " +tableSuffix+ ".Lh.Date AS LieferscheinDatum FROM " +tableSuffix+ ".Ah INNER JOIN " +tableSuffix+ ".Lh ON " +tableSuffix+ ".Ah.Nr = " +tableSuffix+ ".Lh.RefAuftrag WHERE " +tableSuffix+ ".Lh.Date > " +tableSuffix+ ".Ah.AhDateLfBis AND " +tableSuffix+ ".Lh.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"' ORDER BY " +tableSuffix+ ".Ah.Date DESC;";
        }
    }
    
    
    public String getSQLSumNotPunctualPunctualDeliverySearch(){
        if(this.engine.equals("MySQL")){
           return "NOT IMPLEMENTED YET"; 
        }
        
        else{
            return "SELECT COUNT(" +tableSuffix+ ".Ah.Nr) FROM " +tableSuffix+ ".Ah INNER JOIN " +tableSuffix+ ".Lh ON " +tableSuffix+ ".Ah.Nr = " +tableSuffix+ ".Lh.RefAuftrag WHERE " +tableSuffix+ ".Lh.Date > " +tableSuffix+ ".Ah.AhDateLfBis AND " +tableSuffix+ ".Lh.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
    }
    

    
    public String getSQLSumPunctualPunctualDeliverySearch(){
        if(this.engine.equals("MySQL")){
           return "NOT IMPLEMENTED YET"; 
        }
        
        else{
            return "SELECT COUNT(" +tableSuffix+ ".Ah.Nr) FROM " +tableSuffix+ ".Ah INNER JOIN " +tableSuffix+ ".Lh ON " +tableSuffix+ ".Ah.Nr = " +tableSuffix+ ".Lh.RefAuftrag WHERE " +tableSuffix+ ".Lh.Date < " +tableSuffix+ ".Ah.AhDateLfBis AND " +tableSuffix+ ".Lh.Date BETWEEN" + "'" + this.searchFrom +"'" + "AND" + "'" + this.searchTo +"';";
        }
    }
    
    
    //gross profit
    
    public String getSQLGrossProfitModel(){
        if(this.engine.equals("MySQL")){
           return "NOT IMPLEMENTED YET"; 
        }
        
        else{
            return "SELECT SUM(Ertrag01) AS Januar,SUM(Ertrag02) AS Februar,SUM(Ertrag03) AS Maerz,SUM(Ertrag04) AS April, SUM(Ertrag05) AS Mai,SUM(Ertrag06) AS Juni,SUM(Ertrag07) AS Juli,SUM(Ertrag08) AS August,SUM(Ertrag09) AS September,SUM(Ertrag10) AS Oktober,SUM(Ertrag11) AS November,SUM(Ertrag11) AS Dezember, SUM(Ertrag00) AS Ertrag_Gesamt FROM TFW_M001.KstUmsatz WHERE Nr='5410';";
        }
    }
    
    
    public String getSQLGrossProfitModelSearch(){
        if(this.engine.equals("MySQL")){
           return "NOT IMPLEMENTED YET"; 
        }
        
        else{
            return "SELECT SUM(Ertrag01) AS Januar,SUM(Ertrag02) AS Februar,SUM(Ertrag03) AS Maerz,SUM(Ertrag04) AS April, SUM(Ertrag05) AS Mai,SUM(Ertrag06) AS Juni,SUM(Ertrag07) AS Juli,SUM(Ertrag08) AS August,SUM(Ertrag09) AS September,SUM(Ertrag10) AS Oktober,SUM(Ertrag11) AS November,SUM(Ertrag11) AS Dezember, SUM(Ertrag00) AS Ertrag_Gesamt FROM TFW_M001.KstUmsatz WHERE Nr='5410' AND Year =" +"'" + this.searchFrom +"';";
        }
    }
    
    public String getSQLGrossProfitTotal(){
        if(this.engine.equals("MySQL")){
           return "NOT IMPLEMENTED YET"; 
        }
        
        else{
            return "SELECT SUM(Umsatz00) AS Umsatz FROM TFW_M001.KstUmsatz WHERE Nr='5410';";
        }
    }
    
    public String getSQLGrossProfitTotalSearch(){
        if(this.engine.equals("MySQL")){
           return "NOT IMPLEMENTED YET"; 
        }
        
        else{
            return "SELECT SUM(Umsatz00) AS Umsatz FROM TFW_M001.KstUmsatz WHERE Nr='5410' AND Year =" +"'" + this.searchFrom +"';";
        }
    }
    
    
    //sales
    
    public String getSQLSalesModel(){
        if(this.engine.equals("MySQL")){
           return "NOT IMPLEMENTED YET"; 
        }
        
        else{
            return "SELECT SUM(Umsatz01) AS Januar,SUM(Umsatz02) AS Februar,SUM(Umsatz03) AS Maerz,SUM(Umsatz04) AS April, SUM(Umsatz05) AS Mai,SUM(Umsatz06) AS Juni,SUM(Umsatz07) AS Juli,SUM(Umsatz08) AS August,SUM(Umsatz09) AS September,SUM(Umsatz10) AS Oktober,SUM(Umsatz11) AS November,SUM(Umsatz11) AS Dezember,SUM(Umsatz00) AS Umsatz_Gesamt FROM TFW_M001.KstUmsatz WHERE Nr='5410';";
        }
    }
    
    
    public String getSQLSalesModelSearch(){
        if(this.engine.equals("MySQL")){
           return "NOT IMPLEMENTED YET"; 
        }
        
        else{
            return "SELECT SUM(Umsatz01) AS Januar,SUM(Umsatz02) AS Februar,SUM(Umsatz03) AS Maerz,SUM(Umsatz04) AS April, SUM(Umsatz05) AS Mai,SUM(Umsatz06) AS Juni,SUM(Umsatz07) AS Juli,SUM(Umsatz08) AS August,SUM(Umsatz09) AS September,SUM(Umsatz10) AS Oktober,SUM(Umsatz11) AS November,SUM(Umsatz11) AS Dezember, SUM(Umsatz00) AS Umsatz_Gesamt FROM TFW_M001.KstUmsatz WHERE Nr='5410' AND Year =" +"'" + this.searchFrom +"';";
        }
    }
    
    public String getSQLSalesTotal(){
        if(this.engine.equals("MySQL")){
           return "NOT IMPLEMENTED YET"; 
        }
        
        else{
            return "SELECT SUM(Umsatz00) AS Umsatz FROM TFW_M001.KstUmsatz WHERE Nr='5410';";
        }
    }
    
    public String getSQLSalesTotalSearch(){
        if(this.engine.equals("MySQL")){
           return "NOT IMPLEMENTED YET"; 
        }
        
        else{
            return "SELECT SUM(Umsatz00) AS Umsatz FROM TFW_M001.KstUmsatz WHERE Nr='5410' AND Year =" +"'" + this.searchFrom +"';";
        }
    }
    
    
    //margin
    
    public String getSQLMarginModel(){
        if(this.engine.equals("MySQL")){
           return "NOT IMPLEMENTED YET"; 
        }
        
        else{
            return "SELECT SUM(Liste) AS VK, SUM(Ek) AS EK, SUM(Liste)-SUM(Ek) AS Marge_absolut, FLOOR((SUM(Liste)-SUM(Ek))/SUM(Ek)*100) AS Marge_relativ FROM TFW_M001.Art INNER JOIN TFW_M001.ArtLager ON TFW_M001.Art.Nr = TFW_M001.ArtLager.ArtNr WHERE TFW_M001.ArtLager.Kst='5410';";
        }
    }
    
    
    public String getSQLMarginModelSearch(){
        if(this.engine.equals("MySQL")){
           return "NOT IMPLEMENTED YET"; 
        }
        
        else{
            return "SELECT SUM(Liste) AS VK, SUM(Ek) AS EK, SUM(Liste)-SUM(Ek) AS Marge_absolut, FLOOR((SUM(Liste)-SUM(Ek))/SUM(Ek)*100) AS Marge_relativ FROM TFW_M001.Art INNER JOIN TFW_M001.ArtLager ON TFW_M001.Art.Nr = TFW_M001.ArtLager.ArtNr WHERE TFW_M001.ArtLager.Kst='5410'AND TFW_M001.Art.Nr =" +"'" + this.searchFrom +"';";
        }
    }
    
    
    
    
    
     
}


