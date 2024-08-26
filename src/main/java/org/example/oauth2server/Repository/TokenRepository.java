package org.example.oauth2server.Repository;

import org.example.oauth2server.Models.Tokens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Tokens,Long> {

     Tokens save(Tokens tokens);

     Optional <Tokens> findByTokenvalueandisDeletedAndExpiryAtGreaterThan(String tokens, Boolean deleted, Date expriyAt);

     Optional<Tokens> findByTokenvalueAndDeleted(String tokens, Boolean t);

//     @Override
//     Optional<Tokens> findByTokenvalueAndDeletedAnd(Long aLong);

     // Optional<Tokens> findBy(tokenvalue);
}
