package brains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import brains.model.User;
import brains.repository.UserRepository;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		this.userRepository.save(new User("bretty","tosh","gitongabretton@gmail.com"));
		this.userRepository.save(new User("muchoki","bretton","roro@gmail.com"));
		this.userRepository.save(new User("dan","duncah","dan@gmail.com"));
		this.userRepository.save(new User("waweru","beet","waweru@gmail.com"));
		
	}

}
