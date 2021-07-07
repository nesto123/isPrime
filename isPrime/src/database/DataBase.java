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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zialen
 */
public class DataBase {
    String dataBaseName;
    String url;
    
    public DataBase( String name ){
        dataBaseName = name;
        url = "jdbc:sqlite:" + dataBaseName;
        if( !(new File( dataBaseName ).isFile() ) ){
            String sql = "CREATE TABLE IF NOT EXISTS euler (\n"
                + " id integer PRIMARY KEY,\n"
                + " baza integer NOT NULL,\n"
                + " broj integer NOT NULL\n"
                + ");";
            String sql2 = "CREATE TABLE IF NOT EXISTS strong (\n"
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
                    stmt.execute( sql2 );
                }
            } catch( SQLException e ){
                System.out.println( e.getMessage() );
            }
        }
    }
    
    /**
     * Inserts new row into euler table
     * @param baza
     * @param broj 
     */
    public void insertEuler( int baza, int broj ){
        String  sql = "INSERT  INTO  euler(baza, broj) VALUES (?,?)";
        String chck = "SELECT id FROM euler WHERE baza = ? AND broj = ?";
        try( Connection conn = DriverManager.getConnection( url ) ) {
            PreparedStatement ps = conn.prepareStatement( chck );
            ps.setInt ( 1, baza );
            ps.setInt ( 2, broj );
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return;
            } else {
                PreparedStatement pstmt = conn.prepareStatement( sql );
                pstmt.setInt( 1, baza );
                pstmt.setInt( 2, broj );
                pstmt.executeUpdate();
            }
        } catch( SQLException e ){
            System.out.println( e.getMessage() );
        }
    }
    
    /**
     * Checks if row already in euler table
     * @param baza
     * @param broj
     * @return true if row/baza, broj) in euler, false otherwise
     */
    public boolean checkEuler( int baza, int broj ){
        String sql = "SELECT baza FROM euler WHERE broj = ?";
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
    
    /**
     * Inserts new row into strong table
     * @param baza
     * @param broj 
     */
    public void insertStrong( int baza, int broj ){
        String  sql = "INSERT  INTO  strong(baza, broj) VALUES (?,?)";
        String chck = "SELECT id FROM strong WHERE baza = ? AND broj = ?";
        try( Connection conn = DriverManager.getConnection( url ) ) {
            PreparedStatement ps = conn.prepareStatement( chck );
            ps.setInt ( 1, baza );
            ps.setInt ( 2, broj );
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return;
            } 
            else {
                PreparedStatement pstmt = conn.prepareStatement( sql );
                pstmt.setInt( 1, baza );
                pstmt.setInt( 2, broj );
                pstmt.executeUpdate();
            }
        } catch( SQLException e ){
            System.out.println( e.getMessage() );
        }
    }
    
    /**
     * Checks if row already in strong table
     * @param baza
     * @param broj
     * @return true if row(baza, broj) in strong, false otherwise
     */
    public boolean checkStrong( int baza, int broj ){
        String sql = "SELECT baza FROM strong WHERE broj = ?";
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
    
    /**
     * Get all bases from table with name type
     * @param type
     * @return list of all bases from type
     */
    public List<Integer> getAllBases( String type ){
        List list = new ArrayList<Integer>();
        String sql = "SELECT baza FROM " + type;
        try( Connection conn = DriverManager.getConnection( url ) ) {
            PreparedStatement pstmt = conn.prepareStatement( sql );
            ResultSet rs = pstmt.executeQuery();
            while( rs.next() ){
                int b = rs.getInt( "baza" );
                list.add( b );
            }
        } catch( SQLException e ){
            System.out.println( e.getMessage() );
        }
        return list;
    }
    
    public List<Integer> getNumbers( String type, int base ){
        List list = new ArrayList<Integer>();
        String sql = "SELECT broj FROM " + type + " WHERE baza = ?";
        try( Connection conn = DriverManager.getConnection( url ) ) {
            PreparedStatement pstmt = conn.prepareStatement( sql );
            pstmt.setInt( 1, base );
            ResultSet rs = pstmt.executeQuery();
            while( rs.next() ){
                int n = rs.getInt( "broj" );
                list.add( n );
            }
        } catch( SQLException e ){
            System.out.println( e.getMessage() );
        }
        return list;
    }
}
