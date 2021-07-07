/**
 * Sample Skeleton for 'Sample.fxml' Controller Class
 */

package application;

import Algorithms.EulerPseudo;
import java.util.concurrent.ExecutionException;

import Algorithms.MillerRabin;
import Algorithms.SolovayStrassen;
import Algorithms.Sqrt;
import Algorithms.StrongPseudo;
import Algorithms.Wilson;
import database.DataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller for app.
 * @author franv
 *
 */
public class SampleController {

    @FXML // fx:id="calculateButton"
    private Button calculateButton; // Value injected by FXMLLoader

    @FXML // fx:id="resetButton"
    private Button resetButton; // Value injected by FXMLLoader

    @FXML // fx:id="numberTextField"
    private TextField numberTextField; // Value injected by FXMLLoader

    @FXML // fx:id="squareRootCheckBox"
    private CheckBox squareRootCheckBox; // Value injected by FXMLLoader

    @FXML // fx:id="wilsonCheckBox"
    private CheckBox wilsonCheckBox; // Value injected by FXMLLoader

    @FXML // fx:id="millerRabinCheckBox"
    private CheckBox millerRabinCheckBox; // Value injected by FXMLLoader

    @FXML // fx:id="solovayCheckBox"
    private CheckBox solovayCheckBox; // Value injected by FXMLLoader

    @FXML // fx:id="consoleTextArea"
    private TextArea consoleTextArea; // Value injected by FXMLLoadera
    
    @FXML
    private TextField accurMillerTextField;

    @FXML
    private TextField accurSolovayTextField;
    
    @FXML
    private CheckBox pseudoCheckBox;
    
    @FXML
    private TextField basePseudoTextField;
    
    @FXML
    private Button pseudoButton;
    
    @FXML
    private Button strongButton;
    
	/////////////////////////////
    //		FUNCTIONS
    ////////////////////////////
    
    /**
     * Controller for button click calculate.
     * @param event click
     */
    @FXML
    void calculateBottunOnClick(ActionEvent event) 
    {
    	int number, base;
        long startTime, endTime;
        double millerCertenty, solovayCertenty;
        
    	try {
            number = Service.getInt(numberTextField.getText());
            consoleTextArea.appendText("Entered number: " + number + "\n");
    	} catch (NumberFormatException  e) {
            consoleTextArea.appendText("Invalid number input!\n");
            return;
        }
        
    	if(squareRootCheckBox.isSelected())
    	{
            try {
                startTime = System.currentTimeMillis();
                boolean test = Sqrt.isPrime( number );
                endTime = System.currentTimeMillis();
                consoleTextArea.appendText(Service.answer(test, "sqrt", endTime - startTime));
            }catch (InterruptedException | ExecutionException e) {
                consoleTextArea.appendText("Square root algotihm time-out!");
            }
        }
//		NOT IMPLEMENTED YET		--		TO DO...    	
//    	if(wilsonCheckBox.isSelected())
//    	{
//    		try {
//				boolean test = Sqrt.isPrime( number );
//				consoleTextArea.appendText(Service.answer(test, "wilson"));
//    		}catch (InterruptedException | ExecutionException e) {
//				consoleTextArea.appendText("Wilson algotihm time-out!");
//			}
//		}
    	if(millerRabinCheckBox.isSelected())
    	{
            try {
                millerCertenty = Service.getCertenty(accurMillerTextField.getText());
            } catch (NumberFormatException  e) {
                consoleTextArea.appendText("Invalid Miller-Rabin certenty!\n");
                return;
            }
            startTime = System.currentTimeMillis();
            boolean test = MillerRabin.isPrime( number, millerCertenty );
            endTime = System.currentTimeMillis();
            consoleTextArea.appendText(Service.answer(test, "miller", endTime - startTime));
        }
    	if(solovayCheckBox.isSelected())
    	{
            try {
                solovayCertenty = Service.getCertenty(accurSolovayTextField.getText());
            } catch (NumberFormatException  e) {
                consoleTextArea.appendText("Invalid Solovay certenty!\n");
                return;
            }
            startTime = System.currentTimeMillis();
            boolean test = SolovayStrassen.isPrime( number, solovayCertenty );
            endTime = System.currentTimeMillis();
            consoleTextArea.appendText(Service.answer(test, "solovay", endTime - startTime));
        }
    	if( pseudoCheckBox.isSelected() ){
            try {
                base = Integer.parseInt(basePseudoTextField.getText() );
            } catch (NumberFormatException  e) {
                consoleTextArea.appendText("Invalid base input!\n");
                return;
            }
            DataBase db = new DataBase( "dbase.db" );
            startTime = System.currentTimeMillis();
            boolean test = db.checkEuler(base, number);
            if( !test )
                test = EulerPseudo.isPseudo( number, base );
            endTime = System.currentTimeMillis();
            consoleTextArea.appendText( Service.answerPseudo( test, "pseudo", endTime - startTime));
            startTime = System.currentTimeMillis();
            test = db.checkStrong(base, number);
            if( !test )
                test = StrongPseudo.isPseudo( number, base );
            endTime = System.currentTimeMillis();
            consoleTextArea.appendText( Service.answerPseudo( test, "strong", endTime - startTime));
        }
        consoleTextArea.appendText( "------------------------------------------------------------\n" );

    }
    
    @FXML
    void pseudoButtonOnClick(ActionEvent event) 
    {
        Stage secondaryStage = new Stage();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Table.fxml"));
            TableController controller = new TableController( "euler" );
            loader.setController(controller);
            Parent root = loader.load();
            secondaryStage.setTitle("Euler pseudoprimes");
            secondaryStage.setScene(new Scene(root, 600,400));
            secondaryStage.setResizable( false );
            secondaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void strongButtonOnClick( ActionEvent event )
    {
        Stage secondaryStage = new Stage();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Table.fxml"));
            TableController controller = new TableController( "strong" );
            loader.setController(controller);
            Parent root = loader.load();
            secondaryStage.setTitle("Strong pseudoprimes");
            secondaryStage.setScene(new Scene(root, 600,400));
            secondaryStage.setResizable( false );
            secondaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * On click reset button function
     * @param event none
     */
    @FXML
    void resetBottunOnClick(ActionEvent event)
    {
    	consoleTextArea.setText(" ");
    	numberTextField.setText(" ");
    }

}
