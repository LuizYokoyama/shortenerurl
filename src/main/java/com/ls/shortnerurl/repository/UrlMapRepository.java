package com.ls.shortnerurl.repository;

import com.ls.shortnerurl.model.UrlMap;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlMapRepository extends CrudRepository<UrlMap, String> {
}
