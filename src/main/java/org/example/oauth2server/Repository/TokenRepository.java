package org.example.oauth2server.Repository;

import org.example.oauth2server.Models.Tokens;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Tokens,Long> {

     Tokens save(Tokens tokens);
     Optional <Tokens> findByvalueandisDeleteAndAndExpiryAtGreaterThan(String tokens, Boolean deleted, Date expriyAt);

     Optional<Tokens> findByValueandisDelete(String tokens, Boolean t);

    // Optional<Tokens> findBy(tokenvalue);
}
