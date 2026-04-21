package com.amanda.backend.service;

import com.amanda.backend.dto.TaskRequest;
import com.amanda.backend.model.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final AtomicLong sequence = new AtomicLong(1);
    private final Map<Long, Task> store = new ConcurrentHashMap<>();

    public List<Task> listAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Task create(TaskRequest request) {
        Long id = sequence.getAndIncrement();
        Task task = new Task(
                id,
                request.getTitle(),
                request.getDescription(),
                request.isCompleted(),
                LocalDateTime.now()
        );
        store.put(id, task);
        return task;
    }

    public Optional<Task> update(Long id, TaskRequest request) {
        return findById(id).map(task -> {
            task.setTitle(request.getTitle());
            task.setDescription(request.getDescription());
            task.setCompleted(request.isCompleted());
            return task;
        });
    }

    public boolean delete(Long id) {
        return store.remove(id) != null;
    }
}
