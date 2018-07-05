/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboards;

import java.sql.SQLException;
import java.util.Map;
import org.json.JSONObject;

/**
 *
 * @author GNyabuto
 */
public class PushDataSet2 {
    dbConn conn = new dbConn();
    dbConnDash conndash = new dbConnDash();
    
   public int pmtct_fo(Map m1) throws SQLException{
         String startyearmonth="",endyearmonth="",mflcode="",startdate="",enddate="";
         if(m1.containsKey("startyearmonth")){startyearmonth=m1.get("startyearmonth").toString();}
         if(m1.containsKey("endyearmonth")){endyearmonth=m1.get("endyearmonth").toString();}
         if(m1.containsKey("startdate")){startdate=m1.get("startdate").toString();}
         if(m1.containsKey("enddate")){enddate=m1.get("enddate").toString();}
         if(m1.containsKey("mfl_code")){mflcode=m1.get("mfl_code").toString();}
        int num=0;
        String facilitiestable="subpartnera";
        String county,sub_county,facilityName,support_type,mfl_code,arthv,pmtcthv,htchv,allhv,burdencategory,constituency;
        String ward,Owner,Type,latitude,longitude,Male_clinics,Adolescent_clinics,Viremia_clinics,EMR_Sites,Link_desks,yearmonth;
        int total;
        String year,semi_annual,quarter,month;
        String id_="";
        
        String elems[] = {"Numerator","Denominator","HIV_infected","HIV_uninfected","HIV_final_status_unknown","Died_without_status_known"};
        String elem_ids[]={"33:PMTCT FO Num: : :34","34:PMTCT FO Den: : :33","33:PMTCT FO Num:4:HIV-infected EID:34.1","33:PMTCT FO Num:5:HIV-uninfected:34.2","33:PMTCT FO Num:6:HIV-final status unknown:34.3","33:PMTCT FO Num:7:Died without status known:34.4"};
     
        String facil_where="";
         if(!mflcode.equals("")){
             facil_where="AND "+facilitiestable+".CentreSanteID="+mflcode;
         }
     
      String pmtct_fo=""+
             "SELECT "+facilitiestable+".SubPartnerNom AS facility,district.DistrictNom AS sub_county,county.County AS county,"+
                ""+facilitiestable+".CentreSanteId AS mfl_code,IFNULL(PMTCT_Support,0) AS PMTCT_Support,IFNULL(ART_highvolume,0) AS arthv, IFNULL(HTC_highvolume,0) AS htchv,IFNULL(PMTCT_highvolume,0) AS pmtcthv,"+
                "IFNULL(all_highvolume,0) AS  allhv,burden_cartegory AS burdencategory,IFNULL(constituency,'') AS constituency,IFNULL(ward,'') AS ward, IFNULL(Owner,'') AS Owner,IFNULL(Type,'') AS Type,latitude,longitude,IFNULL(Male_clinics,0) AS Male_clinics,IFNULL(Adolescent_clinics,0) AS Adolescent_clinics,"+
                "IFNULL(Viremia_clinics,0) AS Viremia_clinics,IFNULL(EMR_Sites,0) AS EMR_Sites,IFNULL(Link_desks,0) AS Link_desks,hei.results.reportingyearmonth AS yearmonth" +
                " ,sum( case when indicator_id=23 then denominator end) as Denominator " +
                " ,sum( case when (indicator_id=21 or indicator_id=22 or indicator_id=23 or  indicator_id=24 or  indicator_id=25  or indicator_id=26 )  then numerator end) as Numerator " +
                " ,sum( case when (indicator_id=23)  then numerator end) as HIV_infected " +
                " ,sum( case when (indicator_id=21)  then numerator end) as HIV_uninfected " +
                " ,sum( case when (indicator_id=22 or  indicator_id=24 or  indicator_id=25 )  then numerator end) as HIV_final_status_unknown " +
                " ,sum( case when indicator_id=26   then numerator end) as Died_without_status_known " +
                " FROM hei.results join "+facilitiestable+" on hei.results.facility_id="+facilitiestable+".SubPartnerID join (internal_system.district "
                + "join internal_system.county on internal_system.county.CountyID=internal_system.district.CountyID ) on internal_system.district.DistrictID="+facilitiestable+".DistrictID " +
                " WHERE hei.results.reportingyearmonth BETWEEN "+startyearmonth+" AND "+endyearmonth+"  "+facil_where+"  and ( "+facilitiestable+".PMTCT=1 )  AND "+facilitiestable+".active=1  " +
                " group by "+facilitiestable+".SubPartnerID,yearmonth ";
      
               System.out.println("PMTCT FO Query: "+pmtct_fo);
               
              conn.rs=conn.st.executeQuery(pmtct_fo);
             while(conn.rs.next()){

        county = conn.rs.getString("county");
        sub_county = conn.rs.getString("sub_county");
        facilityName = conn.rs.getString("facility");
        support_type = conn.rs.getString("PMTCT_Support");
        mfl_code = conn.rs.getString("mfl_code");

        arthv = conn.rs.getString("arthv");
        pmtcthv = conn.rs.getString("pmtcthv");
        htchv = conn.rs.getString("htchv");
        allhv = conn.rs.getString("allhv");
        burdencategory = conn.rs.getString("burdencategory");
        constituency = conn.rs.getString("constituency");
        ward = conn.rs.getString("ward");
        Owner = conn.rs.getString("Owner");
        Type = conn.rs.getString("Type");
        latitude = conn.rs.getString("latitude");
        longitude = conn.rs.getString("longitude");
        Male_clinics = conn.rs.getString("Male_clinics");
        Adolescent_clinics = conn.rs.getString("Adolescent_clinics");
        Viremia_clinics = conn.rs.getString("Viremia_clinics");
        EMR_Sites = conn.rs.getString("EMR_Sites");
        Link_desks = conn.rs.getString("Link_desks");
        yearmonth = conn.rs.getString("yearmonth");

        JSONObject period_data = getperiod(yearmonth);

        year = period_data.get("year").toString();
        semi_annual = period_data.get("semi_annual").toString();
        quarter = period_data.get("quarter").toString();
        month = period_data.get("month").toString();

       //add this information to the database for dashboarding

          int sections_c=0;
       for(String section:elems){
        total=conn.rs.getInt(section);
                
     
     String id_lv3,lb_lv3,id_lv4,lb_lv4,order_id;
            id_lv3 = elem_ids[sections_c].split(":")[0];
            lb_lv3 = elem_ids[sections_c].split(":")[1];
            id_lv4 = elem_ids[sections_c].split(":")[2];
            lb_lv4 = elem_ids[sections_c].split(":")[3];
            order_id = elem_ids[sections_c].split(":")[4];
            
//            if(lb_lv4.equals(" ")){lb_lv4=null;}
          id_=mfl_code+"_"+yearmonth+"_"+id_lv3+"_"+id_lv4; //numerator 

   String[] hearder ={"id","county","burdencategory","constituency","subcounty","ward","facility","mflcode","supporttype",
    "level1","level2","level3","level4","total","year","semiannual","quarter","month","yearmonth","ownedby","facilitytype","art_hv","htc_hv","pmtct_hv",
    "activity_hv","latitude","longitude","maleclinic","adoleclinic","viremiaclinic","emrsite","linkdesk","islocked","ordernumber"};
   
   String[] data =(""+id_+","+county+","+burdencategory+","+constituency+","+sub_county+","+ward+","+facilityName+","+mfl_code+","+support_type+","+
    "90=Knowing HIV Status,PMTCT FO,"+lb_lv3+","+lb_lv4+","+total+","+year+","+
    ""+semi_annual+","+quarter+","+month+","+yearmonth+","+Owner+","+Type+","+arthv+","+htchv+","+pmtcthv+","+
    ""+allhv+","+latitude+","+longitude+","+Male_clinics+","+Adolescent_clinics+","+Viremia_clinics+","+EMR_Sites+","+Link_desks+",0,"+order_id).split(",");
    
   
   String query_params = "";
    for(int i=0;i<hearder.length;i++){
    query_params+=hearder[i]+"=?,";    
    }
    //remove last comma
    query_params = removeLastChars(query_params, 1);
    
   String query = "REPLACE INTO table1 SET "+query_params;
   conndash.pst = conndash.conn.prepareStatement(query);
    for(int i=0;i<data.length;i++){
        conndash.pst.setString((i+1), data[i]);   
    }
    conndash.pst.executeUpdate();
    
    sections_c++;
        }
     
//      end    
        }
    
    return num;
    }
    
   
       public JSONObject getperiod(String yearmonth){
        JSONObject obj = new JSONObject();
        String[] arraydata = yearmonth.split("");
        String year = arraydata[0]+""+arraydata[1]+""+arraydata[2]+""+arraydata[3];
        String month = arraydata[4]+""+arraydata[5];
        String semi_annual = "",quarter="";
        if(Integer.parseInt(month)>=4 && Integer.parseInt(month)<=9){
          semi_annual = "2. Apr - Sep" ; 
          if(Integer.parseInt(month)>=4 && Integer.parseInt(month)<=6){
              quarter = "3. Apr - Jun";
          }
          else{
              quarter = "4. Jul - Sep";
          }
        }
        else{
          semi_annual = "1. Oct - Mar" ; 
          if(Integer.parseInt(month)>=10 && Integer.parseInt(month)<=12){
              quarter = "1. Oct - Dec";
          }
          else{
              quarter = "2. Jan - Mar";
          }
        }
        
        if(month.equals("01")){month=month+". Jan";}
        else if(month.equals("02")){month=month+". Feb";}
        else if(month.equals("03")){month=month+". Mar";}
        else if(month.equals("04")){month=month+". Apr";}
        else if(month.equals("05")){month=month+". May";}
        else if(month.equals("06")){month=month+". Jun";}
        else if(month.equals("07")){month=month+". Jul";}
        else if(month.equals("08")){month=month+". Aug";}
        else if(month.equals("09")){month=month+". Sep";}
        else if(month.equals("10")){month=month+". Oct";}
        else if(month.equals("11")){month=month+". Nov";}
        else if(month.equals("12")){month=month+". Dec";}
        else{}
        
        obj.put("year", year);
        obj.put("semi_annual", semi_annual);
        obj.put("quarter", quarter);
        obj.put("month", month);
        
        return obj;
    }
    
   private static String removeLastChars(String str, int num) {
    return str.substring(0, str.length() - num);
}
}
