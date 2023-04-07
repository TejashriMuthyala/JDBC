package com.Sample;
import java.sql.*;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	Scanner sc=new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/studentms";
        String username="root";
        String password="Teja@3800";
        Connection bs=DriverManager.getConnection(url,username,password);
        System.out.println("****Student Data****");
        System.out.println("Enter student id:");
        int sid=sc.nextInt();
        System.out.println("Enter student name:");
        sc.nextLine();
        String sname=sc.nextLine();    
        System.out.println("Enter student class");
        int sclass=sc.nextInt();
        System.out.println("Enter student grade");
        sc.nextLine();
        String sgrade=sc.nextLine();
        String query="insert into student values(?,?,?,?)";
        PreparedStatement pst=bs.prepareStatement(query);
        pst.setInt(1, sid);
        pst.setString(2, sname);
        pst.setInt(3, sclass);
        pst.setString(4, sgrade);
        int count=pst.executeUpdate();
        System.out.println(count+" row(s) effected");
        bs.close();
        sc.close();
    }
}
