package com.lucainnocenti.agitado.repository;

import com.lucainnocenti.agitado.repository.entity.TempLogs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempLogsRepository extends CrudRepository<TempLogs, Long> {


}
