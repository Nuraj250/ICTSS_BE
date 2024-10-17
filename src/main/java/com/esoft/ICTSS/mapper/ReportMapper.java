package com.esoft.ICTSS.mapper;

import com.esoft.ICTSS.dto.ReportDto;
import com.esoft.ICTSS.model.Report;

/**
 * Mapper class to convert between Report entity and ReportDto.
 */

public interface ReportMapper {

    /**
     * Converts ReportDto to Report entity.
     */
    Report toEntity(ReportDto dto);

    /**
     * Converts Report entity to ReportDto.
     */
    ReportDto toDto(Report entity);
}
