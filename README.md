Dưới đây là toàn bộ tài liệu ôn tập “Cấu trúc Dữ liệu & Giải thuật” bằng Java 13, được soạn theo cách tiếp cận end-to-end, step by step từ đầu đến cuối. Tài liệu này bao gồm:

- Phân tích đề bài và quy trình giải quyết vấn đề chung  
- Các cấu trúc dữ liệu cơ bản (List, ArrayList, LinkedList, Map, Set, Stack, Queue, PriorityQueue)  
- Đệ quy (Recursion)  
- Backtracking & Branch and Bound (với phân biệt hàm check và pruning)  
- Dynamic Programming (DP) với khung chung, các ví dụ (LIS, 0/1 Knapsack, Truck Route)  
- Các thuật toán đồ thị: Biểu diễn đồ thị, DFS, BFS, Union-Find, Kruskal, Dijkstra  
- Phương pháp tiếp cận chung cho các dạng bài  
- Câu hỏi gợi mở & tư duy chủ động  
- Kết luận và gợi ý thực hành

Mỗi phần đều có code mẫu với chú thích chi tiết để bạn có thể hiểu rõ từng bước.  
 
---

## 1. GIỚI THIỆU VÀ QUY TRÌNH GIẢI BÀI TOÁN

Trước khi giải bài toán, bạn cần làm theo các bước sau:

1. **Phân tích đề bài:**  
   - Xác định đầu vào, đầu ra, và các ràng buộc của bài toán.
2. **Lựa chọn cấu trúc dữ liệu phù hợp:**  
   - Dựa vào tính chất của dữ liệu (sắp xếp, truy cập ngẫu nhiên, chèn/xóa, v.v.).
3. **Đề xuất giải thuật:**  
   - Xác định bài toán thuộc loại nào (tìm kiếm, tối ưu, duyệt đồ thị, …) và chọn giải thuật thích hợp (đệ quy, backtracking, DP, DFS, …).
4. **Triển khai bằng Java 13:**  
   - Viết code có chú thích chi tiết từng bước.
5. **Phân tích độ phức tạp & tối ưu hóa:**  
   - Xác định Time Complexity và Space Complexity, sau đó tối ưu nếu cần.
6. **Gợi ý:** Luôn viết pseudocode hoặc sơ đồ luồng trước khi code để hình dung các bước giải quyết.

---

## 2. CÁC CẤU TRÚC DỮ LIỆU CƠ BẢN

### 2.1 List, ArrayList và LinkedList

#### ArrayList (Ví dụ với chú thích chi tiết)

```java
import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // Khởi tạo ArrayList để lưu trữ chuỗi ngôn ngữ lập trình.
        List<String> languages = new ArrayList<>();

        // Thêm các phần tử vào danh sách
        languages.add("Java");    // Thêm "Java" vào cuối danh sách
        languages.add("C++");     // Thêm "C++" vào cuối danh sách
        languages.add("Python");  // Thêm "Python" vào cuối danh sách

        // Truy cập phần tử theo chỉ số (0-indexed)
        System.out.println("Ngôn ngữ đầu tiên: " + languages.get(0));

        // Duyệt danh sách và in ra từng phần tử
        for (String lang : languages) {
            System.out.println("Ngôn ngữ: " + lang);
        }
    }
}
```

#### LinkedList (Ví dụ với chú thích chi tiết)

```java
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        // Khởi tạo LinkedList để lưu trữ chuỗi từ khóa.
        List<String> words = new LinkedList<>();

        // Thêm các phần tử vào danh sách
        words.add("Data");
        words.add("Structure");
        words.add("Algorithm");

        // Nếu cần thêm phần tử ở đầu danh sách, ép kiểu sang LinkedList
        ((LinkedList<String>) words).addFirst("Introduction");

        // Duyệt danh sách với hàm forEach
        words.forEach(word -> System.out.println("Từ: " + word));
    }
}
```

---

### 2.2 Map và Set

#### HashMap (Ví dụ với chú thích chi tiết)

```java
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Khởi tạo HashMap với key kiểu Integer và value kiểu String
        Map<Integer, String> map = new HashMap<>();

        // Thêm các cặp key-value vào Map
        map.put(1, "Một");
        map.put(2, "Hai");
        map.put(3, "Ba");

        // Duyệt qua Map và in ra từng cặp key-value
        map.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });
    }
}
```

