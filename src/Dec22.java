public class Dec22 {
    public static void main(String[] args){
        ChildA c = new ChildA();
        c.method();
    }
}

class TV {
    boolean power;
    int channel;

    void power() {power = !power;}
    void channelUp() {channel++;}
    void channelDown() {channel--;}
}

class VCR {
    boolean power;
    int counter = 0;
    void power() { power = !power; }
    void play() {}
    void stop() {}
    void rewind() {}
}

class TVCR extends TV {
    VCR vcr = new VCR(); // 다중상속 대신 VCR 의 인스턴스를 포함시켜서 사용한다.

    void play(){
        vcr.play();
    }
    void stop(){
        vcr.stop();
    }
    void rewind(){
        vcr.rewind();
    }
    // 코드를 그대로 다시 써야하는게 비효율적으로 느껴진다.
}

class Parent {
    void method() { }
}
class Child extends Parent{
    void method() {} // 오버라이딩
    void method(int i) {} // 오버라이딩
}

class Parents {
    int x = 10;
}
class ChildA extends Parents {
    int x = 5;
    void method(){
        System.out.println(x); // 5
        System.out.println(this.x); // 5
        System.out.println(super.x); // 10
    }
}

class Point {
    int x; int y;
    String getLocation(){
        return "x" + x + "y" + y;
    }
}

class Point3D extends Point{
    int z;
    String getLocation(){ // 오버라이딩
        // return  "x" + x + "y" + y + "z" + z;
        return super.getLocation();
    }
}

