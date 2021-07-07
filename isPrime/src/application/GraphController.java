/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author zialen
 */
public class GraphController {
    @FXML
    private static ImageView graphImageView;
    
    private int processorNum;
    
    public GraphController( int n ) {
        this.processorNum = n ;
    }

    public GraphController() {
        this( 1 );
    }
    
    @FXML
    public static void drawGraph(){
        /*try{
            InputStream stream = new FileInputStream("time.jpg");
            graphImageView.setImage( new Image (stream) );
        } catch( IOException e ){
            e.printStackTrace();
        }*/
        graphImageView.setImage( new Image ("file:time.jpg") );
    }
    
    @FXML
    void initialize(){
        graphImageView.setImage( new Image( "file:time.jpg" ) );
        GraphService.makeGraph( processorNum );
    }
}
