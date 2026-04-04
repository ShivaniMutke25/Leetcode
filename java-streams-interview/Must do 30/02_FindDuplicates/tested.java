// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.util.stream.Collectors;
class Main {
    public static List<Integer> findDuplicates(List<Integer> numbers){
        return numbers.stream()//convert list -> stream
               .collect(Collectors.groupingBy(
                    num->num, //group by number itself
                    Collectors.counting() //count how many times it appears
                   ))
                   .entrySet()
                   .stream()
                   .filter(entry->entry.getValue()>1)
                   .map(Map.Entry::getKey)
                   .collect(Collectors.toList());
    }
    public static Set<Integer> findDuplicatesAsSet(List<Integer> numbers){
        return numbers.stream()
               .collect(Collectors.toMap(
                    num -> num, //key = number
                   num->1L,
                   Long::sum
            ))
            .entrySet()//take only entryset
            .stream()//convert it into stream
            .filter(entry->entry.getValue()>1)//filter condition
            .map(Map.Entry::getKey)
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1,2,3,2,4,2,2,3,3);
    System.out.println(findDuplicates(numbers));
      System.out.println(findDuplicatesAsSet(numbers));   
    }
//     output:
// [2, 3]
// [2, 3]
}
