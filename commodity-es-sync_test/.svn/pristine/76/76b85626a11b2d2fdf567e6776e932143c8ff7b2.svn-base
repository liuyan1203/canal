package com.haiziwang.commodity.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public class EntityTool {
    protected final static Logger logger = LoggerFactory.getLogger(EntityTool.class);

    /**
     * 转换两个对象name和
     *
     * @param editEntity
     * @param entity
     * @return
     */
    public static Object cpySamePropertyVale(Object editEntity, Object entity) {
        Field fieldEdit[] = editEntity.getClass().getDeclaredFields();
        Field field[] = entity.getClass().getDeclaredFields();

        for (int i = 0; i < fieldEdit.length; i++) {
            fieldEdit[i].setAccessible(true);
            for (int j = 0; j < field.length; j++) {
                field[j].setAccessible(true);
                if (fieldEdit[i].getName().equals(field[j].getName()) && fieldEdit[i].getType().equals(field[j].getType())) {
                    try {
                        //logger.info("editEntity:{}:[{}][{}], entity:{}:[{}][{}]", fieldEdit[i].getName(), fieldEdit[i].getType(), fieldEdit[i].get(editEntity),
                        //        field[j].getName(), field[j].getType(), field[j].get(entity));
                        if (fieldEdit[i].get(editEntity) != null) {
                            field[j].set(entity, fieldEdit[i].get(editEntity));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        //logger.info("cpySamePropertyVale： {}", entity);
        return entity;
    }


}
