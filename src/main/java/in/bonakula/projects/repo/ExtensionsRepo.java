package in.bonakula.projects.repo;

import in.bonakula.projects.data.Extensions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtensionsRepo extends JpaRepository<Extensions, Long> {
    Extensions findByExtname(String extname);
}
