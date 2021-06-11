package th.ac.rmutsb.pro.test.api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import th.ac.rmutsb.pro.test.model.RoomModel;
import th.ac.rmutsb.pro.test.model.TypeModel;


@RestController
@RequestMapping("/hello")
public class HelloApi {

	
	@GetMapping("/say")
	public String hello() {
		return "Helloarm";
	}
//
//	@GetMapping("/xx")
//	public ArrayList<RoomModel> say1(){
//		ArrayList<RoomModel> response = new ArrayList<RoomModel>();
//			
//		RoomModel r = new RoomModel();
//		r.setRoomId("001");
//		r.setRoomName("room 1");
//		r.setAmount(3);
//		
//		TypeModel s = new TypeModel();
//		s.setTypeId("xxx");
//		s.setTdesc("tdesc");
//		s.setEdesc("edesc");
//		r.setType(s);
//		response.add(r);
//		return response;
//	}
}