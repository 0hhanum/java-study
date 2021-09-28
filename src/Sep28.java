public class Sep28 {
    public static void main(String args[]){
        Car car = new Car("red", 3);
        System.out.println(car.color);
        System.out.println(car.door);
        Car car2 = new Car(car);
        System.out.println(car2.color);
        System.out.println(car2.door);
    }
}

class Car{
    String color;
    int door;
    Car(String color, int door){
        this.color = color;
        this.door = door;
    }
    Car(){
        this("white", 4);
    }
    Car(Car car){
        this(car.color, car.door);
    }
}

/*
[java] 9/29 학습기록
생성자 Constructor
생성자란?
인스턴스가 생성될 때 호출되는 "인스턴스 초기화 메서드". (인스턴스 변수들을 초기화)

생성자 역시 메서드처럼 클래스 내에 선언되며, 구조도 메서드와 유사하지만 리턴값이 없다. 예외적으로 void 를 붙이지 않는다.

생성자의 조건
1. 생성자의 이름은 클래스의 이름과 같아야 한다.
2. 생성자는 리턴 값이 없으며 void 생략이 가능하다.

연산자 new 가 인스턴스를 생성하는 것이지 생성자가 "생성" 하는 것은 아님. 이름때문에 오해하기 쉽지만, 단순히 생성될 때 인스턴스 변수의 초기화를 위해 호출되는 메서드라고 생각.

인스턴스 생성 과정은 다음과 같다.

연산자 new 에 의해 heap 에 인스턴스가 생성
생성자가 호출되어 수행.
참조변수가 있을 시, 생성된 인스턴스의 주소가 참조변수에 저장.
Example example = new Example();
// 여기서 Example() 이 생성자를 호출한 것이다.
기본 생성자
모든 클래스에는 반드시 하나 이상의 생성자가 정의되어 있어야 한다.
(생성자도 메서드이기에 오버로딩으로 여러 개를 만들 수 있다. 매개변수를 이용해 구분.)

별도의 생성자를 정의하지 않고도 인스턴스를 생성할 수 있는 이유는 컴파일러가 제공하는 '기본 생성자' 때문.

컴파일 시 소스파일의 클래스에 생성자가 하나도 정의되지 않은 경우, 컴파일러는 자동적으로
ClassName() { } 과 같은 비어있는 생성자를 추가하여 컴파일한다.

매개변수가 있는 생성자
class Car{
  String color;
  int door;
  Car() {} // 생성자 1
  Car(String color, int door){ // 생성자 2
    this.color = color; // 생성자 매개변수명과 인스턴스변수명이 같아 구분 위해 this 사용.
    this.door = door;
  }
}
/*
생성자를 오버로딩해 두 가지 생성자를 만들었다.
*/
    /*
생성자에서 다른 생성자 호출하기 - this(), this
        같은 클래스의 멤버들 간 서로 호출할 수 있는 것처럼 생성자 간에도 서로 호출이 가능.

        생성자의 이름으로 클래스이름 대신 this 를 사용한다.
        한 생성자에서 다른 생성자를 호출할 때는 반드시 첫 줄에서만 가능하다.
        첫 줄에서만 가능한 이유는, 생성자 내에서 초기화 작업도중 다른 생성자를 호출하게 되면, 호출된 다른 생성자 내에서도 멤버변수들의 값을 초기화를 할 것이므로 다른 생성자를 호출하기 이전의 초기화 작업과 엉킬 수 있기 때문.

        예시
class Car{
    String color;
    int door;
    Car(){
        this("white", 4)
        // 이렇게 호출이 가능하다. 매개변수를 통해 어떤 생성자를 호출한 것인지 확인.
    }
    Car(String color){
        this(color, 4);
    }
    Car(String color, int door{
        this.color = color;
        this.door = door;
    }
}
this 는 참조변수 로 인스턴스 자신을 가리킨다(자신의 주소가 저장됨). 참조변수를 통해 인스턴스의 멤버에 접근할 수 있는 것처럼, this 를 통해 인스턴스변수에 접근할 수 있다. 모든 인스턴스메서드에 지역변수로 숨겨진 채 존재한다.

static 메서드에서 인스턴스 멤버들을 사용할 수 없는 것처럼, this 또한 클래스 메서드에선 사용할 수 없다. 같은 이유로.

        this 와 this() 는 완전히 다른 것이다. this 는 참조변수이고 , this() 는 생성자이다.

        생성자를 이용한 인스턴스의 복사
        현재 사용하고 있는 인스턴스와 같은 상태를 갖는 인스턴스를 하나 더 만들고자 할 때 생성자를 이용할 수 있다. 같은 상태를 갖는다는 것은 두 인스턴스의 인스턴스 변수(상태) 가 동일한 값을 갖고 있다는 것을 의미한다.

        클래스 내의 모든 메서드와 클래스 변수는 인스턴스마다 모두 동일하다. 따라서 다른 값을 가질수 있는 것은 인스턴스변수 뿐이다.

        Car(Car car){
        color = car.color;
        door = car.door;
        }
// 인스턴스를(참조변수) 매개변수로 받아 복사하는 생성자. 동일한 상태의 인스턴스를 생성할 수 있다.

        사용예시
class Car{
    String color;
    int door;

    Car(String color, int door){ // 생성자 1
        this.color = color;
        this.door = door;
    }

    Car(){ // 생성자 2
        this("white", 4);
    }

    Car(Car car){ // 생성자 3. 인스턴스(참조변수)를 매개변수로 받음.
        this.color = car.color;
        this.dor = car.door;
    /*
    this(car.color, car.door);
    */
/*
    }
}
class Main{
    public static void main(String[] args){
        Car car1 = new Car("red", 2);
        Car car2 = new Car(car1); // 인스턴스 매개변수 생성자 이용.
        System.out.println(car1.color);
        System.out.println(car1.door);
        System.out.println(car2.color);
        System.out.println(car2.door); // 동일하다.
    }
}
    인스턴스 car2는 car1을 복사하여 생성된 것이므로 같은 상태를 갖지만, 서로 독립적으로 메모리공간에 존재하는 별도의 인스턴스이므로 서로 영향을 받지 않는다.


*/
