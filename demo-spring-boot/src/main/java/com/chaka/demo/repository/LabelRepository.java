package com.chaka.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chaka.demo.domain.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {

}
