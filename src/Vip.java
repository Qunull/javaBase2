import java.util.Scanner;

public class Vip {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入会员卡号：");
        int num = input.nextInt();
        System.out.println("会员卡号是："+num);
        int qianwei = num / 1000;
        int baiwei = num / 100 % 10;
        int shiwei = num / 10 % 10;
        int gewei = num % 10;
        System.out.println("千位数："+qianwei+" 百位数："+baiwei+" 十位数："+shiwei+" 个位数："+gewei);
        System.out.println("会员卡号："+num+"各位数之和："+(qianwei+baiwei+shiwei+gewei));
    }
}
