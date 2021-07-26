package backjoon;

public class Solution1712 {
    public static void main(String[] args) {
        int fixedPay = 1000;
        int variablePay = 70;
        int sellPay = 170;
        System.out.println(solution(fixedPay, variablePay, sellPay));
    }

    private static int solution(int fixedPay, int variablePay, int sellPay) {
        if(variablePay > sellPay) {
            return -1;
        }
        int productPay = fixedPay + variablePay;
        int eachSellPay = sellPay;
        int cnt = 1;
        while(productPay >= sellPay) {
            productPay += variablePay;
            sellPay += eachSellPay;
            cnt++;
        }
        System.out.println(productPay);
        System.out.println(sellPay);

        return cnt;

    }
}