#### HashSet (Ví dụ với chú thích chi tiết)

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        // Khởi tạo HashSet để lưu trữ các chuỗi (sẽ không chứa phần tử trùng lặp)
        Set<String> fruits = new HashSet<>();

        // Thêm các phần tử vào Set
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // "Apple" không được thêm lại

        // Duyệt qua Set và in ra các phần tử
        fruits.forEach(fruit -> System.out.println("Trái cây: " + fruit));
    }
}
```

---

### 2.3 Stack, Queue và PriorityQueue

#### Stack (Ví dụ với chú thích chi tiết)

```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // Khởi tạo Stack chứa các số nguyên
        Stack<Integer> stack = new Stack<>();

        // Đưa các phần tử vào stack (push)
        stack.push(10); // Push 10
        stack.push(20); // Push 20
        stack.push(30); // Push 30

        // Xem phần tử đỉnh của stack mà không xóa (peek)
        System.out.println("Phần tử đỉnh: " + stack.peek());

        // Lấy và xóa phần tử đỉnh (pop)
        System.out.println("Pop: " + stack.pop());
    }
}
```

#### Queue (Ví dụ với chú thích chi tiết)

```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Khởi tạo Queue sử dụng LinkedList
        Queue<String> queue = new LinkedList<>();

        // Thêm các phần tử vào Queue (offer)
        queue.offer("Task1"); // Thêm Task1 vào cuối queue
        queue.offer("Task2"); // Thêm Task2
        queue.offer("Task3"); // Thêm Task3

        // Xem phần tử đầu của queue (peek)
        System.out.println("Phần tử đầu: " + queue.peek());

        // Lấy và xóa phần tử đầu của queue (poll)
        System.out.println("Poll: " + queue.poll());
    }
}
```

#### PriorityQueue (Ví dụ với chú thích chi tiết)

```java
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Khởi tạo PriorityQueue cho số nguyên (mặc định sắp xếp theo thứ tự tăng dần)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Thêm các phần tử vào PriorityQueue
        pq.offer(30);
        pq.offer(10);
        pq.offer(20);

        // Khi lấy phần tử, PriorityQueue trả về phần tử có thứ tự ưu tiên cao nhất (ở đây là nhỏ nhất)
        while (!pq.isEmpty()) {
            System.out.println("Phần tử ưu tiên: " + pq.poll());
        }
    }
}
```

---

## 3. ĐỆ QUY (RECURSION)

### Lý thuyết
- **Đệ quy:** Là phương pháp giải bài toán bằng cách gọi lại chính nó với bài toán con nhỏ hơn.
- **Điều kiện dừng:** Phải xác định rõ để tránh vòng lặp vô hạn.

### Ví dụ: Tính giai thừa với chú thích chi tiết

```java
public class RecursionFactorial {
    // Hàm tính giai thừa của n bằng phương pháp đệ quy
    public static long factorial(int n) {
        // Nếu n <= 1, trả về 1 (điều kiện dừng)
        if (n <= 1) return 1;
        // Gọi đệ quy: n * giai thừa của (n-1)
        return n * factorial(n - 1);
    }
    
    public static void main(String[] args) {
        int number = 5;
        // In ra kết quả của giai thừa
        System.out.println("Giai thừa của " + number + " là " + factorial(number));
    }
}
```

---

## 4. BACKTRACKING & BRANCH AND BOUND

### Lý thuyết  
- **Backtracking:** Duyệt qua không gian giải pháp bằng cách thử từng lựa chọn, sau đó quay lui khi gặp trường hợp không hợp lệ.  
- **Branch and Bound (Cắt nhánh):** Sau khi có lời giải một phần, ước tính “bound” (giới hạn trên hoặc dưới) của nhánh hiện tại; nếu bound không hứa hẹn cải thiện lời giải hiện có, cắt bỏ nhánh đó.

### Phân biệt Check và Pruning
- **Hàm check:**  
  - Mục đích: Kiểm tra candidate tại bước \( k \) có thỏa mãn các ràng buộc cơ bản không.  
  - Ví dụ: Trong N-Queens, kiểm tra xem đặt quân hậu tại (row, col) có bị tấn công từ các quân hậu đã đặt trước không.
- **Hàm pruning:**  
  - Mục đích: Ước lượng khả năng mở rộng lời giải hiện tại. Nếu bound của nhánh hiện tại không thể cải thiện lời giải tối ưu, dừng duyệt nhánh đó sớm.
  - Ví dụ: Trong 0/1 Knapsack, bạn có thể tính bound bằng phương pháp “Fractional Knapsack” (dù đồ vật không chia nhỏ được, dùng để ước lượng).

### Ví dụ: N-Queens với chú thích chi tiết

```java
import java.util.ArrayList;
import java.util.List;

