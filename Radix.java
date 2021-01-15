public class Radix{
  public static int nth(int n, int col){
    int num = 0;
    String cheat = "" + n;
    if (length(n)>col) {
      num =  Integer.parseInt(cheat.substring(cheat.length()-col-1, cheat.length()-col));
    }
    return num;
  }
  public static int length(int n){
    n = Math.abs(n);
    String cheat = "" + n;
    return cheat.length();
  }
  public static void merge( SortableLinkedList original, SortableLinkedList[]buckets){
    for (int i =0; i<buckets.length; i++){
      original.extend(buckets[i]);
    }
  }
  public static void radixSortSimple(SortableLinkedList data){
    SortableLinkedList[] now= new SortableLinkedList[10];
    for (int i= 0; i<10; i++){
      now[i] = new SortableLinkedList();
    }
    int biggie = 0;
    while (data.size() >0){
      int here = data.remove(0);
      if (length(here)>biggie){
        biggie = length(here);
      }
      int digit = nth(here, 0);
      now[digit].add(here);
    }
    merge (data, now);
    for (int i = 1; i< biggie; i++){
      while (data.size()> 0){
        int here = data.remove(0);
        int digit = nth(here, i);
        now[digit].add(here);
      }
      merge(data, now);
    }
  }

  public static void radixSort(SortableLinkedList data){

  }


}