class PointTest{
    int x, y;
    PointTest(int x, int y) {
        this.x = x;
        this.y = y;
    }
    String getLoc(){
        return "" + x + "," + y ;
    }
}
class PointTest3D extends PointTest{
    int z;
    PointTest3D (int x, int y, int z){
        // 비워둘 경우 컴파일러가 자동으로 super() 를 호출한다. 그러나 PointTest 는 기본 생성자가 없기 때문에 에러가 발생.
        super(x, y);
        this.z = z;
        // 혹은 PointTest 의 기본 생성자를 만들어 주는 방법도 있다.
    }
}
class P {
    int x = 10;
    int y = 20;
    P(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class P3D extends P{
    int z = 30;
    P3D(){
        this(100, 200, 300); // *** this 이므로 P3D 의 생성자가 호출되는 것임. P 가 아니라.
    }
    P3D(int x, int y, int z){
        super(x, y);
        this.z = z;
    }
}

/*
## 단일 상속 (single ingeritance)

 자바는 단일 상속만을 허용한다. 하나의 조상 클래스만을 가질 수 있기 때문에 다중 상속에 비해 불편한 점도 있지만, **클래스 간의 관계가 보다 명확해지고 코드를 더욱 신뢰할 수 있게** 만들어 준다는 점에서 다중상속보다 유리하다.

```java
class TV {
    boolean power;
    int channel;

    void power() {power = !power;}
    void channelUp() {channel++;}
    void channelDown() {channel--;}
}

class VCR {
    boolean power;
    int counter = 0;
    void power() { power = !power; }
    void play() {}
    void stop() {}
    void rewind() {}
}

class TVCR extends TV {
    VCR vcr = new VCR();
    // 다중상속 대신 VCR 의 인스턴스를 포함시켜서 사용한다.
    // 외부적으로는 TVCR 의 메서드를 사용하는 것 처럼 보이지만, 내부적으로는 VCR 의 인스턴스를 이용.

    void play(){
        vcr.play();
    }
    void stop(){
        vcr.stop();
    }
    void rewind(){
        vcr.rewind();
    }
    // 코드를 그대로 다시 써야하는게 비효율적으로 느껴진다.
}
```

## Object 클래스


> Object 클래스는 모든 클래스 상속계층도의 최상위에 있는 조상클래스이다.

모든 클래스들은 자동적으로 Object 클래스를 **최상위 클래스**로 상속받는다. (컴파일 과정에서 컴파일러가 ```extends Object``` 를 추가 - 이미 어떤 클래스를 상속받도록 작성된 클래스에는 추가되지 않음. 가장 조상 클래스에 추가해주기 때문)

따라서 자바의 모든 클래스들은 Object 클래스에 정의된 멤버들을 사용할 수 있다.  Object 클래스에는 ``toString(), equals()`` 등 모든 인스턴스가 가져야 할 기본적인 11개의 메서드가 정의되어 있음.


## 오버라이딩

> 조상 클래스로부터 상속받은 메서드의 내용을 변경하는 것.

오버라이딩은 메서드의 내용만을 새로 작성하는 것이므로 메서드의 선언부는 조상의 것과 완전히 일치해야 한다. 그래서 오버라이딩이 성립하기 위해서는 다음과 같은 조건을 만족해야 한다.

	오버라이딩하는 메서드는 조상 클래스 해당 메서드와
    - 이름이 같아야 한다
    - 매개변수가 같아야 한다
    - 반환타입이 같아야 한다 (JDK 1.5 부터 완화)

=> 선언부가 일치해야 함. 단, 접근 제어자와 예외는 제한된 조건 하에서 변경할 수 있다.

	조상 클래스의 static 메서드를 자손 클래스에서 같은 이름의 static 메서드로 정의한다면
    각 클래스에 별개의 static 메서드를 정의한 것일 분 오버라이딩이 아니다. 각 메서드는 클래스 이름으로 구별된다.
    static 멤버들은 자신들이 정의된 클래스에 묶여있는 개념이다.



## 오버로딩 vs 오버라이딩
오버로딩 : 기존에 없는 새로운 메서드를 추가하는 것
오버라이딩: 상속받은 메서드의 내용을 변경하는 것

```java
class Parent {
    void method() { }
}
class Child extends Parent{
    void method() {} // 오버라이딩
    void method(int i) {} // 오버라이딩
}

```

## super
super 는 자손 클래스에서 조상 클래스로부터 상속받은 멤버를 참조하는데 사용되는 참조변수이다.
**상속받은 멤버와 자신의 멤버가 이름이 같을 때, super 를 붙여 구분할 수 있다. (this 처럼)**

조상 클래스로부터 상속받은 멤버도 자손 클래스 자신의 멤버이므로 super 대신 this 를 사용할 수 있다. 조상의 멤버와 자신의 멤버를 구별하는데 사용된다는 점을 제외하고는 super 와 this 는 근본적으로 같다.

모든 인스턴스메서드에는 **자신이 속한 인스턴스의 주소**가 지역변수로 저장되는데, 이것이 참조변수인 this 와 super 의 값이 된다.

```java
class Parents {
    int x = 10;
}
class ChildA extends Parents {
    int x = 5;
    void method(){
        System.out.println(x); // 5
        System.out.println(this.x); // 5
        System.out.println(super.x); // 10
        // ChildA 에 x 가 없으면 모두 10 을 뱉는다.
    }
}
```
변수만이 아니라 메서드도 super 를 이용해 호출할 수 있다.

```java
class Point {
    int x; int y;
    String getLocation(){
        return "x" + x + "y" + y;
    }
}

class Point3D extends Point{
    int z;
    String getLocation(){ // 오버라이딩
        // return  "x" + x + "y" + y + "z" + z;
        return super.getLocation(); // 조상 메서드 호출.
    }
}
```
조상 클래스의 메서드에 추가 작업을 덧붙이는 경우라면 위 예시처럼 super 를 사용해 조상클래스의 메서드를 포함시킬 수 있다.

## super() - 조상 클래스의 생성자

this() 와 마찬가지로 super() 역시 생성자이다. **this() 는 같은 클래스의 다른 생성자를 호출하는 데 사용하지만, super() 는 조상 클래스의 생성자를 호출하는데 사용한다.**

자손 클래스의 인스턴스를 생성하면, 자손의 멤버와 조상의 멤버가 모두 합쳐진 하나의 인스턴스가 생성된다.
-> 조상 클래스 멤버의 초기화 작업이 수행되어서 가능한 것

조상 클래스 생성자 호출은 상속관계를 거슬러 올라가면서 계속 반복된다. 모든 클래스의 최고 조상인 Object 의 생성자인 ``Object()`` 까지 가면 끝이 난다.

> Object 클래스를 제외한 모든 클래스의 생성자 첫 줄에 this() 또는 super() 를 호출해야 한다. 그렇지 않으면 컴파일러가 자동적으로 super(); 를 생성자의 첫 줄에 추가한다.

```java

class PointTest{
    int x, y;
    PointTest(int x, int y) {
        this.x = x;
        this.y = y;
    }
    String getLoc(){
        return "" + x + "," + y ;
    }
}
class PointTest3D extends PointTest{
    int z;
    PointTest3D (int x, int y, int z){
        // 비워둘 경우 컴파일러가 자동으로 super() 를 호출한다. 그러나 PointTest 는 기본 생성자가 없기 때문에 에러가 발생.
        super(x, y);
        this.z = z;
        // 혹은 PointTest 의 기본 생성자를 만들어 주는 방법도 있다.
    }
}
```
** 조상 클래스의 멤버변수는 이처럼 조상의 생성자에 의해 초기화되도록 해야한다.**



```java
class P {
    int x = 10;
    int y = 20;
    P(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class P3D extends P{
    int z = 30;
    P3D(){
        this(100, 200, 300); // *** this 이므로 P3D 의 생성자가 호출되는 것임. P 가 아니라.
    }
    P3D(int x, int y, int z){
        super(x, y);
        this.z = z;
    }
}
```





 */