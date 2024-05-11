import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();


        for (int i = 0; i < num; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            PriorityQueue<Document> queue = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐 생성

            for (int j = 0; j < N; j++) {
                int priority = scanner.nextInt(); // 문서의 중요도
                queue.add(new Document(j, priority)); // 문서의 인덱스와 중요도를 우선순위 큐에 추가
            }

            int count = 0; // 출력된 문서의 개수

            while (!queue.isEmpty()) {
                Document doc = queue.poll(); // 우선순위가 가장 높은 문서를 가져옴
                count++;

                if (doc.index == M) { // 목표 문서를 찾았을 경우
                    System.out.println(count); // 출력된 순서 출력
                    break;
                }
            }
        }
    }


    static class Document implements Comparable<Document> {
        int index; // 문서의 인덱스
        int priority; // 문서의 중요도

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}