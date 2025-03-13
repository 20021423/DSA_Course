Dưới đây là tài liệu ôn tập "Cấu trúc Dữ liệu & Giải Thuật" bằng Java 13 được soạn lại một cách cực kỳ chi tiết, theo từng bước (step-by-step) và end-to-end. Tài liệu này bao gồm các chủ đề từ cơ bản đến nâng cao, từ lý thuyết cho đến ví dụ code có chú thích rõ ràng. Bạn hãy đọc kỹ và thực hành từng phần để nắm vững kiến thức.

---

# MỤC LỤC

1. [Giới thiệu & Quy trình giải bài toán](#giới-thiệu--quy-trình-giải-bài-toán)
2. [Cấu trúc dữ liệu cơ bản](#cấu-trúc-dữ-liệu-cơ-bản)  
   2.1. [List, ArrayList & LinkedList](#list-arraylist--linkedlist)  
   2.2. [Map & Set](#map--set)  
   2.3. [Stack, Queue & PriorityQueue](#stack-queue--priorityqueue)
3. [Đệ quy (Recursion)](#đệ-quy-recursion)
4. [Backtracking & Branch and Bound](#backtracking--branch-and-bound)
5. [Dynamic Programming (Quy hoạch động)](#dynamic-programming-quy-hoạch-động)  
   5.1. [Khái niệm chung và chiến lược triển khai](#khái-niệm-chung-và-chiến-lược-triển-khai)  
   5.2. [Top-Down (Memoization)](#top-down-memoization)  
   5.3. [Bottom-Up (Tabulation)](#bottom-up-tabulation)  
   5.4. [Ví dụ: Longest Increasing Subsequence (LIS)](#ví-dụ-longest-increasing-subsequence-lis)  
   5.5. [Ví dụ: 0/1 Knapsack](#ví-dụ-01-knapsack)  
   5.6. [Ví dụ: Truck Route (Xe tải)](#ví-dụ-truck-route-xe-tải)
6. [Thuật toán đồ thị](#thuật-toán-đồ-thị)  
   6.1. [Biểu diễn đồ thị](#biểu-diễn-đồ-thị)  
   6.2. [DFS & BFS](#dfs--bfs)  
   6.3. [Các thuật toán nâng cao và mẹo trong đồ thị](#các-thuật-toán-nâng-cao-và-mẹo-trong-đồ-thị)
7. [Phương pháp tiếp cận chung cho các dạng bài](#phương-pháp-tiếp-cận-chung-cho-các-dạng-bài)
8. [Câu hỏi gợi mở & Tư duy chủ động](#câu-hỏi-gợi-mở--tư-duy-chủ-động)
9. [Kết luận & Gợi ý thực hành](#kết-luận--gợi-ý-thực-hành)

---

## 1. GIỚI THIỆU & QUY TRÌNH GIẢI BÀI TOÁN

Trước khi giải bài toán, hãy làm theo các bước sau:

- **Phân tích đề bài:**  
  Xác định đầu vào, đầu ra, các ràng buộc và mục tiêu của bài toán.

- **Lựa chọn cấu trúc dữ liệu:**  
  Tùy thuộc vào đặc điểm của dữ liệu (ví dụ: dữ liệu đã sắp xếp hay chưa, cần truy cập theo chỉ số hay thao tác chèn/xóa, …).

- **Chọn giải thuật phù hợp:**  
  Ví dụ: đệ quy, backtracking, dynamic programming (DP), duyệt đồ thị (DFS, BFS), …  
  Luôn viết pseudocode hoặc sơ đồ luồng trước khi code.

- **Triển khai code bằng Java 13:**  
  Code phải được chú thích chi tiết để giải thích ý tưởng và từng bước thực hiện.

- **Phân tích độ phức tạp & tối ưu hóa:**  
  Xác định time complexity, space complexity và tối ưu code nếu cần.

---

## 2. CẤU TRÚC DỮ LIỆU CƠ BẢN

### 2.1 List, ArrayList & LinkedList

#### Lý thuyết:
- **List:** Là một interface lưu trữ các phần tử theo thứ tự.
- **ArrayList:** Sử dụng mảng nội bộ; ưu điểm là truy cập theo chỉ số nhanh, nhược điểm là thao tác chèn/xóa giữa danh sách chậm do phải dịch chuyển các phần tử.
- **LinkedList:** Dựa trên danh sách liên kết; thuận tiện cho thao tác chèn/xóa, nhưng truy cập theo chỉ số chậm hơn.

#### Ví dụ: ArrayList

```java
import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // Khởi tạo ArrayList để lưu trữ các ngôn ngữ lập trình.
        List<String> languages = new ArrayList<>();

        // Thêm phần tử vào danh sách
        languages.add("Java");    // Thêm "Java" vào cuối danh sách
        languages.add("C++");       // Thêm "C++" vào cuối danh sách
        languages.add("Python");    // Thêm "Python" vào cuối danh sách

        // Truy cập phần tử đầu tiên (với chỉ số 0)
        System.out.println("Ngôn ngữ đầu tiên: " + languages.get(0));

        // Duyệt danh sách và in ra từng phần tử
        for (String lang : languages) {
            System.out.println("Ngôn ngữ: " + lang);
        }
    }
}
```

#### Ví dụ: LinkedList

```java
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        // Khởi tạo LinkedList để lưu trữ các từ khóa.
        List<String> words = new LinkedList<>();

        // Thêm các phần tử vào danh sách
        words.add("Data");
        words.add("Structure");
        words.add("Algorithm");

        // Thêm phần tử vào đầu danh sách (ép kiểu về LinkedList)
        ((LinkedList<String>) words).addFirst("Introduction");

        // Duyệt danh sách và in ra các phần tử
        words.forEach(word -> System.out.println("Từ: " + word));
    }
}
```

---

### 2.2 Map & Set

#### Lý thuyết:
- **Map:** Lưu trữ các cặp key-value; cho phép tra cứu giá trị theo key. Ví dụ: HashMap, TreeMap.
- **Set:** Chứa các phần tử duy nhất; ví dụ: HashSet, TreeSet.

#### Ví dụ: HashMap

```java
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Khởi tạo HashMap với key là Integer và value là String.
        Map<Integer, String> map = new HashMap<>();

        // Thêm các cặp key-value vào map.
        map.put(1, "Một");
        map.put(2, "Hai");
        map.put(3, "Ba");

        // Duyệt qua map và in ra từng cặp key-value.
        map.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });
    }
}
```

#### Ví dụ: HashSet

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        // Khởi tạo HashSet để lưu các phần tử không trùng lặp.
        Set<String> fruits = new HashSet<>();

        // Thêm các phần tử vào set.
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // "Apple" không được thêm lại vì đã tồn tại.

        // Duyệt qua set và in ra các phần tử.
        fruits.forEach(fruit -> System.out.println("Trái cây: " + fruit));
    }
}
```

---

### 2.3 Stack, Queue & PriorityQueue

#### Lý thuyết:
- **Stack:** Cấu trúc dữ liệu LIFO (Last In, First Out); phần tử được truy cập theo thứ tự ngược lại với thứ tự thêm.
- **Queue:** Cấu trúc dữ liệu FIFO (First In, First Out); phần tử được truy cập theo thứ tự đã thêm.
- **PriorityQueue:** Hàng đợi ưu tiên tự động sắp xếp các phần tử theo thứ tự xác định (thường là thứ tự tăng dần).

#### Ví dụ: Stack

```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // Khởi tạo Stack chứa các số nguyên.
        Stack<Integer> stack = new Stack<>();

        // Đưa các phần tử vào stack
        stack.push(10); // Push 10 vào stack
        stack.push(20); // Push 20 vào stack
        stack.push(30); // Push 30 vào stack

        // Xem phần tử đỉnh mà không xóa (peek)
        System.out.println("Phần tử đỉnh: " + stack.peek());

        // Lấy và xóa phần tử đỉnh (pop)
        System.out.println("Pop: " + stack.pop());
    }
}
```

#### Ví dụ: Queue

```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Khởi tạo Queue sử dụng LinkedList.
        Queue<String> queue = new LinkedList<>();

        // Thêm các phần tử vào queue (offer)
        queue.offer("Task1"); // Thêm Task1 vào cuối queue
        queue.offer("Task2"); // Thêm Task2 vào cuối queue
        queue.offer("Task3"); // Thêm Task3 vào cuối queue

        // Xem phần tử đầu của queue (peek)
        System.out.println("Phần tử đầu: " + queue.peek());

        // Lấy và xóa phần tử đầu của queue (poll)
        System.out.println("Poll: " + queue.poll());
    }
}
```

#### Ví dụ: PriorityQueue

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

        // Lấy các phần tử ra theo thứ tự ưu tiên (phần tử nhỏ nhất sẽ được lấy trước)
        while (!pq.isEmpty()) {
            System.out.println("Phần tử ưu tiên: " + pq.poll());
        }
    }
}
```

---

## 3. ĐỆ QUY (RECURSION)

### Lý thuyết:
- **Đệ quy:** Là phương pháp giải bài toán bằng cách chia bài toán lớn thành các bài toán con có kích thước nhỏ hơn và gọi lại chính nó.
- **Điều kiện dừng (Base case):** Rất quan trọng để tránh gọi đệ quy vô hạn.

### Ví dụ: Tính giai thừa (Factorial)

```java
public class RecursionFactorial {
    // Hàm tính giai thừa của n bằng đệ quy.
    public static long factorial(int n) {
        // Base case: nếu n <= 1, trả về 1
        if (n <= 1) return 1;
        // Gọi đệ quy: n * giai thừa của (n-1)
        return n * factorial(n - 1);
    }
    
    public static void main(String[] args) {
        int number = 5;
        // In ra kết quả giai thừa của number
        System.out.println("Giai thừa của " + number + " là " + factorial(number));
    }
}
```

---

## 4. BACKTRACKING & BRANCH AND BOUND

### Lý thuyết:
- **Backtracking:** Là kỹ thuật duyệt không gian giải pháp bằng cách thử từng lựa chọn và quay lui khi gặp trường hợp không hợp lệ.  
- **Branch and Bound (Cắt nhánh):** Là cải tiến của backtracking, trong đó bạn ước lượng một giới hạn (bound) của lời giải có thể đạt được từ trạng thái hiện tại. Nếu bound đó không thể cải thiện lời giải hiện có, bạn cắt bỏ nhánh đó để tiết kiệm thời gian.

### Phân biệt:
- **Hàm check:**  
  - Mục đích: Kiểm tra xem candidate tại bước \( k \) có thỏa mãn các ràng buộc cơ bản không.
  - Ví dụ: Trong N-Queens, hàm check sẽ duyệt qua các hàng trước để kiểm tra xem vị trí (row, col) có bị tấn công không.
- **Hàm pruning:**  
  - Mục đích: Ước lượng khả năng mở rộng lời giải hiện tại (bound) và so sánh với lời giải tối ưu hiện có. Nếu bound không đủ cao, dừng duyệt nhánh đó.
  - Ví dụ: Trong 0/1 Knapsack, sử dụng “Fractional Knapsack” để tính bound.

### Ví dụ: N-Queens

```java
import java.util.ArrayList;
import java.util.List;

public class NQueens {
    private int n; // Kích thước bàn cờ n x n
    private List<List<String>> solutions = new ArrayList<>(); // Lưu các cấu hình lời giải hợp lệ

    public NQueens(int n) {
        this.n = n;
    }
    
    // Hàm giải N-Queens: trả về danh sách các cấu hình hợp lệ
    public List<List<String>> solveNQueens() {
        int[] board = new int[n]; // board[i] lưu vị trí (cột) đặt quân hậu ở hàng i
        backtrack(board, 0);
        return solutions;
    }
    
    // Hàm backtracking với check (và có thể thêm pruning nếu cần)
    private void backtrack(int[] board, int row) {
        // Nếu đã đặt quân hậu ở đủ n hàng, thêm cấu hình hiện tại vào kết quả
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
            
            // (Pruning: Bạn có thể tính toán bound của nhánh hiện tại và nếu bound nhỏ hơn lời giải hiện có, bỏ qua nhánh)
            // if (shouldPrune(board, row)) continue;
            
            // Gọi đệ quy cho hàng tiếp theo
            backtrack(board, row + 1);
        }
    }
    
    // Hàm kiểm tra tính hợp lệ của vị trí (row, col)
    private boolean isValid(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            // Kiểm tra cùng cột hoặc trên đường chéo
            if (board[i] == col || Math.abs(board[i] - col) == row - i)
                return false;
        }
        return true;
    }
    
    // Hàm chuyển đổi board (mảng chỉ số cột) thành cấu hình bàn cờ dạng List<String>
    private List<String> generateBoard(int[] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(board[i] == j ? "Q" : ".");
            }
            result.add(sb.toString());
        }
        return result;
    }
    
    public static void main(String[] args) {
        // Ví dụ: N-Queens với bàn cờ 4x4
        NQueens nq = new NQueens(4);
        List<List<String>> sols = nq.solveNQueens();
        // In ra từng cấu hình lời giải
        for (List<String> sol : sols) {
            for (String line : sol) {
                System.out.println(line);
            }
            System.out.println(); // Dòng trắng giữa các lời giải
        }
    }
}
```

*Gợi ý về hàm pruning:*  
- Tùy vào bài toán, bạn có thể ước lượng bound. Ví dụ, trong bài 0/1 Knapsack, bound có thể được tính theo cách "Fractional Knapsack" để xác định nếu nhánh hiện tại có khả năng vượt lời giải hiện có hay không.

---

## 5. DYNAMIC PROGRAMMING (QUY HOẠCH ĐỘNG)

### 5.1 Khái niệm chung và Chiến lược triển khai

Dynamic Programming (DP) là kỹ thuật giải bài toán bằng cách chia bài toán lớn thành các bài toán con có kích thước nhỏ hơn, lưu trữ kết quả các bài toán con (để tránh tính lại) và sau đó kết hợp chúng để đưa ra lời giải cho bài toán ban đầu. DP áp dụng cho các bài toán có đặc tính:
- **Overlapping subproblems:** Các bài toán con được tính lại nhiều lần.
- **Optimal substructure:** Lời giải tối ưu của bài toán lớn có thể được xây dựng từ lời giải tối ưu của các bài toán con.

### 5.2 Chiến lược Top-Down (Memoization)

- **Khái niệm:**  
  Giải bài toán bằng đệ quy và lưu trữ kết quả của các bài toán con vào một bộ nhớ đệm (memo). Khi gặp lại bài toán con đó, chỉ cần trả về kết quả từ bộ nhớ đệm thay vì tính lại.

- **Ưu điểm:**  
  Code ngắn gọn, dễ hiểu theo cách đệ quy.
  
- **Nhược điểm:**  
  Có thể dẫn đến tràn stack nếu độ sâu của đệ quy quá lớn.

#### Ví dụ: Tính Fibonacci với Memoization

```java
import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoization {
    // Sử dụng Map để lưu kết quả của các bài toán con đã tính
    private static Map<Integer, Long> memo = new HashMap<>();

    // Hàm tính Fibonacci theo phương pháp Top-Down (Memoization)
    public static long fibonacci(int n) {
        // Base case: nếu n <= 1, trả về n
        if (n <= 1) return n;
        // Nếu đã có kết quả của n, trả về từ memo
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        // Tính toán kết quả cho n bằng đệ quy
        long result = fibonacci(n - 1) + fibonacci(n - 2);
        // Lưu kết quả vào memo để sử dụng sau
        memo.put(n, result);
        return result;
    }
    
    public static void main(String[] args) {
        int n = 50;
        System.out.println("Fibonacci của " + n + " là " + fibonacci(n));
    }
}
```

---

### 5.3 Chiến lược Bottom-Up (Tabulation)

- **Khái niệm:**  
  Xây dựng bảng (table) kết quả từ các bài toán con nhỏ nhất (base cases) lên đến bài toán cần giải. Không sử dụng đệ quy, thay vào đó dùng vòng lặp để tính toán các giá trị theo thứ tự đã được sắp xếp.

- **Ưu điểm:**  
  Không gặp vấn đề tràn stack, thường hiệu quả về bộ nhớ nếu được tối ưu hóa.
  
- **Nhược điểm:**  
  Code có thể dài hơn và ít trực quan hơn so với đệ quy.

#### Ví dụ: Tính Fibonacci với Tabulation

```java
public class FibonacciTabulation {
    // Hàm tính Fibonacci theo Bottom-Up (Tabulation)
    public static long fibonacci(int n) {
        // Nếu n <= 1, trả về n ngay
        if (n <= 1) return n;
        
        // Tạo mảng dp để lưu kết quả từ 0 đến n
        long[] dp = new long[n + 1];
        dp[0] = 0; // Base case
        dp[1] = 1; // Base case
        
        // Tính toán các giá trị từ dp[2] đến dp[n]
        for (int i = 2; i <= n; i++) {
            // Công thức truy hồi: dp[i] = dp[i-1] + dp[i-2]
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 50;
        System.out.println("Fibonacci của " + n + " là " + fibonacci(n));
    }
}
```

---

### 5.4 Các bước triển khai chung cho DP

1. **Xác định trạng thái (State):**  
   - Chọn các biến (hoặc chỉ số) biểu diễn bài toán con.
   - Ví dụ: Trong bài LIS, \( dp[i] \) là độ dài của dãy con tăng dài nhất kết thúc tại vị trí \( i \). Trong Knapsack, \( dp[i][w] \) là giá trị tối đa với \( i \) đồ vật và sức chứa \( w \).

2. **Diễn giải trạng thái:**  
   - Giải thích ý nghĩa của trạng thái.
   - Ví dụ: \( dp[i] = 1 \) (vì mỗi phần tử tự nó là một dãy con có độ dài 1).

3. **Xác định trạng thái cơ sở (Base Case):**  
   - Đặt giá trị ban đầu cho các bài toán con.
   - Ví dụ: \( dp[0] = 1 \) cho LIS; \( dp[0][w] = 0 \) cho Knapsack.

4. **Xác định công thức truy hồi (Recurrence Relation):**  
   - Xác định cách chuyển từ bài toán con nhỏ sang bài toán lớn.
   - Ví dụ:  
     - LIS: \( dp[i] = \max\{dp[j] + 1 \mid 0 \leq j < i \text{ và } nums[j] < nums[i]\} \).  
     - Knapsack:  
       \[
       dp[i][w] =
       \begin{cases}
       \max\{dp[i-1][w],\, dp[i-1][w - weight[i-1]] + value[i-1]\}, & \text{nếu } weight[i-1] \leq w, \\
       dp[i-1][w], & \text{nếu } weight[i-1] > w.
       \end{cases}
       \]

5. **Chiến lược triển khai:**  
   - Chọn giữa Top-Down và Bottom-Up tùy thuộc vào bài toán và kích thước dữ liệu.

---

### 5.5 Ví dụ: Longest Increasing Subsequence (LIS)

```java
public class LIS {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        // Khởi tạo: mỗi phần tử đứng riêng là dãy con có độ dài 1.
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        // Tính dp[i] bằng cách duyệt qua tất cả các phần tử trước đó
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) { // Nếu nums[i] có thể nối sau nums[j]
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        // Tìm giá trị lớn nhất trong dp
        int max = 0;
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

---

### 5.6 Ví dụ: 0/1 Knapsack

```java
public class KnapsackDP {
    public static int knapsack(int[] weight, int[] value, int W) {
        int n = weight.length;
        // dp[i][w] là giá trị tối đa đạt được với i đồ vật và sức chứa w
        int[][] dp = new int[n + 1][W + 1];
        
        // Duyệt qua các đồ vật (i từ 1 đến n; weight, value sử dụng chỉ số 0-indexed)
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (weight[i - 1] <= w) {
                    // Lựa chọn: không lấy đồ vật i hoặc lấy đồ vật i
                    dp[i][w] = Math.max(dp[i - 1][w],
                                        dp[i - 1][w - weight[i - 1]] + value[i - 1]);
                } else {
                    // Nếu trọng lượng của đồ vật vượt quá w, không lấy được đồ vật i
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
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

---

### 5.7 Ví dụ: Truck Route (Xe tải) – DP với mảng 1-indexed

#### Đề bài Truck Route:
- Có \( N \) trạm (đánh số từ 1 đến \( N \)).
- Tại trạm \( i \):
  - \( a_i \): Lượng hàng hóa có thể lấy.
  - \( t_i \): Thời gian pickup.
- Lộ trình là dãy các trạm \( x_1 < x_2 < \dots < x_k \) sao cho:
  - \( x_{j+1} - x_j \le D \)
  - Tổng thời gian pickup \(\le T\).
- **Mục tiêu:** Tối đa hóa tổng hàng hóa.

#### Xác định trạng thái:
- \( dp[i][\tau] \): Giá trị tối đa hàng hóa thu được khi lộ trình kết thúc tại trạm \( i \) với tổng thời gian đã dùng là \( \tau \).

#### Code Truck Route:

```java
import java.util.Scanner;

public class TruckRouteDP1Indexed {
    /**
     * Tính giá trị tối đa hàng hóa mà xe tải có thể thu được.
     *
     * @param N Số trạm (đánh số từ 1 đến N)
     * @param T Tổng thời gian pickup tối đa cho phép
     * @param D Khoảng cách tối đa giữa 2 trạm liên tiếp
     * @param a Mảng hàng hóa tại các trạm (a[1] đến a[N])
     * @param t Mảng thời gian pickup tại các trạm (t[1] đến t[N])
     * @return Giá trị tối đa hàng hóa có thể thu được.
     */
    public static int maxGoods(int N, int T, int D, int[] a, int[] t) {
        // Tạo bảng dp với kích thước (N+1) x (T+1)
        // dp[i][tau] lưu giá trị tối đa khi lộ trình kết thúc tại trạm i với tổng thời gian là tau.
        int[][] dp = new int[N + 1][T + 1];
        
        // Base case: Với mỗi trạm i, nếu thời gian pickup t[i] không vượt quá T,
        // bắt đầu lộ trình tại trạm i có giá trị hàng hóa là a[i].
        for (int i = 1; i <= N; i++) {
            if (t[i] <= T) {
                dp[i][t[i]] = a[i];
            }
        }
        
        // Chuyển trạng thái:
        // Duyệt qua các trạm i (lộ trình kết thúc tại trạm i)
        for (int i = 1; i <= N; i++) {
            // Với mỗi tổng thời gian tau từ 0 đến T mà dp[i][tau] có giá trị (khác 0)
            for (int tau = 0; tau <= T; tau++) {
                if (dp[i][tau] == 0) continue; // Nếu không có lời giải hợp lệ, bỏ qua
                // Xét chuyển tiếp đến các trạm j nằm trong khoảng [i+1, min(N, i+D)]
                for (int j = i + 1; j <= Math.min(N, i + D); j++) {
                    int newTime = tau + t[j]; // Tổng thời gian sau khi dừng tại trạm j
                    if (newTime <= T) { // Nếu newTime không vượt quá T, cập nhật lời giải
                        dp[j][newTime] = Math.max(dp[j][newTime], dp[i][tau] + a[j]);
                    }
                }
            }
        }
        
        // Tìm giá trị tối đa trong bảng dp với tau từ 0 đến T cho mọi trạm i
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
        
        // Tạo mảng 1-indexed cho a và t (kích thước N+1, bỏ qua chỉ số 0)
        int[] a = new int[N + 1];
        int[] t = new int[N + 1];
        
        // Dòng 2: Mảng a (lượng hàng hóa tại các trạm)
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

*Chú thích quan trọng:*  
- Mỗi khi chuyển từ trạm \(i\) sang trạm \(j\), ta cộng thêm thời gian \(t[j]\) vào tổng thời gian đã dùng (tau) và cập nhật giá trị hàng hóa nếu tổng thời gian không vượt quá \(T\).  
- Sử dụng mảng 1-indexed giúp đồng bộ với mô tả đề bài (trạm từ 1 đến N).

---

## 6. THUẬT TOÁN ĐỒ THỊ

### 6.1 Biểu diễn Đồ thị

#### Lý thuyết chi tiết:
- **Graph:** Tập hợp các đỉnh (vertex) và cạnh (edge).
- **Danh sách kề:**  
  - Thường sử dụng ArrayList cho mỗi đỉnh để lưu các đỉnh kề.
  - Ưu điểm: Tiết kiệm bộ nhớ, dễ duyệt các đỉnh kề, phù hợp với đồ thị thưa.
- **Ma trận kề:**  
  - Một ma trận 2 chiều, với phần tử [i][j] cho biết có cạnh nối giữa đỉnh i và j hay không.
  - Ưu điểm: Truy cập nhanh (O(1)) nhưng tốn bộ nhớ nếu số đỉnh lớn.

#### Ví dụ: Danh sách kề

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
    
    // Hàm thêm cạnh từ đỉnh u đến v
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        // Nếu đồ thị không có hướng, thêm cạnh ngược: adjList.get(v).add(u);
    }
}
```

---

### 6.2 DFS & BFS

#### DFS (Depth-First Search)

**Lý thuyết:**
- DFS duyệt sâu vào đồ thị theo từng nhánh.
- Có thể triển khai bằng đệ quy hoặc sử dụng Stack (phiên bản iterative).
- Ứng dụng: Tìm chu trình, thành phần liên thông, bridges, articulation points.

**Ví dụ DFS với đệ quy (có chú thích chi tiết):**

```java
import java.util.*;

public class DFSExample {
    int V; // Số đỉnh của đồ thị
    List<List<Integer>> adjList; // Danh sách kề

    // Constructor: khởi tạo đồ thị với V đỉnh
    public DFSExample(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            // Mỗi đỉnh có một danh sách kề
            adjList.add(new ArrayList<>());
        }
    }

    // Hàm thêm cạnh từ đỉnh u đến v
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    // Hàm DFS bắt đầu từ đỉnh start
    public void dfs(int start) {
        boolean[] visited = new boolean[V]; // Mảng đánh dấu đỉnh đã thăm
        dfsUtil(start, visited); // Gọi hàm đệ quy hỗ trợ DFS
    }

    // Hàm đệ quy DFS: duyệt các đỉnh từ đỉnh v
    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true; // Đánh dấu v là đã thăm
        System.out.print(v + " "); // In ra đỉnh v
        // Duyệt qua các đỉnh kề của v
        for (int neighbor : adjList.get(v)) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited); // Gọi đệ quy cho đỉnh kề chưa thăm
            }
        }
    }

    public static void main(String[] args) {
        DFSExample graph = new DFSExample(4);
        // Thêm các cạnh vào đồ thị
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

#### BFS (Breadth-First Search)

**Lý thuyết:**
- BFS duyệt đồ thị theo từng lớp sử dụng Queue.
- Ứng dụng chính: Tìm đường đi ngắn nhất trong đồ thị không trọng số.

**Ví dụ BFS với chú thích chi tiết:**

```java
import java.util.*;

public class BFSExample {
    int V; // Số đỉnh của đồ thị
    List<List<Integer>> adjList; // Danh sách kề

    // Constructor: khởi tạo đồ thị với V đỉnh
    public BFSExample(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            // Khởi tạo danh sách kề cho từng đỉnh
            adjList.add(new ArrayList<>());
        }
    }

    // Hàm thêm cạnh từ u đến v
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    // Hàm BFS bắt đầu từ đỉnh start
    public void bfs(int start) {
        boolean[] visited = new boolean[V]; // Mảng đánh dấu các đỉnh đã thăm
        Queue<Integer> queue = new LinkedList<>(); // Queue để duyệt theo lớp

        visited[start] = true; // Đánh dấu đỉnh bắt đầu là đã thăm
        queue.offer(start); // Thêm đỉnh bắt đầu vào queue

        // Duyệt cho đến khi queue rỗng
        while (!queue.isEmpty()) {
            int v = queue.poll(); // Lấy đỉnh đầu tiên trong queue
            System.out.print(v + " "); // In ra đỉnh v
            // Duyệt qua các đỉnh kề của v
            for (int neighbor : adjList.get(v)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true; // Đánh dấu đỉnh neighbor là đã thăm
                    queue.offer(neighbor); // Thêm neighbor vào queue
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

### 6.3 Các thuật toán nâng cao và mẹo trong đồ thị

#### Union-Find (DSU)

**Lý thuyết:**
- Union-Find là cấu trúc để quản lý các tập hợp rời rạc, hỗ trợ thao tác tìm gốc (find) và hợp nhất (union).
- **Path Compression:** Giúp làm phẳng cây, tăng tốc độ tìm kiếm.
- **Union by Rank/Size:** Giúp duy trì cây hợp nhất được cân bằng.

**Ví dụ Union-Find với chú thích:**

```java
public class UnionFind {
    int[] parent, rank;
    
    // Constructor: khởi tạo n phần tử, mỗi phần tử là cha của chính nó, rank ban đầu bằng 0.
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Mỗi phần tử là cha của chính nó
            rank[i] = 0;   // Rank khởi tạo bằng 0
        }
    }
    
    // Hàm find: Tìm gốc của phần tử i với Path Compression
    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]); // Nén đường đi: gán cha của i là gốc của cây
        }
        return parent[i];
    }
    
    // Hàm union: Hợp nhất tập chứa i và j
    public boolean union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        // Nếu i và j đã cùng gốc, không cần hợp nhất
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

#### Kruskal (Tìm cây khung nhỏ nhất)

**Lý thuyết:**
- Kruskal sắp xếp các cạnh theo trọng số tăng dần và sử dụng DSU để kiểm tra chu trình trước khi thêm cạnh vào cây khung.
- **Mẹo:** Sử dụng hàm sort của Java để sắp xếp cạnh và DSU để tránh thêm cạnh tạo chu trình.

**Ví dụ Kruskal với chú thích:**

```java
import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    
    // Constructor: khởi tạo cạnh với đỉnh nguồn, đích và trọng số
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    
    // So sánh cạnh theo trọng số (tăng dần)
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
    
    // Hàm thêm cạnh vào danh sách
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }
    
    // Hàm Kruskal để tìm cây khung nhỏ nhất
    public void kruskal() {
        // Sắp xếp các cạnh theo trọng số tăng dần
        Collections.sort(edges);
        UnionFind uf = new UnionFind(V);
        List<Edge> mst = new ArrayList<>();
        
        // Duyệt qua các cạnh; nếu thêm cạnh không tạo thành chu trình, thêm vào MST
        for (Edge edge : edges) {
            if (uf.union(edge.src, edge.dest)) {
                mst.add(edge);
            }
        }
        
        // In ra các cạnh của cây khung nhỏ nhất
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

#### Dijkstra (Tìm đường đi ngắn nhất)

**Lý thuyết:**
- Dijkstra tìm đường đi ngắn nhất trong đồ thị có trọng số không âm.
- Sử dụng PriorityQueue để luôn lấy đỉnh có khoảng cách nhỏ nhất, cập nhật (relax) các khoảng cách cho các đỉnh kề.
- **Mẹo:**  
  - Kiểm tra điều kiện “relaxation” kỹ càng.
  - Đảm bảo rằng các đỉnh không liên thông giữ khoảng cách là vô cùng (Integer.MAX_VALUE).

**Ví dụ Dijkstra với chú thích:**

```java
import java.util.*;

class Node implements Comparable<Node> {
    int vertex, distance;
    
    // Constructor: khởi tạo Node với đỉnh và khoảng cách hiện tại
    public Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
    
    // So sánh Node dựa trên khoảng cách (để PriorityQueue hoạt động đúng)
    @Override
    public int compareTo(Node other) {
        return this.distance - other.distance;
    }
}

public class Dijkstra {
    int V; // Số đỉnh của đồ thị
    List<List<Node>> adjList; // Danh sách kề: mỗi đỉnh có danh sách các Node (đỉnh kề và trọng số)
    
    // Constructor: khởi tạo đồ thị với V đỉnh
    public Dijkstra(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        // Khởi tạo danh sách kề cho từng đỉnh
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }
    
    // Hàm thêm cạnh từ u đến v với trọng số weight
    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Node(v, weight));
        // Nếu đồ thị không có hướng, có thể thêm cạnh ngược lại: adjList.get(v).add(new Node(u, weight));
    }
    
    // Hàm Dijkstra: trả về mảng khoảng cách từ đỉnh start đến các đỉnh khác
    public int[] dijkstra(int start) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE); // Khởi tạo khoảng cách ban đầu là vô cùng
        dist[start] = 0; // Khoảng cách từ start đến chính nó bằng 0
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;
            // Duyệt qua các đỉnh kề của u
            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.distance;
                // Nếu đường đi qua u cải thiện được khoảng cách đến v, cập nhật và đưa vào pq
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

## 7. PHƯƠNG PHÁP TIẾP CẬN CHUNG CHO CÁC DẠNG BÀI

- **Bài tập với mảng, List, Map, Set:**  
  - Xác định đặc điểm của dữ liệu, chọn cấu trúc phù hợp (ArrayList cho truy cập ngẫu nhiên, HashMap cho tra cứu,…).
  - Code với chú thích rõ ràng và phân tích độ phức tạp.

- **Bài tập đệ quy, Backtracking, DP:**  
  - Xác định state của bài toán.
  - Với Backtracking: viết hàm check để kiểm tra candidate có hợp lệ và hàm pruning để ước lượng bound của nhánh hiện tại.
  - Với DP: xác định trạng thái, base case, công thức truy hồi; chọn chiến lược Top-Down (Memoization) hoặc Bottom-Up (Tabulation) dựa vào bài toán.

- **Bài tập đồ thị:**  
  - Chọn cấu trúc biểu diễn phù hợp (danh sách kề hoặc ma trận kề).
  - Duyệt bằng DFS, BFS tùy vào bài toán.
  - Sử dụng các thuật toán nâng cao (DSU, Kruskal, Dijkstra) và áp dụng các mẹo tối ưu (Path Compression, Union by Rank, …).

---

## 8. CÂU HỎI GỢI MỞ & TƯ DUY CHỦ ĐỘNG

Hãy tự hỏi:
- Đầu vào và đầu ra của bài toán là gì?
- Các ràng buộc có ý nghĩa như thế nào?
- State của bài toán con được biểu diễn như thế nào?
- Lựa chọn “lấy” và “không lấy” (trong DP) ảnh hưởng ra sao đến lời giải?
- Trong Backtracking, hàm check cần kiểm tra những gì và bound của pruning được ước lượng ra sao?
- Trong đồ thị, cấu trúc biểu diễn nào là tối ưu cho bài toán của bạn?
- Top-Down và Bottom-Up khác nhau như thế nào, và ứng dụng trong bài toán của bạn ra sao?

---

## 9. KẾT LUẬN & GỢI Ý THỰC HÀNH

- Tài liệu này cung cấp một khung kiến thức từ cơ bản đến nâng cao, với lý thuyết chi tiết và các ví dụ code minh họa bằng Java 13 có chú thích rõ ràng.
- **Thực hành:**  
  1. Viết lại và chạy các ví dụ, thay đổi dữ liệu đầu vào để kiểm tra code.
  2. Vẽ sơ đồ luồng hoặc pseudocode trước khi bắt đầu code.
  3. So sánh hiệu quả của các giải pháp khác nhau (ví dụ: DFS vs BFS, Top-Down vs Bottom-Up).
  4. Trao đổi với bạn bè và tham khảo thêm tài liệu trực tuyến để mở rộng kiến thức.

> **Lời khuyên:** Hãy luôn đặt câu hỏi, kiểm chứng lại code của mình và tìm hiểu sâu từng khái niệm để phát triển kỹ năng giải thuật.

---

Hy vọng tài liệu cực kỳ chi tiết, step-by-step và end-to-end này sẽ giúp bạn nắm vững toàn bộ các chủ đề trong môn Cấu trúc Dữ liệu & Giải Thuật với Java 13. Nếu bạn có bất kỳ thắc mắc hoặc cần trao đổi thêm về bất kỳ phần nào, hãy cùng thảo luận để cùng tiến bộ!