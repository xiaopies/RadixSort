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
}
