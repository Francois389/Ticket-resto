/*
 * ApplicationControlleur.java                                          20 août 2023
 * François de Saint Palais
 */

package application.controlleur;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import mathematique.Decomposition;

/**
 * Gère les action de l'utilisateur avec la vue.
 * @author François de Saint Palais
 */
public class ApplicationControlleur {

	/**
     * Affiche une alerte indiquant à l'utilisateur que ce qu'il à
     * saisie n'est pas un entier
     */
    private static void pasUnEntier(String saisiUser) {
        System.err.println(saisiUser + " n'est un entier.");
        Alert saisieMontantInvalide = new Alert(AlertType.ERROR,
                "Veillez saisir un entier positif non nul",ButtonType.OK);
        saisieMontantInvalide.showAndWait();
    }
	@FXML private Text firstTicketLabel;

	@FXML private Text secondTicketLabel;
	@FXML private Label firstTicketNumber;
	@FXML private Label secondTicketNumber;

	@FXML private Label resteValue;
	@FXML private TextField montantAPayer;
	@FXML private TextField saisiePremierTicket;

	@FXML private TextField saisieDeuxiemeTicket;
	int firstTicket = 8;
	int secondTicket = 13;

	int montant;

	/**
	 * Calcul la décomposition puis affiche le résultat
	 */
	@FXML
	void calculer() {
		System.out.println(montantAPayer.getText());
		try {
            montant = Integer.parseInt(montantAPayer.getText());
            System.out.println("Saisie valide");

            Decomposition decomposition
            = new Decomposition(firstTicket,secondTicket,Integer.valueOf(montantAPayer.getText()));

            firstTicketNumber.setText(decomposition.decomposeNbPremierValeur() + "");
            secondTicketNumber.setText(decomposition.decomposeNbDeuxiemeValeur() + "");
            resteValue.setText(decomposition.decomposeReste() + " €");
        } catch (Exception e) {
            pasUnEntier(montantAPayer.getText());
            montantAPayer.setText("");
        }
	}

	/** Enregistre les nouvelle valeur des tickets saisi par l'utilisateur */
	@FXML
	void enregistrer () {
	    boolean erreurSaisie = false;
	    if (!saisiePremierTicket.getText().isEmpty() && !erreurSaisie) {
	        try {
	            firstTicket = Integer.parseInt(saisiePremierTicket.getText());
	        } catch (Exception e) {
	            pasUnEntier(saisiePremierTicket.getText());
	            erreurSaisie = true;
	            saisiePremierTicket.setText("");
	        }
        }
	    if (!saisieDeuxiemeTicket.getText().isEmpty() && !erreurSaisie) {
	        try {
	            secondTicket = Integer.parseInt(saisieDeuxiemeTicket.getText());
	        } catch (Exception e) {
	            pasUnEntier(saisieDeuxiemeTicket.getText());
	            erreurSaisie = true;
	            saisieDeuxiemeTicket.setText("");
	        }
	    }

	    if (!erreurSaisie) {
	        resetAffichage();
	        Alert validation = new Alert(AlertType.CONFIRMATION,
	                "Valeur de ticket enregistré",ButtonType.OK);
	        validation.showAndWait();
        }


	}

	@FXML
	void initialize () {
	    resetAffichage();
	}

    /**
	 * Remet à zéro tous les affichage et les champs de l'application.
	 */
	private void resetAffichage() {
	    firstTicketLabel.setText(firstTicket + "€");
	    secondTicketLabel.setText(secondTicket + "€");

	    firstTicketNumber.setText("-");
	    secondTicketNumber.setText("-");
	    resteValue.setText("-");

	    montantAPayer.setText("");
	    saisiePremierTicket.setText("");
	    saisieDeuxiemeTicket.setText("");
	}
}
