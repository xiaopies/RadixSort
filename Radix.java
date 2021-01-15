public class Radix{
  public static int nth(int n, int col){
    n = n / (int) Math.pow(10, col);
    return n % 10;
    // int num = 0;
    // String cheat = "" + n;
    // if (length(n)>col) {
    //   num =  Integer.parseInt(cheat.substring(cheat.length()-col-1, cheat.length()-col));
    // }
    // return num;
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
      now[Math.abs(digit)].add(here);
    }
    merge (data, now);
    for (int i = 1; i< biggie; i++){
      while (data.size()> 0){
        int here = data.remove(0);
        int digit = nth(here, i);
        now[Math.abs(digit)].add(here);
      }
      merge(data, now);
    }
  }
  public static void radixSort(SortableLinkedList data){
    SortableLinkedList[] now= new SortableLinkedList[19];
    for (int i= 0; i<19; i++){
      now[i] = new SortableLinkedList();
    }
    int biggie = 0;
    while (data.size() >0){
      int here = data.remove(0);
      if (length(here)>biggie){
        biggie = length(here);
      }
      int digit = nth(here, 0);
      now[digit+9].add(here);
    }
    merge (data, now);
    for (int i = 1; i< biggie; i++){
      while (data.size()> 0){
        int here = data.remove(0);
        int digit = nth(here, i);
        now[digit+9].add(here);
      }
      merge(data, now);
    }
  }




  // public static void radixSort(SortableLinkedList data){
  //   radixSortSimple(data);
  //   SortableLinkedList[] now= new SortableLinkedList[2];
  //   for (int i= 0; i<2; i++){
  //     now[i] = new SortableLinkedList();
  //   }
  //   while (data.size()> 0){
  //     int last = data.get(data.size()-1);
  //     if (here < 0){
  //       int here = data.remove(data.size()-1);
  //       now[0].add(here);
  //     }
  //   }
  //  merge(data, now);
  //
  // }
  // private static void lastdata(SortableLinkedList data){
  //   return data.end.
  // }


}
