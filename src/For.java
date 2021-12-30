public class For {
    public static void main(String[] args) {
        int i = 0;
        int sum = 0;

        while (i <= 100){
            sum += i;
            i += 2;
        }
        System.out.println(sum);
        int a = 0;
        int sum1 = 0;
        do {
            sum1 += a;
            a += 2;
        }while (a <= 100);
        System.out.println(sum1);
        int b = 0;
        int sum2 = 0;
        for (;b <= 100;b+=2){
            sum2 += b;
        }
        System.out.println(sum2);
    }



}
