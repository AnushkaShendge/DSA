import java.util.LinkedList;

public class ImpHashMap {
    public class HashMap<K, V> {
        public class Node {
            K key;
            V Val;

            Node(K k, V v) {
                this.key = k;
                this.Val = v;
            }
        }

        private int n; // Nodes
        private int N; // bucket(idx)
        private LinkedList<Node> bucket[];

        public int hashFunc(K key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        public int searchLL(K key, int bi) {
            LinkedList<Node> ll = bucket[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }

        public HashMap() {
            this.N = 4;
            this.bucket = new LinkedList[4];
            for (int i = 0; i < bucket.length; i++) {
                this.bucket[i] = new LinkedList<>();
            }
        }

        private void rehash() {
            LinkedList<Node> oldBucket[] = bucket;
            bucket = new LinkedList[N * 2];
            for (int i = 0; i < N * 2; i++) {
                bucket[i] = new LinkedList<>();
            }
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.Val);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunc(key);
            int di = searchLL(key, bi); // di = -1
            if (di == -1) { // key doesn't exist
                bucket[bi].add(new Node(key, value));
                n++;
            } else { // key exists
                Node node = bucket[bi].get(di);
                node.Val = value;
            }
            double lambda = (double) n / N;

            if (lambda > 2.0) {
                rehash();
            }
        }

    }

}
