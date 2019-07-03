package com.lucainnocenti.agitado.service;

import com.lucainnocenti.agitado.repository.TempLogsRepository;
import com.lucainnocenti.agitado.repository.entity.TempLogs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempLogsService {

    private TempLogsRepository tempLogsRepository;

    public TempLogs storeTmpLogs(TempLogs tempLogs){

        return tempLogsRepository.save(tempLogs);

    }
}
