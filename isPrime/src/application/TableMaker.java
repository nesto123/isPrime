/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import database.DataBase;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.*;

/**
 *
 * @author zialen
 */
public class TableMaker implements Runnable{
    private String pseudo;
    
    public TableMaker( String type ){
        this.pseudo = type;
    }
    
    public TableMaker(){
        this( "euler" );
    }
    
    @Override
    public void run(){
        String title = "";
        if( pseudo == "euler" ) title = "Euler pseudoprimes";
        else title = "Strong pseudoprimes";
        JFrame frame = new JFrame( title );
        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        String s = "";
        java.util.List<Integer> list = new ArrayList<Integer>();
        DataBase db = new DataBase( "dbase.db" );
        list = db.getAllBases( pseudo );
        Set<Integer> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        Collections.sort( list );
        Iterator<Integer> listIterator = list.iterator();
        s += "Base         Numbers\n"
                + "--------------------------------------------------------------------------------------------------"
                    + "---------------------\n";
        while (listIterator.hasNext()) {
            int base = listIterator.next();
            s += base + ": ";
            java.util.List<Integer> numbers = new ArrayList<Integer>();
            numbers = db.getNumbers( pseudo, base );
            Set<Integer> num = new HashSet<>(numbers);
            numbers.clear();
            numbers.addAll(num);
            Collections.sort( numbers );
            //String temp = "";
            Iterator<Integer> numbersIterator = numbers.iterator();
            while (numbersIterator.hasNext())
                s += (numbersIterator.next() + ", " );
            s = s.substring(0, s.length() - 2);
            s += "\n"
                + "--------------------------------------------------------------------------------------------------"
                    + "---------------------\n";
        }
        JTextArea tableTextArea = new JTextArea( s );
        JScrollPane scroll = new JScrollPane(tableTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tableTextArea.setRows(30);
        tableTextArea.setEditable( false );
        //frame.getContentPane().add( tableTextArea, BorderLayout.CENTER );
        frame.getContentPane().add( scroll, BorderLayout.CENTER );
        frame.setLocationRelativeTo( null );
        frame.pack();
        frame.setVisible( true );
        SampleController.decreaseProcessorNum();
    }
}
