package September;

class Tv {
    String color;
    boolean power;
    int channel;
    void power() { power = !power; }
    void channelUp() { channel++; }
    void channelDown() {channel--;}
}

public class Sep22 {
    public static void main(String[] args){
        Tv tv1 = new Tv();
        Tv tv2 = new Tv();
        tv1.channel = 5;
        tv2.channel = 3;
        System.out.println(tv1.channel);
        System.out.println(tv2.channel);
        tv2 = tv1;
        tv2.channel = 11;
        System.out.println(tv1.channel);
        System.out.println(tv2.channel);
    }
}
/*
객체지향언어
실제 세계는 사물(객체) 로 이루어져 있으며, 발생하는 모든 사건들은 사물간의 상호작용이다.

객체지향언어는 기존의 프로그래밍 언어와 다른 전혀 새로운 것이 아니라, 기존의 프로그래밍 언어에 몇 가지 새로운 규칙을 추가한 보다 발전된 형태의 것이다.

코드의 재사용성이 높다
새로운 코드를 작성할 때 기존의 코드를 이용하여 쉽게 작성할 수 있다.
코드의 관리가 용이하다.
코드간의 관계를 이용해서 적은 노력으로 쉽게 코드를 변경할 수 있다.
신뢰성이 높은 프로그래밍을 가능하게 한다.
제어자와 메서드를 이용해 데이터를 보호하고 올바른 값을 유지하도록 하며, 코드의 중복을 제거해 코드 불일치로 인한 오동작을 방지할 수 있다.
코드의 재사용성이 높고 유지보수가 용이하다.

클래스와 객체
클래스와 객체의 정의와 용도
클래스란 '객체를 정의해놓은 것' -> 객체의 설계도 또는 틀
객체를 생성하는데 사용되며, 객체는 클래스에 정의된 대로 생성

즉, 클래스와 객체의 관계는 제품 설계도와 제품의 관계라고 할 수 있다. (클래스 != 객체)

객체와 인스턴스
클래스로부터 객체를 만드는 과정을 클래스의 인스턴스화라고 하며, 어떤 클래스로부터 만들어진 객체를 그 클래스의 인스턴스라 한다.


객체의 구성요소 - 속성과 기능
객체는 속성과 기능, 두 종류의 구성요소로 이루어져 있다. 객체가 가지고 있는 속성과 기능을 그 객체의 멤버라 한다.
(속성=멤버변수, property, 속성 attribute, 기능=메서드)


인스턴스의 생성과 사용
클래스는 인스턴스의 설계도를 작성한 것에 불과하므로, 인스턴스를 생성하기 위해서는 일반적으로 아래와 같은 과정을 거친다.

클래스명 변수명;
변수명 = new 클래스명();



class September.Tv {
    String color;
    boolean power;
    int channel; // 멤버변수

    void power() {power = !power;}
    void channelUp() { ++channel; }
    void channelDown() { --channel; } // 메서드
}

class TvTest {
    public static void main(String args[]){
        September.Tv tv; // September.Tv 인스턴스 참조변수 tv 선언
        tv = new September.Tv(); //September.Tv 인스턴스 생성
        tv.channel = 7;
        tv.channelUp();

        September.Tv tv; => 참조변수 선언. 메모리에 tv 를 위한 공간이 마련된다.

        tv = new September.Tv(); 연산자 new 에 의해 September.Tv 인스턴스가 메모리의 빈 공간에 생성되고 그 주소가 참조변수 tv 에 저장. 인스턴스 내에는 속성과 메서드가 저장되어 있으며, 위 예시에서는 속성의 자료형에 따라 기본값으로 초기화되었다.

        인스턴스는 오직 참조변수를 통해서만 다룰 수 있으며 참조변수의 타입은 인스턴스의 타입과 일치해야 한다.

                참조변수의 이해에 좋은 예시.

                class September.Tv {
            String color;
            boolean power;
            int channel;
            void power() { power = !power; }
            void channelUp() { channel++; }
            void channelDown() {channel--;}
        }

        public class September.Sep22 {
            public static void main(String[] args){
                September.Tv tv1 = new September.Tv();
                September.Tv tv2 = new September.Tv();
                tv1.channel = 5;
                tv2.channel = 3;
                System.out.println(tv1.channel);
                System.out.println(tv2.channel);
                tv2 = tv1;
                tv2.channel = 11;
                System.out.println(tv1.channel);
                System.out.println(tv2.channel);
	/*
        tv2 = tv1 으로 설정 후 tv2 의 channel 속성을 변경하면 tv1 의 속성도 변경된다. 참조변수의 이름만 다르지 같은 객체를 가리키고 있기 때문이다.
        */

