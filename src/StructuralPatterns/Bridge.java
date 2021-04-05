// https://leetcode-cn.com/leetbook/read/design-patterns/99c3mc/
package StructuralPatterns;

interface IShape {
    void draw();
}

interface IColor {
    String getColor();
}

class Red implements IColor {
    public String getColor() {
        return "红";
    }
}

class Blue implements IColor {
    public String getColor() {
        return "蓝";
    }
}

class Yellow implements IColor {
    public String getColor() {
        return "黄";
    }
}

class Green implements IColor {
    public String getColor() {
        return "绿";
    }
}

class Rectangle implements IShape {
    private IColor color;

    void setColor(IColor color) {
        this.color = color;
    }

    public void draw() {
        System.out.println("绘制" + color.getColor() + "矩形");
    }
}

class Round implements IShape {
    private IColor color;

    void setColor(IColor color) {
        this.color = color;
    }

    public void draw() {
        System.out.println("绘制" + color.getColor() + "圆形");
    }
}

class Triangle implements IShape {
    private IColor color;

    void setColor(IColor color) {
        this.color = color;
    }

    public void draw() {
        System.out.println("绘制" + color.getColor() + "三角形");
    }
}

public class Bridge {
    public static void drawTest() {
        Rectangle rectangle = new Rectangle();
        rectangle.setColor(new Red());
        rectangle.draw();

        Round round = new Round();
        round.setColor(new Blue());
        round.draw();

        Triangle triangle = new Triangle();
        triangle.setColor(new Yellow());
        triangle.draw();
    }

    public static void main(String[] args) {
        drawTest();
    }
}
