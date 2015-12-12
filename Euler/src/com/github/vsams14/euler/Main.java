package com.github.vsams14.euler;

import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.startSolver("47");
	}
	
	private Main(){		
	}
	
	private void startSolver(String s){
		try {
			Class.forName("com.github.vsams14.euler.solver"+s).getConstructor().newInstance();
		} catch (ClassNotFoundException e) {
			utils.println("Class com.github.vsams14.euler.solver"+s+" does not exist!");
		} catch (NoSuchMethodException e) {
			utils.println("Class com.github.vsams14.euler.solver"+s+" does not have a constructor!");
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}		
	}
}
