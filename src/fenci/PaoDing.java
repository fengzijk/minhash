package fenci;

import net.paoding.analysis.analyzer.PaodingAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;

import java.io.IOException;
import java.io.StringReader;

/**
 * -------------------------------------------------
 *
 * @project :test
 * @作者 :fengzijk
 * @email :guozhifengvip@163.com
 * @时间 : 2017年${MOUTH}月19日16:38
 * @修改 :  who   when    what
 * --------------------------------------------------
 */
public class PaoDing {
    Analyzer analyzer = new PaodingAnalyzer();

    public PaoDing() {
        //
    }

    public String fenci01(String text) throws IOException {
        StringBuffer sb = new StringBuffer();
        StringReader reader = new StringReader(text);
        TokenStream ts = this.analyzer.tokenStream(text, reader);

        TermAttribute termAtt = (TermAttribute) ts
                .addAttribute(TermAttribute.class);
        while (ts.incrementToken()) {
            sb.append(termAtt.term());
            sb.append(" ");
        }
        return sb.toString();
    }

    public String fenci02(String text) throws IOException {
        StringBuffer sb = new StringBuffer();
        StringReader reader = new StringReader(text);
        TokenStream ts = this.analyzer.tokenStream(text, reader);

        Token t;
        t = ts.next();
        while (t != null) {
            sb.append(t.termText());
            sb.append(" ");
            t = ts.next();
        }
        return sb.toString();
    }
}
