package lambda;

/**
 * @author：ldy on 06/01/2018 23:25
 */
public class SayAction implements Action {

    @Override
    public void act(String s) {
        System.out.println("say : " + s);
    }
}
