package chapter01_intro;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Yang QingBo
 * {@code @date} 2026-03-13 21:04
 */

// 一开始有100个人，每个人都有100元
// 在每一轮都做如下的事情:
// 每个人都必须拿出1元钱给除自己以外的其他人，
// 给谁完全随机 如果某个人在这一轮的钱数为0，
// 那么他可以不给，但是可以接收发生很多很多轮之后，
// 这100人的社会财富分布很均匀吗?
public class Video002_Experiment {
    private static final Random r = new Random();

    public static void main(String[] args) {
        System.out.println("一个社会的基尼系数是一个在0~1之间的小数");
        System.out.println("基尼系数为0代表所有人的财富完全一样");
        System.out.println("基尼系数为1代表有1个人掌握了全社会的财富");
        System.out.println("基尼系数越小，代表社会财富分布越均衡；越大则代表财富分布越不均衡");
        System.out.println("在2022年，世界各国的平均基尼系数为0.44");
        System.out.println("目前普遍认为，当基尼系数到达 0.5 时");
        System.out.println("就意味着社会贫富差距非常大，分布非常不均匀");
        System.out.println("社会可能会因此陷入危机，比如大量的犯罪或者经历社会动荡");
        System.out.println("测试开始");
        // 基尼系数的计算
        // 差值总和 除以 2 * 人数 * 财富总和
        int n = 100;
        int t = 10000000;
        System.out.println("人数 : " + n);
        System.out.println("轮数 : " + t);
        experiment(n, t);
        System.out.println("测试结束");
    }

    // 开始实验
    public static void experiment(int n, int t) {
        // 创建财富数组
        double[] wealth = new double[n];
        // 默认每个人初始100r
        Arrays.fill(wealth, 100);
        // 创建数组判断每个人是否有钱
        boolean[] hasMoney = new boolean[n];

        for (int i = 0; i < t; i++) {
            // 默认所有人初始没钱
            Arrays.fill(hasMoney, false);
            // 循环标记有钱的人
            for (int j = 0; j < n; j++) {
                if (wealth[j] > 0) {
                    hasMoney[j] = true;
                }
            }
            // 开始循环每个人随机给其他人钱
            for (int j = 0; j < n; j++) {
                if (hasMoney[j]) {
                    int other;
                    do {
                        other = r.nextInt(n);
                    } while (other == j);
                    wealth[j] -= 1;
                    wealth[other] += 1;
                }
            }

            // 每百万轮输出一次
            if (i % 1000000 == 0 && i > 0) {
                double gini = calculateGini(wealth);
                System.out.printf("已完成 %d 轮，当前基尼系数：%.4f%n", i, gini);
            }
        }

        Arrays.sort(wealth);
        System.out.println("列出每个人的财富：（从贫穷到富有）");
        for (int i = 0; i < n; i++) {
            System.out.print((int) wealth[i] + "\t");
            if (i % 10 == 9) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("这个社会的基尼系数为：" + calculateGini(wealth));
    }

    // 计算社会基尼系数
    private static double calculateGini(double[] wealth) {
        double sumOfWealthDifferences = 0;
        double totalWealth = 0;
        int n = wealth.length;
        for (int i = 0; i < wealth.length; i++) {
            totalWealth += wealth[i];
            for (int j = 0; j < wealth.length; j++) {
                sumOfWealthDifferences += Math.abs(wealth[i] - wealth[j]);
            }
        }
        return sumOfWealthDifferences / (2 * n * totalWealth);
    }
}