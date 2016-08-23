/**
 * 
 */
package me.paddingdun.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.apache.log4j.Logger;

/**
 * 流工具类;
 * @author paddingdun
 *
 * 2015年11月30日
 */
public class IOHelper { 
	
	static int MAX_CACHE_LENGTH = 1024 * 1024;
	/**
	 * IOHelper 日志变量;
	 */
	private final static Logger logger = Logger.getLogger(IOHelper.class);

	
	public static void close(InputStream in){
		if(in != null){
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(OutputStream out){
		if(out != null){
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Reader reader){
		if(reader != null){
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Writer writer){
		if(writer != null){
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void dump(InputStream in, OutputStream out)throws IOException{
		byte[] buffer = new byte[MAX_CACHE_LENGTH];
		int length = -1;
		while((length = in.read(buffer)) > -1){
			out.write(buffer, 0, length);
			out.flush();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
