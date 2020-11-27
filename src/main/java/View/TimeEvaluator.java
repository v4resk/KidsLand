package View;

import com.toedter.calendar.DateUtil;
import com.toedter.calendar.IDateEvaluator;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

// This class implements IDateEvaluator witch let us disable or select date in JCalendar;
// Credits : https://stackoverflow.com/questions/37885199/java-highlighting-specific-dates-in-jcalendar-cell
// We learn how to implement this interface from StackOverflow.com just before adjust our class for our need.

public class TimeEvaluator implements IDateEvaluator {

    private DateUtil dateUtil = new DateUtil();

    private ArrayList<Date> list = new ArrayList<Date>();
    public void add(Date date) {
        list.add(date);
    }

    @Override
    public boolean isSpecial(Date date) {
        return list.contains(date);
    }

    @Override
    public Color getSpecialForegroundColor() {
        return null;
    }

    @Override
    public Color getSpecialBackroundColor() {
        return null;
    }

    @Override
    public String getSpecialTooltip() {
        return null;
    }

    @Override
    public boolean isInvalid(Date date) {
        // if the date is Out of range it will be invalid and if she is not in the list
        return !list.contains(date) || !dateUtil.checkDate(date);
    }

    @Override
    public Color getInvalidForegroundColor() {
        return null;
    }

    @Override
    public Color getInvalidBackroundColor() {
        return null;
    }

    @Override
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
