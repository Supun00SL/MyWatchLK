/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Seconds;
import org.joda.time.Weeks;
import org.joda.time.Years;
import pojos.Supplierlogin;

/**
 *
 * @author Supun Madushanka
 */
public class Common {

    public static final DecimalFormat VALUE_FORMAT = new DecimalFormat("###,###,##0.00");

    public String getdaysCount(String date, String time) {
        String Date = date;
        String Time = time;
        try {
            String Today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            Date fromDay = new SimpleDateFormat("yyyy-MM-dd").parse(Date);
            Date today = new SimpleDateFormat("yyyy-MM-dd").parse(Today);

            String NowTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
            Date fromtime = new SimpleDateFormat("HH:mm:ss").parse(Time);
            Date nowtime = new SimpleDateFormat("HH:mm:ss").parse(NowTime);

            LocalDate from = LocalDate.fromDateFields(fromDay);
            LocalDate to = LocalDate.fromDateFields(today);

            LocalTime fromtimee = LocalTime.fromDateFields(fromtime);
            LocalTime totime = LocalTime.fromDateFields(nowtime);

            Days days = Days.daysBetween(from, to);
            Weeks weeks = Weeks.weeksBetween(from, to);
            Months months = Months.monthsBetween(from, to);
            Years years = Years.yearsBetween(from, to);

            int daysCount = days.getDays();
            int weeksCount = weeks.getWeeks();
            int monthsCount = months.getMonths();
            int yearsCount = years.getYears();

            Seconds seconds = Seconds.secondsBetween(fromtimee, totime);
            Minutes minutes = Minutes.minutesBetween(fromtimee, totime);
            Hours hours = Hours.hoursBetween(fromtimee, totime);

            int secondsCount = seconds.getSeconds();
            int minutesCount = minutes.getMinutes();
            int hoursCount = hours.getHours();

            System.out.println("days :" + daysCount);
            if (daysCount == 0) {
                if (secondsCount < 60) {
                    return secondsCount + " seconds ago";

                } else if (secondsCount > 60 & minutesCount < 60) {
                    return minutesCount + " minutes ago";
                } else {
                    return hoursCount + " hours ago";
                }
            } else if (daysCount < 7) {
                return daysCount + " days ago";
            } else if (daysCount > 7 & daysCount < 31) {
                return weeksCount + " weeks ago";
            } else if (daysCount > 31 & daysCount < 365) {
                return monthsCount + " months ago";
            } else {
                return yearsCount + " years ago";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String checkNullablility(String value) {
        String val = "";
        try {
            if (!value.equals("")) {
                val = value;
            }
        } catch (Exception e) {

        } finally {
            return val;
        }
    }
    
    public String SetDefaultImageSupplier(String value) {
        String val = "icons/business_user.png";
        
        //<%= new classes.Common().SetDefaultImageSupplier(supplier1.getSupplierlogo())%>
        try {
            if (value==null) {
                val = value;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return val;
        }
    }
    
    public String Set_UsernameSupplier(Set<pojos.Supplierlogin> supplierlogins){
        String uname="";
        try {
            Set<pojos.Supplierlogin> supplierlogins1=supplierlogins;
            
            if(!supplierlogins1.isEmpty()){
                for (Supplierlogin supplierlogins11 : supplierlogins1) {
                    uname=supplierlogins11.getUsername();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }finally{
            return uname;
        }
    }
    public String Set_UsernameClient(Set<pojos.Clientlogin> clientlogins){
        String uname="";
        try {
            Set<pojos.Clientlogin> clientlogins1=clientlogins;
            
            if(!clientlogins1.isEmpty()){
                for (pojos.Clientlogin clientlogin : clientlogins1) {
                    uname=clientlogin.getUsername();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }finally{
            return uname;
        }
    }
}
