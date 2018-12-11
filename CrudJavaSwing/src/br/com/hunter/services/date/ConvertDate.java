/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hunter.services.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author edson
 */
public class ConvertDate {

    String pattern = "dd/MM/yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    java.util.Date converted;

    public java.util.Date convertDate(String date) throws ParseException {
        try {
            converted = sdf.parse(date);
        } catch (Exception e) {
            System.out.println(e);
        }
        return converted;
    }

}
