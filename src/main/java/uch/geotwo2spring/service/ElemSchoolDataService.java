package uch.geotwo2spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uch.geotwo2spring.entity.ElemSchoolData;
import uch.geotwo2spring.repository.ElemSchoolDataRepository;

import java.util.List;

@Service
public class ElemSchoolDataService {
    ElemSchoolDataRepository elemSchoolDataRepository;

    @Autowired
    public ElemSchoolDataService(ElemSchoolDataRepository elemSchoolDataRepository) {
        this.elemSchoolDataRepository = elemSchoolDataRepository;
    }

    public List<ElemSchoolData> showSchools() {
        return elemSchoolDataRepository.findAll();
    }
}
