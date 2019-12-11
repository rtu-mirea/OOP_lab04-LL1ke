package Task2;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class Toy {
    private String nameFirm;//here
    private int price;//here
    private int duration;//here
    private static int min = 10000000;//here
    public static final int maxLen = 15;
    public static final char fill = (char)30;

    Toy(String n, int p, int d) throws Exception{
        if(n.length() >= maxLen){
            throw new IllegalArgumentException("Длина названия превышает " + maxLen);
        }
        for(int i = 0; i < n.length(); ++i)
            if(n.charAt(i) == fill)
                throw new IllegalArgumentException("Использован недопустимый символ " + fill);
        nameFirm = n;
        for(int i = n.length(); i < maxLen; ++i){
            nameFirm += fill;
        }
        price = p;
        duration = d;
        if(duration < min){
            min = duration;
        }
    }

    Toy(String t){
        String[] k = t.split(" ");
        nameFirm = k[0];
        price = Integer.parseInt(k[1]);
        duration = Integer.parseInt(k[2]);
    }

    Toy(byte[] info){
        byte[] tmpBytes = new byte[maxLen];
        for(int i = 0; i < maxLen; ++i){
            tmpBytes[i] = info[i];
        }
        nameFirm = new String(tmpBytes);
        tmpBytes = new byte[4];
        for(int i = 0; i < 4; ++i){
            tmpBytes[i] = info[i + maxLen + 1];
        }
        price = ByteBuffer.wrap(tmpBytes).getInt();

        for(int i = 0; i < 4; ++i){
            tmpBytes[i] = info[i + maxLen + 4 + 2];
        }
        duration = ByteBuffer.wrap(tmpBytes).getInt();
    }

    public String getNameFirm(){
        String ans = "";
        int i = 0;
        while(nameFirm.charAt(i) != (char)fill){
            ans += nameFirm.charAt(i);
            ++i;
        }
        return ans;
    }

    public int getDuration() {
        return duration;
    }

    public static int getMin() {
        return min;
    }

    @Override
    public String toString() {
        String n = "";
        int i = 0;
        while (nameFirm.charAt(i) != Toy.fill){
            n += nameFirm.charAt(i);
            ++i;
        }
        return n + ' ' + price + ' ' + duration;
    }

    public String str(){
        return nameFirm + ' ' + price + ' ' + duration;
    }

    public static int byteLen(){
        return maxLen + 8 + 3;
    }

    public byte[] toByteArray() throws UnsupportedEncodingException {
        byte tmp[] = nameFirm.getBytes("UTF-8");
        int endPos = tmp.length;
        byte ans[] = new byte[tmp.length + 8 + 3];
        for(int i = 0; i < tmp.length; ++i){
            ans[i] = tmp[i];
        }
        ans[endPos] = " ".getBytes("UTF-8")[0];
        endPos++;
        tmp = ByteBuffer.allocate(4).putInt(price).array();
        for(int i = 0; i < tmp.length; ++i){
            ans[i + endPos] = tmp[i];
        }
        endPos += 4;
        ans[endPos] = " ".getBytes("UTF-8")[0];
        endPos++;
        tmp = ByteBuffer.allocate(4).putInt(duration).array();
        for(int i = 0; i < tmp.length; ++i){
            ans[i + endPos] = tmp[i];
        }
        endPos += 4;
        ans[endPos] = "\n".getBytes("UTF-8")[0];
        return ans;
    }

    public String get_c_ci(int n){
        if (n == duration){
            return "Название фирмы:" + nameFirm + ", цена:" + price;
        }
        return "";
    }

    public boolean same_age(Toy t){
        return duration == t.duration;
    }

    public void discont (){
        if(duration == min)
            price = price / 2;
    }
}
