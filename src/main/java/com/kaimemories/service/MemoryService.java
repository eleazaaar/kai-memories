
package com.kaimemories.service;

import com.kaimemories.model.Memory;
import com.kaimemories.repository.MemoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemoryService {

    private final MemoryRepository memoryRepository;

    public MemoryService(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    public List<Memory> getAllMemories() {
        return memoryRepository.findAllByOrderByMemoryDateAsc();
    }

    public Memory getMemoryById(Long id) {
        return memoryRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Memory not found: " + id));
    }
}
