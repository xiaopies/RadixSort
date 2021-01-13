public class Radix{
  public static int nth(int n, int col){
    n = Math.abs(n);
    double ten = Math.pow(10, col);
    if (n<ten){
      return -1;
    }
    else{
      String cheat = "" + n;
      return Integer.parseInt(cheat.substring(cheat.length()-col-1, cheat.length()-col));
    }
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
    int counter = 0;

    int size = 0;
    while (data.size() >0){
      int here = data.remove(counter);
      if (length(here)>size){
        size = length(here);
      }
      int digit = nth(here, 0);
      now[digit].add(here);
      counter ++;
    }
    for (int i = 1; i< size; i++){
      now = shush(now, i);
    }
  }
  private static SortableLinkedList[] shush(SortableLinkedList[] in, int sig){
    SortableLinkedList one = new SortableLinkedList();
    SortableLinkedList[] two = new SortableLinkedList[10];
    merge(one, in);
    int counter =0;

    while (one.size()>0){
      int here = one.remove(counter);
      int digit = 0;
      if (here>= Math.pow(10, counter)){
        digit = nth(here,sig);
      }
      two[digit].add(here);
      counter ++;
    }
    return two;
  }
  public static void radixSort(SortableLinkedList data){


  }


}
