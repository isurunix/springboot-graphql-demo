package com.isurunix.graphqldemo.repository;

import com.isurunix.graphqldemo.domain.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends JpaRepository<App, Long> {
}
