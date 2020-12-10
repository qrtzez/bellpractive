package com.bell.bellpractive.service.citizenship;

import com.bell.bellpractive.dao.citizenship.CitizenshipDao;
import com.bell.bellpractive.exception.NotFoundException;
import com.bell.bellpractive.model.Citizenship;
import com.bell.bellpractive.view.CitizenshipView;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class CitizenshipServiceImpl implements CitizenshipService{
    private final CitizenshipDao citizenshipDao;
    private final MapperFactory mapperFactory;

    @Autowired
    public CitizenshipServiceImpl(CitizenshipDao citizenshipDao, MapperFactory mapperFactory) {
        this.citizenshipDao = citizenshipDao;
        this.mapperFactory = mapperFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CitizenshipView> listCitizenship() {
        List<Citizenship> citizenshipList = citizenshipDao.allCitizenship();
        if(citizenshipList.size() == 0){
            throw new NotFoundException("Error! The list is empty");
        }
        return mapperFactory.getMapperFacade().mapAsList(citizenshipList, CitizenshipView.class);
    }
}
