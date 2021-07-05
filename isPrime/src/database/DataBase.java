/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author zialen
 */
public class DataBase {
    String dataBaseName = "dbase.db";
    String url = "jdbc:sqlite:" + dataBaseName;
    
    public DataBase(){
        if( !(new File( dataBaseName ).isFile() ) ){
            String sql = "CREATE TABLE IF NOT EXISTS euler (\n"
                + " id integer PRIMARY KEY,\n"
                + " baza integer NOT NULL,\n"
                + " broj integer NOT NULL\n"
                + ");";
            try( Connection conn = DriverManager.getConnection( url );
            Statement stmt = conn.createStatement() ) {
                if( conn != null ){
                    DatabaseMetaData meta = conn.getMetaData();
                    System.out.println( "Ime biblioteke za rad s bazom podataka " + meta.getDriverName() );
                    System.out.println( "Stvorena je nova baza" );
                    stmt.execute( sql );
                }
            } catch( SQLException e ){
                System.out.println( e.getMessage() );
            }
        }
    }
    
    public void insert( int baza, int broj ){
        String  sql = "INSERT  INTO  euler(baza, broj) VALUES (?,?)";
        try( Connection conn = DriverManager.getConnection( url ) ) {
            PreparedStatement pstmt = conn.prepareStatement( sql );
            pstmt.setInt( 1, baza );
            pstmt.setInt( 2, broj );
            pstmt.executeUpdate();
        } catch( SQLException e ){
            System.out.println( e.getMessage() );
        }
    }
    
    public boolean check( int baza, int broj ){
        String sql = "SELECT baza FROM osobe WHERE broj  ?";
        try( Connection conn = DriverManager.getConnection( url ) ) {
            PreparedStatement pstmt = conn.prepareStatement( sql );
            pstmt.setInt( 1, broj );
            ResultSet rs = pstmt.executeQuery();
            while( rs.next() ){
                int b = rs.getInt( "baza" );
                if( b == baza ) return true;
            }
            return false;
        } catch( SQLException e ){
            System.out.println( e.getMessage() );
            return false;
        }
    }
}
