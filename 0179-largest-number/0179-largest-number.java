import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String largestNumber(int[] nums) {
		// List<Integer> nu = Arrays.stream(nums).boxed().collect( Collectors.toList() );
		// Collections.sort(nu, (a, b) -> (String.valueOf(b) + a).compareTo(String.valueOf(a) + b));
		// String out = nu.stream().map(Object::toString).collect(Collectors.joining(""));
		// return out.replaceFirst("^0+(?!$)", "");
        
        StringBuilder sb = new StringBuilder();
        int n = nums.length;
        String[] temp = new String[n];
        for(int i =0;i<n;i++){
            temp[i] = Integer.toString(nums[i]);
            //System.out.println(temp[i]);
        }
        Arrays.sort(temp, new Comparator<String>(){
            @Override
            public int compare(String i, String j){
                String s1 = i + j;
                String s2 = j + i;
                return s2.compareTo(s1);
            }
        });
        if(temp[0].charAt(0)=='0')return "0";
        for(int i =0;i<n;i++){
            sb.append(temp[i]);
        }
        return sb.toString();
    }
}