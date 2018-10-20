package top.youlanqiang.alphajson.deserialize.decode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


import top.youlanqiang.alphajson.JSONObject;
import top.youlanqiang.alphajson.serialize.JSONSerialize;
import top.youlanqiang.alphajson.utils.CharArrayUtil;
import top.youlanqiang.alphajson.utils.StringUtil;

/**
 * 解析json字符串引擎
 * @author youlanqiang
 *
 */
public class SimpleJSONObjectDecoder{
	
	//char开始下标
	private int start;
	
	//char结束下标
	private int end;
	
	private String key;
	
	private Stack<StackToken> stack;
	
	//贮存对象的
	private Map<String,Object> map = new HashMap<>(15);
	
	public SimpleJSONObjectDecoder(int start){
		this.start = start;
		this.key  = null;
		this.stack = new Stack<>();
		stack.push(new StackToken(start,JSONTag.LJO));
	}
	
	public void run(final char[] str) {
		StackToken token =  null;
		//key记录的上一个key
		for(int i = start+1;i<str.length;i++) {
			if(str[i]==JSONTag.STD&&str[i-1]==JSONTag.LJO||str[i-1]==JSONTag.DOM) {
				//key开头
				stack.push(new StackToken(i+1,str[i]));
			}else if(str[i]==JSONTag.STD&&str[i+1]==JSONTag.CFD){
				//key结尾
				token = stack.pop();
				if(token.getValue()!=JSONTag.STD) {

				}
				key = CharArrayUtil.arrayToString(str,token.getIndex(), i);
			}else if(str[i]==JSONTag.CFD) {
				try {
					//如果没有指定key,说明可能该Key中包含{:}特殊字符
					if(key==null) {
						continue;
					}else {
						i = valueFormat(i,str);
					}
				} catch (Exception e) {
				}
			}else if(str[i]==JSONTag.RJO){
				//判段该JSONDeEntity是否结束
				token = stack.pop();
				if(token.getValue()==JSONTag.LJO) {
					this.end = i;
					return;
				}else {
				}
			}
		}
	}
	
	/**
	 * 解析value值。
	 * @param i
	 * @param str
	 * @return
	 */
	public int valueFormat(int i,char[] str) {
		if(key==null) {

		}
		//value开头
		int index = i;
		String value = "";
		if(StringUtil.matcherNumber(str[i+1])) {
			Map<String,Object> result = CharArrayUtil.arrayToString(str, i+1, new char[] {JSONTag.DOM,JSONTag.RJO});
			index = (int)result.get(CharArrayUtil.END_INDEX);
			value = (String)result.get(CharArrayUtil.VALUE);
			if(value.contains(".")){
				double temp = Double.parseDouble(value);
				if(temp>Float.MAX_VALUE) {
					map.put(key, temp);
				}else {
					map.put(key, Float.parseFloat(value));	
				}
			}else {
				long temp = Long.parseLong(value);
				if(temp>Integer.MAX_VALUE) {
					map.put(key, temp);
				}else {
					map.put(key, Integer.parseInt(value));
				}
			}
		}else {
			switch (str[i+1]) {
				case 't':
					map.put(key, true);
					index = i+4;
					break;
				case 'f':
					map.put(key, false);
					index = i+5;
					break;
				case 'n':
					map.put(key, null);
					index = i+5;
					break;	
				case JSONTag.STD:
					//字符串
					Map<String,Object> result = CharArrayUtil.arrayToString(str,i+2,new char[] {JSONTag.STD});
					index = (int)result.get(CharArrayUtil.END_INDEX);
					value = (String)result.get(CharArrayUtil.VALUE);
					map.put(key, value);
					break;
				case JSONTag.LJO:
					//对象
					SimpleJSONObjectDecoder dejson = new SimpleJSONObjectDecoder(i);
					dejson.run(str);
					index = dejson.getEnd();
					map.put(key, dejson.toJSONObject());
					//System.out.println("开始:"+i+" 结束:"+index+" 对象key:"+key);
					break;
				case JSONTag.LJA:
					//数组
					SimpleJSONArrayDecoder array = new SimpleJSONArrayDecoder(i);
					array.run(str);
					index = array.getEnd();
					map.put(key, array.toJSONArray());
					break;
				default:

			}
		}
		this.key = null;
		return index;
	}
	
	public void putValue(Object obj,String successValue,String value)  {
		if(successValue.equals(value)) {
			this.map.put(key, obj);
		}else {

		}
	}
	
	public JSONSerialize toJSONObject() {
		JSONSerialize entity = new JSONObject();

		return entity;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	
	
}
