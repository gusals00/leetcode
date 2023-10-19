package _2023년._10월.easy;

public class AddBinary {
    public String addBinary(String a, String b) {
        int aLength = a.length() - 1;
        int bLength = b.length() - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (aLength >= 0 || bLength >= 0) {
            if(aLength >= 0)
                carry += a.charAt(aLength--) - '0';
            if(bLength >= 0)
                carry += b.charAt(bLength--) - '0';

            sb.insert(0, carry%2);
            carry /= 2;
        }
        if(carry > 0)
            sb.insert(0, carry);

        return sb.toString();
    }
}
