package com.dynamite.hook_me_up.data.repositories;

import com.dynamite.hook_me_up.data.models.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "profiles", path = "profiles")
public interface ProfileRepository extends MongoRepository<Profile, String> {
}
