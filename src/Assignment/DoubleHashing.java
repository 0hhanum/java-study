package Assignment;

// 이중해싱
public class DoubleHashing {
    public static void main(String[] args){
        // size 10 의 HashTable 선언 및 생성.
        HashTable<String, Integer> hashTable = new HashTable<>(10);

        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);
        hashTable.put("four", 4);
        hashTable.put("five", 5);
        hashTable.put("six", 6);
        hashTable.put("seven", 7);
        hashTable.put("eight", 8);
        hashTable.put("nine", 9);
        // size 10 의 해시테이블의 적재율을 90 % 까지 채운다.
        System.out.println("key: one, value: " + hashTable.get("one"));
        System.out.println("key: two, value: " + hashTable.get("two"));
        System.out.println("key: three, value: " + hashTable.get("three"));
        System.out.println("key: eight, value: " + hashTable.get("eight"));
        System.out.println("key: nine, value: " + hashTable.get("nine"));
        // 기존 해시테이블에선 잘 작동한다.

        // size 20 인 해시테이블로 재해시 진행.

        System.out.println("해시테이블 resize 후 재해싱을 진행합니다.");

        HashTable<String ,Integer> newHashTable = hashTable.resize();
        System.out.println("key: one, value: " + newHashTable.get("one"));
        System.out.println("key: two, value: " + newHashTable.get("two"));
        System.out.println("key: three, value: " + newHashTable.get("three"));
        System.out.println("key: four, value: " + newHashTable.get("four"));
        System.out.println("key: eight, value: " + newHashTable.get("eight"));
        System.out.println("key: nine, value: " + newHashTable.get("nine"));
        // 잘 동작함을 확인 가능.
    }
}

@SuppressWarnings("unchecked")
// 선형조사 방식을 이용.
class DoubleHashTable<Key, Value>{
    private final int M; // 테이블 크기
    private final int D; // 이중해싱을 위한 값

    private final Key[] keys; // 해시테이블
    private final Value[] values; // 데이터 저장.

    private int N; // 항목 수

    public DoubleHashTable(int M, int D){ // 생성자. M 과 D 가 서로소 일 때가 좋다.
        this.M = M;
        this.D = D;
        keys = (Key[]) new Object[M]; // 해시테이블 생성
        values = (Value[]) new Object[M]; // value 배열 생성.
        N = 0;
    }

    private int hash(Key key){ // key 해싱.
        return (key.hashCode() & 0x7fffffff) % M;
        // key.hashcode() 값과 부호비트를 제외한 int 형으로 나타낼 수 있는 가장 큰 수의 AND 연산 후 M 로 나눈 나머지가 hash 값.
    }

    public void put(Key key, Value value){ // put 메서드
        int initialPos = hash(key); // key 값을 해싱.
        int i = initialPos;
        int j = 1;
        int d = (D - (int) key % D);

        do {
            if (keys[i] == null){
                keys[i] = key;
                values[i] = value; N++;
                return;
            }
            if (keys[i].equals(key)){
                values[i] = value; // 이미 key 가 존재한다면 데이터만 갱신
                return;
            }
            i = (initialPos + j++ * d) % M; // 다음 위치로 이동
        } while(N < M);
    }

    public Value get(Key key){
        int initialPos = hash(key);
        int i = initialPos;
        int j = 1;
        int d = (D - (int)key % D);

        while (keys[i] != null){
            if (keys[i].equals(key)) return values[i]; // 탐색 성공

            i = (initialPos + j++ * d) % M; // 다음 위치로 이동
        }
        return null; // 탐색 실패
    }

    public void remove(Key key){ // 삭제 메서드.
        int initialPos = hash(key);
        int i = initialPos;
        int j = 1;
        int d = (D - (int)key % D);

        while(keys[i] != null){
            if(keys[i].equals(key)){ // 찾았다면 삭제.
                keys[i] = null; values[i] = null;
            }
            i = ( initialPos + j++ * d) % M;
        }

    }

    public boolean contains(Key key){
        Value value = get(key);
        return value != null;
    }

    public HashTable<Key, Value> resize(){ // 해시테이블 확장 함수
        HashTable<Key, Value> newTable = new HashTable<>(M * 2);  // 크기 2배의 해시테이블 생성.
        for(int i=0; i<M; i++){ // 재해시 진행
            Key key = keys[i]; Value value = values[i];
            if (key != null) newTable.put(key, value);
        }
        return newTable;
    }
}
