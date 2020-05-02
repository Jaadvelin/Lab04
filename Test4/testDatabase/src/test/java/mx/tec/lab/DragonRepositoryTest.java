package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mx.tec.lab.Entity.Dragon;
import mx.tec.lab.Repository.DragonRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DragonRepositoryTest {
	@Resource
	private DragonRepository dragonRepository;
	
	@Test
	public void givenDragon_whenSave_thenRetrieveSame() {
		Dragon dragon = new Dragon(1, "Meraxes");
		dragonRepository.save(dragon);
		
		dragon.setId(2);
		dragon.setName("Libelle");
		dragonRepository.save(dragon);
		
		Dragon retrievedDragon = dragonRepository.findById(1L).orElse(null);
		assertEquals("Meraxes", retrievedDragon.getName());
		Dragon retrievedDragon2 = dragonRepository.findById(2L).orElse(null);
		assertEquals("Libelle", retrievedDragon2.getName());
	}
	
	
	@Test
	public void modifyDragon() {
		Dragon dragon = new Dragon(1, "Ryoko");
		dragonRepository.save(dragon);
		
		Dragon retrievedDragon = dragonRepository.findById(1L).orElse(null);
		assertEquals("Ryoko", retrievedDragon.getName());
	}
	
	@Test
	public void deleteDragon() {
		dragonRepository.deleteById((long) 1);
	}

}
