package com.ys.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest:";
	@GetMapping("http/lombok")
	public String lombokTest() {
		//Member m1 = new Member(1,"1234","ys","ys@email.com");
		Member m = Member.builder().username("ys").password("1234").email("ys@email.com").build();
		System.out.println(TAG+"getter"+m.getUsername());
		m.setUsername("yslee");
		System.out.println(TAG+"getter"+m.getUsername());
		return "lombok test done!";
	}
	
	// internet request only takes get
	@GetMapping("/http/get")
	public String getTest(Member m){ //@RequestParam int id, @RequestParam String username
		return "get :" + m.getId() +", "+ m.getUsername() +", "+ m.getPassword() +", "+ m.getEmail();
	}
	
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m){
		return "post :"  + m.getId() +", "+ m.getUsername() +", "+ m.getPassword() +", "+ m.getEmail();
	}
	
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m){
		return "put :" + m.getId() +", "+ m.getUsername() +", "+ m.getPassword() +", "+ m.getEmail();
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest(){
		return "delete :";
	}
}
