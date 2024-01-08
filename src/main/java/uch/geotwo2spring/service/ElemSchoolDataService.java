package uch.geotwo2spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uch.geotwo2spring.dto.ElemSchoolDto;
import uch.geotwo2spring.entity.ElemSchoolData;
import uch.geotwo2spring.repository.ElemSchoolDataRepository;
import uch.geotwo2spring.repository.LardAdmSectSggRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElemSchoolDataService {
    ElemSchoolDataRepository elemSchoolDataRepository;
    @Autowired
    public ElemSchoolDataService(ElemSchoolDataRepository elemSchoolDataRepository) {
        this.elemSchoolDataRepository = elemSchoolDataRepository;
    }

    public List<ElemSchoolDto> showSchools() {
        List<ElemSchoolData> elemSchoolDataArrayList = elemSchoolDataRepository.findAll();
        List<ElemSchoolDto> elemSchoolDtoArrayList = new ArrayList<>();

        for (int i = 0; i < elemSchoolDataArrayList.size(); i++) {
            elemSchoolDtoArrayList.add(ElemSchoolDto.toDTO(elemSchoolDataArrayList.get(i)));
        }

        return elemSchoolDtoArrayList;
    }

    public List<ElemSchoolDto> getElemSchoolsByRegion(String regionName) {
        List<ElemSchoolData> elemSchoolDataArrayList = elemSchoolDataRepository.findIntersectingSchoolsBySggNm(regionName);
        List<ElemSchoolDto> elemSchoolDtoArrayList = new ArrayList<>();

        for (int i = 0; i < elemSchoolDataArrayList.size(); i++) {
            elemSchoolDtoArrayList.add(ElemSchoolDto.toDTO(elemSchoolDataArrayList.get(i)));
        }

        return elemSchoolDtoArrayList;
    }
}
