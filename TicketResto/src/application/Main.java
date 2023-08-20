/*
 * Main.java                                          20 août 2023
 * François de Saint Palais
 */

package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


/**
 * Charge et lance l'application
 * @author François de Saint Palais
 */
public class Main extends Application {
	
    @Override
	public void start(Stage primaryStage) {
		try {
		    Parent application = getParentFromVue("vue/application.fxml");
			Scene scene = new Scene(application);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** @param args inutilisé*/
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
     * @param chemin Le chemin relatif depuis la classe MAin jusqu'a la vue
     * @return Un conteneur Parent qui contient l'application
     * @throws IOException SI le chemin ne mène à rien
     */
    private Parent getParentFromVue(String chemin) throws IOException {
        Parent conteneur;
        FXMLLoader chargeurPageDeJeux = new FXMLLoader();
        chargeurPageDeJeux.setLocation(getClass().getResource(chemin));
        conteneur = chargeurPageDeJeux.load();
        return conteneur;
    }
}
