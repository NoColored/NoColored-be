package com.ssafy.backend.collection.repository;

import com.ssafy.backend.collection.document.Skin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SkinRepository extends MongoRepository<Skin, Integer> {
}
