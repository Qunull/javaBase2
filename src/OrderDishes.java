import java.util.Scanner;

public class OrderDishes {
    public static void main(String[] args) {
        String[] names = new String[4];//姓名
        String[] caiMing = new String[7];//菜名
        int[] fenShu = new int[7];//份数
        int[] times = new int[7];//时间
        String[] diZhis = new String[7];//地址
        int[] state = new int[7];//0已预定，1已完成
        double[] moneys = new double[7];//金额
        String[] dishName = {"蒸羊羔", "蒸熊掌", "蒸鹿尾", "烧花鸭", "烧雏鸡", "烧子鹅", "佛跳墙"};
        double[] prices = {550.0, 230.0, 60.0, 55.5, 30.4, 50.0, 998.9};
        int[] dianZan = new int[7];//点赞

        names[0] = "张三";
        caiMing[0] = dishName[2];
        fenShu[0] = 2;
        times[0] = 12;
        diZhis[0] = "山东";
        moneys[0] = prices[2] * fenShu[0];
        dianZan[0] = 0;

        names[1] = "李四";
        caiMing[1] = dishName[3];
        fenShu[1] = 1;
        times[1] = 14;
        diZhis[1] = "山东";
        moneys[1] = prices[3] * fenShu[1];
        dianZan[1] = 1;

        int nums = -1;
        boolean boos = true;
        do {
            System.out.println("****************************\n" +
                    "1、我要订餐\n" +
                    "2、查看餐袋\n" +
                    "3、签收订单\n" +
                    "4、删除订单\n" +
                    "5、我要点赞\n" +
                    "6、退出系统\n" +
                    "****************************\n");
            Scanner input = new Scanner(System.in);
            System.out.println("请选择：");
            int opt = input.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("******我要订餐******");
                    boolean bool = false;
                    for (int i = 0; i < names.length; i++) {
                        if (null == names[i]) {
                            System.out.println("请输入订餐人姓名：");
                            names[i] = input.next();//接受姓名
                            System.out.println("序号" + "\t" + "菜名" + "\t\t" + "单价(￥)");
                            for (int a = 0; a < dishName.length; a++) {
                                String danJia = prices[a] + "元";
                                String dzs = dianZan[a] > 0 ? dianZan[a] + "赞" : "0";
                                System.out.println((a + 1) + "\t  " + dishName[a] + "\t  " + danJia);
                            }
                            System.out.print("请点菜：");
                            int num1 = input.nextInt();
                            System.out.print("请选择份数：");
                            int num2 = input.nextInt();
                            double canFei = prices[num1 - 1] * num2;
                            double scf = canFei >= 500 ? 0 : 50;
                            double money = canFei + scf;
                            boolean boo2 = true;
                            int time = 0;
                            while (boo2) {
                                System.out.print("请输入送餐时间：(送餐时间在12点到20点)");
                                time = input.nextInt();
                                if (time >= 12 && time < 20) {
                                    boo2 = false;
                                } else {
                                    System.out.println("您的输入不在范围内，请重新输入12点到20点的整数：");
                                }//时间不符合后进入循环
                            }
                            System.out.println("请输入送餐地址：");
                            String diZhi = input.next();
                            System.out.println("订餐成功！");
                            System.out.println("您的订单：" + dishName[num1 - 1] + "\t" + num2 + "份");
                            System.out.println("送餐时间：" + time + "点");
                            System.out.println("您的消费：餐费：" + prices[num1 - 1] * num2 + "元" + "，送餐费；（满500免运费）" +
                                    scf + "元" + "，总计：" + money + "元");
                            caiMing[i] = dishName[num1 - 1];
                            times[i] = time;
                            fenShu[i] = num2;
                            diZhis[i] = diZhi;
                            moneys[i] = money;
                            bool = true;
                            break;
                        } else {
                            bool = false;
                        }
                    }
                    if (!bool) {
                        System.out.println("餐袋已满！");
                    }
                    System.out.println("输入0返回：");
                    nums = input.nextInt();
                    if (nums != 0) {
                        boos = false;
                    }
                    break;
                case 2:
                    System.out.println("******查看餐袋******");
                    System.out.println("序号" + "\t" + "订餐人姓名" + "\t" + "订餐信息" + "\t" +
                            "送餐时间" + "\t" + "送餐地址" + "\t" + "总金额" + "\t  " + "状态");
                    for (int i = 0; i < names.length; i++) {
                        if (names[i] != null) {
                            String zhuangTai = state[i] == 0 ? "已预定" : "已完成";
                            System.out.println((i + 1) + "\t     " + names[i] + "\t      " + (dishName[i]) + fenShu[i] + "\t      " +
                                    times[i] + "\t    " + diZhis[i] + "  \t " + moneys[i] + "\t" + zhuangTai);
                        }
                    }
                    break;
                case 3:
                    System.out.println("*******签收订单*******");
                    System.out.println("请输入要签收的订单号：");
                    int num3 = input.nextInt();
                    if (names[num3 - 1] != null) {
                        if (state[num3 - 1] == 0) {// 找到该订单
                            state[num3 - 1] = 1;
                            System.out.println("您的订单签收成功！");
                        } else if (state[num3 - 1] == 1) {//状态为已完成
                            System.out.println("您选择的订单已完成签收，不能再次签收");
                        }
                    } else {//未找到订单序号
                        System.out.println("您选择的订单序号不存在");
                    }
                    System.out.println("输入0返回：");
                    nums = input.nextInt();
                    if (nums != 0) {
                        boos = false;
                    }
                    break;
                case 4:
                    System.out.println("*******删除订单*******");
                    System.out.println("请输入要删除的订单序号：");// 提示要删除的订单
                    int num4 = input.nextInt();// 找到该订单
                    if (names[num4 - 1] != null) {// 状态为已预订
                        if (state[num4 - 1] == 1) {
                            for (int d = num4 - 1; d < names.length; d++) {
                                for (int j = d; j < names.length - 1; ) {
                                    names[j] = names[j + 1];
                                    caiMing[j] = caiMing[j + 1];
                                    times[j] = times[j + 1];
                                    diZhis[j] = diZhis[j + 1];
                                    moneys[j] = moneys[j + 1];
                                    state[j] = state[j + 1];

                                    names[names.length - 1] = null;
                                    caiMing[caiMing.length - 1] = null;
                                    times[times.length - 1] = 0;
                                    diZhis[diZhis.length - 1] = null;
                                    moneys[moneys.length - 1] = 0;
                                    state[state.length - 1] = -1;
                                    break;
                                }
                            }
                            System.out.println("订单删除成功！");
                        } else if (state[num4 - 1] == 0) {
                            System.out.println("该订单未签收，还不能删除，请签收后再删除！");
                        }
                    } else {
                        // 未找到订单序号
                        System.out.println("您要删除的订单不存在!");
                    }
                    System.out.println("输入0返回：");
                    nums = input.nextInt();
                    if (nums != 0) {
                        boos = false;
                    }
                    break;
                case 5:
                    System.out.println("*******我要点赞*******");
                    System.out.println("序号\t菜品名\t单价\t点赞数"); // 显示菜品信息
                    for (int j = 0; j < dishName.length; j++) {
                        System.out.println((j + 1) + "\t  " + dishName[j] + "\t " + prices[j] + "\t   " + dianZan[j]);
                    }
                    System.out.println("请输入您想要点赞的餐品序号："); // 提示选择点赞的菜品编号并接收
                    int num5 = input.nextInt();
                    dianZan[num5 - 1]++;// 点赞数加一
                    System.out.println("输入0返回：");
                    nums = input.nextInt();
                    if (nums != 0) {
                        boos = false;
                    }
                    break;
                case 6:
                    System.out.println("退出系统");
                    boos = false;
                    break;
                default:
                    // 输入其他数字也退出系统
                    System.out.println("输出信息错误，默认退出系统！");
                    boos = false;
                    break;
            }

        } while (boos);
        System.out.println("程序结束！");
    }
}