package org.example.dovhopolyi.repositoriy;
import org.example.dovhopolyi.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
}