public class NQueens {
    private int n; // Kích thước bàn cờ n x n
    private List<List<String>> solutions = new ArrayList<>(); // Lưu các cấu hình lời giải hợp lệ

    public NQueens(int n) {
        this.n = n;
    }
    
    // Hàm giải N-Queens: Trả về danh sách các cấu hình hợp lệ
    public List<List<String>> solveNQueens() {
        int[] board = new int[n]; // board[i] lưu chỉ số cột đặt quân hậu ở hàng i
        backtrack(board, 0);
        return solutions;
    }
    
    // Hàm backtracking: row là chỉ số hàng hiện tại cần xử lý
    private void backtrack(int[] board, int row) {
        // Nếu đã xử lý hết các hàng, nghĩa là tìm được lời giải hoàn chỉnh
        if (row == n) {
            solutions.add(generateBoard(board));
            return;
        }
        // Duyệt qua các cột tại hàng hiện tại
        for (int col = 0; col < n; col++) {
            // Hàm check: kiểm tra xem đặt quân hậu tại (row, col) có hợp lệ không
            if (!isValid(board, row, col)) continue; // Nếu không hợp lệ, bỏ qua candidate này
            
            // Nếu hợp lệ, đặt quân hậu tại (row, col)
            board[row] = col;
            
            // (Hàm pruning có thể được chèn ở đây: ước lượng bound của nhánh hiện tại, nếu không hứa hẹn, quay lui)
            // Ví dụ: if (shouldPrune(board, row)) continue;
            
            // Gọi đệ quy xử lý hàng tiếp theo
            backtrack(board, row + 1);
        }
    }
    
