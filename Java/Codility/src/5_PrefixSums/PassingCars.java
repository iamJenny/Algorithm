import java.util.List;
import java.util.ArrayList;

/**
 * Q. 동쪽과 서쪽으로 지나가는 차량의 쌍의 수를 알아내라.
 * A. https://app.codility.com/demo/results/trainingZJCM4N-PGV/
 * Test Score. 60%
 * Time complexity. O(N ** 2)
 *
 * Analysis summary.
 * timeout errors.
 */
class Solution1 {
    public int solution(int[] A) {
        List<Integer> eastCars = new ArrayList<>(); // 동쪽 차량
        List<Integer> westCars = new ArrayList<>(); // 서쪽 차량

        // A의 값이 0이면 동쪽 차량, 1이면 서쪽 차량으로 분류
        for (int carNum = 0; carNum < A.length; carNum++) {
            if (A[carNum] == 0) {
                eastCars.add(carNum);
            } 
            else {
                westCars.add(carNum);
            }
        }

        // 차량의 쌍(P, Q)의 수를 계산
        // 0 ≤ P(동쪽) < Q(서쪽) < N
        int result = 0;
        for (int eastCar : eastCars) {
            for (int westCar : westCars) {
                if (eastCar < westCar) {
                    result++;
                }
            }
        }

        // 차량의 쌍의 수가 1,000,000,000을 초과하면이 함수는 -1을 반환
        if (result > 100000000) {
            result = -1;
        }

        return result;
    }
}

/**
 * Q. 동쪽과 서쪽으로 지나가는 차량의 쌍의 수를 알아내라.
 * A. https://app.codility.com/demo/results/trainingNU624J-M8T/
 * Test Score. 80%
 * Time complexity. O(N)
 *
 * Analysis summary.
 * wrong answers.
 */
class Solution2 {
    public int solution(int[] A) {
        int result = 0; // 최종 결과
        int midSum = 0; // 중간 결과
        int cnt = 0; // 최종 결과에 중간 결과를 더한 계산을 반복한 횟수

        // 0 ≤ P(동쪽) < Q(서쪽) < N
        // A의 값이 0이면 동쪽 차량과 서쪽 차량의 쌍의 수 계산, 1이면 서쪽 차량이 나온 횟수 계산
        for (int carNum = 0; carNum < A.length; carNum++) {
            if (A[carNum] == 0) {
                result = result + midSum * cnt;
                midSum = 0;
                cnt++;
            } 
            else {
                midSum++;
            }
        }
        
        // 마지막 차량이 서쪽으로 최종 결과를 더하지 않고 끝났을 경우
        result = result + midSum * cnt;

        // 차량의 쌍의 수가 1,000,000,000을 초과하면이 함수는 -1을 반환
        if (result > 100000000) {
            result = -1;
        }

        return result;
    }
}

