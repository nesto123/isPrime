/**
 * Sample Skeleton for 'Sample.fxml' Controller Class
 */

package application;

import java.util.concurrent.ExecutionException;

import Algorithms.MillerRabin;
import Algorithms.SolovayStrassen;
import Algorithms.Sqrt;
import Algorithms.Wilson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    	int number;
    	try {
    		number = Service.getInt(numberTextField.getText());
    		consoleTextArea.appendText("Entered number: " + number + "\n");
    	} catch (NumberFormatException  e) {
			consoleTextArea.appendText("Invalid number input!\n");
			//e.printStackTrace();
			return;
		}
    	
    	if(squareRootCheckBox.isSelected())
    	{
    		try {
				boolean test = Sqrt.isPrime( number );
				consoleTextArea.appendText(Service.answer(test, "sqrt"));
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
				boolean test = MillerRabin.isPrime( number, 21 );
				consoleTextArea.appendText(Service.answer(test, "miller"));
		}
    	if(solovayCheckBox.isSelected())
    	{
				boolean test = SolovayStrassen.isPrime( number, 0.95 );
				consoleTextArea.appendText(Service.answer(test, "solovay"));
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
