package edu.matc.taglibdemo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by David on 3/20/17.
 */
public class HelloWorldTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 3);
        calendar.set(Calendar.DAY_OF_MONTH, 28);

        Date releaseDate = calendar.getTime();
        Date currentDate = new Date();

        long amonkhet = releaseDate.getTime() - currentDate.getTime();
        amonkhet = amonkhet / (1000L*60L*60L*24L);
        out.println(amonkhet + " days until " + "<a href='http://magic.wizards.com/en/products/amonkhet/products'>Amonkhet</a> releases!");
    }
}