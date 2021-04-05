// https://leetcode-cn.com/leetbook/read/design-patterns/99gpi3/
package CreationalPatterns;

abstract class Mask {
}

class SurgicalMask extends Mask {
    public String toString() {
        return "这是医用口罩";
    }
}

class N95Mask extends Mask {
    public String toString() {
        return "这是 N95 口罩";
    }
}

class MaskFactory {
    public Mask create(String type) {
        switch (type) {
            case "Surgical":
                return new SurgicalMask();
            case "N95":
                return new N95Mask();
            default:
                throw new IllegalArgumentException("Unsupported mask type");
        }
    }
}

class SurgicalMaskFactory {
    public Mask create() {
        return new SurgicalMask();
    }
}

class N95MaskFactory {
    public Mask create() {
        return new N95Mask();
    }
}

public class Factory {
    public static void testSimpleFactory() {
        MaskFactory factory = new MaskFactory();
        System.out.println(factory.create("Surgical"));
        System.out.println(factory.create("N95"));
    }

    public static void testFactoryMethod() {
        SurgicalMaskFactory surgicalMaskFactory = new SurgicalMaskFactory();
        System.out.println(surgicalMaskFactory.create());
        N95MaskFactory N95MaskFactory = new N95MaskFactory();
        System.out.println(N95MaskFactory.create());
    }

    public static void main(String[] args) {
        testSimpleFactory();
        testFactoryMethod();
    }
}
