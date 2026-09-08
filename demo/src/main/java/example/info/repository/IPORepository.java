package example.info.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import example.info.pojo.IPO;
import example.info.service.IPOService;


@Repository
public class IPORepository {
	
	@Autowired
	IPOService service;
	
	
	public IPO getIPObyID(){
		
		return service.getIPObyID("XYZ");
			
			
		
		
	}

}
