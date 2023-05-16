package com.project.gestao.application.converters;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

public interface BaseConverter<Entity, Dto> {

	ModelMapper MODEL_MAPPER = new ModelMapper();

	default Dto toDto(Entity entity) {
		var type = (ParameterizedType) getClass().getGenericSuperclass();
		return MODEL_MAPPER.map(entity, type.getActualTypeArguments()[1]);
	}
	
	default List<Dto> toListDto(List<Entity> listEntity) {
		return MODEL_MAPPER.map(listEntity, new TypeToken<List<Dto>>(){}.getType());
	}

	default Entity toEntity(Dto dto) {
		var type = (ParameterizedType) getClass().getGenericInterfaces()[0];
		return MODEL_MAPPER.map(dto, type.getActualTypeArguments()[0]);
	}
	
	default List<Entity> toListEntity(List<Dto> listDto) {
		return MODEL_MAPPER.map(listDto, new TypeToken<List<Entity>>(){}.getType());
	}

	default <FROM, TO> TO toType(FROM from, Class<TO> type, ModelMapper mapper) {
		return mapper.map(from, type);
	}
}