    // Hàm check: Kiểm tra xem quân hậu tại (row, col) có bị tấn công không
    private boolean isValid(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            // Kiểm tra cùng cột hoặc trên đường chéo
            if (board[i] == col || Math.abs(board[i] - col) == row - i)
                return false;
        }
        return true;
    }
    
    // Hàm chuyển board (mảng chỉ số cột) thành cấu hình bàn cờ dạng List<String>
    private List<String> generateBoard(int[] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            // Với mỗi hàng, nếu chỉ số cột bằng board[i] thì in "Q", ngược lại in "."
            for (int j = 0; j < n; j++) {
                sb.append(board[i] == j ? "Q" : ".");
            }
            result.add(sb.toString());
        }
        return result;
    }
    
    public static void main(String[] args) {
        // Ví dụ N-Queens với bàn cờ 4x4
        NQueens nq = new NQueens(4);
        List<List<String>> sols = nq.solveNQueens();
        // In từng cấu hình lời giải
        for (List<String> sol : sols) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println(); // Dòng trắng giữa các lời giải
        }
    }
}
```

---

## 5. DYNAMIC PROGRAMMING (QUY HOẠCH ĐỘNG)

### 5.1 Khung chung cho DP
1. **Xác định trạng thái (State):**  
   - Chọn các biến cần lưu trữ kết quả bài toán con. Ví dụ: \(dp[i]\) hoặc \(dp[i][j]\).
2. **Diễn giải trạng thái:**  
   - Giải thích ý nghĩa của mỗi trạng thái (ví dụ: trong LIS, \(dp[i]\) là độ dài dãy con tăng dài nhất kết thúc tại \(i\)).
3. **Trạng thái cơ sở (Base Cases):**  
   - Đặt giá trị ban đầu cho các trạng thái.
4. **Công thức truy hồi (Recurrence Relation):**  
   - Xác định các lựa chọn “lấy” và “không lấy” (nếu cần) và sử dụng hàm max, min để chọn lựa chọn tối ưu.
5. **Chiến lược triển khai:**  
   - Sử dụng phương pháp Top-Down (Memoization) hoặc Bottom-Up (Tabulation).

### 5.2 Ví dụ: Longest Increasing Subsequence (LIS)

```java
public class LIS {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // Mỗi phần tử độc lập là dãy con có độ dài 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        // Cập nhật dp[i] bằng cách xét tất cả các phần tử trước đó
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) { // Nếu nums[i] có thể nối vào dãy tăng kết thúc tại j
                    dp[i] = Math.max(dp[i], dp[j] + 1); // Cập nhật độ dài tối ưu
                }
            }
        }
        int max = 0;
        // Tìm độ dài dãy con tăng dài nhất
        for (int len : dp) {
            max = Math.max(max, len);
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Độ dài của LIS: " + lengthOfLIS(nums));
    }
}
```

### 5.3 Ví dụ: 0/1 Knapsack

```java
public class KnapsackDP {
    public static int knapsack(int[] weight, int[] value, int W) {
        int n = weight.length;
        // dp[i][w] lưu giá trị tối đa với i đồ vật và sức chứa w
        int[][] dp = new int[n + 1][W + 1];
        
        // Duyệt qua các đồ vật từ 1 đến n (sử dụng chỉ số 1-indexed cho dp, nhưng mảng weight, value là 0-indexed)
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                // Nếu trọng lượng của đồ vật i (weight[i-1]) không vượt w
                if (weight[i - 1] <= w) {
                    // Lựa chọn: không lấy hoặc lấy đồ vật i
                    dp[i][w] = Math.max(dp[i - 1][w],
                                        dp[i - 1][w - weight[i - 1]] + value[i - 1]);
                } else {
                    // Nếu không đủ sức chứa để lấy đồ vật i, giữ nguyên lời giải của i-1 đồ vật
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        // Kết quả là giá trị tối đa với n đồ vật và sức chứa W
        return dp[n][W];
    }
    
    public static void main(String[] args) {
        int[] weight = {2, 3, 4, 5};
        int[] value = {3, 4, 5, 6};
        int W = 5;
        System.out.println("Giá trị tối đa của balo: " + knapsack(weight, value, W));
    }
}
```

### 5.4 Ví dụ: Truck Route (Xe tải) với DP – Sử dụng mảng 1-indexed

#### Đề bài Truck Route:
- Có \(N\) trạm (đánh số từ 1 đến \(N\)).  
- Ở trạm \(i\):  
  - \(a_i\): lượng hàng hóa có thể lấy  
  - \(t_i\): thời gian pickup tại trạm đó  
- Lộ trình là dãy trạm \(x_1 < x_2 < \dots < x_k\) sao cho:  
  - \(x_{j+1} - x_j \le D\)  
  - Tổng thời gian pickup \(\le T\)  
- Mục tiêu: Tối đa hóa tổng hàng hóa.

#### Xác định trạng thái:
- \(dp[i][\tau]\) là giá trị tối đa hàng hóa thu được khi lộ trình kết thúc tại trạm \(i\) với tổng thời gian đã dùng là \(\tau\).

#### Code Truck Route với chú thích chi tiết

```java
import java.util.Scanner;

public class TruckRouteDP1Indexed {
    /**
     * Tính giá trị tối đa hàng hóa mà xe tải có thể thu được.
     *
     * @param N Số trạm (đánh số từ 1 đến N)
     * @param T Tổng thời gian pickup tối đa
     * @param D Khoảng cách tối đa giữa 2 trạm liên tiếp
     * @param a Mảng hàng hóa tại các trạm (a[1] đến a[N])
     * @param t Mảng thời gian pickup tại các trạm (t[1] đến t[N])
     * @return Giá trị tối đa hàng hóa có thể thu được.
     */
    public static int maxGoods(int N, int T, int D, int[] a, int[] t) {
        // Tạo bảng dp có kích thước (N+1) x (T+1)
        // dp[i][tau] = giá trị tối đa khi lộ trình kết thúc tại trạm i với tổng thời gian tau.
        int[][] dp = new int[N + 1][T + 1];
        
        // Khởi tạo (Base case):
        // Nếu bắt đầu lộ trình tại trạm i, thời gian sử dụng = t[i] và hàng hóa = a[i] (nếu t[i] <= T).
        for (int i = 1; i <= N; i++) {
            if (t[i] <= T) {
                dp[i][t[i]] = a[i];
            }
        }
        
        // Chuyển trạng thái:
        // Duyệt qua từng trạm i (lộ trình kết thúc tại trạm i)
        for (int i = 1; i <= N; i++) {
            // Với mỗi tổng thời gian tau từ 0 đến T, nếu dp[i][tau] đã có giá trị hợp lệ:
            for (int tau = 0; tau <= T; tau++) {
                if (dp[i][tau] == 0) continue; // Nếu không có lời giải nào đạt được, bỏ qua
                // Xét chuyển từ trạm i sang trạm j sao cho j nằm trong khoảng [i+1, min(N, i+D)]
                for (int j = i + 1; j <= Math.min(N, i + D); j++) {
                    int newTime = tau + t[j]; // Tổng thời gian sau khi dừng tại trạm j
                    if (newTime <= T) { // Nếu tổng thời gian không vượt quá giới hạn T
                        // Cập nhật dp[j][newTime] với lời giải tối đa giữa giá trị hiện có và việc thêm trạm j
                        dp[j][newTime] = Math.max(dp[j][newTime], dp[i][tau] + a[j]);
                    }
                }
            }
        }
        
        // Tìm lời giải tối đa trên toàn bộ bảng dp với tau từ 0 đến T cho mọi trạm i
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int tau = 0; tau <= T; tau++) {
                ans = Math.max(ans, dp[i][tau]);
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Đọc dữ liệu đầu vào theo định dạng của đề bài:
        // Dòng 1: N, T, D
        int N = sc.nextInt();
        int T = sc.nextInt();
        int D = sc.nextInt();
        
        // Tạo mảng 1-indexed (kích thước N+1, bỏ qua chỉ số 0)
        int[] a = new int[N + 1];
        int[] t = new int[N + 1];
        
        // Dòng 2: Mảng a (hàng hóa tại các trạm)
        for (int i = 1; i <= N; i++) {
            a[i] = sc.nextInt();
        }
        // Dòng 3: Mảng t (thời gian pickup tại các trạm)
        for (int i = 1; i <= N; i++) {
            t[i] = sc.nextInt();
        }
        
        int result = maxGoods(N, T, D, a, t);
        System.out.println(result);
        
        sc.close();
    }
}
```

> **Chú thích quan trọng trong Truck Route:**  
> - Mỗi khi mở rộng lộ trình từ trạm \(i\) sang trạm \(j\), chúng ta cộng thời gian \(t[j]\) vào tổng thời gian đã dùng (tau) và chỉ cập nhật nếu tổng thời gian không vượt quá \(T\).  
> - Sử dụng mảng 1-indexed giúp đồng bộ với mô tả đề bài.

---

## 6. ĐỒ THỊ VÀ THUẬT TOÁN DUY TẾT (Graph & Traversal Algorithms)

### 6.1 Biểu diễn Đồ thị

#### Ví dụ: Biểu diễn Graph bằng Danh sách kề

```java
import java.util.ArrayList;
import java.util.List;

public class Graph {
    int V; // Số đỉnh của đồ thị
    List<List<Integer>> adjList; // Danh sách kề
    
