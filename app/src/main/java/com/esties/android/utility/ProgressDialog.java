package com.esties.android.utility;

import android.content.Context;
import android.util.Log;

import com.esties.android.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProgressDialog {
    private static android.app.ProgressDialog progress;

    public static void showProgressBar(Context context) {
        try {
            progress = new android.app.ProgressDialog(context);
            progress.setMessage("Please Wait");
            progress.setCancelable(false);
            progress.setProgressStyle(android.app.ProgressDialog.STYLE_SPINNER);
            progress.show();
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }

    }

    public static void hideProgressBar() {
        try {
            if (progress != null && progress.isShowing())
                progress.dismiss();

        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }

    }

    public static boolean CheckDates(Context m, String startDate, String endDate, String startDateSlot, String endDateSlot) {

        SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd");

        boolean b = false;

        try {
            if (dfDate.parse(startDate).before(dfDate.parse(endDate))) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
                Date date1 = simpleDateFormat.parse(startDateSlot);
                Date date2 = simpleDateFormat.parse(endDateSlot);
                long difference = date2.getTime() - date1.getTime();
                int days = (int) (difference / (1000 * 60 * 60 * 24));
                int hours = (int) ((difference - (1000 * 60 * 60 * 24 * days)) / (1000 * 60 * 60));
                int min = (int) (difference - (1000 * 60 * 60 * 24 * days) - (1000 * 60 * 60 * hours)) / (1000 * 60);
                hours = (hours < 0 ? -hours : hours);
                Log.i("======= Hours", " :: " + hours);
                b = false;
                // If start date is before end date.
            } else if (dfDate.parse(startDate).equals(dfDate.parse(endDate))) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
                Date date1 = simpleDateFormat.parse(startDateSlot);
                Date date2 = simpleDateFormat.parse(endDateSlot);
                long difference = date2.getTime() - date1.getTime();
                int days = (int) (difference / (1000 * 60 * 60 * 24));
                int hours = (int) ((difference - (1000 * 60 * 60 * 24 * days)) / (1000 * 60 * 60));
                int min = (int) (difference - (1000 * 60 * 60 * 24 * days) - (1000 * 60 * 60 * hours)) / (1000 * 60);
                hours = (hours < 0 ? -hours : hours);
                Log.i("======= Hours", " :: " + hours);
                b = true;
            } else {
                b = true; // If start date is after the end date.
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return b;
    }

}
