package me.paddingdun.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;

import org.apache.commons.lang.StringUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
        System.out.println( "Hello World!" );
        
        //
//        BeanUtils.populate(bean, properties);
        
//        BeanUtils.setProperty(bean, name, value);
        
//        System.out.println(NumberUtils.isDigits("-124"));
//        
//        
//        String s = "xi2Snnt+e2Flkjpd/GDLVg==";
//        
//       String a1 = Base64.encodeBase64String(DigestUtils.md5("123456")) ;
//        
//        String a1 = DigestUtils.md5Hex(Base64.decodeBase64(s.getBytes("utf-8")));
//        System.out.println(a1);
        
//        nsDetector ns = new nsDetector(nsPSMDetector.ALL);
//        boolean isAscii = false;
//        ns.Init(new nsICharsetDetectionObserver() {
//			public void Notify(String paramString) {
//				System.out.println(paramString);
//			}
//		});
//        
//        byte[] b = "中文你好我们".getBytes("utf-8");
//        
//        if(ns.isAscii(b, b.length)){
//        	System.out.println("ASCII");
//        }
//        
////        nsUTF8Verifier u = new nsUTF8Verifier();
////        System.out.println(u.charset());
//        
//        boolean found = ns.DoIt(b, b.length, false);
//        ns.DataEnd();
//        if(found){
//        	System.out.println(StringUtils.join(ns.getProbableCharsets(), ","));
//        }else{
//        	System.out.println("not found");
//        }
        
        ZipFile zf = new ZipFile("/mnt/win/d/home/wai/wai/元教项目包001_rmb4w_appcan.zip");
        File base = new File("/home/company-pc/桌面/a");
        Enumeration<ZipEntry> en =  zf.getEntries();
        while(en.hasMoreElements()){
        	ZipEntry ze =  en.nextElement();
//        	System.out.println(ze.getName());
        	String charset = guess(ze.getRawName());
        	String name = new String(ze.getRawName(), charset);
        	System.out.println(name);
        	if(ze.isDirectory()){
        		System.out.println("dir:" + name);
        		File dir = new File(base, name);
        		if(!dir.exists())
        			dir.mkdirs();
        	}else{
        		System.out.println("file:" + name);
        		File f = new File(base, name);
        		FileOutputStream fos = new FileOutputStream(f);
        		InputStream in = zf.getInputStream(ze);
        		IOHelper.dump(in, fos);
        		IOHelper.close(in);
        		IOHelper.close(fos);
        	}
        }
        
    }
    
    public static String guess(byte[] b){
//    	final CsDetector ns = new CsDetector(nsPSMDetector.CHINESE);
//      ns.Init(new nsICharsetDetectionObserver() {
//			public void Notify(String paramString) {
//				ns.setCs(paramString);
//			}
//		});
//      
////      byte[] b = "中文你好我们".getBytes("utf-8");
//      
//      if(ns.isAscii(b, b.length)){
//    	  return "ASCII";
//      }
//      
////      nsUTF8Verifier u = new nsUTF8Verifier();
////      System.out.println(u.charset());
//      
//      ns.DoIt(b, b.length, false);
//      ns.DataEnd();
//      
//      String cs = ns.getCs();
//      if(StringUtils.isNotBlank(cs)){
//    	  return cs;
//      }else
    	  return "utf-8";
    }
}
