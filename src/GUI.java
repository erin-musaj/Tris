import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {
    private Stage primaryStage;
    private Button[][] buttons = new Button[3][3];
    private Tris tris = new Tris(1);

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        initializeGrid();
        primaryStage.setTitle("Tris");
        primaryStage.show();
    }

    public void initializeGrid(){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                Button b = new Button();
                b.setPrefSize(100,100);
                grid.add(b, j, i);
                this.buttons[i][j] = b;
                int finalI = i;
                int finalJ = j;
                b.setOnAction((event -> click(finalI, finalJ)));
            }
        }
        Scene s = new Scene(grid, 320, 320);
        primaryStage.setScene(s);
    }

    public void click(int x, int y){
        if(tris.place(x,y)) {
            buttons[x][y].setText(String.valueOf(tris.getLastPlayer()));
        }
        if(tris.gameStatus() == "x"){
            //TODO alert box
        } else if (tris.gameStatus() == "0" && tris.IsGameOver()) {
            //TODO alert box
        }
    }
}
