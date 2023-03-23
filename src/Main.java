import java.util.HashMap;
import java.util.Map;

public class Main {

    public class MyClass {

        private Map<String, Integer> map;

        public MyClass() {
            map = new HashMap<>();
            map.put("foo", 1);
            map.put("bar", 3);
        }

        public int getValue(String input, int numRetries) throws Exception {
            try {
                System.out.println("count");
                return map.get(input);
            }
            catch (Exception e) {
                if (numRetries > 3) {
                    throw e;
                }
                return getValue(input, numRetries + 1);
            }
        }
    }
    public void main(String[] args) throws Exception {
        MyClass myclass = new MyClass();
        System.out.println("Hello world!");
        myclass.getValue("foo",0);
    }
}