/*
 * ApplicationControlleur.java                                          20 août 2023
 * François de Saint Palais
 */

package application.controlleur;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/** 
 * Gère les action de l'utilisateur avec la vue.
 * @author François de Saint Palais
 */
public class ApplicationControlleur {
	
	@FXML private Text firstTicketLabel;
	@FXML private Text secondTicketLabel;
	
	@FXML private Label firstTIcketNumber;
	@FXML private Label secondTIcketNumber;
	@FXML private Label resteValue;
	
	@FXML private TextField montantAPayer;

	@FXML
	void calculer() {
		System.out.println(montantAPayer.getText());
	}
}
