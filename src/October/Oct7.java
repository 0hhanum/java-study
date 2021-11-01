package October;

public class Oct7 {
    public static void main(String[] args){
        Deck deck = new Deck();
        System.out.println(deck.pick(0));
        deck.shuffle();
        System.out.println(deck.pick(0));
    }
}

class Parent{

    Parent(int i){
        System.out.println("Overloaded constructor");
    }
}

class Child extends Parent{
    Child(){
        super(123);
        System.out.println("October.Child constructor");
    }
}

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    Point(){
        this(0, 0);
    }
    String getXY(){
        return "" + x + "," + y;
    }
}

class Shape{
    String color = "black";
    void draw() { System.out.println("color is " + color);}
}

class Triangle extends Shape{
    Point[] points = new Point[3]; // October.Point 배열 선언 및 생성.
    Triangle(Point[] points){
        this.points = points;
    }
    void draw(){ // October.Shape draw() 오버라이드.
        for(Point point: points){
            System.out.println(point.getXY());
        }
    }
}

class Card{
    static final int KIND_MAX = 4;
    static final int NUM_MAX = 13;

    static final int SPADE = 4;
    static final int DIAMOND = 3;
    static final int HEART = 2;
    static final int CLOVER = 1;

    int kind;
    int number;

    Card(){
        this(SPADE, 1);
    }
    Card(int kind, int number){
        this.kind = kind;
        this.number = number;
    }
    public String toString(){ // toString 오버라이드.
        String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
        String numbers = "0123456789XJQK";
        return "" + numbers.charAt(this.number) + kinds[this.kind];
    }
}

class Deck{
    final int CARD_NUM = 52;
    Card[] cards = new Card[CARD_NUM];
    Deck(){
        // KIND_MAX * NUM_MAX = CARD_NUM 임을 이용한 for 문. 반복을 뭘로 돌려야 하는지 잘 생각해야한다.
        int i = 0;
        for(int kind=1; kind<Card.KIND_MAX; kind++){
            for(int cardNum=1; cardNum<Card.NUM_MAX + 1; cardNum++){
                cards[i++] = new Card(kind, cardNum);
            }
        }
    }
    Card pick(int i){
        return cards[i];
    }

    void shuffle(){
        for(int i=0; i< cards.length; i++){
            int r = (int) (Math.random() * this.CARD_NUM);
            Card tmp = cards[r];
            cards[r] = cards[i];
            cards[i] = tmp;
        }
    }
}