    // Constructor: khởi tạo đồ thị với V đỉnh
    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        // Khởi tạo danh sách kề cho mỗi đỉnh
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }
    
    // Thêm cạnh từ đỉnh u đến đỉnh v
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        // Nếu đồ thị không có hướng, thêm: adjList.get(v).add(u);
    }
}
```

### 6.2 DFS (Depth First Search)

```java
import java.util.*;

public class DFSExample {
    int V; // Số đỉnh
    List<List<Integer>> adjList; // Danh sách kề của đồ thị

    public DFSExample(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        // Khởi tạo danh sách kề cho mỗi đỉnh
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Thêm cạnh từ u đến v
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    // Hàm DFS bắt đầu từ đỉnh start
    public void dfs(int start) {
        boolean[] visited = new boolean[V]; // Mảng đánh dấu các đỉnh đã thăm
        dfsUtil(start, visited);
    }

    // Hàm hỗ trợ DFS đệ quy
    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true; // Đánh dấu đỉnh hiện tại là đã thăm
        System.out.print(v + " "); // In ra đỉnh hiện tại
        // Duyệt qua các đỉnh kề của v
        for (int neighbor : adjList.get(v)) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFSExample graph = new DFSExample(4);
        // Thêm các cạnh
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.print("DFS từ đỉnh 2: ");
        graph.dfs(2);
    }
}
```

### 6.3 BFS (Breadth First Search)

```java
import java.util.*;

