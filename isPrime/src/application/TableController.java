/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import database.DataBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

/**
 *
 * @author zialen
 */
public class TableController {
    @FXML
    private TextArea tableTextArea;
    String pseudo;

    public TableController( String s ) {
        this.pseudo = s ;
    }

    public TableController() {
        this( "euler" );
    }

    @FXML
    void initialize(){
        List<Integer> list = new ArrayList<Integer>();
        DataBase db = new DataBase( "dbase.db" );
        list = db.getAllBases( pseudo );
        Set<Integer> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        Collections.sort( list );
        Iterator<Integer> listIterator = list.iterator();
        tableTextArea.appendText( "Base         Numbers\n"
                + "--------------------------------------------------------------------------------------------------"
                    + "---------------------\n");
        while (listIterator.hasNext()) {
            int base = listIterator.next();
            tableTextArea.appendText( base + ": " );
            List<Integer> numbers = new ArrayList<Integer>();
            numbers = db.getNumbers( pseudo, base );
            Set<Integer> num = new HashSet<>(numbers);
            numbers.clear();
            numbers.addAll(num);
            Collections.sort( numbers );
            String s = "";
            Iterator<Integer> numbersIterator = numbers.iterator();
            while (numbersIterator.hasNext())
                s += (numbersIterator.next() + ", " );
            s = s.substring(0, s.length() - 2);
            tableTextArea.appendText( s + "\n"
                + "--------------------------------------------------------------------------------------------------"
                    + "---------------------\n");
        }
    }
}
