package View;

import com.toedter.calendar.DateUtil;
import com.toedter.calendar.IDateEvaluator;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class TimeEvaluator_2 implements IDateEvaluator {

    private DateUtil dateUtil = new DateUtil();

    private ArrayList<Date> list = new ArrayList<Date>();
    public void add(Date date) {
        list.add(date);
    }

    public boolean isSpecial(Date date) {
        return list.contains(date);
    }

    public Color getSpecialForegroundColor() {
        return null;
    }

    public Color getSpecialBackroundColor() {
        return null;
    }

    public String getSpecialTooltip() {
        return null;
    }


    public boolean isInvalid(Date date) {
        // if the date is Out of range it will be invalid and if she is not in the list
        return list.contains(date) || !dateUtil.checkDate(date);
    }


    public Color getInvalidForegroundColor() {
        return null;
    }


    public Color getInvalidBackroundColor() {
        return null;
    }


    public String getInvalidTooltip() {
        return null;
    }


    /**
     * Sets the initial date in the range to be validated.
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        dateUtil.setMinSelectableDate(startDate);
    }

    /**
     * @return the initial date in the range to be validated.
     */
    public Date getStartDate() {
        return dateUtil.getMinSelectableDate();
    }

    /**
     * Sets the final date in the range to be validated.
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        dateUtil.setMaxSelectableDate(endDate);
    }
    /**
     * @return the final date in the range to be validated.
     */
    public Date getEndDate() {
        return dateUtil.getMaxSelectableDate();
    }
}

