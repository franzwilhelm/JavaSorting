import java.util.Random;
import java.util.Arrays;

class Sort {
  private int[] original;
  private int[] a;

  public Sort(int[] original) {
    this.original = original;
  }

  public void newSource(int[] src) {
    this.original = original;
  }

  public static int[] randomArray(int len) {
    int[] a = new int[len];
    for (int i = 0; i < len; i++) {
      a[i] = (new Random()).nextInt(len);
    }
    return a;
  }

  /*
  * INSERTION SORT
  * Can be called with from/to-pointers or without
  * to sort the whole array;
  */
  public int[] reverseInsertion() {
    return insertion(0, original.length, true);
  }

  public int[] insertion() {
    return insertion(0, original.length, false);
  }

  public int[] insertion(int from, int to, boolean reverse) {
    prepare();
    for (int i = from; i < to; i++) {
      for (int j = to - 1; j > i; j--) {
        if ((!reverse && a[j] < a[i]) || (reverse && a[j] > a[i])) {
          swap(i, j);
        }
      }
    }
    return a;
  }

  /*
  * QUICKSORT
  */
  public void quickSort() {
    prepare();
    quick(a, 0, a.length);
  }

  int depth = 0;
  private void quick(int a[], int left, int right) {
    if (right - left <= 1) return;
    int pivot = a[right-1];
    int index = left;

    for (int i = left; i < right-1; i++) {
      if (a[i] <= pivot) {
        swap(index, i);
        index++;
      }
    }
    swap(index,right-1);
    quick(a, left, index);
    print(left, right);
    quick(a, index, right);
  }

  void offset() {
    for (int i = 0; i < depth; i++) {
      System.out.print(" ");
    }
  }

  /*
  * Helper methods
  */
  private void print(int left, int right) {
    print("\u001B[37m", 0, left);         // white
    print("\u001B[34m", left, right);     // blue
    print("\u001B[37m", right, a.length); // white
    System.out.println("\u001B[0m");
  }

  private void print(String color, int left, int right) {
    for (int i = left; i < right; i++) {
      System.out.print(color + a[i]);
      if (i != a.length-1) System.out.print(", ");
    }
  }

  private void swap(int i1, int i2) {
    int tmp = a[i1];
    a[i1] = a[i2];
    a[i2] = tmp;
  }

  private void prepare() {
    a = original.clone();
  }

  @Override
  public String toString() {
    return Arrays.toString(a);
  }

}
