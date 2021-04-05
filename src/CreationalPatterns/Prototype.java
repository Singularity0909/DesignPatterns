// https://leetcode-cn.com/leetbook/read/design-patterns/994yw5/
package CreationalPatterns;

class MilkTea2 implements Cloneable {
    public String type;
    public boolean ice;

    public MilkTea2 clone() throws CloneNotSupportedException {
        return (MilkTea2) super.clone();
    }
}

public class Prototype {
    private static void order() throws CloneNotSupportedException {
        MilkTea2 milkTeaOfJay = new MilkTea2();
        milkTeaOfJay.type = "原味";
        milkTeaOfJay.ice = false;

        MilkTea2 yourMilkTea = milkTeaOfJay.clone();
        // ...
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        order();
    }
}
