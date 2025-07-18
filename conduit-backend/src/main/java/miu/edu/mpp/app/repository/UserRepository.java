package miu.edu.mpp.app.repository;

import miu.edu.mpp.app.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndPassword(String email, String password);

    @EntityGraph(attributePaths = "followers")
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    List<User> findByEmailIn(List<String> emails);

    void deleteByEmail(String email);

    @EntityGraph(attributePaths = "followers")
    @Query("SELECT u FROM User u WHERE u.username = :username")
    Optional<User> findByUsernameWithFollowers(@Param("username") String username);

}
