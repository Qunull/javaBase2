import java.util.Scanner;

public class Eat {


    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {// 数据主体 一组订单信息
        String[] names = new String[4];// 保存订餐人姓名
        String[] caiMing = new String[4];// 保存所选信息， 菜名 份数
        int[] fenShu = new int[4];
        int[] times = new int[4];// 保存送餐时间
        String[] diZhis = new String[4];   // 保存送餐地址
        int[] ddzt = new int[4]; // 用数字0或1 标识订单状态 已预订或已完成// 保存订单状态 已预订 或 已完成
        double[] moneys = new double[4]; // 保存订单金额
        String[] foods = {"炒青菜", "青椒炒蛋", "水煮肉片", "鸡肉堡"};// 菜名
        double[] meals = {8, 12, 25, 35};// 单价
        int[] dianZhanShu = new int[4]; // 点赞数
        names[0] = "张三";// 初始化两条订单信息 订餐人 所订餐品及份数 送餐时间 送餐地址 总金额 订单状态
        caiMing[0] = foods[2];
        fenShu[0] = 2;
        times[0] = 12;
        diZhis[0] = "同济路112号";
        moneys[0] = meals[2] * fenShu[0];
        ddzt[0] = 0;

        names[1] = "李四";
        caiMing[1] = foods[3];
        fenShu[1] = 1;
        times[1] = 14;
        diZhis[1] = "同济路121号";
        moneys[1] = meals[3] * fenShu[1];
        ddzt[1] = 1;

        int nums = -1;// 实现菜单切换 当输入1~5时，输出相关的菜单信息
        // 标识用户输入数字，输入0返回主菜单，否则退出系统
        // 输出信息： 欢迎使用 吃货联盟订餐系统
        System.out.println("**********欢迎使用吃货联盟订餐系统**********");
        // 循环：显示菜单，根据用户选择的数字执行相应的功能
        boolean boos = true; // 标识循环条件
        do {
            // 循环：显示菜单，根据用户选择的数字执行相应的功能
            // 显示菜单// 1、我要订餐// 2、查看餐袋// 3、签收订单// 4、删除订单// 5、我要点赞// 6、退出系统
            System.out.println("……………………………………………………");
            System.out.println("1、我要订餐\n" + "2、查看餐袋\n" + "3、签收订单\n" + "4、删除订单\n" + "5、我要点赞\n" + "6、退出系统");
            System.out.println("……………………………………………………");
            System.out.println("请选择："); // 输出提示信息：请选择执行操作数字
            int num = input.nextInt();// 记录用户选择的功能编号
            switch (num) { // 根据用户选择的功能编号执行相应的功能
                case 1:
                    System.out.println("******我要订餐******"); // 输入1 输出信息 我要订餐
                    boolean boo1 = false;// 记录是否可以订餐
                    for (int i = 0; i < names.length; i++) { // 如果找到一个为空的位置，可以添加订单信息
                        if (null == names[i]) {
                            System.out.println("请输入送餐人姓名：");  // 提示输入订餐人姓名，获取信息
                            names[i] = input.next();
                            System.out.println("序号\t" + "菜名\t" + "单价\t" + "点赞数");
                            for (int a = 0; a < foods.length; a++) { // 选择菜品及份数 显示可供选择的菜品序号，菜名，单价，点赞数
                                String danJia = meals[a] + "元";
                                String dzs = dianZhanShu[a] > 0 ? dianZhanShu[a] + "赞" : "0";
                                System.out.println((a + 1) + "\t" + foods[a] + "\t" + danJia + "\t" + dzs);
                            }
                            System.out.println("请选择您要点的餐品序号：");  // 提示输入菜品序号及份数并获取信息
                            int num1 = input.nextInt();
                            System.out.println("请输入所订餐品份数：");
                            int num2 = input.nextInt();
                            double canFei = meals[num1 - 1] * num2; // 计算送餐费（餐费大于50免送餐费，否则送餐费为5元）
                            double scf = canFei >= 50 ? 0 : 5;
                            double money = canFei + scf;
                            boolean boo2 = true;// 标识输入送餐时间是否正确的循环条件// 提示输入送餐时间，要求输入时间为10~20之间的整点数字，否则提示输入错误，重新输入
                            int time = 0;// 标识送餐时间
                            while (boo2) {
                                System.out.println("请输入送餐时间：");
                                time = input.nextInt();
                                if (time >= 10 && time <= 20) {
                                    boo2 = false;
                                } else {
                                    System.out.println("输入不正确，请输入10~20之间的整点时间！");
                                }
                            }
                            System.out.println("请输入送餐地址:");  // 提示输入送餐地址
                            String diZhi = input.next();
                            System.out.println("订餐成功！");// 以上信息输入完成提示 订餐成功
                            // 显示订单信息： 您订单餐品是： 送餐时间： 餐费： 送餐费 总金额：（餐费+送餐费）
                            System.out.println("您订单餐品是：" + foods[num1 - 1] + ",所订份数：" + num2 + "份，送餐地址：" + diZhi + ",送餐时间："
                                    + time + "点，餐费：" + canFei + ",送餐费：" + scf + ",总金额：" + money);
                            caiMing[i] = foods[num1 - 1]; // 把以上信息添加到相应的数组里
                            times[i] = time;
                            fenShu[i] = num2;
                            diZhis[i] = diZhi;
                            moneys[i] = money;
                            boo1 = true;
                            break;
                        } else {
                            boo1 = false;
                        }
                    }
                    if (!boo1) {
                        System.out.println("餐袋已满！");
                    }
                    System.out.println("输入0返回：");
                    nums = input.nextInt();
                    if (nums != 0) {
                        boos = false;
                    }
                    break;
                case 2:
                    System.out.println("******查看餐袋******"); // 输入2 输出信息 查看餐袋
                    // 遍历 餐品序号 ，订餐人姓名，订餐信息（菜名及份数），送餐时间，送餐地址，总金额，订单状态
                    System.out.println("序号\t订餐人\t所订餐品\t份数\t送餐时间\t送餐地址\t\t总金额\t订单状态");
                    for (int i = 0; i < names.length; i++) {
                        if (names[i] != null) {
                            String zhuangTai = ddzt[i] == 0 ? "已预订" : "已完成";
                            System.out.print((i + 1) + "\t" + names[i] + "\t" + caiMing[i] + "\t" + fenShu[i] + "\t"
                                    + times[i] + "\t" + diZhis[i] + "\t" + moneys[i] + "\t" + zhuangTai);
                            System.out.println();
                        }
                    }
                    System.out.println("输入0返回：");
                    nums = input.nextInt();
                    if (nums != 0) {
                        boos = false;
                    }
                    break;
                case 3:
                    // 3 签收订单
                    // 输出信息 ******签收订单*****
                    System.out.println("******签收订单*****");
                    // 提示选择要签收的订单序号并获取信息
                    // 状态为已预订，序号为用户输入的订单序号减一：可签收
                    // 状态为已完成，序号为用户输入的订单序号减一：不可签收
                    System.out.println("请输入要签收的订单序号：");
                    int num3 = input.nextInt();
                    if (names[num3 - 1] != null) {
                        // 找到该订单 若状态为已预订将状态值重新标志位已完成
                        if (ddzt[num3 - 1] == 0) {
                            ddzt[num3 - 1] = 1;
                            System.out.println("您所选订单签收成功！");
                            // 若状态为已完成 提示 ：您选择的订单已完成签收，不能再次签收
                        } else if (ddzt[num3 - 1] == 1) {
                            System.out.println("您选择的订单已完成签收，不能再次签收");
                        }
                        // 若未找到订单序号 提示： 您选择的订单序号不存在
                    } else {
                        System.out.println("您选择的订单序号不存在");
                    }

                    System.out.println("输入0返回：");
                    nums = input.nextInt();
                    if (nums != 0) {
                        boos = false;
                    }
                    break;
                case 4:
                    // 4 删除订单
                    // 输出信息：*******删除订单*******
                    System.out.println("*******删除订单*******");
                    // 提示要删除的订单序号
                    System.out.println("请输入要删除的订单序号：");
                    int num4 = input.nextInt();
                    // 找到该订单 状态为已完成执行删除操作 删除位置后面的元素依次往前移将最后一位清空
                    if (names[num4 - 1] != null) {
                        // 状态为已预订 提示：订单未签收，不能删除
                        if (ddzt[num4 - 1] == 1) {
                            for (int d = num4 - 1; d < names.length; d++) {
                                for (int j = d; j < names.length - 1; ) {
                                    names[j] = names[j + 1];
                                    caiMing[j] = caiMing[j + 1];
                                    times[j] = times[j + 1];
                                    diZhis[j] = diZhis[j + 1];
                                    moneys[j] = moneys[j + 1];
                                    ddzt[j] = ddzt[j + 1];

                                    names[names.length - 1] = null;
                                    caiMing[caiMing.length - 1] = null;
                                    times[times.length - 1] = 0;
                                    diZhis[diZhis.length - 1] = null;
                                    moneys[moneys.length - 1] = 0;
                                    ddzt[ddzt.length - 1] = -1;
                                    break;
                                }
                            }
                            System.out.println("订单删除成功！");
                        } else if (ddzt[num4 - 1] == 0) {
                            System.out.println("该订单未签收，还不能删除，请签收后再删除！");
                        }
                    } else {
                        // 未找到订单序号 提示：您要删除的订单不存在
                        System.out.println("您要删除的订单不存在!");
                    }
                    System.out.println("输入0返回：");
                    nums = input.nextInt();
                    if (nums != 0) {
                        boos = false;
                    }
                    break;
                case 5:
                    // 5 我要点赞
                    // 输出信息 *******我要点赞*******
                    System.out.println("*******我要点赞*******");
                    // 显示菜品信息
                    System.out.println("序号\t菜品名\t单价\t点赞数");
                    for (int j = 0; j < foods.length; j++) {
                        System.out.println((j + 1) + "\t" + foods[j] + "\t" + meals[j] + "\t" + dianZhanShu[j]);
                    }
                    // 提示选择点赞的菜品编号并接收
                    System.out.println("请输入您想要点赞的餐品序号：");
                    int num5 = input.nextInt();
                    // 点赞数加一
                    dianZhanShu[num5 - 1]++;
                    System.out.println("输入0返回：");
                    nums = input.nextInt();
                    if (nums != 0) {
                        boos = false;
                    }
                    break;
                case 6:
                    // 6 退出系统
                    System.out.println("正在退出系统！");
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

        // 提示信息 ： 输入0返回
        // 接收信息
        //
    }
}
