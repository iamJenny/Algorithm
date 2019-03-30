import java.util.*;

/**
 * Q. 정수(N)의 이진 표현에서 0의 가장 긴 순서를 찾아라.
 * A. https://app.codility.com/demo/results/trainingYTHXWU-CCP/
 * Test Score. 33%
 */
class Solution {
    public int solution(int N) {
        // 정수 n에 대한 2진수(각 자릿수의 0과 1)를 배열로 저장
        List<Integer> binary = new ArrayList<Integer>();
        boolean flag = true;

        while (flag) {
            int remainder = N % 2;

            binary.add(remainder);
            N = N / 2;

            if (N <= 1) {
                binary.add(N);
                flag = false;
            } else {
                flag = true;
            }
        }

        // 저장된 2진수 배열을 리스트 역순 조회
        // 2진수의 0의 갯수 확인
        List<Integer> zeroCntArray = new ArrayList<Integer>();
        int zeroCnt = 0;

        for (int binaryIndex = binary.size() - 1; binaryIndex > 0; binaryIndex--) {
            if (binary.get(binaryIndex) == 1) {
                zeroCntArray.add(zeroCnt);
                zeroCnt = 0;
            } else {
                zeroCnt += 1;
            }
        }

        // 2진수의 0의 갯수가 없는 경우
        if (zeroCntArray.size() == 0) {
            zeroCntArray.add(0);
        }

        return (int) Collections.max(zeroCntArray);
    }
}