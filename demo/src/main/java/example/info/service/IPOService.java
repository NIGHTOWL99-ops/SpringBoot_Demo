package example.info.service;

import org.springframework.stereotype.Service;

import example.info.pojo.IPO;

@Service
public class IPOService {
	
	public IPO getIPObyID(String name) {
		
		
		return new IPO(name,890);
	}

}
