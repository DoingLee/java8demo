package lambda;

/**
 * 函数式接口：只有一个抽象方法的接口
 *
 * @author：ldy on 06/01/2018 23:16
 */
@FunctionalInterface
public interface Action {

    /**
     * 抽象方法
     * @param s
     */

    void act(String s);

    /**
     * 默认方法
     * @param s
     */
    default void defaultAct(String s) {
        System.out.println("default act : " + s);
    }
}
