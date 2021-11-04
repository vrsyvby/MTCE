import java.util.*;

public class Phenom {

    static int maxOccurrence=0;

/*
   // String s="abcdssabcdax";

    problems:
      1. getting the individual occurrences
      2. arranging the elements as per their occurrence
      3. if there is a collision in occurrence, then maintain the order of elements as per their index
      4. find the index of element as per occurrence.

    */

    static boolean findPosition(String token, String value, String original){

        if(original.indexOf(token)>original.indexOf(value)){
            return true;
        }

        return false;

    }

    static LinkedList<String> adjustByCollision(LinkedList<String> elements, String value, String original){
            int position=0;
            for(int i=0;i<elements.size();i++){
              String token= elements.get(i);
              if(!findPosition(token, value, original)){
                  position++;
              }
            }
            elements.add(position,value);
            return elements;
    }

   static LinkedList<String>[] orderByOccurrence(Map<String, Integer> Occurrence, String original, int maxOccurrence){
       LinkedList<String>[] ordered= new LinkedList[maxOccurrence+1];

        for(Map.Entry<String,Integer> eachOccurrence:Occurrence.entrySet()){

            int rep= eachOccurrence.getValue();
            String value= eachOccurrence.getKey();

            LinkedList<String> elements= ordered[rep];
            if(elements!=null && elements.size()!=0 ){

                elements= adjustByCollision(elements, value, original);

            }else{
                elements= new LinkedList<>();
                elements.add(value);
                ordered[rep]=elements;

            }


        }
      return ordered;

    }


    static Map<String, Integer> findTheIndividualOccurrence(char[] tokens){
        Map<String, Integer> Occurrence= new HashMap<>();

        for(int i=0;i<tokens.length;i++){
            String token= String.valueOf(tokens[i]);
            if(Occurrence.containsKey(token)){
                int occur= Occurrence.get(token);
                Occurrence.put(token, ++occur);
                if(maxOccurrence<occur){
                    maxOccurrence=occur;
                }

            }else{
                Occurrence.put(token,1);
            }
    }

        return Occurrence;
   }

    public static void main(String[] args){

        String s="abcdssabcdax";
        //solution(s);
        Map<String,Integer>  Occurrences= findTheIndividualOccurrence(s.toCharArray());
        LinkedList<String>[] reps= orderByOccurrence(Occurrences,s,maxOccurrence);

        Arrays.stream(reps).filter(e-> e!=null).forEach(System.out::println);

         s="abcddd";
        //solution(s);
         Occurrences= findTheIndividualOccurrence(s.toCharArray());
         reps= orderByOccurrence(Occurrences,s,maxOccurrence);

        Arrays.stream(reps).forEach(System.out::println);


    }
}
