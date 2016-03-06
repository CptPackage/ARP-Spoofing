package MainClass;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JOptionPane;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;

public class Start_Spoofing {
	 private static final int snaplen = 64 * 1024;
	 private static final int flags = Pcap.MODE_PROMISCUOUS;
	 private static final int timeout = 10 * 1000;
	StringBuilder errbuf = new StringBuilder();
	@SuppressWarnings("deprecation")
	public List <PcapIf> getNics(){
	List<PcapIf> alldevs = new ArrayList<PcapIf>();
    for(PcapIf p : alldevs ){
    	System.out.println(p.getName());
    }
    int r = Pcap.findAllDevs(alldevs, errbuf);
    if (r == Pcap.NOT_OK || alldevs.isEmpty()) {
    	JOptionPane.showMessageDialog(null, "Not able to read list of devices \n"+ errbuf.toString(), "Error(Devices)", JOptionPane.ERROR_MESSAGE);
    }
    
    return alldevs;
}
	public PcapIf  PrepareDevice(List <PcapIf> Nics,int NICnumber){
		 return Nics.get(NICnumber);
		    
	}
	public void Send_Frame(PcapIf device,ByteBuffer a){
		Pcap pcap = Pcap.openLive(device.getName(), snaplen, flags, timeout, errbuf);
		if (pcap.sendPacket(a) != Pcap.OK) {
			JOptionPane.showMessageDialog(null, "Not sent \n"+ pcap.getErr(), "Error in sending Farmes", JOptionPane.ERROR_MESSAGE);
	   }
	}
	public List<String> getDevicesNames() {
		Enumeration<NetworkInterface> interfaces;
		try {
			interfaces = NetworkInterface.getNetworkInterfaces();
		
		List <String> devices= new ArrayList<String>();
		while (interfaces.hasMoreElements() )
		{
		NetworkInterface networkInterface = interfaces.nextElement();
		devices.add(networkInterface.getDisplayName());
		}
		
		return devices;
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String [] args){
		Start_Spoofing s=new Start_Spoofing();
		List < PcapIf> f=s.getNics();
		List <String> t = s.getDevicesNames();
		 for(PcapIf p : f){
		    	System.out.println(p.getName());
		    }

	}
	
}