package model;

import org.springframework.stereotype.Component;

@Component
public class Police implements Person {
	public void say() {
		System.out.println("我是警察");
	}
}
