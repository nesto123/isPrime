/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import Algorithms.MillerRabin;
import Algorithms.SolovayStrassen;
import Algorithms.Sqrt;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author zialen
 */
public class GraphMaker implements Runnable{
    private int processorNum;
    
    public GraphMaker( int processorNum ){
        this.processorNum = processorNum;
    }
    
    public GraphMaker(){
        this( 1 );
    }
    
    @Override
    public void run(){
        JFrame frame = new JFrame( "Euler pseudoprimes" );
        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        //------------------------------------------------------------
        int n;
        long start, end;
        ArrayList<ArrayList<Long>> times = new ArrayList<>();
        for( int i = 0; i < 3 ; i++ )
            times.add(new ArrayList<>());
        for( int i = 1; i < 200000; i += 1000 ){
            System.out.println( i );
            n = i;
            try {
                start = System.currentTimeMillis();
                Sqrt.isPrime( n, processorNum );
                end = System.currentTimeMillis();
                times.get( 0 ).add( end - start );
            }catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            try {
                start = System.currentTimeMillis();
                MillerRabin.isPrime( n, 0.95 );
                end = System.currentTimeMillis();
                times.get( 1 ).add( end - start );
            }catch ( NumberFormatException e)  {
                e.printStackTrace();
            }
            try {
                start = System.currentTimeMillis();
                SolovayStrassen.isPrime( n, 0.95 );
                end = System.currentTimeMillis();
                times.get( 2 ).add( end - start );
            }catch ( NumberFormatException e)  {
                e.printStackTrace();
            }
        }
        
        var data = new XYSeriesCollection () ;
   
        for(int i=0;i<times.size();i++){
            XYSeries series;
            if(i==0) 
                series = new XYSeries ("Square root method");
            else if(i==1)
                series = new XYSeries ("Miller Rabin test");
            else series = new XYSeries ("Solovay Strassen test");

            int count = 0;
            for ( long j : times.get(i) ){
                series.add(count,j);
                count += 100;
            }
           data.addSeries(series);
        }

        JFreeChart chart = ChartFactory.createXYLineChart (
          " Vremena izvrsavanja ", "Broj stupaca od B", "Vrijeme izvrsavanja (milisekunde)", data , PlotOrientation.VERTICAL , true , true , false ) ;
        try{
            ChartUtilities.saveChartAsPNG(new File ("time.png") , chart , 450 , 400) ;
            frame.add(new JLabel(new ImageIcon( "time.png" ) ) );
        } catch( IOException e ){
            e.printStackTrace();
        }
        //--------------------------------------------------------------
        /*try {
            BufferedImage img = ImageIO.read(new File( "time.png" ) );
            frame.add(new JLabel(new ImageIcon( "time.png" ) ) );
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        frame.add(new JLabel(new ImageIcon( "time.png" ) ) );
        frame.setLocationRelativeTo( null );
        frame.pack();
        frame.setVisible( true );
        SampleController.decreaseProcessorNum();
    }
}
