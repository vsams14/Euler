package com.github.vsams14.euler;

public class Main {

	public static void main(String[] args) {
		utils.startTime = System.currentTimeMillis();
		Main m = new Main();
		m.startSolver("067");
		long endTime = System.currentTimeMillis();
		long time = endTime - utils.startTime;
		if (time < 1000) {
			System.out.println("Took " + time + " ms");
		} else {
			time /= 1000;
			System.out.println("Took " + time + " s");
		}

	}

	private Main() {
	}

	private void startSolver(String s) {
		try {
			Class.forName("com.github.vsams14.euler.solver" + s)
					.getConstructor().newInstance();
		} catch (ClassNotFoundException e) {
			utils.println("Class com.github.vsams14.euler.solver" + s
					+ " does not exist!");
		} catch (NoSuchMethodException e) {
			utils.println("Class com.github.vsams14.euler.solver" + s
					+ " does not have a constructor!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
