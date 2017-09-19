package experiment;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

/**
 * -------------------------------------------------
 *
 * @project :test
 * @作者 :fengzijk
 * @email :guozhifengvip@163.com
 * @时间 : 2017年09月19日17:03
 * @修改 :  who   when    what
 * --------------------------------------------------
 */
public class MinhashM {
    public static void main(String[] args) throws IOException {
        System.out.println("-----------使用k-shingle技术分析两段文本之间的Jaccard相似度-------");
        System.out.println("请输入k-shingle中k的值：");
        Scanner scann = new Scanner(System.in);
        int k = scann.nextInt();
        scann.close();
        Set<String> set = KShingle.jaccard(k);
        System.out.println("-----------1使用MinHash技术分析两段文本之间的Jaccard相似度------------");
        MinHash.minHashJaccard(k, set);
        System.out.println("-----------用hash函数代替行打乱计算最小哈希签名------------");
        MinHashSignature.signatureJaccard(set, k);
    }
}
