// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.util.stream.Collectors;
class Main {
    public static Map<Integer,Long> frequencyOfElements(List<Integer> numbers){
        return numbers.stream()//convert list -> stream
               .collect(Collectors.groupingBy(
                    num->num, //group by number itself
                    Collectors.counting() //count how many times it appears
                   ));
    }
    public static Map<Integer,Long> frequencyOfElementsAlternative(List<Integer> numbers){
        return numbers.stream()
               .collect(Collectors.toMap(
                    num -> num, //key = number
                    num ->1L, //every number initailly has count1
                    Long::sum//if duplicat add counts
            ));
    }
    public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1,2,3,2,2,2,3,3);
    System.out.println(frequencyOfElements(numbers));
      System.out.println(frequencyOfElementsAlternative(numbers));   
    }
//     output:
// {1=1, 2=4, 3=3}
// {1=1, 2=4, 3=3}
}
