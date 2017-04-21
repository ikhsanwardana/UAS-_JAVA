    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas;

/**
 *
 * @author USER
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Uas {

    
    public static void main(String[] args) {
      try{
          Class.forName("com.mysql.jdbc.Driver");
      }catch(Exception ex){
      System.err.println("Error :"+ex);
      System.exit(1);
      }
      Connection koneksi=null;
      try{
          koneksi=DriverManager.getConnection("jdbc:mysql://localhost:3306/siak", "root", "");
          System.out.println("koneksi berhasil");
      }catch (Exception ex){
      System.out.println("error :"+ex);
      System.exit(1);
      }
      ResultSet hasilQuery=null;
      try{
          Statement stm=koneksi.createStatement();
          hasilQuery=stm.executeQuery("Select * from mahasiswa");
      }catch(Exception ex){
      System.err.println("Error 3:"+ex);
      System.exit(1);
      }
      System.out.println("NIM"+"     "+"Nama"+"       "+"TTL");
      try {
          while (hasilQuery.next()){
              
          int nim=hasilQuery.getInt("nim");
          String nama=hasilQuery.getString("nama");
          Date tgl_lahir=hasilQuery.getDate("tgl_lahir");
          
          System.out.println(nim+"   "+nama+"   "+tgl_lahir);
        }
      }catch(Exception ex){
          System.out.println("error 4:"+ex);
          System.exit(1);
      }
      try{
          Statement stm=koneksi.createStatement();
          hasilQuery=stm.executeQuery("Select * from matakuliah");
      }catch(Exception ex){
      System.err.println("Error 3:"+ex);
      System.exit(1);
      }
          System.out.println();
          System.out.println("kd_mk"+"    "+"Nama_Matkul"+"   "+"sks");
      try {
          while (hasilQuery.next()){
          int kd_mk=hasilQuery.getInt("kd_mk");
          String nama_matkul=hasilQuery.getString("nama_matkul");
          int sks=hasilQuery.getInt("sks");
          
          System.out.println(kd_mk+"         "+nama_matkul+"         "+sks);
        }
      }catch(Exception ex){
          System.out.println("error 5:"+ex);
          System.exit(1);
      }
      try{
          Statement stm=koneksi.createStatement();
          hasilQuery=stm.executeQuery("Select nim,kd_mk,nilai,case when nilai >=80 then 'A' when nilai >=70 then 'B' when nilai >=60 then 'C' when nilai >=50 then 'D' when nilai <50 then 'E' when nilai is null then '(null)' end as huruf from nilai");
      }catch(Exception ex){
      System.err.println("Error :"+ex);
      System.exit(1);
      }
          System.out.println();
          System.out.println("nim"+"        "+"kd_mk"+"      "+"nilai"+"  "+"huruf");
      try {
          while (hasilQuery.next()){
          int nim=hasilQuery.getInt("nim");
          int kd_mk=hasilQuery.getInt("kd_mk");
          int nilai=hasilQuery.getInt("nilai");
          String huruf=hasilQuery.getString("huruf");
          
          System.out.println(nim+"         "+kd_mk+"         "+nilai+"      "+huruf);
        }
      }catch(Exception ex){
          System.out.println("error 6:"+ex);
          System.exit(1);
      }
    }
    
}
