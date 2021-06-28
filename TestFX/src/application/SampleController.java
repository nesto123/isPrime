/**
 * Sample Skeleton for 'Sample.fxml' Controller Class
 */

package application;

import java.util.concurrent.ExecutionException;

import Algorithms.Sqrt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    
    @FXML
    void calculateBottunOnClick(ActionEvent event) 
    {
    	int number;
    	try {
    		number = Service.getInt(numberTextField.getText());
    		consoleTextArea.appendText("Entered number: " + number + "\n");
    	} catch (NumberFormatException  e) {
			consoleTextArea.appendText("Invalid number input!");
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

    }
    
    @FXML
    void resetBottunOnClick(ActionEvent event)
    {
    	consoleTextArea.setText(" ");
    	numberTextField.setText(" ");
    }

}
