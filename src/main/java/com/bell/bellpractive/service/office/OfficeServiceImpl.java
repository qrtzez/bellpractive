package com.bell.bellpractive.service.office;

import com.bell.bellpractive.dao.office.OfficeDao;
import com.bell.bellpractive.exception.IncorrectDataException;
import com.bell.bellpractive.exception.NotFoundException;
import com.bell.bellpractive.model.Office;
import com.bell.bellpractive.model.User;
import com.bell.bellpractive.view.*;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeDao officeDao;
    private final MapperFactory mapperFactory;

    public OfficeServiceImpl(OfficeDao officeDao, MapperFactory mapperFactory) {
        this.officeDao = officeDao;
        this.mapperFactory = mapperFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<OfficeListView> listOffice(OfficeView officeView) {
        Office office = mapperFactory.getMapperFacade().map(officeView, Office.class);
        List<Office> officeList = officeDao.list(office);
        if(officeList.size() == 0){
            throw new NotFoundException("The list of offices is empty");
        }
        return officeList.stream()
                .map(mapperFactory.getMapperFacade(Office.class, OfficeListView.class)::map)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public OfficeView getOfficeById(Long id) {
        Office office = officeDao.getOfficeById(id);
        if(office == null){
            throw new NotFoundException("There is no such office in the database");
        }
        return mapperFactory.getMapperFacade().map(office, OfficeView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(OfficeSaveView officeSaveView) {
        Office office = mapperFactory.getMapperFacade().map(officeSaveView, Office.class);
        officeDao.save(office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(OfficeUpdateView officeView) {
        Office office = mapperFactory.getMapperFacade().map(officeView, Office.class);
        try {
            officeDao.update(office);
        }catch (Exception e){
            throw new IncorrectDataException();
        }
    }
}
