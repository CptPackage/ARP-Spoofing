# ARP-Spoofing
## What is ARP-Spoofing ?
### How ARP protocol operates ?
ARP (address resolution protocol) operates by broadcasting a message across a network,
to determine the Layer 2 address (MAC address) of a host with a predefined Layer 3 address (IP address). 
The host at the destination IP address sends a reply packet containing its MAC address. 
Once the initial ARP transaction is complete,
the originating device then caches the ARP response, which is used within the Layer 2 header of packets that are sent to a specified IP address.
### What is an ARP Spoofing Attack ?
ARP spoofing Attack is a type of attack in which a malicious actor sends falsified ARP messages over a local area network.
This results in the linking of an attacker's MAC address with the IP address of a legitimate computer or server on the network.
### What you can do with this tool ?
* Finding all connected devices to a LAN
* Interrupt internet connection
