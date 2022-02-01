package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application{
    
    public static int WIDTH = 500;
    public static int HEIGHT = 400;

    public static void main(String[] args) {
        launch(args);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        Text text = new Text(10, 20, "Points: 0");
        pane.getChildren().add(text);
        AtomicInteger points = new AtomicInteger();
        
        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);
        List<Asteroid> asteroids = new ArrayList<>();
        List<Projectile> projectiles = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Random rnd = new Random();
            Asteroid asteroid = new Asteroid(rnd.nextInt(100), rnd.nextInt(100));
            asteroids.add(asteroid);
        }

        pane.getChildren().add(ship.getCharacter());
        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));
                     
        Scene scene = new Scene(pane);
        
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
        
        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
            
            if(event.getCode() == KeyCode.SPACE){
                Projectile projectile = new Projectile((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY());
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectiles.add(projectile);
                    
                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));

                    pane.getChildren().add(projectile.getCharacter());
            }
        });
        
        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });
        
        
        
        
        
        new AnimationTimer(){
            @Override
            public void handle(long l) {
                text.setText("Points: " + points.addAndGet(1));
                List<Projectile> projectilesToRemove = projectiles.stream().filter(projectile -> {
    List<Asteroid> collisions = asteroids.stream()
                                                .filter(asteroid -> asteroid.collide(projectile))
                                                .collect(Collectors.toList());

    if(collisions.isEmpty()) {
        return false;
    }

    collisions.stream().forEach(collided -> {
        asteroids.remove(collided);
        pane.getChildren().remove(collided.getCharacter());
        text.setText("Points: " + points.addAndGet(100));
    });

    return true;
}).collect(Collectors.toList());

projectilesToRemove.forEach(projectile -> {
    pane.getChildren().remove(projectile.getCharacter());
    projectiles.remove(projectile);
});
                if(pressedKeys.getOrDefault(KeyCode.LEFT, false)){
                    ship.turnLeft();
                }
                
                if(pressedKeys.getOrDefault(KeyCode.RIGHT, false)){
                    ship.turnRight();
                }                
                
                if(pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }
                
                
                
                if(Math.random() < 0.05) {
                Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                if(!asteroid.collide(ship)) {
                    asteroids.add(asteroid);
                    pane.getChildren().add(asteroid.getCharacter());
                }
}
                
                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());
                
                asteroids.forEach(asteroid -> {
                    if(ship.collide(asteroid)){
                        stop();
                    }
                });
            }
            
        }.start();
        
        stage.setTitle("Asteroids!");
        
        stage.setScene(scene);
        stage.show();
    }
    
    

}
