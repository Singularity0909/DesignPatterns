// https://leetcode-cn.com/leetbook/read/design-patterns/99zelm/
package CreationalPatterns;

interface Fruit {
    void eat();
}

interface IFactory {
    Fruit create();
}

class Apple implements Fruit {
    public void eat() {
        System.out.println("吃苹果");
    }
}

class Pear implements Fruit {
    public void eat() {
        System.out.println("吃梨");
    }
}

class PearFactory implements IFactory {
    public Fruit create() {
        return new Pear();
    }
}

class AppleFactory implements IFactory {
    public Fruit create() {
        return new Apple();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        IFactory appleFactory = new AppleFactory();
        Fruit apple = appleFactory.create();
        IFactory pearFactory = new PearFactory();
        Fruit pear = pearFactory.create();
        apple.eat();
        pear.eat();
    }
}