/*
[java] 10/7 학습기록 - 상속, 포함
상속
상속의 정의와 장점
상속: 기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것.

코드의 재사용성을 높이고 중복을 제거하여 생산성과 유지보수에 기여.
자바에서는extends 를 이용해 상속.

class October.Child extends October.Parent{
}
예시에서 October.Child 는 자식 클래스, October.Parent 는 부모 클래스

용어 때문에 포함 관계가 헷갈릴 수 있지만, October.Child 는 확장의 개념이므로
October.Parent ⊂ October.Child 이다.

확장 이라는 말 그대로, 부모 클래스가 변경되면 모든 자식 클래스에 영향을 미치지만, 자식 클래스의 변화는 부모 클래스의 변화를 미치지 않는다.

생성자와 초기화 블럭은 상속되지 않는다. 멤버만 상속된다.
자식 클래스의 멤버 개수는 부모 클래스보다 항상 같거나 많다.
접근 제어자(access modifier) 가 private 혹은 default 인 멤버들은 상속되지 않는다기보다 상속은 받지만 자손 클래스로부터의 접근이 제한되는 것이다.
여기서 "생성자는 상속되지 않는다." 라는 말의 뜻을 짚고 넘어갈 필요가 있다.
부모의 생성자는 상속되지 않지만, 컴파일러가 자식의 생성자에서 자동으로 모든 생성자에 super() 를 추가해줌. 즉, 자식 클래스를 생성할 경우, 부모 생성자 호출 -> 자식 생성자 호출 의 순서로 진행됨.

super() 는 인자가 없는 기본 생성자를 호출한다. 만약 자식 생성자에서 오버로드된 부모의 다른 생성자를 호출할 경우,
컴파일러는 super() 를 삽입하지 않는다.
예시를 보자.


class October.Parent{
    October.Parent(){
        System.out.println("October.Parent constructor");
    }
}

class October.Child extends October.Parent{
    October.Child(){
        System.out.println("October.Child constructor");
    }
}

public class Test{
    public static void main(String[] args){
        October.Child child = new October.Child();
    }
}
/*
결과

October.Parent constructor
October.Child constructor
*/
/*
만약 오버로딩된 생성자를 호출한다면? -> 부모의 기본 생성자는 호출되지 않는다.

class October.Parent{
    October.Parent(){ System.out.println("October.Parent Constructor");
        October.Parent(int i) { System.out.println("Overloaded constructor");
        }
        class October.Child extends from October.Parent{
            October.Child(){
                super(123);
                System.out.println("October.Child constructor");
            }
        }
        class Main{
            public static void main(String[] args){
                October.Child child = new October.Child(123); // 생성자를 상속받는게 아니다. 이런 식으로는 생성 불가.
                October.Child child = new October.Child();
            }
        }
// 결과
        Overloaded constructor
        October.Child constructor
        다음과 같은 코드는 에러를 뱉어낸다.

                class October.Parent{
            October.Parent(int i) { System.out.println("Overloaded constructor");
            }
            class October.Child extends from October.Parent{
                October.Child(){
                    System.out.println("October.Child constructor");
                }
            }
            class Main{
                public static void main(String[] args){
                    October.Child child = new October.Child();
                }
            }
            이유는 October.Child 의 생성자가 따로 부모의 생성자를 호출하지 않았고, 따라서 부모의 기본 생성자가 호출되는데, 위의 경우엔 October.Parent(int i) 로 생성자를 오버로드했다. 생성자를 오버로드 한 경우, 컴파일러는 기본 생성자를 자동으로 만들어주지 않고, 자식 생성자에선 super() 로 찾을 생성자가 없으니 오류가 발생한다.

            만약 October.Child() 에 super(123); 을 호출할 경우 에러는 사라진다.

                    클래스간의 관계 - 포함관계
            상속 이외에 클래스를 재사용하는 또 다른 방법이 있는데, 그것은 클래스 간에 포함 관계를 맺어주는 것이다.

            클래스 간의 포함관계를 맺어 주는 것은 한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를 선언하는 것을 뜻한다.

            예시

            class Engine{
                String engineName;
                int cylinder;
            }

            class October.Car{
                Engine engine = new Engine(); // 포함관계
                int wheel;
                String color;
            }
            클래스간의 관계 결정하기
            클래스를 작성할 때 포함관계로 사용할 지 상속으로 사용할 지 혼란스러울 수 있다.

            예시

            class October.Car{
                Engine engine = new Engine();
                int wheel;
                String color;
            }

            와

            class October.Car extends Engine{
                int wheel;
                String color;
            }

            둘은 변수를 사용하는데 있어 큰 차이 없이 사용할 수 있다.
            혼동될 때는 클래스 A 와 B 의 관계를 생각해본다.

            "A 는 B 이다." 로 생각된다면 A 는 B 로부터 상속받아도 좋다.
            "A 는 B 를 가지고 있다." 로 생각된다면 포함관계를 맺어주는 것이 더 좋다.

                    상속과 포함의 사용을 잘 보여주는 예시


            class October.Point{
                int x;
                int y;
                October.Point(int x, int y){
                    this.x = x;
                    this.y = y;
                }
                October.Point(){
                    this(0, 0);
                }
                String getXY(){
                    return "" + x + "," + y;
                }
            }

            class October.Shape{
                String color = "black";
                void draw() { System.out.println("color is " + color);}
            }

            class October.Triangle extends October.Shape{
                October.Point[] points = new October.Point[3]; // October.Point 배열 선언 및 생성.
                October.Triangle(October.Point[] points){
                    this.points = points;
                }
                void draw(){ // October.Shape draw() 오버라이드.
                    for(October.Point point: points){
                        System.out.println(point.getXY());
                    }
                }
            }

            public class Main{
                public static void main(String[] args){
                    October.Point[] points = {new October.Point(1,1), new October.Point(2,3), new October.Point(0,0)};
                    October.Triangle triangle = new October.Triangle(points);
                    triangle.draw();
                }
            }
            October.Point 는 October.Triangle 과 포함관계이며, October.Shape 는 October.Triangle 과 상속관계이다.

            상속 및 클래스 연습


            class October.Card{
                static final int KIND_MAX = 4;
                static final int NUM_MAX = 13;

                static final int SPADE = 4;
                static final int DIAMOND = 3;
                static final int HEART = 2;
                static final int CLOVER = 1;

                int kind;
                int number;

                October.Card(){
                    this(SPADE, 1);
                }
                October.Card(int kind, int number){
                    this.kind = kind;
                    this.number = number;
                }
                public String toString(){ // toString 오버라이드.
                    String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
                    String numbers = "0123456789XJQK";
                    return "" + numbers.charAt(this.number) + kinds[this.kind];
                }
            }

            class October.Deck{
                final int CARD_NUM = 52;
                October.Card[] cards = new October.Card[CARD_NUM];
                October.Deck(){
                    // KIND_MAX * NUM_MAX = CARD_NUM 임을 이용한 for 문. 반복을 뭘로 돌려야 하는지 잘 생각해야한다.
                    int i = 0;
                    for(int kind=1; kind<October.Card.KIND_MAX; kind++){
                        for(int cardNum=1; cardNum<October.Card.NUM_MAX + 1; cardNum++){
                            cards[i++] = new October.Card(kind, cardNum);
                        }
                    }
                }
                October.Card pick(int i){
                    return cards[i];
                }

                void shuffle(){
                    for(int i=0; i< cards.length; i++){
                        int r = (int) (Math.random() * this.CARD_NUM);
                        October.Card tmp = cards[r];
                        cards[r] = cards[i];
                        cards[i] = tmp;
                    }
                }
            }

            class Main{
                static void main(String[] args){
                    October.Deck deck = new October.Deck();
                    System.out.println(deck.pick(0));
                    deck.shuffle();
                    System.out.println(deck.pick(0));
                }
            }
*/