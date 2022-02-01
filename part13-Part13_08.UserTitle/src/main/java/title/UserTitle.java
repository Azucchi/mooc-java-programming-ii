package title;

import javafx.application.Application;
import javafx.stage.Stage;


public class UserTitle extends Application{
    

    public void start(Stage stage) throws Exception {
        Parameters p = getParameters();
        String title = p.getNamed().get("title");
        stage.setTitle(title);
        stage.show();
    }


}
