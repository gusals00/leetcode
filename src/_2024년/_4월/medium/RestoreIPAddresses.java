package _2024년._4월.medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        if(s.length() > 12) {
            return result;
        }

        restoreIpAddresses(s, 0, result, new ArrayList<>());

        return result;
    }

    private void restoreIpAddresses(String s, int index, List<String> result, List<String> ip) {
        if(ip.size() == 4 && index == s.length()) {
            result.add(String.join(".", ip));
            return;
        }

        for(int i=index+1; i<=index+3 && i<=s.length(); i++) {
            String next = s.substring(index, i);
            if((next.equals("0") || !next.startsWith("0")) && Integer.valueOf(next) <= 255) {
                ip.add(next);
                restoreIpAddresses(s, i, result, ip);
                ip.remove(ip.size()-1);
            }
        }
    }
}
