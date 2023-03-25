package com.edpl.coursemanagerservice.persistent.service.impls;

import com.edpl.coursemanagerservice.persistent.model.impls.Task;
import com.edpl.coursemanagerservice.persistent.model.impls.TheoryPart;
import com.edpl.coursemanagerservice.persistent.repository.impls.TheoryPartRepository;
import com.edpl.coursemanagerservice.persistent.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class TheoryPartService extends AbstractService<TheoryPart, TheoryPartRepository> {
    public TheoryPartService(TheoryPartRepository repository) {
        super(repository);
    }

    public TheoryPart save(TheoryPart part) {
        if (part.getId() != null) {
            TheoryPart updatedPart = getById(part.getId());
            updatedPart.setContent(part.getContent());
            updatedPart.setTitle(updatedPart.getTitle());
            return repository.save(updatedPart);
        }
        return repository.save(part);
    }
}
