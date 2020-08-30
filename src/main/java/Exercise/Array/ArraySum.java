package Exercise.Array;


/**
 * 有 N 个的正整数放到数组 A 里，现在要求一个新的数组 B，新数组的第 i 个数 B[i]是原数组 A 第 0 到第 i 个数的和
 */
public class ArraySum {

    public static void main(String[] args) {
        int[] oldArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int c = 7;
        int[] newArray = new ArraySum().ArraySum(oldArray, c);
        for (int i : newArray) {
            System.out.print(i + "\t");
        }
    }


    public int[] ArraySum(int[] array, int c) {
        int[] newArray = new int[c];
        int sum = 0;
        for (int i = 0; i < c; i++) {
            sum += array[i];
            newArray[i] = sum;
        }
        return newArray;
    }
}
