/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import javafx.scene.shape.Polygon;

/**
 *
 * @author reroy
 */
public class Projectile extends Character{
    
    public Projectile(int x, int y) {
        super(new Polygon(2, -2, 2, 2, -2, 2, -2, -2), x, y);
    }
    
    @Override
    public void move() {
        this.character.setTranslateX(this.character.getTranslateX() + this.movement.getX());
        this.character.setTranslateY(this.character.getTranslateY() + this.movement.getY());
        
        if (this.character.getTranslateX() < 0) {
        //this.character.setTranslateX(this.character.getTranslateX() + AsteroidsApplication.WIDTH);
    }

    if (this.character.getTranslateX() > AsteroidsApplication.WIDTH) {
        //this.character.setTranslateX(this.character.getTranslateX() % AsteroidsApplication.WIDTH);
    }

    if (this.character.getTranslateY() < 0) {
       // this.character.setTranslateY(this.character.getTranslateY() + AsteroidsApplication.HEIGHT);
    }

    if (this.character.getTranslateY() > AsteroidsApplication.HEIGHT) {
       // this.character.setTranslateY(this.character.getTranslateY() % AsteroidsApplication.HEIGHT);
    }
    }
    
}
