package top.youlanqiang.alphajson.deserialize.decode;

public class StackToken {

	private int index;
	
	private char value;
	
	public StackToken(int index,char value) {
		this.index = index;
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "StackToken [index=" + index + ", value=" + value + "]";
	}
	
	
}
