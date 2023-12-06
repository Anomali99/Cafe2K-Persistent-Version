/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.math.BigInteger;

/**
 *
 * @author fatiq
 */
public class Rupiah {

    public static String getRp(BigInteger bg) {
        return getRp(String.valueOf(bg));
    }
    
    public static String getRp(long l) {
        return getRp(String.valueOf(l));
    }

    public static String getRp(int i) {
        return getRp(String.valueOf(i));
    }

    public static String getRp(String s) {
        char[] rp = s.toCharArray();
        String ss = "";
        int j = 1;
        for (int i = rp.length; i > 0; i--) {
            ss = rp[i - 1] + ss;
            if (j != 3) {
                j++;
            } else {
                j = 1;
                if (i != 1) {
                    ss = "." + ss;
                }
            }
        }
        return "Rp. " + ss + ",-";
    }

    public static String getString(String s) {
        String p, q, r, t, u, v;
        p = s.replace('-', ' ');
        q = p.replace('.', ' ');
        r = q.replace('R', ' ');
        t = r.replace('p', ' ');
        u = t.replace(',', ' ');
        v = "";
        for (char c : u.toCharArray()) {
            if (!" ".equals(String.valueOf(c))) {
                v = v + c;
            }
        }
        return v;
    }
    
    public static long getLong(String s){
        return Long.parseLong(getString(s));
    }
    
    public  static int getInt(String s){
        return Integer.parseInt(s);
    }
    
    public static BigInteger getBigInt(String s){
        return BigInteger.valueOf(getLong(s));
    }

}