public class BFSExample {
    int V; // Số đỉnh
    List<List<Integer>> adjList; // Danh sách kề

    public BFSExample(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Thêm cạnh từ u đến v
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    // Hàm BFS bắt đầu từ đỉnh start
    public void bfs(int start) {
        boolean[] visited = new boolean[V]; // Mảng đánh dấu các đỉnh đã thăm
        Queue<Integer> queue = new LinkedList<>(); // Queue để duyệt theo lớp

        visited[start] = true; // Đánh dấu đỉnh bắt đầu
        queue.offer(start); // Thêm đỉnh bắt đầu vào queue

        // Duyệt cho đến khi queue rỗng
        while (!queue.isEmpty()) {
            int v = queue.poll(); // Lấy đỉnh đầu tiên trong queue
            System.out.print(v + " ");
            // Thêm các đỉnh kề chưa được thăm vào queue
            for (int neighbor : adjList.get(v)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSExample graph = new BFSExample(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.print("BFS từ đỉnh 2: ");
        graph.bfs(2);
    }
}
```

---

## 7. CÁC THUẬT TOÁN ĐỒ THỊ NÂNG CAO

### 7.1 Union-Find

```java
public class UnionFind {
    int[] parent, rank;
    
    // Constructor: khởi tạo với n phần tử, mỗi phần tử là một tập riêng biệt
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        // Ban đầu, mỗi phần tử là cha của chính nó, rank = 0
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    // Hàm find: tìm gốc của phần tử i (với Path Compression)
    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]); // Nén đường đi
        }
        return parent[i];
    }
    
    // Hàm union: hợp nhất hai tập chứa i và j
    public boolean union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        // Nếu hai phần tử đã cùng tập hợp, không hợp nhất
        if (rootI == rootJ) return false;
        
        // Union by Rank: gắn cây có rank nhỏ hơn vào cây có rank lớn hơn
        if (rank[rootI] < rank[rootJ]) {
            parent[rootI] = rootJ;
        } else if (rank[rootI] > rank[rootJ]) {
            parent[rootJ] = rootI;
        } else {
            parent[rootJ] = rootI;
            rank[rootI]++;
        }
        return true;
    }
}
```

### 7.2 Kruskal (Tìm cây khung nhỏ nhất)

```java
import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    
    // Constructor khởi tạo cạnh với đỉnh nguồn, đích và trọng số
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    
    // Hàm so sánh dựa trên trọng số để sắp xếp cạnh theo thứ tự tăng dần
    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class KruskalMST {
    int V; // Số đỉnh của đồ thị
    List<Edge> edges; // Danh sách các cạnh của đồ thị
    
    public KruskalMST(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }
    
    // Thêm cạnh vào danh sách
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }
    
    // Thuật toán Kruskal để tìm cây khung nhỏ nhất
    public void kruskal() {
        // Sắp xếp các cạnh theo trọng số tăng dần
        Collections.sort(edges);
        UnionFind uf = new UnionFind(V);
        List<Edge> mst = new ArrayList<>();
        
        // Duyệt qua từng cạnh, nếu thêm cạnh đó không tạo chu trình thì thêm vào MST
        for (Edge edge : edges) {
            if (uf.union(edge.src, edge.dest)) {
                mst.add(edge);
            }
        }
        
        // In các cạnh của cây khung nhỏ nhất
        System.out.println("Cây khung nhỏ nhất:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
        }
    }
    
    public static void main(String[] args) {
        KruskalMST graph = new KruskalMST(4);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);
        graph.kruskal();
    }
}
```

### 7.3 Dijkstra (Tìm đường đi ngắn nhất)

```java
import java.util.*;

class Node implements Comparable<Node> {
    int vertex, distance;
    
    // Constructor khởi tạo Node với đỉnh và khoảng cách hiện tại
    public Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
    
    // So sánh dựa trên khoảng cách để PriorityQueue hoạt động đúng
    @Override
    public int compareTo(Node other) {
        return this.distance - other.distance;
    }
}

