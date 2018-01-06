package lambda;

/**
 * @author：ldy on 06/01/2018 23:18
 */
public class Person {

    Action action;

    public Person(Action action) {
        this.action = action;
    }

    public void act(String s) {
        action.act(s);
    }
}
