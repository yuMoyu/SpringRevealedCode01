package s02;

public class ArrayUtils {
    public static boolean isEmpty(String[] arr) {
        if (arr == null) {
            return true;
        }
        if (arr.length <= 0) {
            return true;
        }
        return false;
    }
}
