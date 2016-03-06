package MainClass;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.jnetpcap.PcapIf;
public class ListNIFs {  
	
	   
	public List<String> getDevicesNames() {
		Enumeration<NetworkInterface> interfaces;
		try {
			interfaces = NetworkInterface.getNetworkInterfaces();
		
		List <String> devices= new ArrayList<String>();
		Start_Spoofing s = new Start_Spoofing();
		int number=s.getNics().size();
		int index =0;
		while (interfaces.hasMoreElements())
		{
		NetworkInterface networkInterface = interfaces.nextElement();
		devices.add(networkInterface.getDisplayName());
		
		index++;
		}
		
		return devices;
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	
	public static void main(String [] args){
		ListNIFs s=new  ListNIFs();
		
		List <String> t = s.getDevicesNames();

		 for(String p : t){
		    	System.out.println(t);
		    }
	}
    }  
  