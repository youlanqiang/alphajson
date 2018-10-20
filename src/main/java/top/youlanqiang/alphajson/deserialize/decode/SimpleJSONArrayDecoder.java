package top.youlanqiang.alphajson.deserialize.decode;

import java.util.Stack;

import top.youlanqiang.alphajson.JSONArray;

/**
 * 解析json字符串为数组
 * @author youlanqiang
 *
 */
public class SimpleJSONArrayDecoder{
	
	//char开始下标
	private int start;
		
	//char结束下标
	private int end;
		
	private Stack<StackToken> stack;
	
	private JSONArray array;
	
	public SimpleJSONArrayDecoder(int start) {
		this.start = start;
		this.stack = new Stack<>();
		stack.push(new StackToken(start,JSONTag.LJA));
		this.array = new JSONArray();
	}
		
	public void run(final char[] str) {
		StackToken token =  null;
		//key记录的上一个key
		SimpleJSONObjectDecoder object = null;
		for(int i = start+1;i<str.length;i++) {

			if(str[i]==JSONTag.LJO) {
				//解析到JSONEntity数组
				object = new SimpleJSONObjectDecoder(i);
				object.run(str);
				i = object.getEnd();
				array.addJSONSerialize(object.toJSONObject());
			}else if(str[i]==JSONTag.RJA){
				//判段该JSONArray是否结束
				token = stack.pop();
				if(token.getValue()==JSONTag.LJA) {
					this.end = i;
					return;
				}else {

				}

			}
		}
	}
	
	public JSONArray toJSONArray() {
		return array;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
}
