public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;

        try {
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }

            double average = (double) sum / arr.length;
            System.out.println("Average: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: Index out of bounds");
        } catch (NumberFormatException e) {
            System.err.println("Error: Element in the array is not a number");
        }
    }
}
