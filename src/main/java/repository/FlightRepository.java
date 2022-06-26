package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import entity.Flight;

public interface FlightRepository extends JpaRepository<Flight,String> {
}
