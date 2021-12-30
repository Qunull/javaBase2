import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("我行我素购物管理系统 > 幸运抽奖");
        System.out.println("\t");
        System.out.println("请输入4位会员号：");
        int num = input.nextInt();
        int baiWei = num / 100 % 10;
        int random = (int)(Math.random()*10);
        if (baiWei == random){
            System.out.println(num+"号客户是幸运客户，获得奖品一个。");
        }else{
            System.out.println(num+"号客户，谢谢您的支持！");
        }
    }
}
