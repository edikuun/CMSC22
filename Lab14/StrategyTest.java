/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab14;

/**
 *
 * @author chromalix
 */
public class StrategyTest {
    public static void main(String[] args) {
        //initialize
        Character king = new King();
        Character queen = new Queen();
        Character knight = new Knight();
        Character troll = new Troll();
        
        //set weapons
        king.setWeaponBehavior(new KnifeBehavior());
        queen.setWeaponBehavior(new BowAndArrowBehavior());
        knight.setWeaponBehavior(new SwordBehavior());
        troll.setWeaponBehavior(new AxeBehavior());
        
        //test
        king.fight();
        queen.fight();
        knight.fight();
        troll.fight();
    }
}
