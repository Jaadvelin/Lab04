package mx.tec.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.tec.lab.Entity.Dragon;

@Repository
public interface DragonRepository extends JpaRepository<Dragon, Long> {
	

}


