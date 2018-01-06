package lambda;

/**
 * @author：ldy on 06/01/2018 23:20
 */
public class Main {

    public static void main(String[] args) {
        //lambda表达式实现函数式接口
        Person person = new Person(s -> System.out.println(s));
        person.act("hello world");

        //引用方法实现函数式接口
        SayAction sayAction = new SayAction();
        Person person2 = new Person(sayAction::act);
        person2.act("say - hello world");
    }
}
