// https://leetcode-cn.com/leetbook/read/design-patterns/99sx01/
package CreationalPatterns;

class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }

    public void doSomething() {
        System.out.println("This is a hungry singleton");
    }
}

class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton() {

    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("This is a lazy singleton");
    }
}

public class Singleton {
    public static void main(String[] args) {
        HungrySingleton.getInstance().doSomething();
        LazySingleton.getInstance().doSomething();
    }
}
