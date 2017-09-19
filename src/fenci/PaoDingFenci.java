package fenci;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * -------------------------------------------------
 *
 * @project :test
 * @作者 :fengzijk
 * @email :guozhifengvip@163.com
 * @时间 : 2017年${MOUTH}月19日16:12
 * @修改 :  who   when    what
 * --------------------------------------------------
 */
public class PaoDingFenci {
    //停用词词表
    public static final String stopWordTable = "." + File.separator + "srcFile" + File.separator + "StopWordTable_all.txt";

    public static void main(String[] args) throws IOException {
        //String srcFile = "." + File.separator + "srcFile" + File.separator + "user_tag_query.txt";
        //String srcFile = "." + File.separator + "srcFile" + File.separator + "test.txt";
      //  String destFile = "." + File.separator + "destFile" + File.separator + "fileExcludeStopWord2.0.txt";
        //String destFile = "." + File.separator + "destFile" + File.separator + "output.txt";

        //new PaoDingFenci().fenciMain3(srcFile, destFile);
        System.out.println("OVER DONE!!!!!!!!!!");
        PaoDing pd = new PaoDing();
         String text = "中华人民共和国，猫跟你都想了解";
        System.out.println(pd.fenci01(text));
    }

    public void fenciMain3(String srcFile, String destFile){
        try {
            //读取原文件和停用词表
            BufferedReader srcFileBr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(srcFile))));
            BufferedReader StopWordFileBr = new BufferedReader(new InputStreamReader(new FileInputStream(stopWordTable), "UTF-8"));
            //将分词好的文本信息存入输出文件
            BufferedWriter destFileBw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(destFile))));

            //用来存放停用词的集合
            Set<String> stopWordSet = new HashSet<String>();

            //初始化停用词集
            String stopWord = null;
            for(; (stopWord = StopWordFileBr.readLine()) != null;){
                //  System.out.println(stopWord);
                stopWordSet.add(stopWord);
            }

            String paragraph = null;
            PaoDing pd = new PaoDing();
            for(; (paragraph = srcFileBr.readLine()) != null; ){
                //对读入的文本进行分词
                //显示结果
                //System.out.println(pd.fenci01(paragraph));

                String spiltResultStr = pd.fenci01(paragraph);
                String[] resultArray = spiltResultStr.split(" ");

                //过滤停用词
                for(int i = 4; i< resultArray.length; i++){
                    if(stopWordSet.contains(resultArray[i])){
                        resultArray[i] = null;
                    }
                    else{
                        for(int j = resultArray[i].length(); --j >= 0;){
                            char c = resultArray[i].charAt(j);
                            if(Character.isDigit(c)){
                                resultArray[i] = null;
                                break;
                            }
                            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                                resultArray[i] = null;
                                break;
                            }

                        }
                    }

                }

                //把过滤后的字符串数组存入到一个字符串中
                StringBuffer finalStr = new StringBuffer();
                for(int i = 0; i< resultArray.length; i++){
                    if(resultArray[i] != null){
                        finalStr = finalStr.append(resultArray[i]).append(" ");
                    }
                }

                //输出结果到指定文件
                destFileBw.write(finalStr.toString());
                destFileBw.newLine();
            }

            //关闭输入流
            destFileBw.close();
            srcFileBr.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
