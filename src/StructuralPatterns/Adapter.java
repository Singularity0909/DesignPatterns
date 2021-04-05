// https://leetcode-cn.com/leetbook/read/design-patterns/99yk22/
package StructuralPatterns;

class HomeBattery {
    int supply() {
        return 220;
    }
}

class USBLine {
    void charge(int volt) {
        if (volt != 5) {
            throw new IllegalArgumentException("只能接收 5V 电压");
        }
        System.out.println("正常充电");
    }
}

public class Adapter {
    public static int convert(int homeVolt) {
        return homeVolt - 215;
    }

    public static void main(String[] args) {
        HomeBattery homeBattery = new HomeBattery();
        int homeVolt = homeBattery.supply();
        System.out.println("家庭电源提供的电压是 " + homeVolt + "V");

        int chargeVolt = convert(homeVolt);
        System.out.println("使用适配器将家庭电压转换成了 " + chargeVolt + "V");

        USBLine usbLine = new USBLine();
        usbLine.charge(chargeVolt);
    }
}
