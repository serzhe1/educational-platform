package com.edpl.cms.persistent.service.impls;

import com.edpl.cms.persistent.model.impls.TheoryPart;
import com.edpl.cms.persistent.repository.impls.TheoryPartRepository;
import com.edpl.cms.persistent.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class TheoryPartService extends AbstractService<TheoryPart, TheoryPartRepository> {
    public TheoryPartService(TheoryPartRepository repository) {
        super(repository);
        this.notFoundMassage = "theory is unfounded with id: ";
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
