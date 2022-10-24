import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String largestNumber(int[] nums) {
        List<Integer> nu = Arrays.stream(nums).boxed().collect( Collectors.toList() );
        Collections.sort(nu, (a, b) -> (String.valueOf(b) + a).compareTo(String.valueOf(a) + b));
		String out = nu.stream().map(Object::toString).collect(Collectors.joining(""));
        return out.replaceFirst("^0+(?!$)", "");
    }
}