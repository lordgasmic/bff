package com.lordgasmic.bff.session;

import com.lordgasmic.bff.session.model.SessionDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends CrudRepository<SessionDetails, String> {
}