public class Dijkstra {
    int V; // Số đỉnh của đồ thị
    List<List<Node>> adjList; // Danh sách kề, mỗi đỉnh có danh sách các Node (đỉnh kề và trọng số)
    
    public Dijkstra(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        // Khởi tạo danh sách kề cho từng đỉnh
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }
    
    // Thêm cạnh từ u đến v với trọng số
    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Node(v, weight));
        // Nếu đồ thị không có hướng, thêm cạnh ngược lại: adjList.get(v).add(new Node(u, weight));
    }
    
    // Thuật toán Dijkstra, trả về mảng khoảng cách từ đỉnh start đến các đỉnh khác
    public int[] dijkstra(int start) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE); // Khởi tạo khoảng cách ban đầu là vô cùng
        dist[start] = 0; // Khoảng cách từ start đến chính nó là 0
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;
            // Duyệt các đỉnh kề của u
            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.distance;
                // Nếu đường đi qua u cải thiện được khoảng cách tới v
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }
        return dist;
    }
    
    public static void main(String[] args) {
        Dijkstra graph = new Dijkstra(5);
        graph.addEdge(0, 1, 9);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 4, 3);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 4);
        
        int[] distances = graph.dijkstra(0);
        System.out.println("Khoảng cách từ đỉnh 0:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Đỉnh " + i + " : " + distances[i]);
        }
    }
}
```

---

## 8. PHƯƠNG PHÁP TIẾP CẬN CHUNG CHO CÁC DẠNG BÀI

- **Bài tập với mảng, List, Map, Set:**  
  - Phân tích đặc điểm đầu vào, chọn cấu trúc dữ liệu phù hợp.
  - Viết code với chú thích rõ ràng.
  
- **Bài tập đệ quy, Backtracking, DP:**  
  - Xác định “state” (trạng thái) của bài toán.
  - Trong backtracking: viết hàm check (kiểm tra candidate hợp lệ) và hàm pruning (cắt nhánh) nếu cần.
  - Trong DP: xác định trạng thái, base case và công thức truy hồi (“lấy” và “không lấy”).
  
- **Bài tập đồ thị:**  
  - Biểu diễn đồ thị bằng danh sách kề hoặc ma trận.
  - Sử dụng DFS, BFS cho các bài duyệt.
  - Áp dụng các thuật toán nâng cao (Union-Find, Kruskal, Dijkstra) khi cần thiết.

---

## 9. CÂU HỎI GỢI MỞ & TƯ DUY CHỦ ĐỘNG

Hãy tự hỏi:
- Đầu vào, đầu ra của bài toán là gì?
- Ràng buộc của bài toán có ý nghĩa ra sao?
- Trạng thái bài toán con được biểu diễn như thế nào?
- Lựa chọn “lấy” và “không lấy” ảnh hưởng thế nào đến lời giải?
- Hàm check của backtracking cần kiểm tra những gì? Và bound của pruning được ước lượng ra sao?
- Trong đồ thị, cấu trúc biểu diễn nào giúp duyệt nhanh nhất?

---

## 10. KẾT LUẬN VÀ GỢI Ý THỰC HÀNH

- Tài liệu này tổng hợp kiến thức từ cơ bản đến nâng cao, kèm theo ví dụ cụ thể bằng Java 13 có chú thích chi tiết.  
- **Thực hành:**  
  1. Viết lại các ví dụ, thay đổi dữ liệu đầu vào để kiểm tra code.  
  2. Vẽ sơ đồ luồng và viết pseudocode trước khi triển khai.  
  3. So sánh hiệu quả của các giải pháp khác nhau (ví dụ: DFS vs BFS, đệ quy vs DP).  
  4. Trao đổi với bạn bè và tham khảo thêm tài liệu trực tuyến để mở rộng kiến thức.

> **Lời khuyên:** Luôn tự đặt câu hỏi và kiểm chứng lại code của mình để nắm vững từng khái niệm và kỹ thuật giải thuật.

---

Hy vọng tài liệu chi tiết, end-to-end này sẽ giúp bạn nắm vững các kiến thức cơ bản và nâng cao trong môn Cấu trúc Dữ liệu & Giải thuật với Java 13. Nếu có thắc mắc hoặc cần trao đổi thêm về bất kỳ phần nào, hãy cùng thảo luận để cùng tiến bộ!