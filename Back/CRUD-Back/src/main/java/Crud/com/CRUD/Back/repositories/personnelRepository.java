package Crud.com.CRUD.Back.repositories;

import Crud.com.CRUD.Back.entites.personnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface personnelRepository extends JpaRepository<personnel,Long> {
}
