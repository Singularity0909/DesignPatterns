// https://leetcode-cn.com/leetbook/read/design-patterns/99bupi/
package StructuralPatterns;

import java.util.ArrayList;
import java.util.List;

abstract class Component {
    private final String position;
    private final String job;

    public Component(String position, String job) {
        this.position = position;
        this.job = job;
    }

    public void work() {
        System.out.println("我是" + position + "，我正在" + job);
    }

    abstract void check();
}

class Manager extends Component {
    private final List<Component> components = new ArrayList<>();

    public Manager(String position, String job) {
        super(position, job);
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    void removeComponent(Component component) {
        components.remove(component);
    }

    public void check() {
        work();
        for (Component component : components) {
            component.check();
        }
    }
}

class Employee extends Component {
    public Employee(String position, String job) {
        super(position, job);
    }

    void check() {
        work();
    }
}

public class Composite {
    public static void test() {
        Manager boss = new Manager("老板", "唱怒放的生命");
        Employee HR = new Employee("人力资源", "聊微信");
        Manager PM = new Manager("产品经理", "不知道干啥");
        Manager CFO = new Manager("财务主管", "看剧");
        Manager CTO = new Manager("技术主管", "划水");
        Employee UI = new Employee("设计师", "画画");
        Employee operator = new Employee("运营人员", "兼职客服");
        Employee webProgrammer = new Employee("程序员", "学习设计模式");
        Employee backgroundProgrammer = new Employee("后台程序员", "CRUD");
        Employee accountant = new Employee("会计", "背九九乘法表");
        Employee clerk = new Employee("文员", "给老板递麦克风");
        boss.addComponent(HR);
        boss.addComponent(PM);
        boss.addComponent(CFO);
        PM.addComponent(UI);
        PM.addComponent(CTO);
        PM.addComponent(operator);
        CTO.addComponent(webProgrammer);
        CTO.addComponent(backgroundProgrammer);
        CFO.addComponent(accountant);
        CFO.addComponent(clerk);

        boss.check();
    }

    public static void main(String[] args) {
        test();
    }
}
