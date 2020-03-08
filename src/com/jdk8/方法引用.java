package com.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class 方法引用 {
	public static void main(String[] argv) {
		//	构造器引用：
		//Car car1 = Car.create(new Car());
		Car car = Car.create( Car::new);
		car.name = "car";
		Car police = Car.create( Car::new );
		police.name = "police";
		List<Car> cars = new ArrayList<Car>();
		cars.add(car);
		cars.forEach( police::follow );
		cars.forEach( Car::repair );
	}
}

class Car {
	public String name;

	//Supplier是jdk1.8的接口，这里和lambda一起使用了
	public static Car create(final Supplier<Car> supplier) {
		return supplier.get();
	}

	public static void collide(final Car car) {
		System.out.println("Collided " + car.toString());
	}

	public void follow(final Car another) {
		System.out.println("Following the " + another.toString());
	}

	public void repair() {
		System.out.println("Repaired " + this.toString());
	}
	@Override
	public String toString() {
		return this.name;
	}

}