/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class insertmatkul {
    public static void main(String args[])throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/siak", "root", "");
        
        PreparedStatement smt=con.prepareStatement("insert into matakuliah(kd_mk,nama_matkul,sks)"+"values(?,?,?)");
        Scanner sc=new Scanner(System.in);
        System.out.print("Masukan kd_mk :");
        int kdmk=sc.nextInt();
        System.out.print("Masukan nama_matkul :");
        String matkul=sc.next();
        System.out.print("Masukan sks :");
        int sks=sc.nextInt();
        smt.setInt(1, kdmk);
        smt.setString(2, matkul);
        smt.setInt(3, sks);
        
        smt.executeUpdate();
        System.out.println("Data telah ditambah");
        con.close();
    }
    
}
