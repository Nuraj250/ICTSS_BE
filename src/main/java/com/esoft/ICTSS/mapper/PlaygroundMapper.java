package com.esoft.ICTSS.mapper;

import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlaygroundMapper {
}
