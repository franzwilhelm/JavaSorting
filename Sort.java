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
      print(from, i);
      for (int j = to - 1; j > i; j--) {
        if ((!reverse && a[j] < a[i]) || (reverse && a[j] > a[i])) {
          print(from, i, j);
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

  private void quick(int a[], int left, int right) {
    if (right - left <= 1) return;
    int pivot = a[right-1];
    int index = left;

    for (int i = left; i < right - 1; i++) {
      if (a[i] <= pivot) {
        swap(index, i);
        index++;
      }
    }
    swap(index, right - 1);
    quick(a, left, index);
    print(left, right);
    quick(a, index, right);
  }

  /*
  * MERGE SORT
  * Can be called with from/to-pointers or without
  * to sort the whole array;
  */
  void mergeSort() {
    prepare();
    mergeSort(0, a.length);
  }

  void mergeSort(int l, int r) {
    if (r - l < 2) return;
    int m = (l + r) / 2;

    mergeSort(l, m);
    mergeSort(m, r);

    print(l / 2, l, m, r);

    int[] left = new int[m - l];
    int[] right  = new int[r - m];
    for (int i = l; i < m; i++) left[i - l] = a[i];
    for (int i = m; i < r; i++) right[i - m] = a[i];

    int i = 0, j = 0;
    while(i < left.length && j < right.length) {
      if (left[i] <= right[j]) {
        a[l + i + j] = left[i];
        i++;
      } else {
        a[l + i + j] = right[j];
        j++;
      }
    }
    for (; i < left.length; i++) a[l + i + j] = left[i];
    for (; j < left.length; j++) a[l + i + j] = right[j];
  }

  /*
  * Helper methods
  */
  private final static String BLACK = "\u001B[30m", WHITE = "\u001B[37m", BLUE = "\u001B[34m", RED = "\u001B[31m", RESET = "\u001B[0m";
  private void print(int leftleft, int left, int mid, int right) {
    print(BLACK, leftleft, left);
    print(BLUE, left, mid);
    print(RED, mid, right);
    System.out.println(RESET);
  }

  private void print(int left, int mid, int right) {
    print("\u001B[32m", 0, left);
    print(BLUE, left, mid);
    print(RED, mid, right);
    System.out.println(RESET);
  }

  private void print(int left, int right) {
    print(WHITE, 0, left);
    print(BLUE, left, right);
  }

  private void print(String color, int left, int right) {
    String s = color;
    for (int i = left; i < right; i++) {
      s += a[i];
      if (i != a.length-1) s += ", ";
    }
    System.out.print(s + RESET);
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
