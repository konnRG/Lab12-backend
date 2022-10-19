package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.rest.dao.OrganizerDao;
import se331.rest.entity.Organizer;

import java.util.List;

@Service
public class OrganizerServiceImpl implements OrganizerService{
    @Autowired
    OrganizerDao organizerDao;
    @Override
    public List<Organizer> getAllOrganizer() {
               return organizerDao.getOrganizer(Pageable.unpaged()).getContent();
           }
           @Override
    public Page<Organizer> getOrganizer(Integer page, Integer pageSize) {
              return organizerDao.getOrganizer(PageRequest.of(page,pageSize));
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerDao.getOrganizer(id);
    }

    @Override
    public Organizer save(Organizer organizer) {
        return organizerDao.save(organizer);
    }
}

