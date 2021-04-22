package fabernovel;

public class SuperDigit {

    public static void main(String[] args) {
        SuperDigit superDigit = new SuperDigit();
        System.out.println(superDigit.getSuperDigit(148, 3));
    }

    public int computeNumber(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder.append(n);
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    public int computeSum(int number) {
        char[] chars = String.valueOf(number).toCharArray();
        int result = 0;
        for (Character c : chars) {
            result += Character.getNumericValue(c);
        }
        return result;
    }

    public int getSuperDigit(int n, int k) {
        int number = this.computeNumber(n, k);
        int result = computeSum(number);
        while (result > 10) {
            result = computeSum(result);
        }
        return result;
    }
}
