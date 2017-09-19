
import java.text.ParseException;



/**
*-------------------------------------------------
* @类名称 : Main
* @说明 : TODO
* @作者 : Jeffrey
* @email: guozhifengvip@163.com
* @时间 : 2017/9/19 12:43
* @修改 : who   when    what
*--------------------------------------------------
*/

public class Main {

    public static void main(String[] args) {
        String dateStr = "2017-9-19 12:56:34";
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat simpleDateFormat =(java.text.SimpleDateFormat) java.text.DateFormat.getDateInstance();
        simpleDateFormat.applyPattern("yyyy-MM-dd");
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date b = new java.sql.Date(date.getTime());

        System.out.println(date);

    }
}
