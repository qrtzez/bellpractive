package com.bell.bellpractive.service.organization;

import com.bell.bellpractive.dao.organization.OrganizationDao;
import com.bell.bellpractive.exception.IncorrectDataException;
import com.bell.bellpractive.exception.NotFoundException;
import com.bell.bellpractive.model.Organization;
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
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationDao organizationDao;
    private final MapperFactory mapperFactory;

    public OrganizationServiceImpl(OrganizationDao organizationDao, MapperFactory mapperFactory) {
        this.organizationDao = organizationDao;
        this.mapperFactory = mapperFactory;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<OrganizationListView> listOrganization(OrganizationView organizationView) {
        Organization organization = mapperFactory.getMapperFacade().map(organizationView, Organization.class);
        List<Organization> organizationList = organizationDao.list(organization);
        if(organizationList.size()==0){
            throw new NotFoundException("The list of organizations is empty");
        }
        return organizationList.stream()
                .map(mapperFactory.getMapperFacade(Organization.class, OrganizationListView.class)::map)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public OrganizationView getOrganizationById(Long id) {
        Organization organization = organizationDao.getById(id);
        if(organization == null){
            throw new NotFoundException("There is no such organization");
        }
        return mapperFactory.getMapperFacade().map(organization, OrganizationView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(OrganizationSaveView organizationSaveView) {
        Organization organization = mapperFactory.getMapperFacade().map(organizationSaveView, Organization.class);
        organizationDao.save(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(OrganizationUpdateView organizationUpdateView) {
        Organization organization = mapperFactory.getMapperFacade().map(organizationUpdateView, Organization.class);
        try {
            organizationDao.update(organization);
        }catch (Exception e){
            throw new IncorrectDataException();
        }
    }
}
