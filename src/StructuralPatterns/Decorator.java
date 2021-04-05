// https://leetcode-cn.com/leetbook/read/design-patterns/99j7re/
package StructuralPatterns;

interface IBeauty {
    int getBeautyValue();
}

interface IHouse {
    void live();
}

interface IStickyHookHouse extends IHouse {
    void hangThings();
}

interface IMirrorHouse extends IHouse {
    void lookMirror();
}

class Me implements IBeauty {
    public int getBeautyValue() {
        return 100;
    }
}

class RingDecorator implements IBeauty {
    private final IBeauty me;

    public RingDecorator(IBeauty me) {
        this.me = me;
    }

    public int getBeautyValue() {
        return me.getBeautyValue() + 20;
    }
}

class EarringDecorator implements IBeauty {
    private final IBeauty me;

    public EarringDecorator(IBeauty me) {
        this.me = me;
    }

    public int getBeautyValue() {
        return me.getBeautyValue() + 50;
    }
}

class NecklaceDecorator implements IBeauty {
    private final IBeauty me;

    public NecklaceDecorator(IBeauty me) {
        this.me = me;
    }

    public int getBeautyValue() {
        return me.getBeautyValue() + 80;
    }
}

class House implements IHouse {
    public void live() {
        System.out.println("房屋原有的功能：居住功能");
    }
}

class StickyHookDecorator implements IStickyHookHouse {
    private final IHouse house;

    public StickyHookDecorator(IHouse house) {
        this.house = house;
    }

    public void live() {
        house.live();
    }

    public void hangThings() {
        System.out.println("有了粘钩后，新增了挂东西功能");
    }
}

class MirrorDecorator implements IMirrorHouse {
    private final IHouse house;

    public MirrorDecorator(IHouse house) {
        this.house = house;
    }

    public void live() {
        house.live();
    }

    public void lookMirror() {
        System.out.println("有了镜子后，新增了照镜子功能");
    }
}

public class Decorator {
    public static void showBeauty() {
        IBeauty me = new Me();
        System.out.println("我原本的颜值：" + me.getBeautyValue());

        // 随意挑选装饰
        IBeauty meWithRing = new RingDecorator(me);
        System.out.println("戴上戒指后，我的颜值：" + meWithRing.getBeautyValue());

        // 多次装饰
        IBeauty meWithManyDecorators = new NecklaceDecorator(new RingDecorator(new EarringDecorator(me)));
        System.out.println("戴上耳环、戒指、项链后，我的颜值：" + meWithManyDecorators.getBeautyValue());

        // 任意搭配装饰
        IBeauty meWithNecklaceAndRing = new NecklaceDecorator(new RingDecorator(me));
        System.out.println("戴上戒指、项链后，我的颜值：" + meWithNecklaceAndRing.getBeautyValue());
    }

    public static void showHouse() {
        IHouse house = new House();
        house.live();

        IStickyHookHouse stickyHookHouse = new StickyHookDecorator(house);
        stickyHookHouse.live();
        stickyHookHouse.hangThings();

        IMirrorHouse mirrorHouse = new MirrorDecorator(house);
        mirrorHouse.live();
        mirrorHouse.lookMirror();
    }

    public static void main(String[] args) {
        showBeauty();
        showHouse();
    }
}
