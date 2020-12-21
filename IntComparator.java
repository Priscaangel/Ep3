import java.util.Comparator;

public class IntComparator implements Comparator<Integer> {
    public int compare(Integer v1, Integer v2) {
      return Integer.compare(v1, v2);
    }
}
