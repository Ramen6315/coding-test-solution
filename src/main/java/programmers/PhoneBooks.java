package programmers;

import java.util.HashMap;

public class PhoneBooks {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String phoneNumber : phone_book) {
            hashMap.put(phoneNumber, 0);
        }
        for (String phone : hashMap.keySet()) {
            for (int j = 1; j < phone.length(); j++) {
                if(hashMap.containsKey(phone.substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
