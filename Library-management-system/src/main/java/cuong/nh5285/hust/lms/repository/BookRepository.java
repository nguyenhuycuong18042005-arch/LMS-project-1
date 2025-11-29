package cuong.nh5285.hust.lms.repository;

import cuong.nh5285.hust.lms.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
