package com.sttimchenko.censushelper;

import android.support.design.widget.Snackbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Utils {
    public static List<String> splitToList(String from, String delimiter){
        from = from.replaceAll(" ", "");

        List<String> list = new ArrayList<>(Arrays.asList(from.split(delimiter)));
        if (list.get(0).equals("")) list.remove(0);

        return list;
    }

    public static String join(Collection<String> list, String delimiter) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        for (String item : list) {
            result.append(item);

            if (++i < list.size())
                result.append(delimiter);
        }

        return result.toString();
    }

    public static void showSnackbar(View view, String text, int length){
        Snackbar.make(view, text, length).show();
    }
}
