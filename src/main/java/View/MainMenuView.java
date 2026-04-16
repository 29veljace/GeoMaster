package View;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class MainMenuView {
    public final Button spiel1;
    public final Button spiel2;
    public final Button spiel3;
    public final Button spiel4;
    public final Text willkommen;
    public final Text info;

    public MainMenuView(){
        spiel1 = new Button("Flaggen erraten");
        spiel2 = new Button("Länderumrisse erkennen");
        spiel3 = new Button("Erkenne das Land anhand der Fakten");
        spiel4 = new Button("Higher Or Lower");
        willkommen = new Text("Geomaster");
        info = new Text("Wählen Sie einen der Spielmodi aus");

    }
}
