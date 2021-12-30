import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] series = {8, 4, 2, 1, 23, 344, 12};
        for (int i = 0; i < series.length; i++) {
            System.out.println("数列的值有：" + series[i]);
        }
        int sum = 0;
        for (int s = 0; s < series.length; s++) {
            sum += series[s];
        }
        System.out.println("所有数列的和为：" + sum);
        System.out.println("猜拳游戏：从键盘中任意输入一个数据，判断数列中是否包含此数：");
        int number = input.nextInt();
        char right = 'b';
        for (int k = 0; k < series.length; k++) {
            if (number == series[k]) {
                right = 'a';
                break;
            }
        }
        if (right == 'a'){
            System.out.println("数列中包含此数");
        }else {
            System.out.println("数列中不包含此数");
        }


    }
}

