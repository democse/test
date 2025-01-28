package com.pravin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pravin.entity.FormData;

public interface FormDataRepository extends JpaRepository<FormData, Long> {

}
