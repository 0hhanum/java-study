package Assignment;

// 체이닝 기법 해시테이블
// 2017110523 오한음

public class Assignment5_3 {
    public static void main(String[] args){
        ChainingHashTable<String, Integer> hashTable = new ChainingHashTable<>(6);
        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);
        hashTable.put("four", 4);
        hashTable.put("five", 5);
        hashTable.put("six", 6);
        // 적재율 100 %. 두개의 key - value 를 더 채운다.
        hashTable.put("seven", 7);
        hashTable.put("eight", 8);

        System.out.println("133 % 적재 후 동작 테스트");
        System.out.println("key: seven, value: " + hashTable.get("seven"));
        System.out.println("key: eight, value: " + hashTable.get("eight"));
        System.out.println("key: one, value: " + hashTable.get("one"));
        // seven, eight, one 모두 잘 찾는걸 확인할 수 있다.

    }
}

// 체이닝기법 이용.
class ChainingHashTable<Key, Value>{
    private final int size;
    private Node[] keys;

    public ChainingHashTable(int size){ // 생성자.
        this.size = size;
        keys = new Node[size];
    }

    public static class Node{ // Node 정의
        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value, Node nextNode){
            this.key = key;
            this.value = value;
            this.next = nextNode;
        }
        public Object getKey() { return key; }
        public Object getValue() { return value; }
        public Node getNext() { return next; }
    }
    private int hash(Key key){ // 해시함수
        return (key.hashCode() & 0x7fffffff) % size;
    }

    public void put(Key key, Value value){
        int i = hash(key);
        for (Node node = keys[i]; node != null; node = node.next){
            // node 의 next 를 찾아나간다.
            if(key.equals(node.getKey())){ // 이미 key 가 존재할 경우, 값만 갱신한다.
                node.value = value;
                return;
            }
        }
        keys[i] = new Node(key, value, keys[i]);
        // 만약 해당 key 가 연결리스트에 없을 경우, keys[i](연결리스트) 의 첫 노드로 넣어준다.
        // 이때, next 가 기존 첫 노드가 된다.
    }

    public Value get(Key key){
        int i = hash(key);
        Node node = keys[i];
        while(node.getKey() != key){
            node = node.getNext();
        }
        return (Value) node.getValue();
    }
}


