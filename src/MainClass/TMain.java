package MainClass;

import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class TMain {
	 public static void main(String args[]) throws Exception {
		 try {
			 String JRE=System.getProperty("java.home")+"/bin";	
			 File JrePath =new File(JRE);
			 String[] Files = JrePath.list(new FilenameFilter() {
				    public boolean accept(File directory, String fileName) {
				    	boolean first=(fileName.contains("jnetpcap.dll"))?true:false;
				    	boolean second = (fileName.contains("jnetpcap-pcap100.dll"))?true:false;
				    	
				        return first^second;
				    }
				});
			 if(Files.length==2){
				 try {
			        	
			        	BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
			        	UIManager.put( "RootPane.setupButtonVisible" ,  false );
			            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			        
			        } catch (Exception ex) {
			            }
			        java.awt.EventQueue.invokeLater(new Runnable() {
			            public void run() {
			            	try{
			            	NewJFrame frame = new NewJFrame();
			            	frame.setVisible(true);
			            	}catch(Exception e){
			            		JOptionPane.showMessageDialog(null, "error");
			            	}
			            }
			        });
			 }else{
				 try{
					Copy copy = new Copy();
					copy.copyFile(new File("native/jnetpcap.dll"),new File( JrePath+"/jnetpcap.dll"));
					copy.copyFile(new File("native/jnetpcap-pcap100.dll"),new File( JrePath+"/jnetpcap-pcap100.dll"));
try {
			        	
			        	BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
			        	UIManager.put( "RootPane.setupButtonVisible" ,  false );
			            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			        
			        } catch (Exception ex) {
			            }
			        java.awt.EventQueue.invokeLater(new Runnable() {
			            public void run() {
			            	try{
			            	NewJFrame frame = new NewJFrame();
			            	frame.setVisible(true);
			            	}catch(Exception e){
			            		JOptionPane.showMessageDialog(null, "error");
			            	}
			            }
			        });
				 }catch(Exception e){
					 
				 }
			 }
			 
		    } catch (UnsatisfiedLinkError e) {
		      System.err.println("Native code library failed to load.\n" + e);
		      
		    }
	        
	    }
}
