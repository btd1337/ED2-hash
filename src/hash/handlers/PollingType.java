package hash.handlers;

public enum PollingType {
	LINEAR_PROBING(1), DOUBLE_HASHING(2);
	
	private int _value;
	
	private PollingType(int value) {
		this._value = value;
	}
	
	public int value() {
		return this._value;
	}
}
