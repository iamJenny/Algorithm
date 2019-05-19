import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Q. 주어진 DNA 서열의 특정 부분에 포함되어있는 뉴클레오티드의 영향을 최소화하는 요소는 무엇입니까. 
 *    S문자열의 P인덱스부터 Q인덱스까지의 글자 중 가장 작은 글자 찾기 
 * A. https://app.codility.com/demo/results/trainingMF8Z5P-R77/ 
 * Test Score. 37%
 * 
 * Analysis summary. wrong answers, timeout errors.
 */

class Solution1 {
    public int[] solution(String S, int[] P, int[] Q) {
        // 문자열 S를 값으로 변환, initMap(위치, 값)
        Map<Integer, Integer> initMap = new HashMap<>();
        char[] inputData = S.toCharArray();
        for (int i = 0; i < S.length(); i++) {
            switch (inputData[i]) {
            case 'A':
                initMap.put(i, 1);
                break;
            case 'C':
                initMap.put(i, 2);
                break;
            case 'G':
                initMap.put(i, 3);
                break;
            case 'T':
                initMap.put(i, 4);
                break;
            }
        }

        // (Map의 vale를 통해) 오름차순 정렬
        Map<Integer, Integer> sMap = initMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        // P.length = Q.length
        int[] result = new int[P.length];

        // P[K]와 Q[K](포함) 사이의 DNA 서열에 포함 된 뉴클레오타이드의 최소 영향 요인
        // 배열 P와 Q를 비교하며 최소값 구함
        for (int i = 0; i < P.length; i++) {
            int pValue = P[i];
            int qValue = Q[i];

            if (sMap.get(pValue) <= sMap.get(qValue)) {
                result[i] = sMap.get(pValue); // P의 최소값
            } else {
                result[i] = sMap.get(qValue); // Q의 최소값
            }
        }

        return result;
    }
}

/**
 * Q. S문자열의 P인덱스부터 Q인덱스까지의 글자 중 가장 작은 글자 찾기 
 * A. https://app.codility.com/demo/results/trainingHT7HUN-B7R/
 * Test Score. 75%
 * 
 * Analysis summary.
 * For example, for the input ('AC', [0, 0, 1], [0, 1, 1]) the solution returned a wrong answer (got [1, 2, 2] expected [1, 1, 2]).
 */

class Solution2 {
    public int[] solution(String S, int[] P, int[] Q) {
        // A, C, G의 변화에 대한 배열 (변화가 없는 경우엔 T)
        int A[] = new int[S.length() + 1]; 
        int C[] = new int[S.length() + 1];
        int G[] = new int[S.length() + 1];

        // 문자열 S를 값으로 변환
        char[] inputData = S.toCharArray();
        for (int i = 0; i < S.length(); i++) {
            switch (inputData[i]) {
            case 'A':
                A[i]++;
                break;
            case 'C':
                C[i]++;
                break;
            case 'G':
                G[i]++;
                break;
            default:
                break;
            }

            // 배열 A, C, G에 대한 이전 값에 대한 변화 값 저장
            A[i + 1] += A[i];
            C[i + 1] += C[i];
            G[i + 1] += G[i];
        }

        // P.length = Q.length
        int[] result = new int[P.length];

        // P[K]와 Q[K](포함) 사이의 DNA 서열에 포함 된 뉴클레오타이드의 최소 영향 요인
        // 배열 P와 Q를 비교하며 최소값 구함
        for (int i = 0; i < P.length; i++) {
            int startIndex = P[i];
            int endIndex = Q[i];

            if (startIndex == endIndex) {
                char c = S.charAt(startIndex);

                switch (c) {
                case 'A':
                    result[i] = 1;
                    break;
                case 'C':
                    result[i] = 2;
                    break;
                case 'G':
                    result[i] = 3;
                    break;
                case 'T':
                    result[i] = 4;
                    break;
                }
            } else if (A[startIndex] != A[endIndex]) {
                result[i] = 1;
            } else if (C[startIndex] != C[endIndex]) {
                result[i] = 2;
            } else if (G[startIndex] != G[endIndex]) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        return result;
    }
}

/**
 * Q. S문자열의 P인덱스부터 Q인덱스까지의 글자 중 가장 작은 글자 찾기 
 * A. https://app.codility.com/demo/results/trainingN73V4K-F9U/
 * Test Score. 100%
 */

class Solution3 {
    public int[] solution(String S, int[] P, int[] Q) {
        // prefix-sum algorithm
        // A, C, G의 변화에 대한 배열 (변화가 없는 경우엔 T)
        int A[] = new int[S.length() + 1]; 
        int C[] = new int[S.length() + 1]; 
        int G[] = new int[S.length() + 1];

        // 문자열 S를 값으로 변환
        char[] inputData = S.toCharArray();
        for (int i = 0; i < S.length(); i++) {
            switch (inputData[i]) {
            case 'A':
                A[i + 1]++; // A[0] = 0
                break;
            case 'C':
                C[i + 1]++; // C[0] = 0
                break;
            case 'G':
                G[i + 1]++; // G[0] = 0
                break;
            default:
                break;
            }

            // 배열 A, C, G에 대한 이전 값에 대한 변화 값 저장
            A[i + 1] += A[i];
            C[i + 1] += C[i];
            G[i + 1] += G[i];
        }

        // P.length = Q.length
        int[] result = new int[P.length];

        // P[K]와 Q[K](포함) 사이의 DNA 서열에 포함 된 뉴클레오타이드의 최소 영향 요인
        // 배열 P와 Q를 비교하며 최소값 구함
        for (int i = 0; i < P.length; i++) {
            int startIndex = P[i];
            int endIndex = Q[i];

            if (startIndex == endIndex) {
                char c = S.charAt(startIndex);

                switch (c) {
                case 'A':
                    result[i] = 1;
                    break;
                case 'C':
                    result[i] = 2;
                    break;
                case 'G':
                    result[i] = 3;
                    break;
                case 'T':
                    result[i] = 4;
                    break;
                }
            } else if (A[startIndex] != A[endIndex + 1]){ // 배열의 마지막에 변화한 값이 들어가므로 endIndex + 1 까지 비교
                result[i] = 1;
            } else if (C[startIndex] != C[endIndex + 1]) {
                result[i] = 2;
            } else if (G[startIndex] != G[endIndex + 1]) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        return result;
    }
}