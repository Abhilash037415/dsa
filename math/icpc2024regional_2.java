import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }

}

class LRUcache {
    int cap;
    HashMap<Integer, Node> map;

    Node head;
    Node tail;

    public LRUcache(int cap) {
        this.cap = cap;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);
        if (map.size() > cap) {
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }
    }

    public int getCycles(int[] array) {
        int score = 0;
        for (int current : array) {
            if (map.containsKey(current)) {
                score += 1;
                Node node = map.get(current);
                remove(node);
                insert(node);
            } else {
                score += 2;
                put(current, current);
            }
        }

        return score;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        next.prev = prev;
        prev.next = next;
    }

    public void insert(Node node) {
        Node prev = tail.prev;
        Node next = tail;
        prev.next = next.prev = node;
        node.next = next;
        node.prev = prev;
    }

}

public class icpc2024regional_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] array = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                LRUcache lru = new LRUcache(i);
                System.out.print(lru.getCycles(array) + " ");
            }
            System.out.println();
        }

    }
}
