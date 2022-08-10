
import java.util.List;
import java.util.Arrays;

public class Day2Calculator {
        public static void main(String[] args) {
            int[] a={1,2,3,4};
            String[] b={"Sub", "Mul", "Div"};
            int result1 = calculator(a,b);
            System.out.println(result1);
        }
        public static int calculator (int[] nums, String [] operators) {
            if (nums.length- operators.length !=1) return -1;
            List<Integer> list1 = new java.util.ArrayList<>(Arrays.stream(nums).boxed().toList());
            List<String> list2 = new java.util.ArrayList<>(Arrays.stream(operators).toList());
            int result=0;
            int i=0;
            while(i<list2.size())  // do mul and div fist
            {   if (list2.get(i).equals("Mul"))  {list2.remove(i); result= list1.get(i) * list1.get(i + 1); list1.set(i, result); list1.remove(i+1);}
                else if (list2.get(i).equals("Div")&& nums[i+1]!=0) {list2.remove(i); result= list1.get(i) / list1.get(i + 1); list1.set(i, result); list1.remove(i+1);}
                else i++;
            }
            i=0;
            while(!list2.isEmpty()) // then add and sub
            {   if (list2.get(i).equals("Add"))  {list2.remove(i); result= list1.get(i) +list1.get(i + 1); list1.set(i, result); list1.remove(i+1);}
                else if (list2.get(i).equals("Sub")&& nums[i+1]!=0) {list2.remove(i); result= list1.get(i)-list1.get(i + 1); list1.set(i, result); list1.remove(i+1);}
                else i++;
            }
            return result;
        }

}
