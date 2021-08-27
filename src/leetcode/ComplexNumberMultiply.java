package leetcode;


public class ComplexNumberMultiply {
    public String complexNumberMultiply(String num1, String num2) {
        String[] a = num1.split("\\+|i");
        String[] b = num2.split("\\+|i");
        int ar = Integer.parseInt(a[0]), ai = Integer.parseInt(a[1]);
        int br = Integer.parseInt(b[0]), bi = Integer.parseInt(b[1]);
        return String.format("%d+%di",ar*br -ai*bi, ar*bi + ai*br);
    }

    public static void main(String[] args) {
        ComplexNumberMultiply obj = new ComplexNumberMultiply();
        System.out.println(obj.complexNumberMultiply("1+-1i", "1+1i"));
        System.out.println(obj.complexNumberMultiply("1+1i", "1+1i"));
    }
}
