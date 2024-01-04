import java.util.HashMap;

public class Mapper {

    private static HashMap<Character,Integer> hex2dec = new HashMap<>();
    private static HashMap<Integer,Character> dec2hex = new HashMap<>();
    
    private static Mapper mappers = new Mapper();

    private Mapper() {
    
        hex2dec.put('0',0);
        hex2dec.put('1',1);
        hex2dec.put('2',2);
        hex2dec.put('3',3);
        hex2dec.put('4',4);
        hex2dec.put('5',5);
        hex2dec.put('6',6);
        hex2dec.put('7',7);
        hex2dec.put('8',8);
        hex2dec.put('9',9);
        hex2dec.put('a',10);
        hex2dec.put('b',11);
        hex2dec.put('c',12);
        hex2dec.put('d',13);
        hex2dec.put('e',14);
        hex2dec.put('f',15);

        dec2hex.put(0,'0');
        dec2hex.put(1,'1');
        dec2hex.put(2,'2');
        dec2hex.put(3,'3');
        dec2hex.put(4,'4');
        dec2hex.put(5,'5');
        dec2hex.put(6,'6');
        dec2hex.put(7,'7');
        dec2hex.put(8,'8');
        dec2hex.put(9,'9');
        dec2hex.put(10,'a');
        dec2hex.put(11,'b');
        dec2hex.put(12,'c');
        dec2hex.put(13,'d');
        dec2hex.put(14,'e');
        dec2hex.put(15,'f');
    }
    
    public static int hex2dec(char c) {
        return hex2dec.get(c);
    }

    public static int dec2hex(int d) {
        return dec2hex.get(d);
    }
}
