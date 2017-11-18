package backend;

public enum LGrade {
	A(true),
	A_PLUS(true),
	A_MINUS(true),
	B(true),
	B_PLUS(true),
	B_MINUS(true),
	C(true),
	C_PLUS(true),
	C_MINUS(true),
	D(true),
	D_PLUS(true),
	F(false);
	
	final private boolean passed;

	private LGrade(boolean passed) {
	    this.passed = passed;
	}

	public boolean isPassing() {
	    return this.passed;
	}
}
